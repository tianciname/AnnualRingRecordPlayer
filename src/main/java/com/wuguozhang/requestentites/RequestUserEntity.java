package com.wuguozhang.requestentites;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserEntity {

    private String id;

    private String musicId;

    private String musicName;

}
