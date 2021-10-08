package com.example.GiftCertificatesREST.dao;

import com.example.GiftCertificatesREST.models.GiftCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftCertificateRepository extends JpaRepository<GiftCertificate, Long> {
}
