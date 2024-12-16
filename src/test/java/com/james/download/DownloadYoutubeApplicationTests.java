package com.james.download;

import com.james.download.utils.YoutubeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DownloadYoutubeApplicationTests {

    @Test
    void contextLoads() {
        String videoUrl = "https://www.youtube.com/watch?v=----meyKR48";
        String outputFileName = YoutubeUtils.extractVideoId(videoUrl);
        String videoFormat = "bestvideo[height<=720]";
        String cookieFilePath = YoutubeUtils.extractVideoId(videoUrl);
        YoutubeUtils.downloadVideo(videoUrl,videoFormat,outputFileName,cookieFilePath);
    }

}
