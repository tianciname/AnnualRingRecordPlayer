package com.wuguozhang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuguozhang.domain.AnnualRing;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
public interface AnnualRingImpl extends BaseMapper<AnnualRing> {

}
