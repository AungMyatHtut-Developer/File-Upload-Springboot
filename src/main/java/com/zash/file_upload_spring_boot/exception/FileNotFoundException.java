package com.zash.file_upload_spring_boot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String message;
                                        
}
