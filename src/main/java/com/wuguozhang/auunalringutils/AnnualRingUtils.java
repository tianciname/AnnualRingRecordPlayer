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
                    new File(BASE_PATH + File.separator + idPath + File.separator + PathType.IMAGE_FILE );

            if(!imageFile.exists()){
                imageFile.mkdirs();
            }

            IMAGE_PATH = imageFile.getCanonicalPath() + File.separator +  data.getOriginalFilename();

            data.transferTo(new File(IMAGE_PATH));

            return true;

        }

        if(dataType.equals(DataType.MUSIC)){


            File musicFile =
                    new File(BASE_PATH + File.separator +
                            idPath + File.separator + PathType.MUSIC_FILE);

            if(!musicFile.exists()){
                musicFile.mkdirs();
            }

            MUSIC_PATH = musicFile.getCanonicalPath() + File.separator + data.getOriginalFilename();

            data.transferTo(new File(MUSIC_PATH));

            return true;

        }

        return false;

    }

    public static  boolean saveData(String dataType, String data , String idPath) throws IOException {

        if (dataType.equals(DataType.ENVIRONMENTAL)) {

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

        return false;

    }


    public static boolean deleteData(String path) throws IOException {

        Files.delete(Paths.get(path));

        return true;
    }

}
