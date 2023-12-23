package com.jay.safewayauto.api.user;

import com.jay.safewayauto.domain.banner.application.BannerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserViewApi {

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

    /**
     * =========================================================================================================
     * ABOUT US
     *
     */
    @GetMapping("/company-profile")
    public String companyProfilePage(Model model, String category){
        model.addAttribute("disableLoading", true);
        if (category == null) {
            category = "전체";
        }

        model.addAttribute("category", category);
        return "user/content/pages/aboutus/company-profile";
    }


    /**
     * =========================================================================================================
     * SERVICES
     */

    @GetMapping("/daily-auction")
    public String dailyAuctionPage(Model model, String category){
        model.addAttribute("disableLoading", true);
        if (category == null) {
            category = "전체";
        }

        model.addAttribute("category", category);
        return "user/content/pages/services/daily-auction";
    }

    @GetMapping("/weekly-auction")
    public String weeklyAuctionPage(Model model, String category){
        model.addAttribute("disableLoading", true);
        if (category == null) {
            category = "전체";
        }

        model.addAttribute("category", category);
        return "user/content/pages/services/weekly-auction";
    }

    @GetMapping("/dealerships")
    public String dealershipsPage(Model model, String category){
        model.addAttribute("disableLoading", true);
        if (category == null) {
            category = "전체";
        }

        model.addAttribute("category", category);
        return "user/content/pages/services/dealerships";
    }

    @GetMapping("/stocks")
    public String stocksPage(Model model, String category){
        model.addAttribute("disableLoading", true);
        if (category == null) {
            category = "전체";
        }

        model.addAttribute("category", category);
        return "user/content/pages/services/stocks";
    }

    @GetMapping("/government-tender")
    public String governmentTenderPage(Model model, String category){
        model.addAttribute("disableLoading", true);
        if (category == null) {
            category = "전체";
        }

        model.addAttribute("category", category);
        return "user/content/pages/services/government-tender";
    }

    @GetMapping("/preconditioning")
    public String preconditioningPage(Model model, String category){
        model.addAttribute("disableLoading", true);
        if (category == null) {
            category = "전체";
        }

        model.addAttribute("category", category);
        return "user/content/pages/services/preconditioning";
    }

    /**
     * =========================================================================================================
     * SALES HISTORY
     *
     * 페이징처리
     * 최신순
     */
    @GetMapping("/sales-history")
    public String salesHistoryPage(Model model, String category){
        model.addAttribute("disableLoading", true);
        if (category == null) {
            category = "전체";
        }

        model.addAttribute("category", category);
        return "user/content/pages/saleshistory/sales-history";
    }

    /**
     * =========================================================================================================
     * SHIPPING
     */
    @GetMapping("/shipping")
    public String shippingPage(Model model, String category){
        model.addAttribute("disableLoading", true);
        if (category == null) {
            category = "전체";
        }

        model.addAttribute("category", category);
        return "user/content/pages/shipping/shipping";
    }

    /**
     * =========================================================================================================
     * CONTACT US
     */


    @GetMapping("/contact-us")
    public String contactUsPage(Model model, String category){
        model.addAttribute("disableLoading", true);
        if (category == null) {
            category = "전체";
        }

        model.addAttribute("category", category);
        return "user/content/pages/contactus/contact-us";
    }
    /**
     *
     * =========================================================================================================
     *
     */
}
