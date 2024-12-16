package com.james.download;

import com.james.download.utils.YoutubeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DownloadYoutubeApplicationTests {

    @Test
    void contextLoads() {
        String videoUrl = "https://www.youtube.com/watch?v=----meyKR48"; // 替换为你要下载的视频链接
        String cookieFilePath = "/Users/james/Downloads/yt_dlp-main/cookies.txt"; // 替换为你的 cookies 文件路径
        YoutubeUtils.downloadVideo("https://www.youtube.com/watch?v=----meyKR48",YoutubeUtils.extractVideoId("https://www.youtube.com/watch?v=----meyKR48"), "/Users/james/Downloads/yt_dlp-main/cookies.txt");
    }

}
