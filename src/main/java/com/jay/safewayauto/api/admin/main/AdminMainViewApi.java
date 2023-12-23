package com.jay.safewayauto.admin.view;

import com.sch.shift3.admin.service.*;
import com.sch.shift3.user.dto.*;
import com.sch.shift3.user.entity.Account;
import com.sch.shift3.user.entity.ContentFeed;
import com.sch.shift3.user.entity.Image;
import com.sch.shift3.user.entity.Product;
import com.sch.shift3.user.service.FeedService;
import com.sch.shift3.user.service.ProductService;
import com.sch.shift3.user.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminView {

    private final AdminShopService adminShopService;
    private final AdminProductService adminProductService;
    private final AdminContentFeedService adminContentFeedService;
    private final FeedService feedService;
    private final ProductService productService;
    private final PopupService popupService;
    private final QuestionService questionService;
    private final AdminNoticeService adminNoticeService;
    private final AdminAccountService adminAccountService;

    @GetMapping("")
    public String mainPage(Model model){
//        return "admin/content/main";
        model.addAttribute("questionList", questionService.getAllQuestionList());
        return "admin/content/pages/cs/list";
    }

    @GetMapping("/account/list")
    public String accountListPage(Model model){
        model.addAttribute("accounts", adminAccountService.getAllAccounts());
        return "admin/content/pages/account/list";
    }

    @GetMapping("/account/detail/{accountId}")
    public String accountDetailPage(Model model, @PathVariable Integer accountId){
        Account account = adminAccountService.getAccountById(accountId)
                        .orElse(new Account());
        model.addAttribute("account", account);
        return "admin/content/pages/account/view";
    }

    @GetMapping("/account/edit/{accountId}")
    public String accountEditPage(Model model, @PathVariable Integer accountId){
        Account account = adminAccountService.getAccountById(accountId)
                .orElse(new Account());
        model.addAttribute("account", account);
        return "admin/content/pages/account/edit";
    }

    @GetMapping("/contents/list")
    public String contentListPage(Model model){
        model.addAttribute("contents", adminContentFeedService.getAllContentList());

        return "admin/content/pages/contents/list";
    }

    @GetMapping("/contents/create")
    public String contentCreatePage(Model model){
        ContentFeedDto contentFeedDto = new ContentFeedDto();
//        contentFeedDto.setTitle("테스트");
//        contentFeedDto.setDescription("테스트");
//        contentFeedDto.setThumbnailFileName("eb2172fd-61b0-485d-826b-a65ca131074d2.png");

        model.addAttribute("ContentFeedDto", contentFeedDto);
        return "admin/content/pages/contents/create";
    }

    @GetMapping("/contents/edit/{feedId}")
    public String contentCreatePage(Model model, @PathVariable Integer feedId){
        ContentFeed contentFeed = feedService.getFeedById(feedId);
        ContentFeedDto dto = ContentFeedDto.builder()
                .id(contentFeed.getId())
                .description(contentFeed.getDescription())
                .title(contentFeed.getTitle())
                .category(contentFeed.getCategory())
                .thumbnailFileName(contentFeed.getThumbnailFileName())
                .createdAt(contentFeed.getCreatedAt())
                .isBanner(contentFeed.getIsBanner())
                .build();

        List<Product> products = productService.getProductsByFeed(feedId);
        if (!products.isEmpty())
            dto.setProducts(products);

        model.addAttribute("ContentFeedDto", dto);
        model.addAttribute("editMode", true);

        return "admin/content/pages/contents/create";
    }



}
