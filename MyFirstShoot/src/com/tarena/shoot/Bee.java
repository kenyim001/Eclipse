package com.tarena.shoot;

import java.util.Random;

//С�۷�
public class Bee extends FlyingObject implements Award{
//	�۷�б����
	private int xSpeed=1;//X������һ��
	private int ySpeed=2;//y�����߶���
	private int awardType;
	public Bee(){
		image =ShootGame.bee;
		width=image.getWidth();
		height=image.getHeight();
		Random rand=new Random();
		x=rand.nextInt(ShootGame.WIDTH-this.width);//y:���ĵл���
		y=-this.height;//	y:���ĵл���
		awardType=rand.nextInt(2);
	}
	public int getType(){
		return awardType;
		}
}
