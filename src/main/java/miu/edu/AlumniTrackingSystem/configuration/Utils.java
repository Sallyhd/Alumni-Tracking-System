package miu.edu.AlumniTrackingSystem.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Utils<T,S> {
    @Autowired
    private static ModelMapper modelMapper;

//    public List<T> convertToListDto(List<S> lstObj, Type mapper) {
//        return lstObj.stream().map(x -> modelMapper.map(x, mapper.getClass())).collect(Collectors.toList());
//    }
    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
            .stream()
            .map(element -> modelMapper.map(element, targetClass))
            .collect(Collectors.toList());
    }
}
