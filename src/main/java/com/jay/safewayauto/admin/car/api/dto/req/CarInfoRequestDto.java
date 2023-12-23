package com.jay.safewayauto.admin.carinfo.api.dto.req;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarInfoRequestDto {

    private String imgLink;
    private String carName;
    private Long price; // USD

    public CarInfoRequestDto(String imgLink, String carName, Long price) {
        this.imgLink = imgLink;
        this.carName = carName;
        this.price = price;
    }


}
