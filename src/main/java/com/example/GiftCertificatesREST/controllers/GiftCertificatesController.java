package com.example.GiftCertificatesREST.controllers;

import com.example.GiftCertificatesREST.dto.GiftCertificateDto;
import com.example.GiftCertificatesREST.models.GiftCertificate;
import com.example.GiftCertificatesREST.service.CertificateService;
import com.example.GiftCertificatesREST.service.GiftCertificateDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/certificate")
public class GiftCertificatesController {

    private final CertificateService certificateService;
    private final GiftCertificateDtoService giftCertificateDtoService;

    @Autowired
    public GiftCertificatesController(CertificateService certificateService, GiftCertificateDtoService giftCertificateDtoService) {
        this.certificateService = certificateService;
        this.giftCertificateDtoService = giftCertificateDtoService;
    }

    @GetMapping()
    @ResponseBody
    public List<GiftCertificateDto> getGiftCertificates() {
        List<GiftCertificate> giftCertificates = certificateService.getAllCertificates();
        return giftCertificates
                .stream()
                .map(giftCertificateDtoService::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateGiftCertificate(@PathVariable("id") Long id,
                                      @RequestBody GiftCertificateDto giftCertificateDto) {
        GiftCertificate giftCertificate = giftCertificateDtoService
                .toEntity(giftCertificateDto);
        certificateService.updateGiftCertificate(id, giftCertificate);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGiftCertificate(@PathVariable("id") Long id){
        certificateService.deleteGiftCertificate(id);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public GiftCertificateDto getGiftCertificateById(@PathVariable("id") Long id) {
        return giftCertificateDtoService
                .toDto(certificateService.getGiftCertificateById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public GiftCertificateDto createGiftCertificate(@RequestBody GiftCertificateDto giftCertificateDto) {
        GiftCertificate giftCertificate = giftCertificateDtoService
                .toEntity(giftCertificateDto);
        GiftCertificate giftCertificateCreated = certificateService.createGiftCertificate(giftCertificate);
        return giftCertificateDtoService.toDto(giftCertificateCreated);
    }

    @GetMapping(value = "/search")
    @ResponseBody
    public List<GiftCertificateDto> getGiftCertificateBySubstring(@RequestParam(value = "substring") String substring,
                                                                  @RequestParam(value = "sortBy") String sort){
        List<GiftCertificate> result =  certificateService.getGiftCertificateBySubstring(substring);
        return certificateService
                .getSortedGiftCertificatesBy(result, sort)
                .stream()
                .map(giftCertificateDtoService::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/tag/{id}")
    @ResponseBody
    public List<GiftCertificateDto> getGiftCertificatesByTagId(@PathVariable("id") Long id,
                                                               @RequestParam(value = "sortBy") String sort) {
        List<GiftCertificate> result = certificateService.getGiftCertificatesByTagId(id);
        return certificateService
                .getSortedGiftCertificatesBy(result, sort)
                .stream()
                .map(giftCertificateDtoService::toDto)
                .collect(Collectors.toList());
    }
}
