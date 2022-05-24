package com.zash.file_upload_spring_boot.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileStorageException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String message;



}
