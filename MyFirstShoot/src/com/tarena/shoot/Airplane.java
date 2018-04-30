package com.tarena.shoot;

import java.util.Random;

//敌机: 
public class Airplane extends FlyingObject implements Enemy{
	private int speed=2;//敌机的速度
	
	public Airplane(){
		image =ShootGame.airplane;
		width=image.getWidth();
		height=image.getHeight();
		Random rand=new Random();
		x=rand.nextInt(ShootGame.WIDTH-this.width);//y:负的敌机宽
		y=-this.height;//	y:负的敌机高
	}
	
	
	
	public int getScore(){ //重写getS core（）
		return 5;
	}
	
}
