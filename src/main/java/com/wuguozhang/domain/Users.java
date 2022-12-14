package com.wuguozhang.domain;

import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * 年轮实体类
 *
 * @author wuguozhang
 * @version 1.0  2022.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@TableCharset(MySqlCharsetConstant.UTF8)
public class Users {

    @Column
    @IsNotNull
    @IsKey
    @ColumnType(MySqlTypeConstant.VARCHAR)
    private String id;

    @Column
    @ColumnType(MySqlTypeConstant.VARCHAR)
    private String userName;

    @Column
    @ColumnType(value = MySqlTypeConstant.VARCHAR)
    private String collectionData;


}
