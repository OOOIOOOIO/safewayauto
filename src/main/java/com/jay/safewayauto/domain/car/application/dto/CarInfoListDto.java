package com.jay.safewayauto.domain.car.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CarInfoListDto {

    private List<CarInfoDto> carList = new ArrayList<>();
    private Long totalPage;
}
