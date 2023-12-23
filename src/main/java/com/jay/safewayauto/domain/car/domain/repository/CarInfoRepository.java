package com.jay.safewayauto.domain.car.info.domain.repository;

import com.jay.safewayauto.domain.car.info.domain.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInfoRepository extends JpaRepository<CarInfo, Long> {


}
