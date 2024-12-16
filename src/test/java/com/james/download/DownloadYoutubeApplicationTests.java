package com.james.download;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.james.download.utils.YoutubeUtils.downloadVideo;

@SpringBootTest
class DownloadYoutubeApplicationTests {

    @Test
    void contextLoads() {
        String videoUrl = "https://www.youtube.com/watch?v=----meyKR48"; // 替换为你要下载的视频链接
        String cookieFilePath = "/Users/james/Downloads/yt_dlp-main/cookies.txt"; // 替换为你的 cookies 文件路径
        downloadVideo(videoUrl, cookieFilePath);
    }

}
