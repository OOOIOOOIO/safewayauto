package com.jay.safewayauto.api.user.aboutus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AboutUsViewApi {

    @GetMapping("/company-profile")
    public String companyProfilePage(Model model){
        model.addAttribute("disableLoading", true);

        return "user/content/pages/aboutus/company-profile";
    }


}
