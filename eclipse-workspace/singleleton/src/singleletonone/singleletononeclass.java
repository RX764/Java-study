package singleletonone;

//����ʽ �̰߳�ȫ  ��������ʵ����ʱ��ͳ�ʼ��
public class singleletononeclass {
	private singleletononeclass() {
	}

	// �������˽�о�̬ʵ��
	private static singleletononeclass instance = new singleletononeclass();

	// �������о�̬���������ؾ�̬ʵ������
	public static singleletononeclass getinstance() {
		return instance;

	}

}
