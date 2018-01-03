package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.util.List;

import edu.jyu.stumgm.entity.Elective;

public interface IElectiveDAO {
	public void save(Elective elective) ;

	public Elective get(Serializable id) ;
	
	public void update(Elective elective) ;

	public void delete(Elective elective);

	public void delete(String stuNumber);
	
	public List<Elective> findAll();
	
	/**
	 * 根据key进行模糊匹配查找
	 * @param key
	 * @return
	 */
	public List<Elective> findByKey(String key);

	public void deleteByids(List<String> ids);
}