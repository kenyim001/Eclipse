package com.tarena.shoot;
import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {
	private int life;
	private int doubleFire;
	private BufferedImage[] images;//ͼƬ����
	private int index;//ͼƬ�л�
	public Hero(){
		image=ShootGame.hero0;
		width=image.getWidth();
		height=image.getHeight();
		x=150;	//X���꣺�̶�
		y=400;	//Y���꣺�̶�
		life=3; //3����
		doubleFire=0;//����ֵΪ0��������������
		images=new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		index=0;
	}
}

