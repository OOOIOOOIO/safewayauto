package com.jay.safewayauto.api.user.contactus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ContactUsViewApi {

    @GetMapping("/contact-us")
    public String contactUsPage(Model model){
        model.addAttribute("disableLoading", true);

        return "user/content/pages/contactus/contact-us";
    }

}
