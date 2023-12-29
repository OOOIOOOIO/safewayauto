package com.jay.safewayauto.util.aws.s3.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AmazonS3Service {

    private final AmazonS3Client amazonS3Client;


    @Value("${cloud.aws.region.static}")
    private String region;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String uploadFile(MultipartFile file){

        String fileUrl = "None";
        try {
            LocalDateTime now = LocalDateTime.now();
            String fileName = "safeway/" + now + file.getOriginalFilename();
            fileUrl= "https://" + bucket + ".s3." + region + ".amazonaws.com/" + fileName;
            ObjectMetadata metadata= new ObjectMetadata();

            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());

            amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
            return fileUrl;

        } catch (IOException e) {

            log.info("[error] : " + e.getMessage());
            throw new RuntimeException("S3 파일 업로드에 실패하였습니다.");
        }

    }


    public String deleteFile(String imgLink){

        amazonS3Client.deleteObject(bucket, imgLink);

        return null;
    }





}
