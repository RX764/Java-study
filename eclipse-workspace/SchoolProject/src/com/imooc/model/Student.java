package com.imooc.model;

public class Student {
	// ѧ�������Ա�����רҵ
	private String studentNo;
	private String studentName;
	private String studentSex;
	private int studentAge;
	private Subject studenSubject;

	public Student() {
		super();
	}

	public Student(String studentNo, String studentName, String studentSex, int studentAge, Subject studentSubject) {
		super();
		this.setStudentAge(studentAge);
		this.setStudentName(studentName);
		this.setStudentNo(studentNo);
		this.setStudentSex(studentSex);
		this.setStudenSubject(studentSubject);

//		this.studentNo = studentNo;
//		this.studentName = studentName;
//		this.studentSex = studentSex;
//		this.studentAge = studentAge;
	}

	public Subject getStudenSubject() {
		if (studenSubject == null)
			this.studenSubject = new Subject();
		return studenSubject;
	}

	public void setStudenSubject(Subject studenSubject) {

		this.studenSubject = studenSubject;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		if (studentAge < 0 || studentAge > 110)
			return;
		this.studentAge = studentAge;
	}

//	public String introduction() {
//		String str = "������" + this.getStudentName() + "\tѧ�ţ�" + this.getStudentNo() + "\t �Ա�" + this.getStudentSex()
//				+ "\t���䣺" + this.getStudentAge();
//		return str;
//	}

	// ����1
	public String introduction() {
		String str = "������" + this.getStudentName() + "\tѧ�ţ�" + this.getStudentNo() + "\t �Ա�" + this.getStudentSex()
				+ "\t���䣺" + this.getStudentAge() + "\tרҵ����" + this.getStudenSubject().getSubjectName() + "\tѧ�ƣ���"
				+ this.getStudenSubject().getSubjectLife();
		return str;
	}

	// ����2
	public String introduction(Subject mysubkect) {
		String str = "������" + this.getStudentName() + "\tѧ�ţ�" + this.getStudentNo() + "\t �Ա�" + this.getStudentSex()
				+ "\t���䣺" + this.getStudentAge() + "\tרҵ����" + mysubkect.getSubjectName() + "\tѧ�ƣ���"
				+ mysubkect.getSubjectLife();
		return str;
	}

}
