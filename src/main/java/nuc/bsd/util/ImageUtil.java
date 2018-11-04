package nuc.bsd.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

	
	public static void trimBlank(String fn) throws IOException {
		
		BufferedImage src;
		int x1,y1,x2,y2;//左上角，右下角
		src=ImageIO.read(new File(fn));
		
		int w=src.getWidth();
		int h=src.getHeight();
		x1=w;y1=h;x2=0;y2=0;
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){
				int rgb=src.getRGB(i, j);
				/*int R = (rgb & 0xff0000) >> 16;
				int G = (rgb & 0xff00) >> 8;
				int B = (rgb & 0xff);*/
				if(rgb!=-1){//不透明
					x1 = i;
					y1 = j;
					i = w +1;
					j = h +1;
				}
			}
		}
		for(int j=0;j<h;j++){
			for(int i=0;i<w;i++){
				int rgb=src.getRGB(i, j);
				
				/*int R = (rgb & 0xff0000) >> 16;
				int G = (rgb & 0xff00) >> 8;
				int B = (rgb & 0xff);*/
				if(rgb!=-1){//不透明
					if(y1>j) {
						y1 = j;
					}
					i = w +1;
					j = h +1;
				}
			}
		}
		for(int j=h-1;j>-1;j--){
			for(int i=w-1;i>-1;i--){
				int rgb=src.getRGB(i, j);
				int R = (rgb & 0xff0000) >> 16;
				int G = (rgb & 0xff00) >> 8;
				int B = (rgb & 0xff);
				if(!(R==255 && G==255 && B==255)){//不透明
					x2 = i;
					y2 = j;
					i = j = -1;
				}
			}
		}
		for(int i=w-1;i>-1;i--){
			for(int j=h-1;j>-1;j--){
				int rgb=src.getRGB(i, j);
				int R = (rgb & 0xff0000) >> 16;
				int G = (rgb & 0xff00) >> 8;
				int B = (rgb & 0xff);
				if(!(R==255 && G==255 && B==255)){//不透明
					if(i>x2) {
						x2 = i;
					}
					i = j = -1;
				}
			}
		}
		int ww =  x2-x1+1;
		int hh = y2-y1+1;
		//System.out.println("x1:"+x1+",y1:"+y1+"w:"+ww+",h:"+hh);
		BufferedImage out=src.getSubimage(x1, y1, x2-x1+1, y2-y1+1);
		BufferedImage bi_scale = new BufferedImage(ww, hh, BufferedImage.TYPE_4BYTE_ABGR);
		double grayMean = 0;
		for(int i=0; i<ww; i++) {
			for(int j=0; j<hh; j++) {
				 int rgb = out.getRGB(i,j);
	                int r = (0xff&rgb);
	                int g = (0xff&(rgb>>8));
	                int b = (0xff&(rgb>>16));
	                //这是灰度值的计算公式
	                grayMean += (r*0.299+g*0.587+b*0.114);
				
			}
		}
		//计算平均灰度
        grayMean = grayMean/(ww*hh);
        for (int i = 0; i < ww; i++) {
            for (int j = 0; j < hh; j++) {
                int rgb = out.getRGB(i,j);
                int r = (0xff&rgb);
                int g = (0xff&(rgb>>8));
                int b = (0xff&(rgb>>16));
                double gray = (r*0.299+g*0.587+b*0.114);
                if (gray>grayMean){
                    rgb = r + (g << 8) + (b << 16) + (0 << 24);
                }
                bi_scale.setRGB(i,j,rgb);
            }
        }
		ImageIO.write(bi_scale, "png", new File(fn));
		

	}
	public static void main(String[]args) throws IOException {
		//for(int i=21; i<32 ;i++) {
		trimBlank("D:\\ky\\bsd\\pdfReport\\target\\classes\\pbTest\\p"+22+".png");
		//}
	}
}
