package com.zhou.shop.util;

import com.zhou.shop.enums.Source;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Administrator
 */
public class RandomUtil {
    private static int width = 62;
    private static int height = 25;

    /**
     * 生成随机验证码(数字，字母)
     */
    public static String createRandom(int length, Source sources, int bound){
        java.util.Random random = new java.util.Random(System.currentTimeMillis());
        StringBuffer randomCode = new StringBuffer();
        //循环伪随机生成length个字符
        for (int j = 0; j < length; j++) {
            randomCode.append(sources.sources.charAt(random.nextInt(bound)) + "");
        }
        return randomCode.toString();
    }

    /**
     * 生成图片(长，宽，高)
     * @param checkCode 验证码
     * @param outputStream 输入流
     * @throws IOException
     */
    public static void createImage(String checkCode,OutputStream outputStream) throws IOException {
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        setBackground(g);
        //setBorder(g);
        g.setFont(new Font("宋体",Font.BOLD,20));
        g.setColor(Color.blue);
        //将生成的随机字符串写在图片上
        g.drawString(checkCode,10,20);

        ImageIO.write(bi,"jpg",outputStream);
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
        g.drawRect(1, 1, width-2, height-2);
    }

    /**
     * //设置背景色
     * @param g 图片
     */
    public static void setBackground(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
    }


}
