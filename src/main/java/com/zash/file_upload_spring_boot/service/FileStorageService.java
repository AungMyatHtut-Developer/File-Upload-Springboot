package com.zash.file_upload_spring_boot.service;

import com.zash.file_upload_spring_boot.exception.FileNotFoundException;
import com.zash.file_upload_spring_boot.exception.FileStorageException;
import com.zash.file_upload_spring_boot.helper.FileStorageHelper;
import com.zash.file_upload_spring_boot.properties.FileUploadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService implements FileStorageHelper {

    //create a path using the path from properties
    private final Path directory_location;

    //call the fileUploadProperties and create the path for directory_location
    @Autowired
    public FileStorageService(FileUploadProperties fileUploadProperties){
        this.directory_location = Paths.get(fileUploadProperties.
                getLocation()).toAbsolutePath().normalize();
    }

    //after creating The FileStorageService Object this method will start
    @Override
    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(this.directory_location);
        } catch (IOException e) {
            throw new FileStorageException("Could not create upload Directory!");
        }

    }

    //save the file
    @Override
    public String saveFile(MultipartFile file) {

        try {
            String fileName = file.getOriginalFilename();
            Path meal_file = this.directory_location.resolve(fileName);
            Files.copy(file.getInputStream(), meal_file, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException e) {
            throw new FileStorageException("Could not upload file");
        }

    }

    @Override
    public Resource loadFile(String fileName) {

        try {
            Path file = this.directory_location.resolve(fileName).normalize();
            Resource resource = new UrlResource(file.toUri());

            if(resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new FileNotFoundException("Could not find file");
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Could not download file");
        }

    }
}
