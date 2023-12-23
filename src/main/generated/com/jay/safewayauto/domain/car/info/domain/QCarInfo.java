package com.jay.safewayauto.domain.car.info.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCarInfo is a Querydsl query type for CarInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCarInfo extends EntityPathBase<CarInfo> {

    private static final long serialVersionUID = 717445194L;

    public static final QCarInfo carInfo = new QCarInfo("carInfo");

    public final StringPath carCode = createString("carCode");

    public final NumberPath<Long> carId = createNumber("carId", Long.class);

    public final ListPath<com.jay.safewayauto.domain.car.image.domain.CarImage, com.jay.safewayauto.domain.car.image.domain.QCarImage> carImageList = this.<com.jay.safewayauto.domain.car.image.domain.CarImage, com.jay.safewayauto.domain.car.image.domain.QCarImage>createList("carImageList", com.jay.safewayauto.domain.car.image.domain.CarImage.class, com.jay.safewayauto.domain.car.image.domain.QCarImage.class, PathInits.DIRECT2);

    public final StringPath carName = createString("carName");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public QCarInfo(String variable) {
        super(CarInfo.class, forVariable(variable));
    }

    public QCarInfo(Path<? extends CarInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarInfo(PathMetadata metadata) {
        super(CarInfo.class, metadata);
    }

}

