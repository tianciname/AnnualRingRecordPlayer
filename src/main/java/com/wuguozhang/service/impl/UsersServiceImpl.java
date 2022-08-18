package com.wuguozhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuguozhang.controller.exception.Code;
import com.wuguozhang.controller.exception.superexception.extendbussinessexception.GetException;
import com.wuguozhang.controller.exception.superexception.extendbussinessexception.SaveException;
import com.wuguozhang.dao.UserInter;
import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.domain.Users;
import com.wuguozhang.entites.UsersEntity;
import com.wuguozhang.entites.UsersResponseEntity;
import com.wuguozhang.service.UsersService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 所属功能模块: 登录模块
 * 功能: service层接口实现类
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 *
 */
@Data
@Service
@NoArgsConstructor
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserInter users;


    @Override
    public UsersResponseEntity saveUserName(String userName) {

        Users user = new Users();
        user.setUserName(userName);

        try {
            users.insert(user);
        }catch (Exception e){
            throw new SaveException();
        }

        return new UsersResponseEntity(
                null,
                Code.SAVE_OK,
                "添加成功"
            );
    }

    @Override
    public UsersResponseEntity saveCollectionList(String userName, String collectionList, String musicName) {

        Users user = new Users();
        user.setUserName(userName);
        user.setCollectionList(collectionList);
        user.setMusicName(musicName);
        try {
            users.insert(user);
        }catch (Exception e){
            throw new SaveException();
        }
        return new UsersResponseEntity(
                null,
                Code.SAVE_OK,
                "添加成功"
        );
    }

    @Override
    public UsersResponseEntity saveHistoryList(String userName, String historyList) {

        Users user = new Users();
        user.setUserName(userName);
        user.setHistoryList(historyList);

        try {
            users.insert(user);
        }catch (Exception e){
            throw new SaveException();
        }

        return new UsersResponseEntity(
                null,
                Code.SAVE_OK,
                "添加成功"
        );
    }

    @Override
    public UsersResponseEntity getCollectionList(String userName) {

        LambdaQueryWrapper<Users> annualRingLambdaQueryWrapper = new LambdaQueryWrapper<>();
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUserName(userName);
        annualRingLambdaQueryWrapper.select(Users::getUserName);

        try {
            Users user = users.selectById(annualRingLambdaQueryWrapper);

            String collectionList = user.getCollectionList();
            CharSequence charSequence = collectionList.subSequence(1, collectionList.length() - 1);
            String[] splitSequences = charSequence.toString().split(",");
            List<String> collectionListRe = new ArrayList<>(Arrays.asList(splitSequences));

            usersEntity.setUserName(userName);
            usersEntity.setCollectionList(collectionListRe);
            usersEntity.setMusicName(user.getMusicName());
        }catch (Exception e){
            throw new GetException();
        }
        return new UsersResponseEntity(
                usersEntity,
                Code.GET_OK,
                "获取成功"
        );
    }

    @Override
    public UsersResponseEntity getHistoryList(String userName) {
        LambdaQueryWrapper<Users> annualRingLambdaQueryWrapper = new LambdaQueryWrapper<>();
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUserName(userName);
        annualRingLambdaQueryWrapper.select(Users::getUserName);



        try {
            Users user = users.selectById(annualRingLambdaQueryWrapper);
            String historyList = user.getHistoryList();
            CharSequence charSequence = historyList.subSequence(1, historyList.length() - 1);
            String[] splitSequences = charSequence.toString().split(",");
            List<String> historyListRe = new ArrayList<>(Arrays.asList(splitSequences));

            usersEntity.setUserName(userName);
            usersEntity.setHistoryList(historyListRe);

        }catch (Exception e){
            throw new SaveException();
        }


        return new UsersResponseEntity(
                usersEntity,
                Code.GET_OK,
                "获取成功"
        );
    }
}
