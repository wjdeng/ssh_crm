package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;

public class LinkManDaoImpl implements LinkManDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void add(LinkMan linkMan) {
		
		hibernateTemplate.save(linkMan);
		
	}

	@Override
	public List<LinkMan> findAll() {
		// TODO Auto-generated method stub
		return (List<LinkMan>) hibernateTemplate.find("from LinkMan");
	}

	@Override
	public LinkMan findOne(int linkid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(LinkMan.class, linkid);
	}

	@Override
	public void updateLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.update(linkMan);
	}

	@Override
	public void delete(LinkMan linkMan) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(linkMan);
	}

	//多条件查询
	public List<LinkMan> findMoreCondition(LinkMan linkMan) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		
		if(linkMan.getCustomer().getCid()!=null && linkMan.getCustomer().getCid()>0){
			detachedCriteria.add(Restrictions.eq("customer.cid", linkMan.getCustomer().getCid()));
		}
		if(linkMan.getLkmName()!=null && !"".equals(linkMan.getLkmName())){
			detachedCriteria.add(Restrictions.eq("lkmName", linkMan.getLkmName()));
		}		
		List<LinkMan> list = (List<LinkMan>) hibernateTemplate.findByCriteria(detachedCriteria);
		return list;
	}
	
}
