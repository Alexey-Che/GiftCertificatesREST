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

    @GetMapping() //work
    @ResponseBody
    public List<GiftCertificateDto> getGiftCertificates() {
        List<GiftCertificate> giftCertificates = certificateService.getAllCertificates();
        return giftCertificates
                .stream()
                .map(giftCertificateDtoService::convertGiftCertificateToDto)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/{id}") //work
    @ResponseStatus(HttpStatus.OK)
    public void updateGiftCertificate(@PathVariable("id") Long id,
                                      @RequestBody GiftCertificateDto giftCertificateDto) {
        GiftCertificate giftCertificate = giftCertificateDtoService
                .convertGiftCertificateDtoToEntity(giftCertificateDto);
        certificateService.updateGiftCertificate(id, giftCertificate);
    }

    @DeleteMapping(value = "/{id}") //work
    @ResponseStatus(HttpStatus.OK)
    public void deleteGiftCertificate(@PathVariable("id") Long id){
        certificateService.deleteGiftCertificate(id);
    }

    @GetMapping(value = "/{id}") //work
    @ResponseBody
    public GiftCertificateDto getGiftCertificateById(@PathVariable("id") Long id) {
        return giftCertificateDtoService
                .convertGiftCertificateToDto(certificateService.getGiftCertificateById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public GiftCertificateDto createGiftCertificate(@RequestBody GiftCertificateDto giftCertificateDto) {
        GiftCertificate giftCertificate = giftCertificateDtoService
                .convertGiftCertificateDtoToEntity(giftCertificateDto);
        GiftCertificate giftCertificateCreated = certificateService.createGiftCertificate(giftCertificate);
        return giftCertificateDtoService.convertGiftCertificateToDto(giftCertificateCreated);
    }

    @GetMapping(value = "/search") //work
    @ResponseBody
    public List<GiftCertificateDto> getGiftCertificateBySubstring(@RequestParam(value = "substring",
            required = false) String substring){
        List<GiftCertificate> giftCertificates = certificateService.getGiftCertificateBySubstring(substring);
        return giftCertificates
                .stream()
                .map(giftCertificateDtoService::convertGiftCertificateToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/tag/{id}")
    @ResponseBody
    public List<GiftCertificateDto> getGiftCertificatesByTagId(@PathVariable("id") Long id) {
        List<GiftCertificate> result = certificateService.getGiftCertificatesByTagId(id);
        return result
                .stream()
                .map(giftCertificateDtoService::convertGiftCertificateToDto)
                .collect(Collectors.toList());
    }
}
