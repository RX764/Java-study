package com.imooc.model;

public class Subject {
	// 学科名称，编号，学制年限
	private String subjectName;
	private String subjectNo;
	private int subjectLife;
	private Student muStudent[];
	private int studentNum;

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public Subject(String subjectName, String subjectNo, int subjectLife) {
		this.setSubjectLife(subjectLife);
		this.setSubjectName(subjectName);
		this.setSubjectNo(subjectNo);
	}

	public Subject(String subjectName, String subjectNo, int subjectLife, Student[] muStudent) {
		super();
		this.subjectName = subjectName;
		this.subjectNo = subjectNo;
		this.subjectLife = subjectLife;
		this.muStudent = muStudent;
	}

	public Subject() {
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectNo() {
		return subjectNo;
	}

	public void setSubjectNo(String subjectNo) {
		this.subjectNo = subjectNo;
	}

	public int getSubjectLife() {
		return subjectLife;
	}

	public void setSubjectLife(int subjectLife) {
		if (subjectLife <= 0)
			return;
		this.subjectLife = subjectLife;
	}

	public String info() {
		String str = "学制：" + this.subjectLife + "\t课程名：" + this.subjectName + "\t 编号：" + this.subjectNo;
		return str;
	}

	public Student[] getMuStudent() {
		if (this.muStudent == null)
			this.muStudent = new Student[1000];
		return muStudent;
	}

	public void setMuStudent(Student[] muStudent) {
		this.muStudent = muStudent;
	}

	public void addstudent(Student stu) {
		for (int i = 0; i < getMuStudent().length; i++) {
			if (this.getMuStudent()[i] == null) {
				this.getMuStudent()[i] = stu;
				this.studentNum = i + 1;
				return;
			}
		}
	}

}
