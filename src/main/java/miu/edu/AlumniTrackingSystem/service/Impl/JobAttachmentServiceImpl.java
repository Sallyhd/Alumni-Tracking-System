package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.Exceptions.StorageException;
import miu.edu.AlumniTrackingSystem.Exceptions.StorageFileNotFoundException;
import miu.edu.AlumniTrackingSystem.config.Storage;
import miu.edu.AlumniTrackingSystem.entity.JobAdvertisment;
import miu.edu.AlumniTrackingSystem.entity.JobAttachment;
import miu.edu.AlumniTrackingSystem.repository.JobAdvertisementRepository;
import miu.edu.AlumniTrackingSystem.repository.JobAttachmentRepository;
import miu.edu.AlumniTrackingSystem.service.JobAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class JobAttachmentServiceImpl implements JobAttachmentService {
    @Autowired
    private JobAttachmentRepository jobAttachmentRepository;


    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepo;
    private final Path rootLocation;


    @Autowired
    public JobAttachmentServiceImpl(JobAttachmentRepository jobAttachmentRepository , Storage properties )
    {
        this.jobAttachmentRepository = jobAttachmentRepository;
        this.rootLocation = Paths.get(properties.getLocation());
    }
    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }


    @Override
    public String getFileNameById (int id)
    {
        return jobAttachmentRepository.findNameByJobAdvertisementId(id);
    }


    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public JobAttachment save(Integer id,MultipartFile file)  {


        System.out.println("Here here");
        JobAttachment jobAttachment = new JobAttachment();
        jobAttachment.setUrl(getURLofFileupload(rootLocation)+ "/" +file.getOriginalFilename());
        jobAttachment.setName(file.getOriginalFilename());
        JobAdvertisment ja = jobAdvertisementRepo.findById(id).orElse(null);
        jobAttachment.setJobAdvertisment(ja);
        System.out.println(jobAttachment.getUrl());

        store(file);

        return jobAttachmentRepository.save(jobAttachment);

    }

    @Override
    public String saveAll(Integer id,MultipartFile[] files)  {

        try {

            Arrays.asList(files).stream().forEach(file -> {
                JobAttachment jobAttachment = new JobAttachment();
                jobAttachment.setUrl(getURLofFileupload(rootLocation)+ "/" +file.getOriginalFilename());

                JobAdvertisment ja = jobAdvertisementRepo.findById(id).orElse(null);
                jobAttachment.setJobAdvertisment(ja);
                System.out.println(jobAttachment.getUrl());

                jobAttachmentRepository.save(jobAttachment);
                store(file);

            });

            return "Uploaded the files successfully: ";
        } catch (Exception e) {

            return "Fail to upload files!";
        }


    }


    public Resource readFileById(@PathVariable Integer attachmentId){

        JobAttachment jb = jobAttachmentRepository.findById(attachmentId).orElse(null);
        String s = jb.getUrl();
        String[] arr = s.split("/");
        String filename = arr[arr.length - 1];
        Resource file = loadAsResource(filename);
        return file;
    }

    private String getURLofFileupload(Path location)
    {
        return location.toString();
    }
}
