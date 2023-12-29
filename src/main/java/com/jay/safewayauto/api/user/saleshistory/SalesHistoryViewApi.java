package com.jay.safewayauto.api.user.saleshistory;

import com.jay.safewayauto.domain.car.application.CarInfoService;
import com.jay.safewayauto.domain.car.application.dto.CarInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SalesHistoryViewApi {

    private final CarInfoService carInfoService;
    /**
     * sales history page
     */
    @GetMapping("/sales-history")
    public String salesHistoryPage(@PageableDefault(size = 32, sort="createdAt", direction = Sort.Direction.DESC) Pageable pageable, Model model){

        log.info("==== sales history ====");

        Page<CarInfoDto> carList = carInfoService.getCarList(pageable);

        model.addAttribute("carList",carList);

        return "user/content/pages/saleshistory/sales-history";
    }

    /**
     * carList + paging 처리(ajax)
     */
    @GetMapping("/carlist")
    @ResponseBody
    public ResponseEntity<Page<CarInfoDto>> getCarList(@PageableDefault(size = 32, sort="createdAt", direction = Sort.Direction.DESC) Pageable pageable){

        log.info("==== car List + ====");

        Page<CarInfoDto> carList = carInfoService.getCarList(pageable);

        return new ResponseEntity<>(carList, HttpStatus.OK);
    }






}
