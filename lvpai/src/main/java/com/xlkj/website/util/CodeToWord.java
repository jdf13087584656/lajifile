//package com.xlkj.website.util;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.WriterException;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.geom.RoundRectangle2D;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Auther: Admin
// * @Date: 2019/8/6 14:42
// * @Description:
// */
//public class CodeToWord {
//
//    private static final String CHARSET = "utf-8";
//    private static final String FORMAT = "JPG";
//    // 二维码尺寸
//    private static final int QRCODE_SIZE = 230;
//    // LOGO宽度
//    private static final int LOGO_WIDTH = 60;
//    // LOGO高度
//    private static final int LOGO_HEIGHT = 60;
//
//    /**
//     * 颜色
//     */
//    private static final int QRCOLOR = 0xFF000000;
//    /**
//     * 背景颜色
//     */
//    private static final int BGWHITE = 0xFFFFFFFF;
//
//    /**
//     * 存放路径
//     */
////    private static final String CODEPATH = "..\\..\\codeImage\\";
//    public static void main(String[] args) {
//        try {
//            System.out.println(System.currentTimeMillis());
//            getQRCode("fe212ac018f4711811", "300-欧阳峰子","C:\\Users\\Admin\\Desktop\\pict","110");
//            System.out.println(System.currentTimeMillis());
//            System.out.println("生成ok");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 生成二维码方法
//     *
//     * @param data
//     * @param belowText
//     * @return
//     */
//    public static com.lowagie.text.Image getQRCode(String data, String belowText,String filepath,String filename) {
//        try {
//            CodeToWord zp = new CodeToWord();
//            BufferedImage bim = zp.generateQRCodeBufferedImage(data, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, zp.getDecodeHintType(),filename);
//            //字节数组
//            com.lowagie.text.Image imageByte = zp.addTextForQRCode(bim, belowText,filepath,filename);
//            return imageByte;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * @param bim       放在内存中图片
//     * @param belowText 二维码下方显示文字
//     * @return
//     */
//    public com.lowagie.text.Image addTextForQRCode(BufferedImage bim, String belowText,String filepath,String filename) {
//        try {
//            BufferedImage image = bim;
//            if (belowText != null && !belowText.equals("")) {
//                BufferedImage outImage = new BufferedImage(230, 245, BufferedImage.TYPE_4BYTE_ABGR);
//                Graphics2D outg = outImage.createGraphics();
//                outg.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
//                outg.setColor(Color.BLACK);
//                outg.setFont(new Font("宋体", Font.PLAIN, 18));
//                int strWidth = outg.getFontMetrics().stringWidth(belowText);
//                outg.drawString(belowText, 100 - strWidth / 2 + 8, image.getHeight() + (outImage.getHeight() - image.getHeight()) / 2 + 5);
//                outg.dispose();
//                outImage.flush();
//                image = outImage;
//            }
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            baos.flush();
//            ImageIO.write(image, "png", baos);
//            BufferedImage newBufferedImage = new BufferedImage(
//                    image.getWidth(), image.getHeight(),
//                    BufferedImage.TYPE_INT_RGB);
//            newBufferedImage.createGraphics().drawImage(image, 0, 0,
//                    Color.WHITE, null);
//
//            insertImage(newBufferedImage,"C:\\Users\\Admin\\Desktop\\log.png",true);
//            mkdirs(filepath);
//
//
////            存放本地
//            ImageIO.write(newBufferedImage, "png", new File(filepath + "/" +filename + ".png"));
//          //  com.lowagie.text.Image imageByte = com.lowagie.text.Image.getInstance(baos.toByteArray());
//            baos.close();
//            image.flush();
//          //  return imageByte;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    /**
//     * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．
//     * (mkdir如果父目录不存在则会抛出异常)
//     * @param destPath
//     *            存放目录
//     */
//    public static void mkdirs(String destPath) {
//        File file = new File(destPath);
//        if (!file.exists() && !file.isDirectory()) {
//            file.mkdirs();
//        }
//    }
//
//    private static void insertImage(BufferedImage source, String logoPath, boolean needCompress) throws Exception {
//        File file = new File(logoPath);
//        if (!file.exists()) {
//            throw new Exception("logo file not found.");
//        }
//        Image src = ImageIO.read(new File(logoPath));
//        int width = src.getWidth(null);
//        int height = src.getHeight(null);
//        if (needCompress) { // 压缩LOGO
//            if (width > LOGO_WIDTH) {
//                width = LOGO_WIDTH;
//            }
//            if (height > LOGO_HEIGHT) {
//                height = LOGO_HEIGHT;
//            }
//            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//            Graphics g = tag.getGraphics();
//            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
//            g.dispose();
//            src = image;
//        }
//        // 插入LOGO
//        Graphics2D graph = source.createGraphics();
//        int x = (230 - width) / 2;
//        int y = (230 - height) / 2;
//        graph.drawImage(src, x, y, width, height, null);
//        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
//        graph.setStroke(new BasicStroke(3f));
//        graph.draw(shape);
//        graph.dispose();
//    }
//
//    /**
//     * 绘制二维码，不带文字
//     *
//     * @param content       扫描内容
//     * @param barcodeFormat 格式
//     * @param width
//     * @param height
//     * @param hints         二维码属性设置
//     * @return 放到内存中，后续再二维码下方添加文字
//     */
//    public BufferedImage generateQRCodeBufferedImage(String content, BarcodeFormat barcodeFormat, int width, int height, Map<EncodeHintType, ?> hints,String filename) {
//        MultiFormatWriter multiFormatWriter = null;
//        BitMatrix bm = null;
//        BufferedImage image = null;
//        try {
//            multiFormatWriter = new MultiFormatWriter();
//            bm = multiFormatWriter.encode(content, barcodeFormat, width, height, hints);
//            int w = bm.getWidth();
//            int h = bm.getHeight();
//            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//            for (int x = 0; x < w; x++) {
//                for (int y = 0; y < h; y++) {
//                    image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
//                }
//            }
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    /**
//     * 设置二维码属性
//     *
//     * @return
//     */
//    public Map<EncodeHintType, Object> getDecodeHintType() {
//        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
//        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//        hints.put(EncodeHintType.MARGIN, 0);
//        hints.put(EncodeHintType.MAX_SIZE, 350);
//        hints.put(EncodeHintType.MIN_SIZE, 100);
//        return hints;
//    }
//
//}
