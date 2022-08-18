package com.wuguozhang.entites;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 所属功能模块: 登录模块
 * 功能: 统一返回体
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponseEntity {


    private UsersEntity usersData;

    private Integer code;

    private String msg;


}
