package com.example.GiftCertificatesREST.dao;

import com.example.GiftCertificatesREST.models.GiftCertificate;

import java.util.List;

public interface GiftCertificateDao {


    GiftCertificate createCertificate(GiftCertificate giftCertificate);
    List<GiftCertificate> getAllCertificates();
    List<GiftCertificate> getGiftCertificateBySubstring(String substring);
    void deleteCertificate(Long id);
    GiftCertificate getCertificateById(Long id);
    void updateCertificate(Long id, GiftCertificate giftCertificate);
    List<GiftCertificate> getGiftCertificatesByTagId(Long id);
}
