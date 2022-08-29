package com.wuguozhang.controller;


import com.wuguozhang.requestentites.RequestUserListEntity;
import com.wuguozhang.responseentites.UsersResponseEntity;
import com.wuguozhang.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

    /**
     * @param userName 用户姓名
     * @return UsersResponseEntity 统一返回实体
     */
    @PostMapping("/name")
    public  UsersResponseEntity saveUserName(@RequestParam String userName){

        return usersService.saveUserName(userName);

    }

    /**
     * 功能：保存用户的收藏列表
     * @param requestUserListEntity 收藏列表
     *                       [
     *                         {
     *                              annualRingId:xxxx,
     *                              music:{
     *                                  musicName,
     *                                  musicId,
     *                              }
     *                         },
     *                       ]
     * @return UsersResponseEntity 统一返回实体
     */
    @PostMapping("/collList")
    public  UsersResponseEntity saveCollectionList(@RequestBody RequestUserListEntity requestUserListEntity){

        return usersService.saveCollectionList(requestUserListEntity);

    }

    /**
     * 功能：获取用户的收藏列表
     *
     * @param userName 用户姓名
     * @return UsersResponseEntity 统一返回实体
     */
    @GetMapping("/collList")
    public  UsersResponseEntity getCollectionList(@RequestParam String userName){

        return usersService.getCollectionList(userName);
    }

    @GetMapping("/name")
    public UsersResponseEntity isExistUserName(@RequestParam String userName){

        return usersService.isExistUserName(userName);
    }


}
