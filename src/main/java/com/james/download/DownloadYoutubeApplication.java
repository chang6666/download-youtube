package com.james.download;

import com.james.download.utils.YoutubeUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DownloadYoutubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DownloadYoutubeApplication.class, args);
    }


    @GetMapping("/")
    public String down(){
        String videoUrl = "https://www.youtube.com/watch?v=----meyKR48";
        String outputFileName = YoutubeUtils.extractVideoId(videoUrl);
        String videoFormat = "bestvideo[height<=720]";
        String cookieFilePath = YoutubeUtils.extractVideoId(videoUrl);
        YoutubeUtils.downloadVideo(videoUrl,videoFormat,outputFileName,cookieFilePath);
        return "success";
    }



}
