package com.jay.safewayauto.domain.car.domain.repository;

import com.jay.safewayauto.domain.car.domain.CarInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CarInfoRepository extends JpaRepository<CarInfo, Long> {


}
