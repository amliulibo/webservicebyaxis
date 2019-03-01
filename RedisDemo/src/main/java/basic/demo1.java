package basic;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class demo1 {

	public static void main(String[] args) {
		 
		Jedis jedis=new Jedis("localhost");
		System.out.println("连结成功");
		jedis.del("list1");
		//存储数据到列表中
		jedis.lpush("list1", "张三");
		jedis.lpush("list1", "李四");
		jedis.lpush("list1", "王五");
		
		jedis.set("key2", "value2");
		//获取存储的数据并输出
		List<String> list= jedis.lrange("list1", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("列表项为："+list.get(i));
		}
		
		Set<String> keys=jedis.keys("*");
		Iterator<String> iterator=keys.iterator();
		while(iterator.hasNext())
		{
			String key=iterator.next();
			System.out.println(key);
		}
		

	}
	
	static void ListDemo()
	{
		Jedis jedis=new Jedis("localhost");
		System.out.println("连结成功");
		jedis.del("list1");
		//存储数据到列表中
		jedis.lpush("list1", "张三");
		jedis.lpush("list1", "李四");
		jedis.lpush("list1", "王五");
		//获取存储的数据并输出
		List<String> list= jedis.lrange("list1", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("列表项为："+list.get(i));
		}
	}
	static void StringDemo()
	{
		// TODO Auto-generated method stub
				Jedis jedis=new Jedis("localhost");
				System.out.println("连结成功");
				//设置redis字符串
				jedis.set("key1", "I am value1");
				System.out.println("获取key1的值："+jedis.get("key1"));
	}
	
	static void ConnectionDemo()
	{
		// TODO Auto-generated method stub
				Jedis jedis=new Jedis("localhost");
				System.out.println("连结成功");
				//查看服务是否运行
				System.out.println("服务正在运行："+jedis.ping());
	}
	

}
