package com.wuguozhang.controller.exception.superexception.extendbussinessexception;

import com.wuguozhang.controller.exception.superexception.BusinessException;
import lombok.NoArgsConstructor;



@NoArgsConstructor
public class DeleteException extends BusinessException {


    private DeleteException(Integer code, String message, Throwable cause){
        super(code, message, cause);
    }
}
