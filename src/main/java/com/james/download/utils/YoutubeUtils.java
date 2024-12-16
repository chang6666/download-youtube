package com.james.download.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YoutubeUtils {


    public static void downloadVideo(String videoUrl, String cookieFilePath) {
        // yt-dlp 命令，包含 cookies 文件和多线程下载参数
        String command = String.format("yt-dlp --cookies %s -N 4 -f best %s", cookieFilePath, videoUrl);

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
