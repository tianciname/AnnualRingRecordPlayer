package com.wuguozhang.auunalringutils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 功能: 操作服务器文件的工具类
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 *
 */
@Data
public class AnnualRingUtils {

    private static final String BASE_PATH = "src/main/resources/static/data";

    public static String getImagePath() {
        return IMAGE_PATH;
    }

    public static String getEnvironmentalPath() {
        return ENVIRONMENTAL_PATH;
    }

    public static Map<String,String> getMusicMap() {
        return MUSIC_MAP;
    }

    private static  String IMAGE_PATH;

    private static  String ENVIRONMENTAL_PATH;

    private static Map<String,String> MUSIC_MAP = new HashMap<>();


    /**
     * @param data 年轮图片
     * @param idPath 年轮信息的id
     * @return 是否操作成功
   、、
     */
    public static  boolean saveData( MultipartFile data , String idPath) throws IOException {


        File imageFile =
                new File(BASE_PATH + File.separator + idPath + File.separator + PathType.IMAGE_FILE );

        if(!imageFile.exists()){
            imageFile.mkdirs();
        }

        IMAGE_PATH = imageFile.getCanonicalPath() + File.separator +  data.getOriginalFilename();

        data.transferTo(new File(IMAGE_PATH));

        return true;

    }

    /**
     * @param data 音乐歌曲的列表
     * @param idPath 年轮信息的id
     */
    public static  boolean saveData(List<MultipartFile> data , String idPath) throws IOException {

        Map<String, String> musicMap = new HashMap<>();

        for (MultipartFile music: data) {

            String musicId = String.valueOf(UUID.randomUUID());

            File musicFile =
                    new File(BASE_PATH + File.separator +
                            idPath + File.separator + PathType.MUSIC_FILE + File.separator + musicId);

            if(!musicFile.exists()){

                musicFile.mkdirs();
            }

            String musicPath = musicFile.getCanonicalPath() + File.separator + music.getOriginalFilename();

            MUSIC_MAP.put(musicId,musicPath);

            music.transferTo(new File(musicPath));

        }

        return true;
    }

    /**
     * @param data 环保信息
     * @param idPath 年轮信息的id
     * @return 是否操作成功
     */
    public static  boolean saveData( String data , String idPath) throws IOException {


        File environmentFile =
                new File(BASE_PATH + File.separator+
                        idPath+ File.separator +
                        PathType.ENVIRONMENTAL_FILE);

        if(!environmentFile.exists()){
             environmentFile.mkdirs();
        }

        ENVIRONMENTAL_PATH = environmentFile.getCanonicalPath() + File.separator+ "message.text";

        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(ENVIRONMENTAL_PATH));

        bufferedWriter.write(data);
        bufferedWriter.flush();
        bufferedWriter.close();

        return true;

    }


    /**
     * @param path 要删除的文件的路径
     * @return 是否操作成功
     */
    public static boolean deleteData(String path) throws IOException {

        Files.delete(Paths.get(path));

        return true;
    }

}
