package com.example.multithreadlogging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class BaseResponse<T> {

    private int status;
    private T data;
    private String message;
}
