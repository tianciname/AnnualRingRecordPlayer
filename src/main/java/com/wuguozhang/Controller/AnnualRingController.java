package com.wuguozhang.Controller;

import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.service.AnnualRingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/arimg")
public class AnnualRingController {

    @Autowired
    private AnnualRingService annualRingService;


    /**
     * 功能: 返回库模块所有的年轮图片
     *
     */
    @GetMapping
    public List<AnnualRing> getAllAnnualRingImages(){

        return annualRingService.getAllAnnualRingImages();

    }


    /**
     * 功能: 返回库模块所有的年轮图片 + 环保知识 + 音乐
     *
     */
    @GetMapping
    public List<AnnualRing> getAllAnnualRingImagesEnvironmentalSong(){

        return annualRingService.getAllAnnualRing();
    }


    /**
     * 功能: 按照id返回年轮图片 + 环保知识 + 音乐
     *
     * @param id 年轮图片id
     *
     */
    @GetMapping("{/id}")
    public AnnualRing getAnnualRingImagesEnvironmentalSong(@PathVariable Integer id){

        return annualRingService.getAnnualRingById(id);
    }


    /**
     * 功能: 批量添加年轮图片 + 环保知识 + 音乐
     *
     * @param annualRingList 年轮图片+环保知识+音乐对象的列表
     *
     */
    @PostMapping
    public boolean addAnnualRing(@RequestBody List<AnnualRing> annualRingList){

        return annualRingService.addAnnualRing(annualRingList);
    }


    /**
     * 功能: 更新一组年轮数据的年轮图片
     *
     * @param annualRing 一组年轮数据
     *
     */
    @PostMapping("/{id}")
    public boolean updateAnnualRingImageById(@RequestBody AnnualRing annualRing){

        return annualRingService.updateAnnualRingImageById(annualRing);
    }

    /**
     * 功能: 更新一组年轮数据的环保知识
     *
     * @param annualRing 一组年轮数据
     *
     */
    @PostMapping("/{id}")
    public boolean updateAnnualRingEnvironmentalById(@RequestBody AnnualRing annualRing){

        return annualRingService.updateAnnualRingImageById(annualRing);
    }

    /**
     * 功能: 更新一组年轮数据的音乐
     *
     * @param annualRing 一组年轮数据
     *
     */
    @PostMapping("/{id}")
    public boolean updateAnnualRingMusicById(@RequestBody AnnualRing annualRing){

        return annualRingService.updateAnnualRingImageById(annualRing);
    }


    /**
     * ‘功能: 按照id删除一组年轮数据
     *
     * @param id 一组年轮数据的id
     *
     */
    @DeleteMapping("/{id}")
    public boolean deleteAnnualRingById(@PathVariable Integer id){

        return  annualRingService.deleteAnnualRingById(id);
    }

}
