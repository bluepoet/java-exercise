package net.bluepoet.exercise.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * Created by bluepoet on 2017. 10. 22..
 */
@Slf4j
public class CopyUtil {
    public static long copy(String srcPath, String destPath) throws FileNotFoundException {
        int count = 0;
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        if (!srcFile.exists()) {
            throw new FileNotFoundException(srcFile.getAbsolutePath());
        }

        if (srcFile.isFile()) {
            return copyFile(srcFile, destFile);
        } else {
            copyDirectory(srcFile, destFile);
        }

        return count;

    }

    private static long copyFile(File srcFile, File destFile) {
        long beginTime = System.currentTimeMillis();

        int count = 0;
        long totalSize = 0;
        byte[] b = new byte[8192];
        long totalTime = 0L;

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(destFile);

            while ((count = in.read(b)) != -1) {
//                log.info("byte array " + new String(b, "UTF-8"));
//                System.out.println("bate length write before " + b.length);
                out.write(b, 0, count);
                totalSize += count;
//                System.out.println("bate length write after " + b.length);
            }
        } catch (IOException e) {
            log.warn(e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                log.warn(e.getMessage());
            }

            totalTime = System.currentTimeMillis() - beginTime;
            StringBuilder sb = new StringBuilder();
            sb.append(totalTime);
            sb.append(", " + totalSize + "bytes");

            log.info(sb.toString());
        }

        return totalTime;
    }

    private static void copyDirectory(File srcFile, File destFile) {
    }

    public static void main(String[] args) throws FileNotFoundException {
        long totalTime = 0L;
        for (int i = 0; i < 100; i++) {
            totalTime += copy("/Users/Mac/Downloads/20161008_juwon1.jpg", "/Users/Mac/Downloads/test00.jpg");
//            totalTime += copyTextFile();
//            totalTime += copyTextFileByBuffer();
        }

        log.info("final totalTime : {}", totalTime);

//        log.info("text file copy : {}", copyTextFile());

//        log.info("copy filewriter : {}", copyTextFile());
    }

    private static long copyTextFileByBuffer() {
        long startTime = System.currentTimeMillis();
        File file = new File("/Users/Mac/Downloads/martini_search_result.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/Mac/Downloads/test00.txt"))) {
            String tmp = null;

            while ((tmp = reader.readLine()) != null) {
                System.out.println(tmp);
                writer.write(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis() - startTime;
    }

    private static long copyTextFile() {
        long startTime = System.currentTimeMillis();
        File file = new File("/Users/Mac/Downloads/martini_search_result.txt");

        try (FileReader reader = new FileReader(file);
             FileWriter writer = new FileWriter("/Users/Mac/Downloads/test01.txt")) {
            int i = 0;

            while ((i = reader.read()) != -1) {
//                log.info("read character : {}", (char) i);
                writer.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis() - startTime;
    }


}
