package com.example.GiftCertificatesREST.controllers;

import com.example.GiftCertificatesREST.dto.TagDto;
import com.example.GiftCertificatesREST.models.Tag;
import com.example.GiftCertificatesREST.service.TagDtoService;
import com.example.GiftCertificatesREST.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;
    private final TagDtoService tagDtoService;

    @Autowired
    public TagController(TagService tagService, TagDtoService tagDtoService) {
        this.tagService = tagService;
        this.tagDtoService = tagDtoService;
    }

    @GetMapping()
    @ResponseBody
    public List<TagDto> getTags(){
        List<Tag> tags = tagService.getAllTags();
        return tags
                .stream()
                .map(tagDtoService::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTag(@PathVariable("id") Long id) {
        tagService.deleteTag(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public TagDto getTagById(@PathVariable("id") Long id) {
        return tagDtoService.toDto(tagService.getTagById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public TagDto createTag(@RequestBody TagDto tagDto){
        Tag tag = tagDtoService.toEntity(tagDto);
        Tag created = tagService.createTag(tag);
        return tagDtoService.toDto(created);
    }
}
