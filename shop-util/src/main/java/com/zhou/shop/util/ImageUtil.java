package com.zhou.shop.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/17 18:26-zhouxiong： 创建此类
 * @since 2022/6/17 18:26
 */
public class ImageUtil {
    private static final int WIDTH = 62;
    private static final int HEIGHT = 25;

    /**
     * 生成图片(长，宽，高)
     *
     * @param checkCode 验证码
     * @param outputStream 输入流
     * @throws IOException
     */
    public static void createImage(String checkCode, OutputStream outputStream) throws IOException {
        BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        setBackground(g);
        // setBorder(g);
        g.setFont(new Font("宋体", Font.BOLD, 20));
        g.setColor(Color.blue);
        // 将生成的随机字符串写在图片上
        g.drawString(checkCode, 10, 20);

        ImageIO.write(bi, "jpg", outputStream);
    }

    /**
     * 设置各种属性(颜色，字体) 设置边框
     *
     * @param g 图片
     */
    public static void setBorder(Graphics g) {
        // 设置边框颜色
        g.setColor(Color.BLUE);
        // 边框区域
        g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
    }

    /**
     * //设置背景色
     *
     * @param g 图片
     */
    public static void setBackground(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }
}
