package com.wuguozhang.service;


import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.domain.Music;
import com.wuguozhang.responseentites.ARResponseEntity;

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

    public ARResponseEntity  getAnnualRingMusicList(String id) ;

    public ARResponseEntity addAnnualRing(AnnualRing annualRing, List<Music> musicList);

    public ARResponseEntity deleteAnnualRingById(String id);

}
