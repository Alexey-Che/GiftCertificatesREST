package com.example.GiftCertificatesREST.dao;

import com.example.GiftCertificatesREST.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
