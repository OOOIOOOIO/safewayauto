package com.jay.safewayauto.domain.car.application.dto;

import com.jay.safewayauto.domain.car.domain.CarInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CarInfoDto {

    private Long carId;
    private String imgLink;
    private String carName;
    private Long price; // USD

    public CarInfoDto(CarInfo carInfo) {
        this.carId = carInfo.getCarId();
        this.imgLink = carInfo.getImgLink();
        this.carName = carInfo.getCarName();
        this.price = carInfo.getPrice();
    }

    /**
     * 테스트용
     */
    public CarInfoDto(Long carId, String imgLink, String carName, Long price) {
        this.carId = carId;
        this.imgLink = imgLink;
        this.carName = carName;
        this.price = price;
    }
}
