package cn.itcast.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.itcast.entity.Visit;

public class VisitDaoImpl implements VisitDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

// 1. 添加Visit
	public void addVisit(Visit visit) {
		
		hibernateTemplate.save(visit);
		
	}

	//2. 查找所有
	public List<Visit> findAll() {
		// TODO Auto-generated method stub
		return (List<Visit>) hibernateTemplate.find("from Visit");
	}
	
}
