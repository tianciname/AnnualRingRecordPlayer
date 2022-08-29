package com.wuguozhang.domain;


import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@TableCharset(MySqlCharsetConstant.UTF8)
public class Music {

    @Column
    @IsNotNull
    @IsKey
    @ColumnType(MySqlTypeConstant.VARCHAR)
    public String id;

    @Column
    @ColumnType(value = MySqlTypeConstant.VARCHAR)
    public String music;

    @Column
    @ColumnType(value = MySqlTypeConstant.VARCHAR)
    public String annualRingImageId;

}
