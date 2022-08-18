package com.wuguozhang.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * 功能: 库模块实体类
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnualRingEntity {


    private long id;

    private List<String> idList;

    private String annualRingImage;

    private String annualRingEnvironmental;

    private String music;

    public String musicName;


}
