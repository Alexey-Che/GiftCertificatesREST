package com.example.GiftCertificatesREST.controllers;

import com.example.GiftCertificatesREST.dto.GiftCertificateDto;
import com.example.GiftCertificatesREST.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificate")
public class GiftCertificatesController {

    private final CertificateService certificateService;


    @Autowired
    public GiftCertificatesController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping()
    @ResponseBody
    public List<GiftCertificateDto> getGiftCertificates() {
        return certificateService.getAllCertificates();

    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateGiftCertificate(@PathVariable("id") Long id,
                                      @RequestBody GiftCertificateDto giftCertificateDto) {
        certificateService.updateGiftCertificate(id, giftCertificateDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGiftCertificate(@PathVariable("id") Long id) {
        certificateService.deleteGiftCertificate(id);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public GiftCertificateDto getGiftCertificateById(@PathVariable("id") Long id) {
        return certificateService.getGiftCertificateById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public GiftCertificateDto createGiftCertificate(@RequestBody GiftCertificateDto giftCertificateDto) {
        return certificateService.createGiftCertificate(giftCertificateDto);
    }

    @GetMapping(value = "/search")
    @ResponseBody
    public List<GiftCertificateDto> getGiftCertificateBySubstring(@RequestParam(value = "substring") String substring,
                                                                  @RequestParam(value = "sortBy") String sort) {
        return certificateService.getGiftCertificateBySubstring(substring, sort);
    }

    @GetMapping(value = "/tag/{id}")
    @ResponseBody
    public List<GiftCertificateDto> getGiftCertificatesByTagId(@PathVariable("id") Long id,
                                                               @RequestParam(value = "sortBy") String sort) {
        return certificateService.getGiftCertificatesByTagId(id, sort);
    }
}
