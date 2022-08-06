package com.wuguozhang.controller;

import com.wuguozhang.auunalringutils.AnnualRingUtils;
import com.wuguozhang.auunalringutils.DataType;
import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.entites.AnnualRingEntity;
import com.wuguozhang.service.AnnualRingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 所属功能模块: 建库模块
 *
 * 功能: 前端和后台操作年轮图片和环保知识
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 *
 */
@RestController
@RequestMapping( "/ar")
public class AnnualRingController {

    @Autowired
    private AnnualRingService annualRingService;


    /**
     * 功能：获取所有年轮数据的id
     *
     * @return ResponseEntity<List<Long>>  年轮信息id的列表
     */
    @GetMapping("/allid")
    public ResponseEntity<List<Long>> getAllAnnualRingIdList(){

        return annualRingService.getAllAnnualRingIdList();
    }


    /**
     * 功能: 按照id返回库模块中的年轮图片
     *
     * @param id 一组年轮信息的id
     *
     * @return ResponseEntity<AnnualRingEntity> 年轮图片地址的实体类
     */
    @GetMapping("/img/{id}")
    public ResponseEntity<AnnualRingEntity> getAnnualRingImage(@PathVariable Integer id) throws IOException {

        return annualRingService.getAnnualRingImage(id);

    }


    /**
     * 功能: 按照id返回库模块中的年轮图片+环保知识+音乐
     *
     * @param id 年轮图片id
     *
     * @return ResponseEntity<AnnualRingEntity> 年轮信息实体类对应的文件地址
     *
     */
    @GetMapping("/{id}")
    public ResponseEntity<AnnualRingEntity>  getAnnualRing(@PathVariable Integer id) throws IOException {

        return annualRingService.getAnnualRing(id);
    }


    /**
     * 功能: 添加一组年轮图片 + 环保知识 + 音乐
     *
     * @param   id  年轮信息id
     * @param   annualRingImage 年轮图片
     * @param   annualRingEnvironmental 环保知识
     * @param   music 音乐
     *
     * @return ResponseEntity<AnnualRingEntity> 空实体类
     */
    @PostMapping
    public ResponseEntity<AnnualRingEntity> addAnnualRing(@RequestParam Integer id,
                                                          @RequestParam MultipartFile annualRingImage,
                                                          @RequestParam String annualRingEnvironmental,
                                                          @RequestParam MultipartFile music) throws IOException {

        AnnualRingUtils.saveData(DataType.IMAGE,
                annualRingImage,
                "/" + id);

        AnnualRingUtils.saveData(DataType.ENVIRONMENTAL,
                annualRingEnvironmental,
                "/" + id);

        AnnualRingUtils.saveData(DataType.MUSIC,
                music,
                "/" + id);

        AnnualRing annualRing = new AnnualRing();
        annualRing.setAnnualRingImage(AnnualRingUtils.getImagePath());
        annualRing.setAnnualRingEnvironmental(AnnualRingUtils.getEnvironmentalPath());
        annualRing.setMusic(AnnualRingUtils.getMusicPath());
        return  annualRingService.addAnnualRing(annualRing);

    }



    /**
     * ‘功能: 按照id删除一组年轮数据
     *
     * @param id 一组年轮数据的id
     *
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<AnnualRingEntity> deleteAnnualRingById(@PathVariable Integer id) throws IOException {

        return  annualRingService.deleteAnnualRingById(id);
    }

}
