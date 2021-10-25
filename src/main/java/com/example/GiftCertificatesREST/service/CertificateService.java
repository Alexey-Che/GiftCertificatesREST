package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.models.GiftCertificate;

import java.util.List;

public interface CertificateService {

    GiftCertificate createGiftCertificate(GiftCertificate giftCertificate);
    List<GiftCertificate> getAllCertificates();
    List<GiftCertificate> getGiftCertificateBySubstring(String substring);
    void deleteGiftCertificate(Long id);
    GiftCertificate getGiftCertificateById(Long id);
    void updateGiftCertificate(Long id, GiftCertificate giftCertificate);
    List<GiftCertificate> getGiftCertificatesByTagId(Long id);
    List<GiftCertificate> getSortedGiftCertificatesBy(List<GiftCertificate> list, String sort);
}
