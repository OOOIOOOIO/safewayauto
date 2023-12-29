package com.jay.safewayauto.api.user.main.main.service;

import com.jay.safewayauto.api.user.main.main.dto.MainCarImgDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MainCarImgService {

    public List<MainCarImgDto> getMainCarImages(){
        List<MainCarImgDto> carImgList = new ArrayList<>();

        String PATH = "/user/assets/image/";
        String EXTENSION = ".jpg";

        for(int i = 1; i <= 15; i++){
            carImgList.add(MainCarImgDto.builder()
                    .carImgLink(PATH + "car_" + i + EXTENSION)
                    .build());
        }

        return carImgList;
    }
}
