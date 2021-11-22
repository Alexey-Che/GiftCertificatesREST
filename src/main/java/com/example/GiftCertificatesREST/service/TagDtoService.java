package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.dto.TagDto;
import com.example.GiftCertificatesREST.models.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagDtoService {

    private final ModelMapper modelMapper;

    @Autowired
    public TagDtoService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TagDto toDto(Tag tag) {
        return modelMapper.map(tag, TagDto.class);
    }

    public Tag toEntity(TagDto tagDto) {
        return modelMapper.map(tagDto, Tag.class);
    }
}
