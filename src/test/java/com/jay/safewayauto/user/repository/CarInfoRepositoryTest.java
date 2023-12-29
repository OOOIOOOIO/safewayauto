package com.jay.safewayauto.user.repository;


import com.jay.safewayauto.domain.car.application.dto.CarInfoDto;
import com.jay.safewayauto.domain.car.domain.CarInfo;
import com.jay.safewayauto.domain.car.domain.repository.CarInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest
public class CarInfoRepositoryTest {

    @Autowired
    CarInfoRepository carInfoRepository;


    @Test
    @Transactional
    public void uploadCarInfoTest() throws InterruptedException {
        String[] imgArr = new String[]{
                "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/교촌치킨-레드콤보.jpeg",
                "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/굽네치킨-고추바사삭.png",
                "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/바른치킨-통곡물간장치킨.jpeg",
                "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/bhc-뿌링클.jpg",
                "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/bhc-포테킹-후라이드.jpeg",
                "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/60계-크크크치킨.png",
                "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/60계-간지치킨.png",
                "https://seongho-s3-bucket.s3.ap-northeast-2.amazonaws.com/chicken/60계-후라이드치킨.png"

        };

        String[] nameArr = new String[]{
                "교촌치킨-레드콤보.jpeg",
                "굽네치킨-고추바사삭.png",
                "바른치킨-통곡물간장치킨.jpeg",
                "뿌링클.jpg",
                "포테킹-후라이드.jpeg",
                "60계-크크크치킨.png",
                "60계-간지치킨.png",
                "60계-후라이드치킨.png"

        };

        Long[] priceArr = new Long[]{
                10000L,
                20000L,
                30000L,
                40000L,
                50000L,
                60000L,
                70000L,
                80000L

        };

        for(int i = 0; i < nameArr.length * 100; i++){
            log.info("index: " + i);
            carInfoRepository.save(CarInfo.createCar(imgArr[i % 7], priceArr[i%7], nameArr[i%7]));
            Thread.sleep(1000);
        }


    }


}
