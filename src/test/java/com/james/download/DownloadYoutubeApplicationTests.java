package com.james.download;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
class DownloadYoutubeApplicationTests {

    @Test
    void contextLoads() {
        String videoUrl = "https://www.youtube.com/watch?v=----meyKR48"; // 替换为你要下载的视频链接
        String cookieFilePath = "/Users/james/Downloads/yt_dlp-main/cookies.txt"; // 替换为你的 cookies 文件路径
        downloadVideo(videoUrl, cookieFilePath);
    }


    public static void downloadVideo(String videoUrl, String cookieFilePath) {
        // yt-dlp 命令，包含 cookies 文件
        String command = "yt-dlp --cookies " + cookieFilePath + " " + videoUrl;

        try {
            // 创建进程
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.redirectErrorStream(true); // 合并标准输出和错误输出

            Process process = processBuilder.start();

            // 读取输出
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // 等待进程结束
            int exitCode = process.waitFor();
            System.out.println("下载完成，退出代码：" + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
