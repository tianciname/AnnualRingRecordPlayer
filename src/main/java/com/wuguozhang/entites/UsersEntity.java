package com.wuguozhang.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 功能: 登录模块实体类
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity {

    private String userName;


    private List<String> collectionList;

    private String musicName;

    private List<String> historyList;
}
