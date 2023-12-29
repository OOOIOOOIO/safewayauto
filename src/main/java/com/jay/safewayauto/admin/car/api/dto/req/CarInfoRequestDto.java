package com.jay.safewayauto.admin.car.api.dto.req;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarInfoRequestDto {

    private String carName;
    private Long price; // USD

    public CarInfoRequestDto(String carName, Long price) {
        this.carName = carName;
        this.price = price;
    }


}
