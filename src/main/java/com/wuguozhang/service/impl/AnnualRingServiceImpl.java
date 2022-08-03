package com.wuguozhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuguozhang.dao.AnnualRingImpl;
import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.service.AnnualRingService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 所属功能模块: 建库模块
 *
 * 功能: service层接口实现类
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 *
 */
@Data
@Service
public class AnnualRingServiceImpl implements AnnualRingService {

    @Autowired
    private AnnualRingImpl annualRing;

    @Override
    public List<AnnualRing> getAllAnnualRingImages() {
        LambdaQueryWrapper<AnnualRing> annualRingLambdaQueryWrapper = new LambdaQueryWrapper<>();
        annualRingLambdaQueryWrapper.select(AnnualRing::getId, AnnualRing::getAnnualRingImage);
        return annualRing.selectList(annualRingLambdaQueryWrapper);
    }

    @Override
    public List<AnnualRing> getAllAnnualRing() {

        return annualRing.selectList(null);
    }

    @Override
    public AnnualRing getAnnualRingById(Integer id) {

        return annualRing.selectById(id);
    }

    @Override
    public boolean addAnnualRing(List<AnnualRing> annualRingList) {
        try {
            for (AnnualRing AnnualRingData:annualRingList) {
                annualRing.insert(AnnualRingData);
            }
            return true;
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
        return false;
    }

    @Override
    public boolean updateAnnualRingImageById(AnnualRing annualR) {

        try {

            annualRing.updateById(annualR);

            return true;
        }catch (Exception exception){
            System.out.println(exception.toString());
        }

        return false;
    }

    @Override
    public boolean updateAnnualRingEnvironmentalById(AnnualRing annualR) {

        try {

            annualRing.updateById(annualR);

            return true;
        }catch (Exception exception){
            System.out.println(exception.toString());
        }

        return false;
    }

    @Override
    public boolean updateAnnualRingMusicById(AnnualRing annualR) {

        try {

            annualRing.updateById(annualR);

            return true;
        }catch (Exception exception){
            System.out.println(exception.toString());
        }

        return false;
    }

    @Override
    public boolean deleteAnnualRingById(Integer id) {

        try {

            annualRing.deleteById(id);
            return  true;
        }catch (Exception exception){
            System.out.println(exception.toString());
        }

        return false;
    }
}
