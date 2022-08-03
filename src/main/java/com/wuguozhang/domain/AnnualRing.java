package com.wuguozhang.domain;


import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.AllArgsConstructor;
import lombok.Data;


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
@Table(name = "data_annualRing")
@TableCharset(MySqlCharsetConstant.UTF8)
public class AnnualRing {


    @Column
    @IsNotNull
    @IsKey
    @IsAutoIncrement
    @ColumnType(MySqlTypeConstant.INT)
    public Integer id;

    @Column
    @ColumnType(MySqlTypeConstant.BINARY)
    public byte[] annualRingImage;

    @Column
    @ColumnType(MySqlTypeConstant.VARCHAR)
    public String annualRingEnvironmental;

    @Column
    @ColumnType(MySqlTypeConstant.BINARY)
    public byte[] Music;

}
