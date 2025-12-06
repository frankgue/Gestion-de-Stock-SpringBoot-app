package com.gkfcsolution.pstock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created on 2025 at 16:38
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 16:38
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound  extends Exception{

    public ResourceNotFound(String message) {
        super(message);
    }
}
