package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.dto.CommentDTO;
import miu.edu.AlumniTrackingSystem.entity.Comment;
import miu.edu.AlumniTrackingSystem.entity.Faculty;
import miu.edu.AlumniTrackingSystem.entity.Student;
import miu.edu.AlumniTrackingSystem.repository.CommentRepository;
import miu.edu.AlumniTrackingSystem.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentImpl implements CommentService {

    private final CommentRepository commentRepository;

    ModelMapper modelMapper;

    @Autowired
    public CommentImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void AddComment(Student student, Faculty faculty, String discription) {

//        @Override
//        public void addExperience(ProfessionalExperienceDto professionalExperienceDto, String username) {
//            ProfessionalExperience professionalExperience =
//                    modelMapper.map(professionalExperienceDto , ProfessionalExperience.class);
//            professionalExperience.setStudent(studentRepo.getStudentByUsername(username));
//            studentRepo.getStudentByUsername(username).getProfessionalExperiences().add(professionalExperience);
//
//        }
        Comment comment =new Comment();

        comment.setFaculty(faculty);
        comment.setStudent(student);
        comment.setDiscription(discription);
        commentRepository.save(comment);



            }

    @Override
    public List<CommentDTO> getAllComment() {



        var comment = commentRepository.findAll();
        var result = new ArrayList<CommentDTO>();
        for(Comment comment1: comment) {

            if (!comment1.isDeleted()) {
                CommentDTO commentDTO = new CommentDTO();
                commentDTO = modelMapper.map(comment1, CommentDTO.class);
                result.add(commentDTO);
            }
        }
        return result;
    }


}
