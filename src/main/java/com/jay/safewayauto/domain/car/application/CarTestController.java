package com.jay.safewayauto.domain.car.application;

import com.jay.safewayauto.domain.car.application.dto.CarInfoDto;
import com.jay.safewayauto.domain.car.domain.CarInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/test")
public class CarTestController {

    private final CarInfoService carInfoService;
    @GetMapping
    public ResponseEntity<Page<CarInfoDto>> test(@PageableDefault(size = 32, sort="createdAt", direction = Sort.Direction.DESC) Pageable pageable){

        Page<CarInfoDto> carList = carInfoService.getCarList(pageable);


        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

}
