package com.imoom.test;

import com.imooc.model.Student;
import com.imooc.model.Subject;

public class SchoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject sub1 = new Subject();
		Subject sub2 = new Subject("�����", "J1000", 4);
		System.out.println(sub1.info());
		System.out.println(sub2.info());
		System.out.println("===============================================");
		Student stu2 = new Student("S1001", "Nick1", "��", 18, sub2);
		Student stu3 = new Student("S1002", "Nick2", "��", 18, sub2);
		Student stu4 = new Student("S1003", "Nick3", "��", 18, sub2);
		Student stu5 = new Student("S1004", "Nick4", "��", 18, sub2);
		sub2.addstudent(stu2);
		sub2.addstudent(stu3);
		System.out.println("ѡ�������� " + sub2.getStudentNum());
	}

}
