package com.jay.safewayauto.api.user.main;

import com.jay.safewayauto.domain.banner.application.BannerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainViewApi {

    /**
     * =========================================================================================================
     * MAIN
     */
    private final BannerService bannerService;

    @GetMapping("/")
    public String mainPage(Model model){

        model.addAttribute("disableLoading", true);
//        model.addAttribute("popupList", popupService.getAllPopupList());
//        model.addAttribute("bannerFeed", feedService.getBannerFeed());

        model.addAttribute("bannerList", bannerService.getBannerImages());

        // category Feed
        // 최근 피드, 패션, 편집샵 스토리, 소품, 레코드 (순서대로)
//        model.addAttribute("recentFeed", feedService.getRecentFeed());
//        model.addAttribute("fashion_category", feedService.getFeedByCategory("패션"));
//        model.addAttribute("story_category", feedService.getFeedByCategory("편집샵 스토리"));
//        model.addAttribute("goods_category", feedService.getFeedByCategory("소품"));
//        model.addAttribute("record_category", feedService.getFeedByCategory("래코드"));

        log.info("=======" + "MAIN PAGE");
        return "user/content/main";
    }


}
