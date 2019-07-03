package com;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

/**
 * 商品接口
 * @author Administrator
 * @date 
 */
public interface GoodsMapper {
	/**
	 * sql注解形式接口
	 * 根据商品id获取商品信息
	 * @param id
	 * @return
	 */
	 @Select("SELECT id,name,order_no AS orderNo,updateTime FROM goods WHERE id = #{id}")
	 public Goods selectGoods(int id); 
	 
	 
	 /**
	  * sql配置文件形式接口
	  * 根据商品id获取商品信息
	  * @param id
	  * @return
	  */
	 public Goods selectGood(int id); 
}
