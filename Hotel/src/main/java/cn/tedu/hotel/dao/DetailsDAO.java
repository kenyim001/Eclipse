package cn.tedu.hotel.dao;

import cn.tedu.hotel.entity.Offer;

public interface DetailsDAO {
	//根据roomStyle和bedStyle获取价格
	public Offer getPrice(Offer o);
	
}
