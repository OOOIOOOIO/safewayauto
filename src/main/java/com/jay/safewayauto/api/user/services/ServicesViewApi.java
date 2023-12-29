package com.jay.safewayauto.api.user.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ServicesViewApi {

    @GetMapping("/daily-auction")
    public String dailyAuctionPage(Model model){
        model.addAttribute("disableLoading", true);

        return "user/content/pages/services/daily-auction";
    }

    @GetMapping("/weekly-auction")
    public String weeklyAuctionPage(Model model){
        model.addAttribute("disableLoading", true);

        return "user/content/pages/services/weekly-auction";
    }

    @GetMapping("/dealerships")
    public String dealershipsPage(Model model){
        model.addAttribute("disableLoading", true);

        return "user/content/pages/services/dealerships";
    }

    @GetMapping("/stocks")
    public String stocksPage(Model model){
        model.addAttribute("disableLoading", true);

        return "user/content/pages/services/stocks";
    }

    @GetMapping("/government-tender")
    public String governmentTenderPage(Model model){
        model.addAttribute("disableLoading", true);

        return "user/content/pages/services/government-tender";
    }

    @GetMapping("/preconditioning")
    public String preconditioningPage(Model model){
        model.addAttribute("disableLoading", true);

        return "user/content/pages/services/preconditioning";
    }


}
