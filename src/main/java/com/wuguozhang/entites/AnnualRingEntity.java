package com.wuguozhang.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 功能: 库模块返回实体类
 * @author wuguozhang
 * @version 1.0 2022.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnualRingEntity {


    public long id;

    public String annualRingImage;

    public String annualRingEnvironmental;

    public String music;
}
