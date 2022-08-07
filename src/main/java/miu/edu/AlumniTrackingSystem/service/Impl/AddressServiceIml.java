package miu.edu.AlumniTrackingSystem.service.Impl;

import miu.edu.AlumniTrackingSystem.dto.AddressDTO;
import miu.edu.AlumniTrackingSystem.entity.Address;
import miu.edu.AlumniTrackingSystem.repository.AddressRepository;
import miu.edu.AlumniTrackingSystem.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceIml implements AddressService {

    @Autowired
    AddressRepository addressRepository;
    ModelMapper modelMapper;

    @Override
    public void saveAddress(AddressDTO addressDTO) {
        addressRepository.save(modelMapper.map(addressDTO, Address.class));
    }
}
