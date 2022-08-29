package com.wuguozhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.wuguozhang.controller.exception.Code;
import com.wuguozhang.controller.exception.superexception.extendbussinessexception.GetException;
import com.wuguozhang.controller.exception.superexception.extendbussinessexception.SaveException;
import com.wuguozhang.dao.UserInter;
import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.domain.Users;
import com.wuguozhang.requestentites.RequestUserEntity;
import com.wuguozhang.requestentites.RequestUserListEntity;
import com.wuguozhang.responseentites.UserDataEntity;
import com.wuguozhang.responseentites.UsersEntity;
import com.wuguozhang.responseentites.UsersResponseEntity;
import com.wuguozhang.service.UsersService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


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
        user.setId(UUID.randomUUID().toString());
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
    public UsersResponseEntity saveCollectionList(RequestUserListEntity requestUserListEntity) {

        Users user = new Users();
        String collectionInfoData = "";

        for (RequestUserEntity collectionObject : requestUserListEntity.getCollectionData()) {
            String musicListForString = collectionObject.getId() + "," +
                    collectionObject.getMusicId() + "," + collectionObject.getMusicName() + ",";

            collectionInfoData += musicListForString ;
        }
        user.setCollectionData(collectionInfoData);

        LambdaUpdateWrapper<Users> objectLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        objectLambdaUpdateWrapper.eq(Users::getUserName,requestUserListEntity.getUserName());
        try {
            users.update(user,objectLambdaUpdateWrapper);
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

        List<UserDataEntity> userDataEntityList = new ArrayList<>();
        LambdaUpdateWrapper<Users> objectLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        objectLambdaUpdateWrapper.eq(Users::getUserName,userName);
        try {
            Users usersData = users.selectOne(objectLambdaUpdateWrapper);
            String collectionData = usersData.getCollectionData();

            String[] collectionDataForStringArray = collectionData.split(",");

            UserDataEntity userDataEntity = new UserDataEntity();

            int index =0;
            for (int size_i = 0;size_i<collectionDataForStringArray.length/3;size_i++){

                userDataEntity.setId(collectionDataForStringArray[index]);
                userDataEntity.setMusicId(collectionDataForStringArray[index+1]);
                userDataEntity.setMusicName(collectionDataForStringArray[index+2]);

                userDataEntityList.add(userDataEntity);

                index += 3;
            }

        }catch (Exception e){
            throw new GetException();
        }
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setCollectionData(userDataEntityList);
        return new UsersResponseEntity(
                usersEntity,
                Code.GET_OK,
                "获取成功"
        );
    }

    @Override
    public UsersResponseEntity isExistUserName(String userName) {
        LambdaQueryWrapper<Users> usersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        usersLambdaQueryWrapper.select(Users::getUserName);
        List<Users> usersList = users.selectList(usersLambdaQueryWrapper);

        for (Users user:usersList){
            if (user.getUserName().equals(userName)){

                return new UsersResponseEntity(
                        null,
                        Code.GET_OK,
                        "获取成功 名称存在"
                );
            }
        }
        return new UsersResponseEntity(
                null,
                Code.GET_ERR,
                "获取失败 名称不存在"
        );
    }

}
