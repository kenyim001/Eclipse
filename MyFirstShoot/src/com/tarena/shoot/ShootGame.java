package com.tarena.shoot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;//ImageIO=image input out 图版输入输出
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

//主程序 
public class ShootGame extends JPanel{
	public static final int WIDTH=400;
	public static final int HEIGHT=654;
	
	public static BufferedImage background; //背景图	
	public static BufferedImage start;//启动图
	public static BufferedImage pause;//暂停
	public static BufferedImage airplane;//敌机
	public static BufferedImage gameouve;//游戏结束
	public static BufferedImage bee;//小蜜蜂
	public static BufferedImage bullet;//子弹
	public static BufferedImage hero0;//英雄机1
	public static BufferedImage hero1;//英雄机1


	private Hero hero =new Hero();
	private Bullet[] bullets={};//子弹 
	private FlyingObject[] flyings={};//敌人机和蜜蜂 数组~
	
	ShootGame(){
		bullets=new Bullet[1];
		bullets[0]=new Bullet(20,30);
		flyings=new FlyingObject[2];
		flyings[0]=new Airplane();
		flyings[1]=new Bee();
	}
	
	static{//初始化静态资源
		try{
			background= ImageIO.read(ShootGame.class.getResource("backgroud.png"));
			start= ImageIO.read(ShootGame.class.getResource("start.png"));
			pause= ImageIO.read(ShootGame.class.getResource("pause.png"));
			airplane= ImageIO.read(ShootGame.class.getResource("airplane.png"));
			gameouve= ImageIO.read(ShootGame.class.getResource("gameouve.png"));
			bee= ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet= ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0= ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1= ImageIO.read(ShootGame.class.getResource("hero1.png"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*重写paint() g:等于画笔*/
	public void paint(Graphics g){
		g.drawImage(background,0,0,null);//0代表坐标 画背景图
		paintHero(g);//画英雄机对象
		paintFlyingObjects(g);//画敌人对象
		paintBullets(g);//画子弹对象
	}

	
	/*画英雄机对象*/
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y,null);
	}
	/*画敌人对象s*/
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){//遍历所有敌人
			FlyingObject f=flyings[i];//获取每一个敌人
			g.drawImage(f.image,f.x,f.y,null);//画出每一个敌人
		}
	}
	/*画子弹对象*/
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){//遍历子弹数组
			FlyingObject b=bullets[i];//获取每一个子弹
			g.drawImage(b.image,b.x,b.y,null);//画出每一个子弹
		}
	}
	
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("Fly");//创建窗口对象
		ShootGame game=new ShootGame();//面板
		frame.add(game);//将面板添加到窗口中
		
		frame.setSize(WIDTH,HEIGHT);//设置窗口的大小
		frame.setAlwaysOnTop(true);//窗口永远在最上面
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭时退出
		frame.setLocationRelativeTo(null);//默认为顶点（0.0），null居中
		frame.setVisible(true);//1.设置窗口可见 2.尽快的调用paint() 父类有JPanel而父类什么都没有 
	}
}
