package com.james.download.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YoutubeUtils {


    // 提取视频 ID
    public static String extractVideoId(String videoUrl) {
        String[] parts = videoUrl.split("v=");
        if (parts.length > 1) {
            String id = parts[1];
            int ampersandIndex = id.indexOf("&");
            if (ampersandIndex != -1) {
                id = id.substring(0, ampersandIndex);
            }
            return id;
        }
        return "unknown_video_id"; // 默认视频 ID
    }

    /**
     * 下载视频
     * @param videoUrl 视频地址
     * @param videoFormat 视频参数信息 eg:bestvideo[height<=720]   ||   bestvideo[height<=144]+bestaudio/best[height<=720p]
     * @param outputFileName 输出文件名
     * @param cookieFilePath cookies 文件路径
     */

    public static void downloadVideo(String videoUrl,String videoFormat,String outputFileName, String cookieFilePath) {
        // yt-dlp 命令，包含 cookies 文件和多线程下载参数
        String command = String.format("yt-dlp  --cookies %s -N 12 -f %s --no-warn -o %s %s",
                cookieFilePath,videoFormat, outputFileName+".%(ext)s", videoUrl);

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
