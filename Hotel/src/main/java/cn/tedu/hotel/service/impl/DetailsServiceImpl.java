package cn.tedu.hotel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.hotel.dao.DetailsDAO;
import cn.tedu.hotel.entity.Offer;
import cn.tedu.hotel.service.DetailsService;

@Service("detailsService")
public class DetailsServiceImpl implements DetailsService{
	@Resource(name="detailsDAO")
	private DetailsDAO detailsDAO;
	public Offer getPrice(Offer o) {
		Offer offer=detailsDAO.getPrice(o);
		return offer;
	}

}
