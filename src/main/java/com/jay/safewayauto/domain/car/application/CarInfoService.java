package com.jay.safewayauto.domain.car.application;

import com.jay.safewayauto.admin.car.api.dto.req.CarInfoRequestDto;
import com.jay.safewayauto.domain.car.application.dto.CarInfoDto;
import com.jay.safewayauto.domain.car.domain.CarInfo;
import com.jay.safewayauto.domain.car.domain.repository.CarInfoRepository;
import com.jay.safewayauto.util.aws.s3.service.AmazonS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CarInfoService {

    private final CarInfoRepository carInfoRepository;
    private final AmazonS3Service amazonS3Service;


    /**
     * 자동차 조회
     */
    public CarInfoDto getCarInfo(Long carId) {
        CarInfo carInfo = carInfoRepository.findById(carId).orElseThrow(() -> new RuntimeException("해당 자동차 정보가 존재하지 않습니다."));

        return new CarInfoDto(carInfo);
    }


    /**
     * 자동차 리스트 조회
     *
     * 업로드 순으로(최신순)
     */
    public Page<CarInfoDto> getCarList(Pageable pageable) {

        Page<CarInfoDto> carList = carInfoRepository.findAll(pageable).map(CarInfoDto::new);

        return carList;
    }


    /**
     * 업로드
     */
    public void uploadCarInfo(CarInfoRequestDto carInfoRequestDto, MultipartFile file) {

        String imgLink = amazonS3Service.uploadFile(file);
        CarInfo car = CarInfo.createCar(imgLink, carInfoRequestDto.getPrice(), carInfoRequestDto.getCarName());

        carInfoRepository.save(car);
        log.info("===== CarInfoService | upload =====");

    }

    /**
     * 수정
     */
    public void updateCarInfo(Long carId, CarInfoRequestDto carInfoRequestDto, MultipartFile file) {

        CarInfo oldCarInfo = carInfoRepository.findById(carId).orElseThrow(() -> new RuntimeException("해당 자동차 정보가 존재하지 않습니다."));

        amazonS3Service.deleteFile(oldCarInfo.getImgLink());

        // 수정
        String imgLink = amazonS3Service.uploadFile(file);
        oldCarInfo.updateCar(imgLink, carInfoRequestDto.getPrice(), carInfoRequestDto.getCarName());

        log.info("===== CarInfoService | update =====");

    }

    /**
     * 삭제
     */
    public void deleteCarInfo(Long carId){

        CarInfo oldCarInfo = carInfoRepository.findById(carId).orElseThrow(() -> new RuntimeException("해당 자동차 정보가 존재하지 않습니다."));

        carInfoRepository.delete(oldCarInfo);
        amazonS3Service.deleteFile(oldCarInfo.getImgLink());

        log.info("===== CarInfoService | delete =====");
    }



}
