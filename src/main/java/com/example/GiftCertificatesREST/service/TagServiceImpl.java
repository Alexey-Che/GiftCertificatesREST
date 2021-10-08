package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.dao.TagDao;
import com.example.GiftCertificatesREST.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{

    private final TagDao tagDao;

    @Autowired
    public TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagDao.createTag(tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagDao.getAllTags();
    }

    @Override
    public void deleteTag(Long id) {
        tagDao.deleteTag(id);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagDao.getTagById(id);
    }
}
