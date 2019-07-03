package com;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 商品mybatis测试类
 * @author Administrator
 * @date 
 */

public class TestMyBatis {

	public static void main(String[] args) throws SQLException, IOException{
		String resource = "configuration.xml";
		//加载配置文件
		Reader reader = Resources.getResourceAsReader(resource);
		//根据read获取SqlSessionFactory 对象
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//根据SqlSessionFactory获取SqlSession对象
		SqlSession session = sessionFactory.openSession();
		try{
			//通过session调用接口
			GoodsMapper mapper = session.getMapper(GoodsMapper.class);
			Goods goods = mapper.selectGoods(1);//注解 sql
			System.out.println(goods.getName());
			//Goods goods = mapper.selectGood(1);//配置文件 sql
			/*Goods goods = (Goods)
					session.selectOne("com.GoodsMapper.selectGood",1);
			System.out.println("good name:"+goods.getName()+"orderOrd:"+goods.getOrderNo()+"time:"+goods.getUpdateTime());*/
		}finally{
			//关闭session
			session.close();
		}
	
	}
}
