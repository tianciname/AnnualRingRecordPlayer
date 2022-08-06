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
 * 成员变量:
 *         annualRingImage             年轮图片
 *         annualRingEnvironmental     环保知识
 *         Music                       乐曲
 *
 * @author wuguozhang
 * @version 1.0  2022.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@TableCharset(MySqlCharsetConstant.UTF8)
public class AnnualRing {


    @Column
    @IsNotNull
    @IsKey
    @IsAutoIncrement
    @ColumnType(MySqlTypeConstant.INT)
    public long id;

    @Column
    @ColumnType(value = MySqlTypeConstant.VARCHAR,length = 100)
    public String annualRingImage;

    @Column
    @ColumnType(value = MySqlTypeConstant.VARCHAR,length = 100)
    public String annualRingEnvironmental;

    @Column
    @ColumnType(value = MySqlTypeConstant.VARCHAR,length = 100)
    public String music;

}
