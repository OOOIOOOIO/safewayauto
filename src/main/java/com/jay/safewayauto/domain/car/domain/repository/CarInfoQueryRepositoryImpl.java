package com.jay.safewayauto.domain.car.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CarInfoQueryRepositoryImpl implements CarInfoQueryRepository{

    private final JPAQueryFactory queryFactory;

}
