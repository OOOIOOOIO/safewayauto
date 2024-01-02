package com.jay.safewayauto.api.user.main.banner.service;

import com.jay.safewayauto.api.user.main.banner.dto.BannerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BannerService {


    public List<BannerDto> getBannerImages() {

        List<BannerDto> bannerFeed = new ArrayList<>();

        String[] imgArr = new String[]{
                "/user/assets/image/banner_11.jpeg",
                "/user/assets/image/banner_12.jpeg"
        };

        for(int i = 0; i < imgArr.length; i++){
            bannerFeed.add(BannerDto.builder().thumbnailFileName(imgArr[i])
                    .title((i+1)+"")
                    .build());

        }

        for(int i = 0; i < imgArr.length; i++){
            log.info(bannerFeed.get(i).getThumbnailFileName());
        }

        log.info("================");

        return bannerFeed;
    }
}
