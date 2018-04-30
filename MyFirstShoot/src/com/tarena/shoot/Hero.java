package com.tarena.shoot;
import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {
	private int life;
	private int doubleFire;
	private BufferedImage[] images;//图片数组
	private int index;//图片切换
	public Hero(){
		image=ShootGame.hero0;
		width=image.getWidth();
		height=image.getHeight();
		x=150;	//X坐标：固定
		y=400;	//Y坐标：固定
		life=3; //3条命
		doubleFire=0;//火力值为0（即单倍火力）
		images=new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		index=0;
	}
}

