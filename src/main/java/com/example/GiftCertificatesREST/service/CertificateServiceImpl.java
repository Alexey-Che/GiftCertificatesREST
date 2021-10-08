package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.dao.GiftCertificateDao;
import com.example.GiftCertificatesREST.models.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final GiftCertificateDao giftCertificateDao;

    @Autowired
    public CertificateServiceImpl(GiftCertificateDao giftCertificateDao) {
        this.giftCertificateDao = giftCertificateDao;
    }

    @Override
    public GiftCertificate createGiftCertificate(GiftCertificate giftCertificate) {
        giftCertificate.setCreateDate(LocalDate.now());
        giftCertificate.setLastUpdateDate(LocalDate.now());
        return giftCertificateDao.createCertificate(giftCertificate);
    }

    @Override
    public List<GiftCertificate> getAllCertificates() {
        return giftCertificateDao.getAllCertificates();
    }

    @Override
    public List<GiftCertificate> getGiftCertificateBySubstring(String substring) {
        return giftCertificateDao.getGiftCertificateBySubstring(substring);
    }

    @Override
    public void deleteGiftCertificate(Long id) {
        giftCertificateDao.deleteCertificate(id);
    }

    @Override
    public GiftCertificate getGiftCertificateById(Long id) {
        return giftCertificateDao.getCertificateById(id);
    }

    @Override
    public void updateGiftCertificate(Long id, GiftCertificate giftCertificate) {
        giftCertificateDao.updateCertificate(id, giftCertificate);
    }

    @Override
    public List<GiftCertificate> getGiftCertificatesByTagId(Long id) {
        return giftCertificateDao.getGiftCertificatesByTagId(id);
    }
}
