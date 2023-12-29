package com.jay.safewayauto.api.user.main.main.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MainCarImgDto {
    private String carImgLink;

    @Builder
    public MainCarImgDto(String carImgLink) {
        this.carImgLink = carImgLink;
    }
}
