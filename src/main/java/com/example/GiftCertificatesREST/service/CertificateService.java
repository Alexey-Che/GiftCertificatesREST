package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.dto.GiftCertificateDto;
import com.example.GiftCertificatesREST.models.GiftCertificate;

import java.util.List;

public interface CertificateService {

    GiftCertificateDto createGiftCertificate(GiftCertificateDto giftCertificateDto);

    List<GiftCertificateDto> getAllCertificates();

    List<GiftCertificateDto> getGiftCertificateBySubstring(String substring, String sort);

    void deleteGiftCertificate(Long id);

    GiftCertificateDto getGiftCertificateById(Long id);

    void updateGiftCertificate(Long id, GiftCertificateDto giftCertificateDto);

    List<GiftCertificateDto> getGiftCertificatesByTagId(Long id, String sort);

    List<GiftCertificate> getSortedGiftCertificatesBy(List<GiftCertificate> list, String sort);
}
