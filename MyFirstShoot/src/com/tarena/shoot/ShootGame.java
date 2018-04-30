package com.tarena.shoot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;//ImageIO=image input out ͼ���������
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

//������ 
public class ShootGame extends JPanel{
	public static final int WIDTH=400;
	public static final int HEIGHT=654;
	
	public static BufferedImage background; //����ͼ	
	public static BufferedImage start;//����ͼ
	public static BufferedImage pause;//��ͣ
	public static BufferedImage airplane;//�л�
	public static BufferedImage gameouve;//��Ϸ����
	public static BufferedImage bee;//С�۷�
	public static BufferedImage bullet;//�ӵ�
	public static BufferedImage hero0;//Ӣ�ۻ�1
	public static BufferedImage hero1;//Ӣ�ۻ�1


	private Hero hero =new Hero();
	private Bullet[] bullets={};//�ӵ� 
	private FlyingObject[] flyings={};//���˻����۷� ����~
	
	ShootGame(){
		bullets=new Bullet[1];
		bullets[0]=new Bullet(20,30);
		flyings=new FlyingObject[2];
		flyings[0]=new Airplane();
		flyings[1]=new Bee();
	}
	
	static{//��ʼ����̬��Դ
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
	
	/*��дpaint() g:���ڻ���*/
	public void paint(Graphics g){
		g.drawImage(background,0,0,null);//0�������� ������ͼ
		paintHero(g);//��Ӣ�ۻ�����
		paintFlyingObjects(g);//�����˶���
		paintBullets(g);//���ӵ�����
	}

	
	/*��Ӣ�ۻ�����*/
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x, hero.y,null);
	}
	/*�����˶���s*/
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){//�������е���
			FlyingObject f=flyings[i];//��ȡÿһ������
			g.drawImage(f.image,f.x,f.y,null);//����ÿһ������
		}
	}
	/*���ӵ�����*/
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){//�����ӵ�����
			FlyingObject b=bullets[i];//��ȡÿһ���ӵ�
			g.drawImage(b.image,b.x,b.y,null);//����ÿһ���ӵ�
		}
	}
	
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("Fly");//�������ڶ���
		ShootGame game=new ShootGame();//���
		frame.add(game);//�������ӵ�������
		
		frame.setSize(WIDTH,HEIGHT);//���ô��ڵĴ�С
		frame.setAlwaysOnTop(true);//������Զ��������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ڹر�ʱ�˳�
		frame.setLocationRelativeTo(null);//Ĭ��Ϊ���㣨0.0����null����
		frame.setVisible(true);//1.���ô��ڿɼ� 2.����ĵ���paint() ������JPanel������ʲô��û�� 
	}
}
