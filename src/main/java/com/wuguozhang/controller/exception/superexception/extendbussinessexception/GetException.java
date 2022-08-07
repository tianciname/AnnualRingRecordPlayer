package com.wuguozhang.controller.exception.superexception.extendbussinessexception;

import com.wuguozhang.controller.exception.superexception.BusinessException;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class GetException extends BusinessException {

    private GetException(Integer code, String message, Throwable cause){
        super(code, message, cause);
    }
}

