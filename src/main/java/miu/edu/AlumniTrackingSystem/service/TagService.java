package miu.edu.AlumniTrackingSystem.service;

import miu.edu.AlumniTrackingSystem.dto.TagDTO;
import miu.edu.AlumniTrackingSystem.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    List<TagDTO> getAll();

    Optional<Tag> getById(int id);
}
