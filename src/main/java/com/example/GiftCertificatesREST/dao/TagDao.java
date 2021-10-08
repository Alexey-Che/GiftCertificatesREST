package com.example.GiftCertificatesREST.dao;

import com.example.GiftCertificatesREST.models.Tag;

import java.util.List;

public interface TagDao {

    Tag createTag(Tag tag);
    List<Tag> getAllTags();
    void deleteTag(Long id);
    Tag getTagById(Long id);
}
