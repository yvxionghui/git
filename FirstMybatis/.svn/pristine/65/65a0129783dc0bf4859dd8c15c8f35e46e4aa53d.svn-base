package com.art;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.art.util.Page;

/**
 * 文章、用户、博客测试类
 * @author Administrator
 * @date
 */
public class Test {
	
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	//静态代码块 在 类第一次被调用或实例化的时候会执行, 静态代码块只会执行一次，一般用来初始化一些值，并且在所有对象中全局共享
	static {
		System.out.println("static............");
		try {
			//通过配置文件初始化sqlSessionFactory
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Test() {
		System.out.println("test()............");
	}
	/**
	 * 所有对象共享一个sqlSessionFactory
	 * @return
	 */
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
     /**
      * 根据用户id查询用户信息
      * @param userID
      */
	public void getUserByID(int userID) {
		//获取sqlSessionFactory
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(userID);
			if (user != null) {
				System.out.println(user.getId() + ":" + user.getUserName()
						+ ":" + user.getUserAddress());
			}

		} finally {//一定不要忘记close
			session.close();
		}
	}
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 */
	public void getUserList(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			List<User> users = userOperation.selectUsersByName(userName);
			for (User user : users) {
				System.out.println(user.getId() + ":" + user.getUserName()
						+ ":" + user.getUserAddress());
			}

		} finally {
			session.close();
		}
	}

	/**
	 * 添加用户
	 */
	public void addUser() {
		User user = new User();
		user.setUserAddress("place");
		user.setUserName("test_add");
		user.setUserAge(30);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			userOperation.addUser(user);
			//不要忘记commit，否则数据无法保存到数据库中
			session.commit();
			System.out.println("新增用户ID：" + user.getId());
		} finally {
			session.close();
		}
	}

	/**
	 * 修改用户
	 */
	public void updateUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(18);
			if (user != null) {
				user.setUserAddress("A new place");
				userOperation.updateUser(user);
				session.commit();
			}
		} finally {
			session.close();
		}
	}

	/**
	 * 根据用户id,删除用户
	 * @param id
	 */
	public void deleteUser(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			userOperation.deleteUser(id);
			session.commit();
		} finally {
			session.close();
		}
	}
	/**
	 * 根据用户id查询用户发表过的文章
	 * @param userid
	 */
	public void getUserArticles(int userid) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IArticleOperation articleOperation = session
					.getMapper(IArticleOperation.class);
			List<Article> articles = articleOperation.getUserArticles(userid);
			//循环遍历打印出文章信息
			for (Article article : articles) {
				System.out.println(article.getId()+":"+article.getTitle() + ":"
						+ article.getContent() +  article.getUser().getId()+":"+"用户名："
						+ article.getUser().getUserName() + "用户地址："
						+ article.getUser().getUserAddress());
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	/**
	 * 根据博客id，查询该博客下所有的文章及作者信息
	 * @param blogid
	 */
	public void getBlogArticles(int blogid) {
		System.out.println(blogid+"...............");
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IBlogOperation blogOperation = session
					.getMapper(IBlogOperation.class);
			Blog blog = blogOperation.getBlogByID(blogid);
			System.out.println(blog.getTitle() + ":");
			//获取文章集合
			List<Article> articles = blog.getArticles();
			//循环遍历打印出文章及作者信息
			for (Article article : articles) {
				System.out.println(article.getTitle() + ":"
						+ article.getContent() + "用户名："
						+ article.getUser().getUserName() + "用户地址："
						+ article.getUser().getUserAddress());
			}
		} finally {
			session.close();
		}
	}

	/**
	 * 用户分页测试
	 * @param pageIndex 当前页码
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getUserPage(int pageIndex) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Integer count=(Integer)session.selectOne("com.art.IUserOperation.getUserCount");
			Page page =new Page();
			page.setPageIndex(pageIndex);//当前页
			page.setRecord(count); //总记录数  
			HashMap parMap=new HashMap(); 
			parMap.put("stratRow",page.getSartRow());  
			parMap.put("endRow",page.getEndRow());  
			List<User> list=(List)session.selectList("com.art.IUserOperation.getUserPage", parMap);
			page.setResultList(list);
			for (User user : (List<User>)page.getResultList()) {
				System.out.println(user.getId() + ":" + user.getUserName()
						+ ":" + user.getUserAddress());
			}
			 System.out.println(list.toString());
			 System.out.println(count);
			 
			    System.out.println("当前页是："+page.getPageIndex());  
		        System.out.println("下一页是："+page.getNextPage());  
		        System.out.println("上一页是："+page.getPrePage());  
		        System.out.println("总记录数："+page.getRecord());  
		        System.out.println("总页数是："+page.getTotalPageCount());  
		        System.out.println("页大小是："+page.getPageSize());  
		        
		} finally {
			session.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			Test test = new Test();
			
			// test.getUserByID(17);	//根据用户id查询用户信息
			
			// test.getUserList("liuguang"); //根据用户名查询
			
			// test.addUser(); //添加用户
			
			// test.updateUser(); //修改用户
			
			// test.deleteUser(18); //删除用户
			
			//test.getUserArticles(16); //根据用户id查询用户发表过的文章

			test.getBlogArticles(1);  //根据博客id查询博客下所有文章及文章作者信息
			
			//test.getUserPage(1);//	分页测试
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
