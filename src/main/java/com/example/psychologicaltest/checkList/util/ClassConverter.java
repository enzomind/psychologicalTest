package com.example.psychologicaltest.checkList.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClassConverter {
    private final ModelMapper modelMapper;

    public ClassConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T,P> P converter(T src, Class<P> dest){

        return modelMapper.map(src, dest);
    }
}
