package com.tarena.shoot;

import java.util.Random;

//�л�: 
public class Airplane extends FlyingObject implements Enemy{
	private int speed=2;//�л����ٶ�
	
	public Airplane(){
		image =ShootGame.airplane;
		width=image.getWidth();
		height=image.getHeight();
		Random rand=new Random();
		x=rand.nextInt(ShootGame.WIDTH-this.width);//y:���ĵл���
		y=-this.height;//	y:���ĵл���
	}
	
	
	
	public int getScore(){ //��дgetS core����
		return 5;
	}
	
}
