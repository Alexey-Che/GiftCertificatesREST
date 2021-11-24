package com.example.GiftCertificatesREST.dto;

import com.example.GiftCertificatesREST.models.Tag;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class GiftCertificateDto {

    private Long id;
    private String name;
    private String description;
    private int price;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;
    private int duration;
    private Set<Tag> tags;

    public GiftCertificateDto() {
    }

    public GiftCertificateDto(Long id, String name, String description, int price, LocalDate createDate, LocalDate lastUpdateDate, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GiftCertificateDto)) return false;
        GiftCertificateDto that = (GiftCertificateDto) o;
        return getPrice() == that.getPrice()
                && getDuration() == that.getDuration()
                && Objects.equals(getId(), that.getId())
                && Objects.equals(getName(), that.getName())
                && Objects.equals(getDescription(), that.getDescription())
                && Objects.equals(getCreateDate(), that.getCreateDate())
                && Objects.equals(getLastUpdateDate(), that.getLastUpdateDate())
                && Objects.equals(getTags(), that.getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getCreateDate(), getLastUpdateDate(), getDuration(), getTags());
    }
}
