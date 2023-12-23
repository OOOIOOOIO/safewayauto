package com.jay.safewayauto.admin.carinfo.api.dto.res;


import com.jay.safewayauto.domain.car.info.domain.CarInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarInfoResponseDto {

    private String imgLink;
    private String carName;
    private Long price; // USD

    public CarInfoResponseDto(CarInfo carInfo) {
        this.imgLink = carInfo.getImgLink();
        this.carName = carInfo.getCarName();
        this.price = carInfo.getPrice();
    }
}
