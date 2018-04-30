package com.tarena.shoot;

import java.util.Random;

//小蜜蜂
public class Bee extends FlyingObject implements Award{
//	蜜蜂斜着走
	private int xSpeed=1;//X坐标走一步
	private int ySpeed=2;//y坐标走二步
	private int awardType;
	public Bee(){
		image =ShootGame.bee;
		width=image.getWidth();
		height=image.getHeight();
		Random rand=new Random();
		x=rand.nextInt(ShootGame.WIDTH-this.width);//y:负的敌机宽
		y=-this.height;//	y:负的敌机高
		awardType=rand.nextInt(2);
	}
	public int getType(){
		return awardType;
		}
}
