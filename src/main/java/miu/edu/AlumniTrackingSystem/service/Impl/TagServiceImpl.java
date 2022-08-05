package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.dto.TagDTO;
import miu.edu.AlumniTrackingSystem.entity.Tag;
import miu.edu.AlumniTrackingSystem.service.TagService;

import java.util.List;
import java.util.Optional;

public class TagServiceImpl implements TagService {
    @Override
    public List<TagDTO> getAll() {
        return null;
    }

    @Override
    public Optional<Tag> getById(int id) {
        return Optional.empty();
    }
}
