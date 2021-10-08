package com.example.GiftCertificatesREST.dao;

import com.example.GiftCertificatesREST.models.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class GiftCertificateDaoImpl implements GiftCertificateDao {

    @PersistenceContext
    private final EntityManager entityManager;

    private final GiftCertificateRepository repository;

    @Autowired
    public GiftCertificateDaoImpl(EntityManager entityManager, GiftCertificateRepository repository) {
        this.entityManager = entityManager;
        this.repository = repository;
    }

    @Override
    @Transactional
    public GiftCertificate createCertificate(GiftCertificate giftCertificate) {
        return repository.save(giftCertificate);
    }

    @Override
    @Transactional()
    public List<GiftCertificate> getAllCertificates() {
        return entityManager.createQuery("select s from GiftCertificate s",
                GiftCertificate.class).getResultList();
    }

    @Override
    @Transactional
    public List<GiftCertificate> getGiftCertificateBySubstring(String substring) {
        String search = "%" + substring.toLowerCase() + "%";
        return entityManager
                .createQuery("select s from GiftCertificate s where lower(s.name) like :string or lower(s.description) like :string",
                        GiftCertificate.class).setParameter("string", search).getResultList();
    }

    @Override
    @Transactional
    public List<GiftCertificate> getGiftCertificatesByTagId(Long id) {
//        return entityManager.createQuery("select s from GiftCertificate s where Tag.id = :id",
//                GiftCertificate.class).setParameter("id", id).getResultList();
        return null;
    }

    @Override
    @Transactional
    public void deleteCertificate(Long id) {
        entityManager.remove(entityManager.find(GiftCertificate.class, id));
    }

    @Override
    @Transactional
    public GiftCertificate getCertificateById(Long id) {
        return entityManager.find(GiftCertificate.class, id);
    }

    @Override
    @Transactional
    public void updateCertificate(Long id, GiftCertificate giftCertificate) {
        GiftCertificate giftCertificateToBeUpdated = entityManager.find(GiftCertificate.class, id);
        giftCertificateToBeUpdated.setName(giftCertificate.getName());
        giftCertificateToBeUpdated.setDescription(giftCertificate.getDescription());
        giftCertificateToBeUpdated.setPrice(giftCertificate.getPrice());
        giftCertificateToBeUpdated.setCreateDate(giftCertificate.getCreateDate());
        giftCertificateToBeUpdated.setLastUpdateDate(LocalDate.now());
        giftCertificateToBeUpdated.setDuration(giftCertificate.getDuration());
    }
}
