package com.zash.file_upload_spring_boot.helper;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageHelper {

    void init();

    String saveFile(MultipartFile file);

    Resource loadFile(String fileName);
}
