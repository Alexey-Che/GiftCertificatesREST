package com.example.GiftCertificatesREST.dao;

import com.example.GiftCertificatesREST.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TagDaoImpl implements TagDao{

    @PersistenceContext
    private final EntityManager entityManager;

    private final TagRepository tagRepository;

    @Autowired
    public TagDaoImpl(EntityManager entityManager, TagRepository tagRepository) {
        this.entityManager = entityManager;
        this.tagRepository = tagRepository;
    }

    @Override
    @Transactional
    public Tag createTag(Tag tag) {
        tag.setId(null);
        entityManager.persist(tag);
        return tag;
//        return tagRepository.save(tag);
    }

    @Override
    @Transactional
    public List<Tag> getAllTags() {
        return entityManager.createQuery("select t from Tag t",
                Tag.class).getResultList();
    }

    @Override
    @Transactional
    public Tag getTagById(Long id) {
        return entityManager.find(Tag.class, id);
    }

    @Override
    @Transactional
    public void deleteTag(Long id) {
        entityManager.remove(entityManager.find(Tag.class, id));
    }
}
