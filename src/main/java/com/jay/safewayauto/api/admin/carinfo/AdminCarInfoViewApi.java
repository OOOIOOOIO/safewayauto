package com.jay.safewayauto.api.admin.carinfo;

import com.jay.safewayauto.domain.car.application.CarInfoService;
import com.jay.safewayauto.domain.car.application.dto.CarInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminCarInfoViewApi {

    private final CarInfoService carInfoService;

    /**
     * 조회 화면
     * 업로드 순으로(최신순)
     * 페이징처리
     */
    @GetMapping("/car/list")
    public String getCarInfoPage(){


        return "admin/content/pages/car/list";
    }

    /**
     * 상세 페이지
     */
    @GetMapping("/car/info/{carId}")
    public String carInfoPage(@PathVariable(value = "carId") Long carId, Model model){
        CarInfoDto carInfo = carInfoService.getCarInfo(carId);

        model.addAttribute("carInfo", carInfo);

        return "admin/content/pages/car/car-info";
    }


    /**
     * 업로드 페이지
     */
    @GetMapping("/car/upload")
    public String uploadPage(){


        return "admin/content/pages/car/upload";
    }


    /**
     * 수정 페이지
     */
    @GetMapping("/car/update/{carId}")
    public String updatePage(@PathVariable(value = "carId") Long carId, Model model){
        CarInfoDto carInfo = carInfoService.getCarInfo(carId);

        model.addAttribute("carInfo", carInfo);

        return "admin/content/pages/car/update";
    }


}
