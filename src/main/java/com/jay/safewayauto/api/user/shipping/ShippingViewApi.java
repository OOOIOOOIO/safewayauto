package com.jay.safewayauto.api.user.shipping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ShippingViewApi {

    @GetMapping("/shipping")
    public String shippingPage(Model model){
        model.addAttribute("disableLoading", true);

        return "user/content/pages/shipping/shipping";
    }


}
