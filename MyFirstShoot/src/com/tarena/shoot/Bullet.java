package com.tarena.shoot;

import java.util.Random;

//�ӵ�
public class Bullet extends FlyingObject  {
	private int speed=3;//�ӵ���Ѹ��
	public Bullet(int x, int y){
	image =ShootGame.bullet;
	width=image.getWidth();
	height=image.getHeight();
	x=x;
	y=-y;

	}
}
