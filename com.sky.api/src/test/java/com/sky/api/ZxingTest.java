package com.sky.api;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class ZxingTest {
	
	private static final int BLACK = 0xFF000000;  
    private static final int WHITE = 0xFFFFFFFF;   
      
    /** 
     *  最终调用该方法生成二维码图片 
     * @param url 要生成二维码的url 
     * @param imgPath 二维码生成的绝对路径 
     * @param logoPath 二维码中间logo绝对地址 
     * @throws Exception 
     */  
    public static void get2CodeImage(String url,String imgPath,String logoPath) throws Exception{  
        String format = "png";  
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");    
        BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 300, 300, hints);  
        bitMatrix = deleteWhite(bitMatrix);
        int width = bitMatrix.getWidth();  
        int height = bitMatrix.getHeight();  
        BufferedImage image = new BufferedImage(width, height,  
                BufferedImage.TYPE_INT_RGB);  
        for (int x = 0; x < width; x++) {  
            for (int y = 0; y < height; y++) {  
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000  
                        : 0xFFFFFFFF);  
            }  
        }  
        if (imgPath == null || "".equals(imgPath)) {  
        }  
        File qrcodeFile = new File(imgPath);    
        ZxingTest.writeToFile(bitMatrix, format, qrcodeFile, logoPath); 
    }  
    
    public static BitMatrix deleteWhite(BitMatrix matrix){  
        int[] rec = matrix.getEnclosingRectangle();  
        int resWidth = rec[2] + 1;  
        int resHeight = rec[3] + 1;  
      
        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);  
        resMatrix.clear();  
        for (int i = 0; i < resWidth; i++) {  
            for (int j = 0; j < resHeight; j++) {  
                if (matrix.get(i + rec[0], j + rec[1]))  
                    resMatrix.set(i, j);  
            }  
        }  
        return resMatrix;  
    }
      
    /** 
     *  
     * @param matrix 二维码矩阵相关 
     * @param format 二维码图片格式 
     * @param file 二维码图片文件 
     * @param logoPath logo路径 
     * @throws IOException 
     */  
    public static void writeToFile(BitMatrix matrix,String format,File file,String logoPath) throws IOException {  
        BufferedImage image = toBufferedImage(matrix);  
        Graphics2D gs = image.createGraphics();  
          
        //载入logo  
        Image img = ImageIO.read(new File(logoPath));  
        gs.drawImage(img, 80, 80, null);  
        gs.dispose();  
        img.flush();  
        if(!ImageIO.write(image, format, file)){  
            throw new IOException("Could not write an image of format " + format + " to " + file);    
        }  
        System.out.println(""+file.length());
    }  
      
    public static BufferedImage toBufferedImage(BitMatrix matrix){  
        int width = matrix.getWidth();  
        int height = matrix.getHeight();  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
          
        for(int x=0;x<width;x++){  
            for(int y=0;y<height;y++){  
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);  
            }  
        }  
        return image;     
    }  
  
      
    public static void main(String[] args) {  
        try {  
            get2CodeImage("www.baidu.com","D:\\test\\uuu.png","D:\\test\\gem_9.png");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
    }  
}
