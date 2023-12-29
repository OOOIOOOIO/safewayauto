package com.jay.safewayauto.api.user.main;

import com.jay.safewayauto.api.user.main.banner.service.BannerService;
import com.jay.safewayauto.api.user.main.main.service.MainCarImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserMainViewApi {

    /**
     * =========================================================================================================
     * MAIN
     */
    private final BannerService bannerService;
    private final MainCarImgService mainCarImgService;

    @GetMapping("/")
    public String mainPage(Model model){

        model.addAttribute("disableLoading", true);

        model.addAttribute("bannerList", bannerService.getBannerImages());
        model.addAttribute("carImgList", mainCarImgService.getMainCarImages());

        log.info("=======" + "MAIN PAGE" + "========");

        return "user/content/main";
    }


}
