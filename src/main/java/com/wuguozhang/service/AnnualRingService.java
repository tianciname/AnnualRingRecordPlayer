package com.wuguozhang.service;


import com.wuguozhang.domain.AnnualRing;
import org.springframework.stereotype.Service;

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
     * 功能: 返回所有年轮图片
     *
     * @return 年轮图片的列表
     *
     */
    public List<AnnualRing> getAllAnnualRingImages();


    /**
     * 功能: 返回所有年轮图片+环保知识+音乐
     *
     * @return 年轮图片+环保知识+音乐的列表
     *
     */
    public List<AnnualRing> getAllAnnualRing();


    /**
     * 功能: 按id返回年轮图片+环保知识+音乐
     *
     * @param id 年轮图片对应的id
     * @return 年轮图片+环保知识+音乐的json对象
     *
     */
    public AnnualRing getAnnualRingById(Integer id);


    /**
     * 功能 批量添加年轮图片+环保知识+音乐
     *
     * @return 返回一个布尔值判断是否添加成功
     *
     */
    public boolean addAnnualRing(List<AnnualRing> annualRingList);


    /**
     * 功能: 更新一组年轮数据的年路图片
     *
     * @param annualR 一组年轮数据
     */
    public boolean updateAnnualRingImageById(AnnualRing annualR);


    /**
     * 功能: 添加一组年轮数据的环保知识
     *
     * @param annualR 一组年轮数据
     */
    public boolean updateAnnualRingEnvironmentalById(AnnualRing annualR);


    /**
     * 功能: 更新一组年轮数据的音乐
     *
     * @param annualR 一组年轮数据
     */
    public boolean updateAnnualRingMusicById(AnnualRing annualR);


    /**
     * 功能: 删除一组年轮数据
     *
     * @param id 一组年轮数据的id
     */
    public boolean deleteAnnualRingById(Integer id);


}
