package management.util;
/**
 * 主要是用来处理图片
 */
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;


public class ImageUtil {

	public static BufferedImage change2jpg(File f) {//将文件转换成为.jpg格式
		try {
			java.awt.Image i = Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
			PixelGrabber pg = new PixelGrabber(i, 0, 0, -1, -1, true);
			pg.grabPixels();
			int width = pg.getWidth(), height = pg.getHeight();
			final int[] RGB_MASKS = { 0xFF0000, 0xFF00, 0xFF };
			final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
			DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
			WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
			BufferedImage img = new BufferedImage(RGB_OPAQUE, raster, false, null);
			return img;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	/**
	 * 
	 * @param srcFile 原图片文件
	 * @param width   
	 * @param height
	 * @param destFile 目标文件
	 */
	public static void resizeImage(File srcFile, int width,int height, File destFile) { //按倍率缩小文件
		try {
			if(!destFile.getParentFile().exists())
				destFile.getParentFile().mkdirs();
			Image i = ImageIO.read(srcFile);
			i = resizeImage(i, width, height);
			ImageIO.write((RenderedImage) i, "jpg", destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Image resizeImage(Image srcImage, int width, int height) {//调整文件的大小
		try {

			BufferedImage buffImg = null;
			buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			buffImg.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			return buffImg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据文件内容以及文件名和位置创建文件，并返回存储的完整位置
	 * @param is
	 * @param filePath
	 * @param fileName 文件的名字（piid）
	 * @return
	 */
	public static String saveImage(InputStream is, HttpServletRequest request, String fileName) {
		//创建完整的文件名
		String filePath = request.getSession().getServletContext().getRealPath("img/product");
		File f = new File(filePath, fileName + ".jpg");
		//如果文件不存在创建文件
		f.getParentFile().mkdirs();
		
		//在文件中写入内容
		 try {
	    	 if(is != null && 0!=is.available()) {
	    		 try {
	    			 FileOutputStream fos = new FileOutputStream(f);
	    			 byte[] b = new byte[1024*1024];
	    			 int length =0;
	    			 while((length = is.read(b))!= -1) {
	    				 fos.write(b, 0, length);
	    			 }
	    			 fos.flush();
	    			 
	    			 //创建缩略图
	    			 String imgFolder_small = request.getSession().getServletContext().getRealPath("img/productsmall");
	    			 File f_small = new File(imgFolder_small, fileName + ".jpg");
	    			 ImageUtil.resizeImage(f, 217, 190, f_small);
	    			 
	    			 fos.close();
	    		 }catch(Exception e) {
	    			 e.printStackTrace();
	    		 }
	    	 }
	     }catch (IOException e) {
	    	 e.printStackTrace();
	     }
		return f.toString();
	}

}
