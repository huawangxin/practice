package src.remoteControl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * 画板，用户界面
 * @author huawangxin
 *
 * 
 * @date 2016年11月10日 下午3:14:37
 */
public class ImagePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4902352066805834017L;
	BufferedImage image ;
	
	public void setImage(BufferedImage image){
		this.image = image ;
		this.setPreferredSize(new Dimension(image.getWidth() , image.getHeight()));
		this.repaint() ;
		this.updateUI() ;
	}
	
	public void paint(Graphics g){
		if(image != null){
			g.drawImage(image , 0 , 0 , null) ;
		}
	}

}
