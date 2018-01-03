package edu.jyu.stumgm.entity;

import java.util.HashSet;
import java.util.Set;

public class Elective {
	private String id;
	private String name; //选修课名称
	private String teacherName; //任课老师
	private String credit;	//学分
	private Set<Student> students=new HashSet<Student>(); //已选学生
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Elective [id=" + id + ", name=" + name + ", teacherName=" + teacherName + ", credit=" + credit
				+ ", students=" + students + "]";
	}
	
	
}
