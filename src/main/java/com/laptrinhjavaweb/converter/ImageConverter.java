package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.ImageDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ImageModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ImageDTO convertToImageDTO(ImageModel imageModel){
        ImageDTO imageDTO = new ImageDTO();
        imageDTO =modelMapper.map(imageModel,ImageDTO.class);
        return imageDTO;
    }
}
