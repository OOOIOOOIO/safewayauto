package com.jay.safewayauto.api.user.main.banner.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BannerDto {
    private String title;
    private String thumbnailFileName;

    @Builder
    public BannerDto(String title, String thumbnailFileName) {
        this.title = title;
        this.thumbnailFileName = thumbnailFileName;
    }
}