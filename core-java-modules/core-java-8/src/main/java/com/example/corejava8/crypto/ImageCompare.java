package com.example.corejava8.crypto;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageCompare {

    public static void main(String[] args) throws Exception {
//        URL url1 = new URL("https://qncdn.wanshifu.com/4e30c652206cdce5c4da21b499eec90a.jpg");
        String url1 = "https://qncdn.wanshifu.com/4e30c652206cdce5c4da21b499eec90a.jpg";
        String url2 = "https://qncdn.wanshifu.com/4e30c652206cdce5c4da21b499eec90a.jpg";
//        URL url2 = new URL("https://qncdn.wanshifu.com/4e30c652206cdce5c4da21b499eec90a.jpg");
        long l1 = System.currentTimeMillis();
        byte[] b1 = downloadImage(url1);
        long l2 = System.currentTimeMillis();
//        byte[] b2 = downloadImage(url2);
//        long l3 = System.currentTimeMillis();

//        System.out.println(compareImage(b1, b2));

        System.out.println(String.format("第1张图片hash时间：%d", (l2 - l1)));
//        System.out.println(String.format("第2张图片hash时间：%d", (l3 - l2)));
//        if (hash1 == hash2) {
//            System.out.println("The images are identical");
//        } else {
//            System.out.println("The images are different");
//        }
    }

    private static String getHash(URL url) throws IOException {
        BufferedImage img = ImageIO.read(url);

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                sb.append(img.getRGB(x, y));
            }
        }
        String data = sb.toString();

        Digester sha256 = new Digester(DigestAlgorithm.SHA256);
        String result = sha256.digestHex(data);
        System.out.println(result);
        return result;
    }

    public static long hash(String imageUrl) {
//        String imageUrl = "https://example.com/image.jpg"; // 图片的URL
        URL url = null;
        try {
            url = new URL(imageUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedImage image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Mat mat = new Mat(image.getHeight(), image.getWidth(), Imgcodecs.IMREAD_GRAYSCALE);
        byte[] data = ((java.awt.image.DataBufferByte) image.getRaster().getDataBuffer()).getData();
        mat.put(0, 0, data);
        Mat resized = new Mat();
        Size size = new Size(8, 8);
        Imgproc.resize(mat, resized, size, 0, 0, Imgproc.INTER_AREA);
        long hashValue = 0;
        for (int i = 0; i < resized.rows(); i++) {
            for (int j = 0; j < resized.cols(); j++) {
                double[] pixel = resized.get(i, j);
                hashValue += (long) (pixel[0] * Math.pow(2, i * resized.cols() + j));
            }
        }
        System.out.println("Hash value: " + hashValue);
        return hashValue;
    }


    private static byte[] downloadImage(String imageUrl) throws Exception {
        URL url = new URL(imageUrl);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (InputStream inputStream = url.openStream()) {
            byte[] buffer = new byte[1024];
            int n = 0;
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        }
        return output.toByteArray();
    }


    private static boolean compareImage(byte[] img1, byte[] img2) {
        Digester sha256 = new Digester(DigestAlgorithm.SHA256);
        String h1 = sha256.digestHex(img1);
        String h2 = sha256.digestHex(img2);
        return h1.equals(h2);
    }

}
