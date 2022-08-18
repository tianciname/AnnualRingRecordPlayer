package com.wuguozhang.service;

import com.wuguozhang.entites.UsersResponseEntity;

public interface UsersService {

    public abstract UsersResponseEntity saveUserName(String userName);

    public abstract UsersResponseEntity saveCollectionList(String userName, String collectionList, String musicName);

    public abstract UsersResponseEntity saveHistoryList(String userName, String historyList);


    public abstract UsersResponseEntity getCollectionList(String userName);

    public abstract UsersResponseEntity getHistoryList(String userName);




}
