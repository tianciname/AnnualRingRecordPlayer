package com.wuguozhang.service;


import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.entites.ARResponseEntity;
import com.wuguozhang.entites.AnnualRingEntity;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;


/**
 * 所属功能模块: 建库模块
 * 功能: service层接口
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 *
 */
public interface AnnualRingService {

    public ARResponseEntity getAllAnnualRingIdList();

    public ARResponseEntity getAnnualRingImage(String id) ;

    public ARResponseEntity  getAnnualRing(String id) ;

    public ARResponseEntity addAnnualRing(AnnualRing annualRing);

    public ARResponseEntity deleteAnnualRingById(String id);

    public ARResponseEntity addMusicName(AnnualRing annualRing);

}
