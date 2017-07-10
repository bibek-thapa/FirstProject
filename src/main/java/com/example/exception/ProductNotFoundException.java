/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Dell
 */

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason = "Product Not Found")
public class ProductNotFoundException extends RuntimeException{
    
}
