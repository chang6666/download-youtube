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
        YoutubeUtils.downloadVideo("https://www.youtube.com/watch?v=----meyKR48", "/Users/james/Downloads/yt_dlp-main/cookies.txt");
        return "success";
    }



}
