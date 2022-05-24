package com.zash.file_upload_spring_boot;

import com.zash.file_upload_spring_boot.controller.FileUploadController;
import com.zash.file_upload_spring_boot.properties.FileUploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.File;

@SpringBootApplication
@EnableConfigurationProperties({
        FileUploadProperties.class
})

public class FileUploadSpringBootApplication {


    public static void main(String[] args) {

//        new File(FileUploadController.uploadDirectory).mkdir();
        SpringApplication.run(FileUploadSpringBootApplication.class, args);
    }

}
