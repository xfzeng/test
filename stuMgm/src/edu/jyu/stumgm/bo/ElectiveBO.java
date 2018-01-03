package edu.jyu.stumgm.bo;

import java.util.Calendar;
import java.util.List;

import edu.jyu.stumgm.dao.IElectiveDAO;
import edu.jyu.stumgm.entity.Elective;

public class ElectiveBO {
	private IElectiveDAO electiveDAO;

	public void setElectiveDAO(IElectiveDAO electiveDAO) {
		this.electiveDAO = electiveDAO;
	}

	/**
	 * 新加一条记录Elective
	 * 
	 * @param Elective
	 * @throws Exception
	 */
	public void addElective(Elective elective) {
		electiveDAO.save(elective);
	}

	/**
	 * 修改已建立的记录
	 * 
	 * @param Elective
	 *            
	 */
	public void updateElective(Elective elective) {
		electiveDAO.update(elective);
	}

	/**
	 * 得到所有的Elective列表
	 * @return @
	 */
	public List<Elective> getAllElectives() {
		return electiveDAO.findAll();

	}

	/**
	 * 根据学号得到学生姓名
	 * 
	 * @param stuNumber
	 * @return @
	 */
	/*public String getUserNameByID(String stuNumber) {
		Elective stu = electiveDAO.get(stuNumber);
		if (stu != null) {
			return stu.getUsername();
		}
		return null;
	}*/
	/**
	 * 按指定的条件搜索Elective列表
	 * 
	 * @param searchkey
	 * @return @
	 */
	public List<Elective> getSearchElectives(String searchkey) {
		return electiveDAO.findByKey(searchkey);
	}

	/**
	 * 按学号取到学生信息
	 * 
	 * @param stuid
	 * @return @
	 */
	public Elective getElectiveByNumber(String stuNumber) {
		System.out.println("getElectiveByNumber " + stuNumber);
		return electiveDAO.get(stuNumber);
	}

	/**
	 * 删除Elective
	 * @param STUID
	 */
	public void deleteElective(String stuNumber) {
		electiveDAO.delete(stuNumber);
	}
	
	public void deleteElectivesByNumber(List<String> numbers){
		electiveDAO.deleteByids(numbers);
	}

	/**
	 * 生成STUID，前四位是年份，后六位是随机数
	 * @return @
	 */
	public String generateStuNumber() {
		Calendar calendar = Calendar.getInstance();
		String id = "";
		int done = 1;
		while (done == 1) {
			id = "";
			id += calendar.get(Calendar.YEAR);
			double rand = Math.random() * 900000;
			long stuID = (long) (rand) + 100000;
			id += stuID;

			if (!isExistStuNumber(id)) {
				done = 0;
			}
		}
		return id;

	}

	/**
	 *判断学号是否存在
	 */
	private boolean isExistStuNumber(String id) {
		return electiveDAO.get(id) != null;
	}
}