package com.jay.safewayauto.api.admin.main;

import com.jay.safewayauto.domain.car.application.CarInfoService;
import com.jay.safewayauto.domain.car.application.dto.CarInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminMainViewApi {

    private final CarInfoService carInfoService;

    /**
     * 메인 페이지
     */
    @GetMapping("")
    public String mainPage() {

        return "admin/content/main";
    }





}
