package singleletonone;

//饿汉式 线程安全  创建对象实例的时候就初始化
public class singleletononeclass {
	private singleletononeclass() {
	}

	// 创建类的私有静态实例
	private static singleletononeclass instance = new singleletononeclass();

	// 创建共有静态方法，返回静态实例对象
	public static singleletononeclass getinstance() {
		return instance;

	}

}
