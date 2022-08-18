package com.wuguozhang.controller;


import com.wuguozhang.entites.UsersResponseEntity;
import com.wuguozhang.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 所属功能模块: 建库模块
 * 功能: 表现层实现类
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 *
 */
@RestController
@RequestMapping( "/user")
public class UserController {

    @Autowired
    private UsersServiceImpl usersService;


    @PostMapping("/name")
    public  UsersResponseEntity saveUserName(@RequestParam String userName){

        return usersService.saveUserName(userName);

    }

    @PostMapping("/collList")
    public  UsersResponseEntity saveCollectionList(@RequestParam String userName,
                                                    @RequestParam List<String> collectionList,
                                                   @RequestParam String musicName){

        String collectionStringList = collectionList.toString();

        return usersService.saveCollectionList(userName, collectionStringList,musicName);

    }

    @PostMapping("/hisList")
    public  UsersResponseEntity saveHistoryList(@RequestParam String userName,
                                                @RequestParam List<String> historyList){

        String StringList = historyList.toString();

        return usersService.saveHistoryList(userName,StringList);
    }

    @GetMapping("/collList")
    public  UsersResponseEntity getCollectionList(@RequestParam String userName){
        return usersService.getCollectionList(userName);
    }

    @GetMapping("/hisList")
    public  UsersResponseEntity getHistoryList(@RequestParam String userName){

        return usersService.getHistoryList(userName);

    }

}
