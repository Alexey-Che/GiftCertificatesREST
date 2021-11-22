package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.dto.TagDto;
import com.example.GiftCertificatesREST.models.Tag;

import java.util.List;

public interface TagService {

    TagDto createTag(TagDto tagDto);
    List<TagDto> getAllTags();
    void deleteTag(Long id);
    TagDto getTagById(Long id);
}
