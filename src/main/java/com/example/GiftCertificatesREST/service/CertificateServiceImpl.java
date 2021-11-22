package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.dao.GiftCertificateDao;
import com.example.GiftCertificatesREST.dto.GiftCertificateDto;
import com.example.GiftCertificatesREST.models.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final GiftCertificateDao giftCertificateDao;
    private final GiftCertificateDtoService giftCertificateDtoService;

    @Autowired
    public CertificateServiceImpl(GiftCertificateDao giftCertificateDao, GiftCertificateDtoService giftCertificateDtoService) {
        this.giftCertificateDao = giftCertificateDao;
        this.giftCertificateDtoService = giftCertificateDtoService;
    }

    @Override
    public GiftCertificateDto createGiftCertificate(GiftCertificateDto giftCertificateDto) {
        GiftCertificate giftCertificate = giftCertificateDtoService.toEntity(giftCertificateDto);
        giftCertificate.setCreateDate(LocalDate.now());
        giftCertificate.setLastUpdateDate(LocalDate.now());
        return giftCertificateDtoService.toDto(giftCertificateDao.createCertificate(giftCertificate));
    }

    @Override
    public List<GiftCertificateDto> getAllCertificates() {
        return giftCertificateDao.getAllCertificates()
                .stream()
                .map(giftCertificateDtoService::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificateDto> getGiftCertificateBySubstring(String substring, String sort) {
        List<GiftCertificate> result = giftCertificateDao.getGiftCertificateBySubstring(substring);
        return getSortedGiftCertificatesBy(result, sort)
                .stream()
                .map(giftCertificateDtoService::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGiftCertificate(Long id) {
        giftCertificateDao.deleteCertificate(id);
    }

    @Override
    public GiftCertificateDto getGiftCertificateById(Long id) {
        return giftCertificateDtoService.toDto(giftCertificateDao.getCertificateById(id));
    }

    @Override
    public void updateGiftCertificate(Long id, GiftCertificateDto giftCertificateDto) {
        GiftCertificate giftCertificate = giftCertificateDtoService.toEntity(giftCertificateDto);
        giftCertificateDao.updateCertificate(id, giftCertificate);
    }

    @Override
    public List<GiftCertificateDto> getGiftCertificatesByTagId(Long id, String sort) {
        List<GiftCertificate> result = giftCertificateDao.getGiftCertificatesByTagId(id);
        return getSortedGiftCertificatesBy(result, sort)
                .stream()
                .map(giftCertificateDtoService::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GiftCertificate> getSortedGiftCertificatesBy(List<GiftCertificate> list, String sort) {
        switch (sort) {
            case "name":
                list
                        .stream()
                        .sorted(Comparator.comparing(GiftCertificate::getName));
            case "date":
                list
                        .stream()
                        .sorted(Comparator.comparing(GiftCertificate::getCreateDate));
        }
        return list;
    }
}
