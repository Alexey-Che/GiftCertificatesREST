package com.example.GiftCertificatesREST.controllers;

import com.example.GiftCertificatesREST.dto.TagDto;
import com.example.GiftCertificatesREST.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping()
    @ResponseBody
    public List<TagDto> getTags(){
        return tagService.getAllTags();

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTag(@PathVariable("id") Long id) {
        tagService.deleteTag(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public TagDto getTagById(@PathVariable("id") Long id) {
        return tagService.getTagById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public TagDto createTag(@RequestBody TagDto tagDto){
        return tagService.createTag(tagDto);
    }
}
