package com.wuguozhang.controller.exception;


import com.wuguozhang.controller.exception.superexception.extendbussinessexception.DeleteException;
import com.wuguozhang.controller.exception.superexception.extendbussinessexception.GetException;
import com.wuguozhang.controller.exception.superexception.extendbussinessexception.SaveException;
import com.wuguozhang.responseentites.ARResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectException {


    @ExceptionHandler(DeleteException.class)
    public ARResponseEntity doDeleteException(DeleteException ex){

        return new ARResponseEntity(null,Code.DELETE_ERR,"删除异常");

    }

    @ExceptionHandler(GetException.class)
    public ARResponseEntity doGetException(GetException ex){

        return new ARResponseEntity(null,Code.GET_ERR,"获取异常");

    }

    @ExceptionHandler(SaveException.class)
    public ARResponseEntity doSaveException(SaveException ex){

        return new ARResponseEntity(null,Code.SAVE_ERR,"获取异常");

    }

    @ExceptionHandler(Exception.class)
    public ARResponseEntity doOtherException(Exception ex){

        return new ARResponseEntity(null ,Code.SYSTEM_ERR,"系统繁忙，请稍后再试！");
    }

}
