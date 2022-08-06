package com.wuguozhang.auunalringutils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 功能: 工具类
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

    public static String getMusicPath() {
        return MUSIC_PATH;
    }

    private static  String IMAGE_PATH = "";
    private static  String ENVIRONMENTAL_PATH = "";
    private static  String MUSIC_PATH = "";
    public static  boolean saveData(String dataType, MultipartFile data , String idPath) throws IOException {


        if (dataType.equals(DataType.IMAGE)){

            File imageFile =
                    new File(BASE_PATH + PathType.IMAGE_FILE+ idPath );

            if(!imageFile.exists()){
                imageFile.mkdirs();
            }
            boolean mkdirs = imageFile.mkdirs();

            IMAGE_PATH = imageFile.getPath();

            data.transferTo(new File(imageFile +"/" +  data.getOriginalFilename()));

            return true;

        }

        if(dataType.equals(DataType.MUSIC)){


            File musicFile =
                    new File(BASE_PATH + PathType.MUSIC_FILE + idPath);

            if(!musicFile.exists()){
                musicFile.mkdirs();
            }

            ENVIRONMENTAL_PATH = musicFile.getPath();

            data.transferTo(new File(musicFile + data.getOriginalFilename()));

            return true;

        }

        return false;

    }

    public static  boolean saveData(String dataType, String data , String idPath) throws IOException {

        if (dataType.equals(DataType.ENVIRONMENTAL)) {

            File environmentFile =
                    new File(BASE_PATH +
                            PathType.ENVIRONMENTAL_FILE +
                            idPath + FilePostfix.ENVIRONMENTAL_POSTFIX);


            if(!environmentFile.exists()){
                 environmentFile.mkdirs();
            }

            MUSIC_PATH = environmentFile.getPath();

            FileWriter fileWriter = new FileWriter(environmentFile);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            return true;

        }

        return false;

    }


    public static boolean deleteData(String path) throws IOException {

        Files.delete(Paths.get(path));

        return true;
    }

}
