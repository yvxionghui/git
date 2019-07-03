package com.art;

import java.util.List;

import com.art.util.Page;

/**
 * �û��ӿ���
 * @author Administrator
 * @date 
 */
public interface IUserOperation {
	/**
	 * �����û�id��ѯ�û���Ϣ
	 * @param id
	 * @return
	 */
	public User selectUserByID(int id);
	/**
	 * �����û�����ѯ�û���Ϣ
	 * @param userName
	 * @return
	 */
	public List<User> selectUsersByName(String userName);
	
	/**
	 * ����û�
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * �޸��û�
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * �����û�idɾ���û�
	 * @param id
	 */
	public void deleteUser(int id);
	

}

