package com.wuguozhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuguozhang.auunalringutils.AnnualRingUtils;
import com.wuguozhang.controller.exception.Code;
import com.wuguozhang.controller.exception.superexception.extendbussinessexception.DeleteException;
import com.wuguozhang.controller.exception.superexception.extendbussinessexception.GetException;
import com.wuguozhang.controller.exception.superexception.extendbussinessexception.SaveException;
import com.wuguozhang.dao.AnnualRingInter;
import com.wuguozhang.dao.MusicInter;
import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.domain.Music;
import com.wuguozhang.responseentites.ARResponseEntity;
import com.wuguozhang.responseentites.AnnualRingEntity;
import com.wuguozhang.service.AnnualRingService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 所属功能模块: 建库模块
 * 功能: service层接口实现类
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 *
 */
@Data
@NoArgsConstructor
@Service
public class AnnualRingServiceImpl implements AnnualRingService {

    @Autowired
    private AnnualRingInter annualRing;

    @Autowired
    private MusicInter music;


    @Override
    public ARResponseEntity getAllAnnualRingIdList() {

        LambdaQueryWrapper<AnnualRing> annualRingLambdaQueryWrapper = new LambdaQueryWrapper<>();
        AnnualRingEntity annualRingEntity = new AnnualRingEntity();
        List<String> idList = new ArrayList<>();
        annualRingLambdaQueryWrapper.select(AnnualRing::getId);
        try {
            for (AnnualRing annualRing : annualRing.selectList(annualRingLambdaQueryWrapper)) {

                idList.add(annualRing.getId());
            }
            annualRingEntity.setIdList(idList);
        }catch (Exception e){
            throw new GetException();
        }

        return new ARResponseEntity(
                annualRingEntity,
                Code.GET_OK,
                "获取成功"
        );
    }

    @Override
    public ARResponseEntity getAnnualRingImage(String id)  {

        AnnualRingEntity annualRingEntity = new AnnualRingEntity();

        try {
            AnnualRing annualR = annualRing.selectById(id);
            annualRingEntity.setAnnualRingImage(annualR.getAnnualRingImage());

        }catch (Exception e){
            throw new GetException();

        }

        return new ARResponseEntity(
                annualRingEntity,
                Code.GET_OK,
                "获取成功"
        );
    }

    @Override
    public ARResponseEntity getAnnualRing(String id) {

        AnnualRingEntity annualRingEntity = new AnnualRingEntity();

        LambdaQueryWrapper<Music> MusicLambdaQueryWrapper = new LambdaQueryWrapper<>();
        MusicLambdaQueryWrapper.select(Music::getId);
        try{

            AnnualRing annualR = annualRing.selectById(id);
            List<Music> musicData = music.selectList(MusicLambdaQueryWrapper);
            List<String> musicIdList = new ArrayList<>();

            for (Music music: musicData) {
                musicIdList.add(music.getId());
            }

            annualRingEntity.setAnnualRingImage(annualR.getAnnualRingImage());
            annualRingEntity.setAnnualRingEnvironmental(annualR.getAnnualRingEnvironmental());
            annualRingEntity.setMusicList(musicIdList);

        }catch (Exception e){
            throw new GetException();
        }

        return new ARResponseEntity(
                annualRingEntity,
                Code.GET_OK,
                "获取成功"
        );

    }

    @Override
    public ARResponseEntity addAnnualRing(AnnualRing annualR, List<Music> musicList) {

        try{
            annualRing.insert(annualR);

            for (Music musicData: musicList) {

                music.insert(musicData);
            }

        }catch (Exception e){
            throw new SaveException();
        }

        return new ARResponseEntity(
                null,
                Code.SAVE_OK,
                "添加成功"
        );
    }

    @Override
    public ARResponseEntity deleteAnnualRingById(String id)  {

        AnnualRing annualR = annualRing.selectById(id);
        LambdaQueryWrapper<Music> musicLambdaQueryWrapper = new LambdaQueryWrapper<>();
        musicLambdaQueryWrapper.select(Music::getMusic);
        List<Music> musicList = music.selectList(musicLambdaQueryWrapper);

        try {
            AnnualRingUtils.deleteData(annualR.getAnnualRingImage());
            AnnualRingUtils.deleteData(annualR.getAnnualRingEnvironmental());

            for (Music music: musicList) {
                AnnualRingUtils.deleteData(music.getMusic());
            }
        }catch (Exception e){

            throw new DeleteException();
        }

        annualRing.deleteById(id);
        music.delete(musicLambdaQueryWrapper);

        return new ARResponseEntity(
                null,
                Code.DELETE_OK,
                "删除成功"
        );
    }
}
