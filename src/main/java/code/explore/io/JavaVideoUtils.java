package code.explore.io;

import java.io.File;
import java.nio.file.Files;

public class JavaVideoUtils {
    public static void main(String[] args) {
        String targetPath = "/Users/wangxin/work/doc/JAVA/JAVA/";

        String rootPath = "/Users/wangxin/work/doc/JAVA/JAVA-Video";
        //主文件夹
        File rootFolder = new File(rootPath);
        //所有包含视频的文件夹
        File[] outFolders = rootFolder.listFiles((file, name) -> name.startsWith("JavaSE"));
        for (File outFoler : outFolders) {
            //视频列表OR文件夹
            File[] innerFiles = outFoler.listFiles();
            for(File videoFiles : innerFiles){
                if(videoFiles.isDirectory()){
                    // 文件夹中的视频
                    File[] realVideos = videoFiles.listFiles();
                    for(File realVideo:realVideos){
                        String newName = outFoler.getName()+"-"+videoFiles.getName()+"-"+realVideo.getName();
                        realVideo.renameTo(new File(targetPath+newName));
                    }
                }else{
                    //视频 移动
                    String newName = outFoler.getName()+"-"+videoFiles.getName();
                    videoFiles.renameTo(new File(targetPath+newName));
                }
            }
        }
    }
}

