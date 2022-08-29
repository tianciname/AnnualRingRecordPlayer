package com.wuguozhang.requestentites;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户模块请求接收实体类
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserListEntity {

    private String userName;

    private List<RequestUserEntity> collectionData;

}
