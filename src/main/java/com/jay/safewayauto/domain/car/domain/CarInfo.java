package com.jay.safewayauto.domain.car.domain;

import com.jay.safewayauto.domain.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CarInfo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;
    private String imgLink;
    private String carName;
    private Long price; // USD


    @Builder
    private CarInfo(String imgLink, String carName, Long price) {
        this.imgLink = imgLink;
        this.carName = carName;
        this.price = price;
    }

    public static CarInfo createCar(String imgLink, Long price, String carName){
        return CarInfo.builder()
                .imgLink(imgLink)
                .price(price)
                .carName(carName)
                .build();

    }


    /**
     * 수정 - 더티체킹
     */
    public void updateCar(String imgLink, Long price, String carName){
        this.imgLink = imgLink;
        this.price = price;
        this.carName = carName;
    }





}
