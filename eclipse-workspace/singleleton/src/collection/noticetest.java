package collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class noticetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		notice no1 = new notice(1, "我的命运，由我做主", "娜美", new Date());
		notice no2 = new notice(2, "正义，展翅翱翔", "奎因", new Date());
		notice no3 = new notice(3, "王牌飞行员，申请出战！", "库奇", new Date());
		notice no4 = new notice(4, "所到之处寸草不生", "奥拉夫", new Date());
		notice no5 = new notice(5, "是时候表演真正的技术了", "伊泽瑞尔", new Date());
		List notiList = new ArrayList();
		notiList.add(no1);
		notiList.add(no2);
		notiList.add(no3);
		System.out.println("公告内容：");
		for (int i = 0; i < notiList.size(); i++) {
			System.out.println((i + 1) + "  " + ((notice) notiList.get(i)).getTitl());
		}
		System.out.println("===============================");
		notiList.add(0, no4);
		notiList.remove(0);

		System.out.println("公告内容：");
		for (int i = 0; i < notiList.size(); i++) {
			System.out.println((i + 1) + "  " + ((notice) notiList.get(i)).getTitl());
		}
	}

}
