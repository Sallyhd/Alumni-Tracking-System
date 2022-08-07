package miu.edu.AlumniTrackingSystem.service.Impl;


import lombok.AllArgsConstructor;
import lombok.Data;
import miu.edu.AlumniTrackingSystem.dto.CvDTO;
import miu.edu.AlumniTrackingSystem.repository.StudentRepository;
import miu.edu.AlumniTrackingSystem.service.CVService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Data
@Transactional
public class CvServiceImpl implements CVService {
        ModelMapper modelMapper;

        StudentRepository studentRepository;


        @Override
        public CvDTO getCv(String username) {
            return modelMapper.map(studentRepository.getStudentsByUsername(username),CvDTO.class);

        }


    }

