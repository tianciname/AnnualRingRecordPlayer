package com.wuguozhang.service;

import com.wuguozhang.requestentites.RequestUserListEntity;
import com.wuguozhang.responseentites.UsersResponseEntity;

public interface UsersService {

    public abstract UsersResponseEntity saveUserName(String userName);

    public abstract UsersResponseEntity saveCollectionList(RequestUserListEntity requestUserListEntity);


    public abstract UsersResponseEntity getCollectionList(String userName);

    public abstract UsersResponseEntity isExistUserName(String userName);





}
