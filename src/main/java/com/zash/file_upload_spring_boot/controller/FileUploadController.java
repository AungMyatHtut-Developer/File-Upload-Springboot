package com.zash.file_upload_spring_boot.controller;

import com.zash.file_upload_spring_boot.helper.FileStorageHelper;
import com.zash.file_upload_spring_boot.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    @Autowired
    FileStorageHelper fileStorageHelper;

    @GetMapping("/")
    public String uploadPage(Model model) {
        return "uploadview";
    }

    @PostMapping("/upload")
    public String upload(Model model, @RequestParam("file")MultipartFile file){
        String upload_file = fileStorageHelper.saveFile(file);
//        StringBuilder fileNames = new StringBuilder();
//        for(MultipartFile file: files){
//            Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
//            fileNames.append(file.getOriginalFilename());
//            try {
//                Files.write(fileNameAndPath,file.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        model.addAttribute("msg","Successfully uploaded files "+file.toString());
        return "uploadfilestatusview";
    }
}
