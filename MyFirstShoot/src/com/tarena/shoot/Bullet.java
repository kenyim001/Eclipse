package com.tarena.shoot;

import java.util.Random;

//子弹
public class Bullet extends FlyingObject  {
	private int speed=3;//子弹的迅速
	public Bullet(int x, int y){
	image =ShootGame.bullet;
	width=image.getWidth();
	height=image.getHeight();
	x=x;
	y=-y;

	}
}
