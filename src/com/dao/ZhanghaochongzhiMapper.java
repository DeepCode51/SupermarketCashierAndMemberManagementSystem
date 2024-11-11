package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zhanghaochongzhi;

public interface ZhanghaochongzhiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhanghaochongzhi record);

    int insertSelective(Zhanghaochongzhi record);

    Zhanghaochongzhi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhanghaochongzhi record);
	
    int updateByPrimaryKey(Zhanghaochongzhi record);
	public Zhanghaochongzhi quchongZhanghaochongzhi(Map<String, Object> shoujihao);
	public List<Zhanghaochongzhi> getAll(Map<String, Object> map);
	public List<Zhanghaochongzhi> getsyzhanghaochongzhi1(Map<String, Object> map);
	public List<Zhanghaochongzhi> getsyzhanghaochongzhi3(Map<String, Object> map);
	public List<Zhanghaochongzhi> getsyzhanghaochongzhi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhanghaochongzhi> getByPage(Map<String, Object> map);
	public List<Zhanghaochongzhi> select(Map<String, Object> map);
//	所有List
}

