package cn.tedu.hotel.service;

import cn.tedu.hotel.entity.Offer;

public interface DetailsService {
	//根据roomStyle和bedStyle获取价格
	public Offer getPrice(Offer o);
}
