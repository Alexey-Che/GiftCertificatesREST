package com.example.GiftCertificatesREST.service;

import com.example.GiftCertificatesREST.dto.GiftCertificateDto;
import com.example.GiftCertificatesREST.models.GiftCertificate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftCertificateDtoService {

    private final ModelMapper modelMapper;

    @Autowired
    public GiftCertificateDtoService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GiftCertificateDto convertGiftCertificateToDto(GiftCertificate giftCertificate) {
        return modelMapper.map(giftCertificate,
                GiftCertificateDto.class);
    }

    public GiftCertificate convertGiftCertificateDtoToEntity(GiftCertificateDto giftCertificateDto) {
        return modelMapper.map(giftCertificateDto, GiftCertificate.class);
    }
}
