package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;

public interface LinkManDao {

	void add(LinkMan linkMan);

	List<LinkMan> findAll();

	LinkMan findOne(int linkid);

	void updateLinkMan(LinkMan linkMan);

	void delete(LinkMan linkMan);

	List<LinkMan> findMoreCondition(LinkMan linkMan);

}
