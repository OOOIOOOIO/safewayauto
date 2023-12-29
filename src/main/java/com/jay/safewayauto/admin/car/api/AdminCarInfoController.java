package com.jay.safewayauto.admin.car.api;


import com.jay.safewayauto.admin.car.api.dto.req.CarInfoRequestDto;
import com.jay.safewayauto.domain.car.application.CarInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminCarInfoController {

    private final CarInfoService carInfoService;


    /**
     * 업로드
     */
    @PostMapping("/car/upload")
    public void uploadCarInfos(@ModelAttribute CarInfoRequestDto carInfoRequestDto,
                                 @RequestPart(value = "imgLink") MultipartFile file,
                                 HttpServletResponse response) throws IOException {


        carInfoService.uploadCarInfo(carInfoRequestDto, file);

        response.sendRedirect("/admin/car/list");
    }


    /**
     * 수정
     *
     */
    @PutMapping("/car/update/{carId}")
    public void updateCarInfos(@PathVariable(value = "carId") Long carId,
                                                 @ModelAttribute CarInfoRequestDto carInfoRequestDto,
                                                 @RequestPart(value = "imgLink") MultipartFile file,
                                                 HttpServletResponse response) throws IOException {

        carInfoService.updateCarInfo(carId, carInfoRequestDto, file);

        response.sendRedirect("/admin/car/list");
    }

    /**
     * 삭제
     */
    @DeleteMapping("/car/delete/{carId}")
    public ResponseEntity<String> deleteCarInfos(@PathVariable(value = "carId") Long carId){

        carInfoService.deleteCarInfo(carId);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }


}
