package com.jay.safewayauto.domain.car.info.application;

import com.jay.safewayauto.domain.car.info.domain.repository.CarInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CarInfoService {

    private final CarInfoRepository carInfoRepository;

    /**
     * 조회
     *
     * 업로드 순으로(최신순)
     */
    public void getCarInfos(){

    }

    /**
     * 업로드
     */
    public void uploadCarInfo(){

    }

    /**
     * 수정
     */
    public void updateCarInfo(){

    }

    /**
     * 삭제
     */
    public void deleteCarInfo(){

    }


}
