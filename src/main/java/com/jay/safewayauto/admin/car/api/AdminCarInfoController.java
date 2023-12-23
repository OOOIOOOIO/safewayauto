package com.jay.safewayauto.admin.car.api;


import com.jay.safewayauto.admin.car.api.dto.req.CarInfoRequestDto;
import com.jay.safewayauto.domain.car.application.CarInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class CarInfoController {

    private final CarInfoService carInfoService;


    /**
     * 업로드
     */
    @PostMapping("/sales-history")
    public ResponseEntity<String> uploadCarInfos(@RequestBody CarInfoRequestDto carInfoRequestDto) {

        return new ResponseEntity<>("success", HttpStatus.OK);
    }


    /**
     * 수정
     *
     */
    @PutMapping("/sales-history")
    public ResponseEntity<String> updateCarInfos(){

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    /**
     * 삭제
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCarInfos(){

        return new ResponseEntity<>("success", HttpStatus.OK);
    }


}
