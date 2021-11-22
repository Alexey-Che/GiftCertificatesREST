package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.dao.TagDao;
import com.example.GiftCertificatesREST.dto.TagDto;
import com.example.GiftCertificatesREST.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService{

    private final TagDao tagDao;
    private final TagDtoService tagDtoService;

    @Autowired
    public TagServiceImpl(TagDao tagDao, TagDtoService tagDtoService) {
        this.tagDao = tagDao;
        this.tagDtoService = tagDtoService;
    }

    @Override
    public TagDto createTag(TagDto tagDto) {
        Tag tag = tagDtoService.toEntity(tagDto);
        return tagDtoService.toDto(tagDao.createTag(tag));
    }

    @Override
    public List<TagDto> getAllTags() {
        return tagDao.getAllTags()
                .stream()
                .map(tagDtoService::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTag(Long id) {
        tagDao.deleteTag(id);
    }

    @Override
    public TagDto getTagById(Long id) {
        return tagDtoService.toDto(tagDao.getTagById(id));
    }
}
