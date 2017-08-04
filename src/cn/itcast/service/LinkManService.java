package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.LinkManDao;
import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;

@Transactional
public class LinkManService {

	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	public void addLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.add(linkMan);
	}

	public List<LinkMan> findAll() {
		// TODO Auto-generated method stub
		return linkManDao.findAll();
	}

	public LinkMan findOne(int linkid) {
		// TODO Auto-generated method stub
		return linkManDao.findOne(linkid);
	}

	public void updateLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		
		linkManDao.updateLinkMan(linkMan);
	}

	public void deleteLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.delete(linkMan);
	}

	public List<LinkMan> findMoreCondition(LinkMan linkMan) {
		// TODO Auto-generated method stub
		return linkManDao.findMoreCondition(linkMan);
	}
	
}
