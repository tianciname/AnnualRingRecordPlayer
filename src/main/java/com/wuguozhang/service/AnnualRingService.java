package com.wuguozhang.service;


import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.entites.AnnualRingEntity;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;


/**
 * 所属功能模块: 建库模块
 *
 * 功能: service层接口
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 *
 */
public interface AnnualRingService {


    /**
     * 功能：获取所有年轮数据的id
     *
     * @return ResponseEntity<List<Long>>  年轮信息id的列表
     */
    public ResponseEntity<List<Long>> getAllAnnualRingIdList();


    /**
     * 功能: 返回所有年轮图片
     *
     * @return 年轮图片的列表
     *
     */
    public ResponseEntity<AnnualRingEntity> getAnnualRingImage(Integer id) throws IOException;



    /**
     * 功能: 按id返回年轮图片+环保知识+音乐
     *
     * @param id 年轮图片对应的id
     * @return 年轮图片+环保知识+音乐的json对象
     *
     */
    public ResponseEntity<AnnualRingEntity>  getAnnualRing(Integer id) throws IOException;


    /**
     * 功能 添加一组年轮图片+环保知识+音乐
     *
     * @return 返回一个布尔值判断是否添加成功
     *
     */
    public ResponseEntity<AnnualRingEntity> addAnnualRing(AnnualRing annualRing);



    /**
     * 功能: 删除一组年轮数据
     *
     * @param id 一组年轮数据的id
     */
    public ResponseEntity<AnnualRingEntity> deleteAnnualRingById(Integer id) throws IOException;



}
