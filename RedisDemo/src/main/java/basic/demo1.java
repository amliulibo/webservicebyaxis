package basic;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class demo1 {

	public static void main(String[] args) {
		 
		Jedis jedis=new Jedis("localhost");
		System.out.println("����ɹ�");
		jedis.del("list1");
		//�洢���ݵ��б���
		jedis.lpush("list1", "����");
		jedis.lpush("list1", "����");
		jedis.lpush("list1", "����");
		
		jedis.set("key2", "value2");
		//��ȡ�洢�����ݲ����
		List<String> list= jedis.lrange("list1", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("�б���Ϊ��"+list.get(i));
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
		System.out.println("����ɹ�");
		jedis.del("list1");
		//�洢���ݵ��б���
		jedis.lpush("list1", "����");
		jedis.lpush("list1", "����");
		jedis.lpush("list1", "����");
		//��ȡ�洢�����ݲ����
		List<String> list= jedis.lrange("list1", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("�б���Ϊ��"+list.get(i));
		}
	}
	static void StringDemo()
	{
		// TODO Auto-generated method stub
				Jedis jedis=new Jedis("localhost");
				System.out.println("����ɹ�");
				//����redis�ַ���
				jedis.set("key1", "I am value1");
				System.out.println("��ȡkey1��ֵ��"+jedis.get("key1"));
	}
	
	static void ConnectionDemo()
	{
		// TODO Auto-generated method stub
				Jedis jedis=new Jedis("localhost");
				System.out.println("����ɹ�");
				//�鿴�����Ƿ�����
				System.out.println("�����������У�"+jedis.ping());
	}
	

}
