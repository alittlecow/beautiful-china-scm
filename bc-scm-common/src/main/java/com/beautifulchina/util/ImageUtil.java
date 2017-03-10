/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-27
 */
package com.beautifulchina.util;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.color.ColorSpace;

import java.awt.geom.AffineTransform;

import java.awt.image.AffineTransformOp;

import java.awt.image.BufferedImage;

import java.awt.image.ColorConvertOp;

import java.io.File;

import java.io.IOException;

/**
 * 图片处理工具方法
 */
public class ImageUtil {
    public static String IMAGE_TYPE_GIF = "gif";

    public static String IMAGE_TYPE_JPG = "jpg";

    public static String IMAGE_TYPE_JPEG = "jpeg";

    public static String IMAGE_TYPE_BMP = "bmp";

    public static String IMAGE_TYPE_PNG = "png";

    public static String IMAGE_TYPE_PSD = "psd";

    /**
     * 按比例缩放
     *
     * @param srcImageFile 输入图片地址
     * @param result       输出图片地址
     * @param scale        比率
     * @param flag         缩放标志
     */
    public final static void scaleByRatio(String srcImageFile, String result, double scale, boolean flag) {

        try {

            BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件

            int width = src.getWidth(); // 得到源图宽

            int height = src.getHeight(); // 得到源图长

            if (flag) {// 放大

                width = (int) (width * scale);

                height = (int) (height * scale);

            } else {// 缩小

                width = (int) (width / scale);

                height = (int) (height / scale);

            }

            Image image = src.getScaledInstance(width, height,

                    Image.SCALE_DEFAULT);

            BufferedImage tag = new BufferedImage(width, height,

                    BufferedImage.TYPE_INT_RGB);

            Graphics g = tag.getGraphics();

            g.drawImage(image, 0, 0, null); // 绘制缩小后的图

            g.dispose();

            ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /**
     * 按高度和宽度缩放
     *
     * @param srcImageFile 图片地址
     * @param result       输出地址
     * @param height       指定高度
     * @param width        指定宽度
     * @param bb           补白标志
     */
    public final static void scaleBySize(String srcImageFile, String result, int height, int width, boolean bb) {

        try {

            double ratio = 0.0; // 缩放比例

            File f = new File(srcImageFile);

            BufferedImage bi = ImageIO.read(f);

            Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);

            // 计算比例

            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {

                if (bi.getHeight() > bi.getWidth()) {

                    ratio = (new Integer(height)).doubleValue()

                            / bi.getHeight();

                } else {

                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();

                }

                AffineTransformOp op = new AffineTransformOp(AffineTransform

                        .getScaleInstance(ratio, ratio), null);

                itemp = op.filter(bi, null);

            }

            if (bb) {//补白

                BufferedImage image = new BufferedImage(width, height,

                        BufferedImage.TYPE_INT_RGB);

                Graphics2D g = image.createGraphics();

                g.setColor(Color.white);

                g.fillRect(0, 0, width, height);

                if (width == itemp.getWidth(null))

                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,

                            itemp.getWidth(null), itemp.getHeight(null),

                            Color.white, null);

                else

                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,

                            itemp.getWidth(null), itemp.getHeight(null),

                            Color.white, null);

                g.dispose();

                itemp = image;

            }

            ImageIO.write((BufferedImage) itemp, "JPEG", new File(result));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /**
     * 图像类型转换
     *
     * @param srcImageFile  输入图片
     * @param formatName    输出格式
     * @param destImageFile 输出图片
     */
    public final static void convert(String srcImageFile, String formatName, String destImageFile) {

        try {

            File f = new File(srcImageFile);

            f.canRead();

            f.canWrite();

            BufferedImage src = ImageIO.read(f);

            ImageIO.write(src, formatName, new File(destImageFile));

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    /**
     * 彩色转黑白
     *
     * @param srcImageFile  输入图片
     * @param destImageFile 输出图片
     */
    public final static void gray(String srcImageFile, String destImageFile) {

        try {

            BufferedImage src = ImageIO.read(new File(srcImageFile));

            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);

            ColorConvertOp op = new ColorConvertOp(cs, null);

            src = op.filter(src, null);

            ImageIO.write(src, "JPEG", new File(destImageFile));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /**
     * 图片添加文字水印
     *
     * @param pressText     水印文字
     * @param srcImageFile  输入图片
     * @param destImageFile 输出图片
     * @param fontName      字体名称
     * @param fontStyle     字体样式
     * @param color         字体颜色
     * @param fontSize      字体大小
     * @param x             文字坐标x
     * @param y             文字坐标y
     * @param alpha         透明度
     */
    public final static void pressText(String pressText, String srcImageFile, String destImageFile, String fontName, int fontStyle, Color color, int fontSize, int x, int y, float alpha, Integer degree) {

        try {

            File img = new File(srcImageFile);

            Image src = ImageIO.read(img);

            int width = src.getWidth(null);

            int height = src.getHeight(null);

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = image.createGraphics();

            g.drawImage(src, 0, 0, width, height, null);

            g.setColor(color);

            g.setFont(new Font(fontName, fontStyle, fontSize));

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(src.getScaledInstance(src.getWidth(null), src.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);

            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree), (double) image.getWidth() / 2, (double) image.getHeight() / 2);
            }
            // 在指定坐标绘制水印文字

            g.drawString(pressText, (width - (getLength(pressText) * fontSize)) / 2 + x, (height - fontSize) / 2 + y);

            g.dispose();

            ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));// 输出到文件流

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    /**
     * 图片添加图片水印
     *
     * @param pressImg      水印图片
     * @param srcImageFile  输入图片
     * @param destImageFile 输出图片
     * @param x             坐标x
     * @param y             坐标y
     * @param alpha         透明度
     */
    public final static void pressImage(String pressImg, String srcImageFile, String destImageFile, int x, int y, float alpha) {

        try {

            File img = new File(srcImageFile);

            Image src = ImageIO.read(img);

            int wideth = src.getWidth(null);

            int height = src.getHeight(null);

            BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = image.createGraphics();

            g.drawImage(src, 0, 0, wideth, height, null);

            // 水印文件

            Image src_biao = ImageIO.read(new File(pressImg));

            int wideth_biao = src_biao.getWidth(null);

            int height_biao = src_biao.getHeight(null);

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

            g.drawImage(src_biao, (wideth - wideth_biao) / 2, (height - height_biao) / 2, wideth_biao, height_biao, null);

            // 水印文件结束

            g.dispose();

            ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    public final static int getLength(String text) {

        int length = 0;

        for (int i = 0; i < text.length(); i++) {

            if (new String(text.charAt(i) + "").getBytes().length > 1) {

                length += 2;

            } else {

                length += 1;

            }

        }

        return length / 2;

    }
}
