package com.example.demo.qrcode;

/**
 *  * 二维码 生成、解析器 帮助类
 *  * @author yuki_ho
 *  *
 *  
 */

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPSize;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.Hashtable;
import java.util.UUID;

public class QRCodeUtil {

    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";
    // 二维码尺寸
    private static final int QRCODE_SIZE = 300;
    // LOGO宽度
    private static final int WIDTH = 60;
    // LOGO高度
    private static final int HEIGHT = 60;

    /**
     *          *  检查路径 图片是否存在
     *          * @param imgPath
     *          * @return
     *          * @throws IOException
     *         
     */
    private static BufferedImage CheckImageExist(String imgPath) throws IOException {
        File file = new File(imgPath);
        if (!file.exists()) {
            System.err.println("" + imgPath + "   该文件不存在！");
            return null;
        }
        BufferedImage src = ImageIO.read(new File(imgPath));
        return src;
    }

    /**
     *          * 创建 二维码所需图片  
     *          * @param content   内容
     *          * @param imgPath   Logo图片地址
     *          * @param needCompress 是否压缩Logo大小
     *          * @param needDescription 是否需要底部描述
     *          * @return   
     *          * @throws Exception
     *         
     */
    private static BufferedImage createImage(String content, BufferedImage logoImage, String bottomDes, boolean needCompress) throws Exception {
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); //容错级别 H->30%  
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int tempHeight = height;
        boolean needDescription = (null == bottomDes && "".equals(bottomDes));
        if (needDescription) {
            tempHeight += 30;
        }
        BufferedImage image = new BufferedImage(width, tempHeight, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        if (null == logoImage)
            return image;
// 插入图片  
        QRCodeUtil.insertImage(image, logoImage, needCompress);

        if (needDescription)
            return image;

        QRCodeUtil.addFontImage(image, bottomDes);
        return image;
    }

    /**
     *          * 添加 底部图片文字
     *          * @param source   图片源
     *          * @param declareText 文字本文
     *         
     */
    private static void addFontImage(BufferedImage source, String declareText) {
        BufferedImage textImage = FontImage.getImage(declareText, QRCODE_SIZE, 50);
        Graphics2D graph = source.createGraphics();

        int width = textImage.getWidth(null);
        int height = textImage.getHeight(null);
        Image src = textImage;
        graph.drawImage(src, 0, QRCODE_SIZE - 20, width, height, null);
        graph.dispose();
    }

    /**
     *          *  插入Logo图片
     *          * @param source    图片操作对象
     *          * @param imgPath   Logo图片地址
     *          * @param needCompress 是否压缩Logo大小
     *          * @throws Exception
     *         
     */
    private static void insertImage(BufferedImage source, BufferedImage logoImage, boolean needCompress) throws Exception {
        int width = logoImage.getWidth(null);
        int height = logoImage.getHeight(null);

        Image src = logoImage;
        if (needCompress) {
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = logoImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            src = image;
        }
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     *          * 创建 目录
     *          * @param destPath
     *         
     */
    public static void mkdirs(String destPath) {
        File file = new File(destPath);
        //当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)  
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     *          *  生成二维码 (以Logo路径)
     *          * @param content  内容 (若带http:// 会自动跳转)
     *          * @param imgPath  Logo 图片地址
     *          * @param destPath   保存二维码 地址 (没有该目录会自动创建)
     *          * @param bottomDes 底部文字描述
     *          * @param needCompress 是否压缩Logo大小
     *          * @throws Exception
     *         
     */
    public static void encodeOfPath(String content, String imgPath, String bottomDes, String destPath, boolean needCompress) throws Exception {

        BufferedImage image = QRCodeUtil.createImage(content, CheckImageExist(imgPath), bottomDes, needCompress);
        mkdirs(destPath);
        String file = UUID.randomUUID().toString() + ".jpg";
        ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + file));
    }

    /**
     *          *
     *          * @param content 内容    
     *          * @param logoImage  图片源 LOGO
     *          * @param bottomDes 底部描述文字
     *          * @param destPath   保存二维码 地址 (没有该目录会自动创建)
     *          * @param needCompress  是否压缩logo
     *          * @throws Exception
     *         
     */
    public static void encode(String content, BufferedImage logoImage, String bottomDes, String destPath, boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, logoImage, bottomDes, needCompress);
        mkdirs(destPath);
        String file = UUID.randomUUID().toString() + ".jpg";
        ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + file));
    }

    /**
     *          *
     *          * @param content  内容    
     *          * @param logoImage  图片源LOGO
     *          * @param bottomDes 底部描述文字
     *          * @param picName   图片名
     *          * @param destPath     保存二维码 地址 (没有该目录会自动创建)
     *          * @param needCompress 是否压缩logo
     *          * @throws Exception
     *         
     */
    public static void encode(String content, BufferedImage logoImage, String bottomDes, String picName, String destPath, boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, logoImage, bottomDes, needCompress);

        mkdirs(destPath);
        String file = picName + ".jpg";
        ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + file));
    }

    /**
     *          *
     *          * @param content  内容
     *          * @param destPath     保存二维码 地址 (没有该目录会自动创建)
     *          * @throws Exception
     *         
     */
    public static void encode(String content, String destPath) throws Exception {
        QRCodeUtil.encode(content, null, null, destPath, false);
    }

    /**
     *          *   
     *          * @param content   内容
     *          * @param imgPath    图片源地址LOGO
     *          * @param bottomDes 底部描述文字
     *          * @param output    输出流
     *          * @param needCompress 是否压缩logo
     *          * @throws Exception
     *         
     */
    public static void encodeOfPath(String content, String imgPath, String bottomDes, OutputStream output, boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, CheckImageExist(imgPath), bottomDes, needCompress);
        ImageIO.write(image, FORMAT_NAME, output);
    }

    /**
     *          *
     *          * @param content  内容
     *          * @param Image        图片源LOGO
     *          * @param bottomDes 底部描述文字
     *          * @param output    输出流
     *          * @param needCompress 是否压缩
     *          * @throws Exception
     *         
     */
    public static void encode(String content, BufferedImage Image, String bottomDes, OutputStream output, boolean needCompress) throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, Image, bottomDes,
                needCompress);
        ImageIO.write(image, FORMAT_NAME, output);
    }

    /**
     *          *
     *          * @param content 内容
     *          * @param output    输出流
     *          * @throws Exception
     *         
     */
    public static void encode(String content, OutputStream output) throws Exception

    {
        QRCodeUtil.encode(content, null, null, output, false);
    }

    /**
     *          * 解析 二维码
     *          * @param file 图片文件
     *          * @return
     *          * @throws Exception
     *         
     */
    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable hints = new Hashtable();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    /**
     *          *  解析二维码
     *          * @param path 图片地址
     *          * @return
     *          * @throws Exception
     *         
     */
    public static String decode(String path) throws Exception {
        return QRCodeUtil.decode(new File(path));
    }


    public static void main(String[] args) throws Exception {
// //         String text = "http://www.baidu.com";
// // //            QRCodeUtil.encodeOfPath(text, "d:/test/a1.jpg",null,"d:/test", true);  
// // //            QRCodeUtil.encode(text,"d:/test"); // 不带logo
// //         BufferedImage bi = ImageIO.read(new File("d:/test/a1.jpg"));
// //         QRCodeUtil.encode(text, bi, "ok", "123", "d:/test", true);
//
//
//         String targetText = "https://invest.zfaex.com/";
//         // 1. 生成带文字图片
//         // FontImage.getImage("刘东东", 100, 100, "d:/");
//         // // 2. 读取图片
//         // BufferedImage bufferedImage = ImageIO.read(new File("d:/test/123.jpg"));
//         // 3. 将带文字图片嵌入二维码中
//         // QRCodeUtil.encode(targetText, bufferedImage, "ok", "刘东东二维码测试", "d:/", true);
//
//         ByteArrayOutputStream out1 = new ByteArrayOutputStream();
//         FontImage.getImage("刘东东", 100, 100 , out1);
//
//         BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(out1.toByteArray()));
//
//         // 第二种测试： 将流中的图片转换成base64
//         ByteArrayOutputStream out2 = new ByteArrayOutputStream();
//         // QRCodeUtil.encode(targetText, bufferedImage, "",  out2, true);
//         // String base64 = Base64Utils.encodeToString(out2.toByteArray());
//         // System.out.println("data:image/png;base64," + base64);
//
//         QRCodeUtil.encode(targetText, out2);
//
//         String base64 = Base64.getEncoder().encodeToString(out2.toByteArray());
//         System.out.println(base64);
//
//         // String base64 = Base64Utils.encodeToString(out2.toByteArray());
//         // System.out.println("data:image/png;base64," + base64);
//
//         long endTime = System.currentTimeMillis();


        String s = genQRCode("https://invest.zfaex.com/", "");
        System.out.println(s);
        String s2 = genQRCode("https://invest.zfaex.com/", "葫芦娃");
        System.out.println(s2);
    }

    public static String genQRCode(String targetUrl, String clientManagerName) {
        String qrCodeBase64Url = null;
        ByteArrayOutputStream output1 = null;
        ByteArrayOutputStream output2 = null;
        ByteArrayInputStream input1 = null;
        BufferedImage bufferedImage = null;
        if (StringUtils.isNotBlank(clientManagerName)) {
            try {
                // 1. 生成客户经理名字图片
                output1 = new ByteArrayOutputStream();
                FontImage.getImage(clientManagerName, WIDTH, HEIGHT, output1);
                // 2. 读取output1中的图片
                input1 = new ByteArrayInputStream(output1.toByteArray());
                bufferedImage = ImageIO.read(input1);
                // 3. 嵌入客户经理图片到二维码中
                output2 = new ByteArrayOutputStream();
                QRCodeUtil.encode(targetUrl, bufferedImage, "", output2, false);
                // 4. 生成base64地址
                qrCodeBase64Url = Base64.getEncoder().encodeToString(output2.toByteArray());
            } catch (Exception e) {
            } finally {
                IOUtils.closeQuietly(output1);
                IOUtils.closeQuietly(input1);
                IOUtils.closeQuietly(output2);
            }
        } else {
            try {
                output2 = new ByteArrayOutputStream();
                QRCodeUtil.encode(targetUrl, output2);
                // 4. 生成base64地址
                qrCodeBase64Url = Base64.getEncoder().encodeToString(output2.toByteArray());
            } catch (Exception e) {
            } finally {
                IOUtils.closeQuietly(output2);
            }
        }
        return "data:image/png;base64," + qrCodeBase64Url;
    }
}
