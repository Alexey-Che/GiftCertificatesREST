package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.models.Tag;

import java.util.List;

public interface TagService {

    Tag createTag(Tag tag);
    List<Tag> getAllTags();
    void deleteTag(Long id);
    Tag getTagById(Long id);
}
