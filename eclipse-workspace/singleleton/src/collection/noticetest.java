package collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class noticetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		notice no1 = new notice(1, "�ҵ����ˣ���������", "����", new Date());
		notice no2 = new notice(2, "���壬չ�᰿��", "����", new Date());
		notice no3 = new notice(3, "���Ʒ���Ա�������ս��", "����", new Date());
		notice no4 = new notice(4, "����֮����ݲ���", "������", new Date());
		notice no5 = new notice(5, "��ʱ����������ļ�����", "�������", new Date());
		List notiList = new ArrayList();
		notiList.add(no1);
		notiList.add(no2);
		notiList.add(no3);
		System.out.println("�������ݣ�");
		for (int i = 0; i < notiList.size(); i++) {
			System.out.println((i + 1) + "  " + ((notice) notiList.get(i)).getTitl());
		}
		System.out.println("===============================");
		notiList.add(0, no4);
		notiList.remove(0);

		System.out.println("�������ݣ�");
		for (int i = 0; i < notiList.size(); i++) {
			System.out.println((i + 1) + "  " + ((notice) notiList.get(i)).getTitl());
		}
	}

}
