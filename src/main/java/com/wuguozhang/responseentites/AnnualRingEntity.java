package com.wuguozhang.responseentites;

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


    private String id;

    private List<String> idList;

    private List<String> musicList;


}
