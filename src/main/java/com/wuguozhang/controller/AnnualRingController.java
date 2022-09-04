package com.wuguozhang.controller;

import com.wuguozhang.auunalringutils.AnnualRingUtils;
import com.wuguozhang.domain.AnnualRing;
import com.wuguozhang.domain.Music;
import com.wuguozhang.responseentites.ARResponseEntity;
import com.wuguozhang.service.AnnualRingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * 所属功能模块: 建库模块
 * 功能: 表现层实现类
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
     * @return ARResponseEntity  年轮信息id的列表
     */
    @GetMapping("/allid")
    public ARResponseEntity getAllAnnualRingIdList(){

        return annualRingService.getAllAnnualRingIdList();
    }


    /**
     * 功能: 按照id返回库模块中的年轮图片
     *
     * @param id 一组年轮信息的id
     *
     * @return ARResponseEntity 年轮图片地址的实体类
     */
    @GetMapping("/img")
    public ARResponseEntity getAnnualRingImage(@RequestParam String id) {

        return annualRingService.getAnnualRingImage(id);

    }


    /**
     * 功能: 按照id返回库模块中的年轮图片+环保知识+音乐
     *
     * @param id 年轮图片id
     *
     * @return ARResponseEntity 年轮信息实体类对应的文件地址
     */
    @GetMapping()
    public ARResponseEntity  getAnnualRing( String id){

        return annualRingService.getAnnualRing(id);
    }


    /**
     * 功能: 添加一组年轮图片 + 环保知识 + 音乐
     *
     * @param   annualRingImage 年轮图片
     * @param   annualRingEnvironmental 环保知识
     * @param   musicData 音乐列表
     *
     * @return ARResponseEntity 空实体类
     */
    @PostMapping
    public ARResponseEntity addAnnualRing( MultipartFile annualRingImage,
                                           String annualRingEnvironmental,
                                           List<MultipartFile> musicData) throws IOException {

        //@RequestParam不能接收axios post请求体的数据

        //年轮id
        String AnnualRingId = UUID.randomUUID().toString();

        //将年轮信息存储到服务器本地
        AnnualRingUtils.saveData(annualRingImage, "/" + AnnualRingId);
        AnnualRingUtils.saveData(annualRingEnvironmental, "/" + AnnualRingId);
        AnnualRingUtils.saveData(musicData, "/" + AnnualRingId);

        //设置年轮实体类属性
        AnnualRing annualRing = new AnnualRing();

        annualRing.setId(AnnualRingId);
        annualRing.setAnnualRingImage(AnnualRingUtils.getImagePath());
        annualRing.setAnnualRingEnvironmental(AnnualRingUtils.getEnvironmentalPath());

        //设置音乐列表属性
        List<Music> musicList = new ArrayList<>();

        Map<String, String> musicMap = AnnualRingUtils.getMusicMap();
        Set<String> musicIdSet = musicMap.keySet();

        for (String musicId: musicIdSet) {

            Music music = new Music();

            music.setId(musicId);
            music.setMusic(musicMap.get(musicId));
            music.setAnnualRingImageId(AnnualRingId);

            musicList.add(music);


        }

        return  annualRingService.addAnnualRing(annualRing,musicList);

    }


    /**
     * ‘功能: 按照id删除一组年轮数据
     *
     * @param id 一组年轮数据的id
     * @return ARResponseEntity 空实体类
     */
    @DeleteMapping()
    public ARResponseEntity deleteAnnualRingById(@RequestParam String id){

        return  annualRingService.deleteAnnualRingById(id);

    }


}
