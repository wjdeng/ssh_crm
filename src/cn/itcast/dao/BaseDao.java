package cn.itcast.dao;

import java.util.List;

public interface BaseDao<T> {

	void add(T t);
	
	void update(T t);
	
	void delete(T t);
	
	T get(int id);
	
	List<T> findAll();
	
	
}
