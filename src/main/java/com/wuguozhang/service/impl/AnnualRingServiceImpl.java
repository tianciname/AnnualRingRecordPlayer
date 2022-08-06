package com.wuguozhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuguozhang.auunalringutils.AnnualRingUtils;
import com.wuguozhang.dao.AnnualRingInter;
import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.entites.AnnualRingEntity;
import com.wuguozhang.service.AnnualRingService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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
@NoArgsConstructor
@Service
public class AnnualRingServiceImpl implements AnnualRingService {

    @Autowired
    private AnnualRingInter annualRing;

    @Override
    public ResponseEntity<List<Long>> getAllAnnualRingIdList() {

        LambdaQueryWrapper<AnnualRing> annualRingLambdaQueryWrapper = new LambdaQueryWrapper<>();
        annualRingLambdaQueryWrapper.select(AnnualRing::getId);

        List<Long> idList = new ArrayList<>();

        for (AnnualRing annualRing : annualRing.selectList(annualRingLambdaQueryWrapper)) {

            idList.add(annualRing.getId());
        }
        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(idList);
    }

    @Override
    public ResponseEntity<AnnualRingEntity> getAnnualRingImage(Integer id) throws IOException {

        LambdaQueryWrapper<AnnualRing> annualRingLambdaQueryWrapper = new LambdaQueryWrapper<>();
        annualRingLambdaQueryWrapper.select(AnnualRing::getAnnualRingImage);
        AnnualRing annualR = annualRing.selectById(id);

        String imagePath = annualR.getAnnualRingImage();

        AnnualRingEntity annualRingEntity = new AnnualRingEntity();
        annualRingEntity.setAnnualRingImage(imagePath);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.IMAGE_JPEG)
                             .body(annualRingEntity);
    }

    @Override
    public ResponseEntity<AnnualRingEntity> getAnnualRing(Integer id) throws IOException {

        AnnualRing annualR = annualRing.selectById(id);

        AnnualRingEntity annualRingEntity = new AnnualRingEntity();
        annualRingEntity.setAnnualRingImage(annualR.getAnnualRingImage());
        annualRingEntity.setAnnualRingEnvironmental(annualR.getAnnualRingEnvironmental());
        annualRingEntity.setMusic(annualR.getMusic());


        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(annualRingEntity);

    }

    @Override
    public ResponseEntity<AnnualRingEntity> addAnnualRing(AnnualRing annualR) {

         annualRing.insert(annualR);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(null);
    }

    @Override
    public ResponseEntity<AnnualRingEntity> deleteAnnualRingById(Integer id) throws IOException {

        annualRing.deleteById(id);
        annualRing.selectById(id);

        AnnualRing annualR = annualRing.selectById(id);

        AnnualRingUtils.deleteData(annualR.getAnnualRingImage());
        AnnualRingUtils.deleteData(annualR.getAnnualRingEnvironmental());
        AnnualRingUtils.deleteData(annualR.getMusic());

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(null);

    }
}
