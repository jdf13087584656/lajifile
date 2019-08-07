//package com.xlkj.website.util;
//
//import com.google.zxing.*;
//import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.common.HybridBinarizer;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//import java.awt.Color;
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.geom.RoundRectangle2D;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.util.Hashtable;
//import java.util.Random;
//
///**
// * @Auther: Admin
// * @Date: 2019/8/5 19:07
// * @Description:
// */
//public class CodeUtil {
//
//
//        private static final String CHARSET = "utf-8";
//        private static final String FORMAT = "JPG";
//        // 二维码尺寸
//        private static final int QRCODE_SIZE = 300;
//        // LOGO宽度
//        private static final int LOGO_WIDTH = 60;
//        // LOGO高度
//        private static final int LOGO_HEIGHT = 60;
//
//        private static BufferedImage createImage(String content, String logoPath, boolean needCompress) throws Exception {
//            Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
//            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//            hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
//            hints.put(EncodeHintType.MARGIN, 1);
//            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
//                    hints);
//            int width = bitMatrix.getWidth();
//            int height = bitMatrix.getHeight();
//            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//            for (int x = 0; x < width; x++) {
//                for (int y = 0; y < height; y++) {
//                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
//                }
//            }
//            if (logoPath == null || "".equals(logoPath)) {
//                return image;
//            }
//
//
//            // 插入图片
//            CodeUtil.insertImage(image, logoPath, needCompress);
//            return image;
//        }
//
//        /**
//         * 插入LOGO
//         *
//         * @param source
//         *            二维码图片
//         * @param logoPath
//         *            LOGO图片地址
//         * @param needCompress
//         *            是否压缩
//         * @throws Exception
//         */
//        private static void insertImage(BufferedImage source, String logoPath, boolean needCompress) throws Exception {
//            File file = new File(logoPath);
//            if (!file.exists()) {
//                throw new Exception("logo file not found.");
//            }
//            Image src = ImageIO.read(new File(logoPath));
//            int width = src.getWidth(null);
//            int height = src.getHeight(null);
//            if (needCompress) { // 压缩LOGO
//                if (width > LOGO_WIDTH) {
//                    width = LOGO_WIDTH;
//                }
//                if (height > LOGO_HEIGHT) {
//                    height = LOGO_HEIGHT;
//                }
//                Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//                BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//                Graphics g = tag.getGraphics();
//                g.drawImage(image, 0, 0, null); // 绘制缩小后的图
//                g.dispose();
//                src = image;
//            }
//            // 插入LOGO
//            Graphics2D graph = source.createGraphics();
//            int x = (QRCODE_SIZE - width) / 2;
//            int y = (QRCODE_SIZE - height) / 2;
//            graph.drawImage(src, x, y, width, height, null);
//            Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
//            graph.setStroke(new BasicStroke(3f));
//            graph.draw(shape);
//            graph.dispose();
//        }
///*    *//**
//     * @param bim       放在内存中图片
//     * @param belowText 二维码下方显示文字
//     * @return
//     *//*
//    public Image addTextForQRCode(BufferedImage bim, String belowText) {
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
////            存放本地
//            *//*ImageIO.write(newBufferedImage, "png", new File(CODEPATH + "SZ-" + System.currentTimeMillis() + "code.png"));*//*
//            Image imageByte = com.lowagie.text.Image.getInstance(baos.toByteArray());
//            baos.close();
//            image.flush();
//            return imageByte;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }*/
//
//        /**
//         * 生成二维码(内嵌LOGO)
//         * 二维码文件名随机，文件名可能会有重复
//         *
//         * @param content
//         *            内容
//         * @param logoPath
//         *            LOGO地址
//         * @param destPath
//         *            存放目录
//         * @param needCompress
//         *            是否压缩LOGO
//         * @throws Exception
//         */
//        public static String encode(String content, String logoPath, String destPath, boolean needCompress) throws Exception {
//            BufferedImage image = CodeUtil.createImage(content, logoPath, needCompress);
//            mkdirs(destPath);
//            String fileName = new Random().nextInt(99999999) + "." + FORMAT.toLowerCase();
//            ImageIO.write(image, FORMAT, new File(destPath + "/" + fileName));
//            return fileName;
//        }
//
//        /**
//         * 生成二维码(内嵌LOGO)
//         * 调用者指定二维码文件名
//         *
//         * @param content
//         *            内容
//         * @param logoPath
//         *            LOGO地址
//         * @param destPath
//         *            存放目录
//         * @param fileName
//         *            二维码文件名
//         * @param needCompress
//         *            是否压缩LOGO
//         * @throws Exception
//         */
//        public static String encode(String content, String logoPath, String destPath, String fileName, boolean needCompress) throws Exception {
//            BufferedImage image = CodeUtil.createImage(content, logoPath, needCompress);
//            mkdirs(destPath);
//            fileName = fileName.substring(0, fileName.indexOf(".")>0?fileName.indexOf("."):fileName.length())
//                    + "." + FORMAT.toLowerCase();
//            ImageIO.write(image, FORMAT, new File(destPath + "/" + fileName));
//            return fileName;
//        }
//
//        /**
//         * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．
//         * (mkdir如果父目录不存在则会抛出异常)
//         * @param destPath
//         *            存放目录
//         */
//        public static void mkdirs(String destPath) {
//            File file = new File(destPath);
//            if (!file.exists() && !file.isDirectory()) {
//                file.mkdirs();
//            }
//        }
//
//        /**
//         * 生成二维码(内嵌LOGO)
//         *
//         * @param content
//         *            内容
//         * @param logoPath
//         *            LOGO地址
//         * @param destPath
//         *            存储地址
//         * @throws Exception
//         */
//        public static String encode(String content, String logoPath, String destPath) throws Exception {
//            return CodeUtil.encode(content, logoPath, destPath, false);
//        }
//
//        /**
//         * 生成二维码
//         *
//         * @param content
//         *            内容
//         * @param destPath
//         *            存储地址
//         * @param needCompress
//         *            是否压缩LOGO
//         * @throws Exception
//         */
//        public static String encode(String content, String destPath, boolean needCompress) throws Exception {
//            return CodeUtil.encode(content, null, destPath, needCompress);
//        }
//
//        /**
//         * 生成二维码
//         *
//         * @param content
//         *            内容
//         * @param destPath
//         *            存储地址
//         * @throws Exception
//         */
//        public static String encode(String content, String destPath) throws Exception {
//            return CodeUtil.encode(content, null, destPath, false);
//        }
//
//        /**
//         * 生成二维码(内嵌LOGO)
//         *
//         * @param content
//         *            内容
//         * @param logoPath
//         *            LOGO地址
//         * @param output
//         *            输出流
//         * @param needCompress
//         *            是否压缩LOGO
//         * @throws Exception
//         */
//        public static void encode(String content, String logoPath, OutputStream output, boolean needCompress)
//                throws Exception {
//            BufferedImage image = CodeUtil.createImage(content, logoPath, needCompress);
//            ImageIO.write(image, FORMAT, output);
//        }
//
//        /**
//         * 生成二维码
//         *
//         * @param content
//         *            内容
//         * @param output
//         *            输出流
//         * @throws Exception
//         */
//        public static void encode(String content, OutputStream output) throws Exception {
//            CodeUtil.encode(content, null, output, false);
//        }
//
//        /**
//         * 解析二维码
//         *
//         * @param file
//         *            二维码图片
//         * @return
//         * @throws Exception
//         */
//        public static String decode(File file) throws Exception {
//            BufferedImage image;
//            image = ImageIO.read(file);
//            if (image == null) {
//                return null;
//            }
//            BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
//            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//            Result result;
//            Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
//            hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
//            result = new MultiFormatReader().decode(bitmap, hints);
//            String resultStr = result.getText();
//            return resultStr;
//        }
//
//        /**
//         * 解析二维码
//         *
//         * @param path
//         *            二维码图片地址
//         * @return
//         * @throws Exception
//         */
//        public static String decode(String path) throws Exception {
//            return CodeUtil.decode(new File(path));
//        }
//
//
//    /**
//     * 给二维码添加logo
//     */
//    public static BufferedImage addLogo_QRCode(BufferedImage barCodeImage, File logoPic, LogoConfig logoConfig) {
//        try {
//            if (!logoPic.isFile()) {
//                System.out.print("file not find !");
//                throw new IOException("file not find !");
//            }
//
//            // 读取二维码图片，并构建绘图对象
//            Graphics2D g = barCodeImage.createGraphics();
//
//            //读取Logo图片
//            BufferedImage logo = ImageIO.read(logoPic);
//
//            int widthLogo = barCodeImage.getWidth() / logoConfig.getLogoPart();
//            int heightLogo = barCodeImage.getWidth() / logoConfig.getLogoPart(); //保持二维码是正方形的
//
//            // 计算图片放置位置
//            int x = (barCodeImage.getWidth() - widthLogo) / 2;
//            int y = (barCodeImage.getHeight() - heightLogo) / 2 - 50;
//
//            //开始绘制图片
//            g.drawImage(logo, x, y, widthLogo, heightLogo, null);
//            g.drawRoundRect(x, y, widthLogo, heightLogo, 10, 10);
//            g.setStroke(new BasicStroke(logoConfig.getBorder()));
//            g.setColor(logoConfig.getBorderColor());
//            g.drawRect(x, y, widthLogo, heightLogo);
//            g.dispose();
//            return barCodeImage;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 给二维码下方附加说明文字
//     * @param pressText 文字
//     * @param newImg    带文字的图片
//     * @param image     需要添加文字的图片
//     * @为图片添加文字
//     */
//    public static void pressText(String pressText, String newImg, BufferedImage image, int fontStyle, Color color, int fontSize, int width, int height) {
//
//        //计算文字开始的位置
//        //x开始的位置：（图片宽度-字体大小*字的个数）/2
//        int startX = (width - (fontSize * pressText.length())) / 3 - 28;
//        //y开始的位置：图片高度-（图片高度-图片宽度）/2
//        int startY = height - (height - width) / 2 - 30;
//
//        System.out.println("startX: " + startX);
//        System.out.println("startY: " + startY);
//        System.out.println("height: " + height);
//        System.out.println("width: " + width);
//        System.out.println("fontSize: " + fontSize);
//        System.out.println("pressText.length(): " + pressText.length());
//
//        try {
//            int imageW = image.getWidth();
//            int imageH = image.getHeight();
//            Graphics g = image.createGraphics();
//            g.drawImage(image, 0, 0, imageW, imageH, null);
//            g.setColor(color);
//            g.setFont(new Font("粗体", Font.BOLD, 25));
//            g.drawString(pressText, startX, startY);
//            g.drawString("", startX - 5, startY + 30);
//            g.dispose();
//
//            FileOutputStream out = new FileOutputStream(newImg);
//            ImageIO.write(image, "png", out);
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//            encoder.encode(image);
//            out.close();
//            System.out.println("image press success");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e);
//        }
//
//    }
//
////        public static void main(String[] args) throws Exception {
////            String text = "1025479864";
////            //不含Logo
////            //CodeUtil.encode(text, null, "/Users/ianly/Documents/picture", true);
////            //含Logo，不指定二维码图片名
////            //CodeUtil.encode(text, "/Users/ianly/Documents/picture/google-icon.jpg", "/Users/ianly/Documents/picture/", true);
////            //含Logo，指定二维码图片名
////            try {
////                CodeUtil.encode(text, "C:\\Users\\Admin\\Desktop\\logo.png", "C:\\Users\\Admin\\Desktop\\pict", "qrcode", true);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
//
//
//}
//
//
//
///**
// * logo配置类
// * @author Administrator
// *
// */
//class LogoConfig {
//
//    // logo默认边框颜色
//    public static final Color DEFAULT_BORDERCOLOR = Color.WHITE;
//    // logo默认边框宽度
//    public static final int DEFAULT_BORDER = 2;
//    // logo大小默认为二维码照片的1/6
//    public static final int DEFAULT_LOGOPART = 6;
//
//    private final int border = DEFAULT_BORDER;
//    private final Color borderColor;
//    private final int logoPart;
//
//
//    public LogoConfig() {
//        this(DEFAULT_BORDERCOLOR, DEFAULT_LOGOPART);
//    }
//
//    public LogoConfig(Color borderColor, int logoPart) {
//        this.borderColor = borderColor;
//        this.logoPart = logoPart;
//    }
//
//    public Color getBorderColor() {
//        return borderColor;
//    }
//
//    public int getBorder() {
//        return border;
//    }
//
//    public int getLogoPart() {
//        return logoPart;
//    }
//
//}