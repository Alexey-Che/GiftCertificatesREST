package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.dto.GiftCertificateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CertificateServiceImplTest {

    @Autowired
    private CertificateService service;

    @Test
    void createGiftCertificate() {
        LocalDate date = LocalDate.now();
        GiftCertificateDto giftCertificate = new GiftCertificateDto(1L, "name", "description", 10, date, date, 10);
        GiftCertificateDto expected = service.createGiftCertificate(giftCertificate);
        assertEquals(giftCertificate, expected);
    }

    @Test
    void getAllCertificates() {
    }

    @Test
    void getGiftCertificateBySubstring() {
    }

    @Test
    void deleteGiftCertificate() {
    }

    @Test
    void getGiftCertificateById() {
    }

    @Test
    void updateGiftCertificate() {
    }

    @Test
    void getGiftCertificatesByTagId() {
    }

    @Test
    void getSortedGiftCertificatesBy() {
    }
}