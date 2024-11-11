package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Duihuanlipin;

public interface DuihuanlipinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Duihuanlipin record);

    int insertSelective(Duihuanlipin record);

    Duihuanlipin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Duihuanlipin record);
	
    int updateByPrimaryKey(Duihuanlipin record);
	public Duihuanlipin quchongDuihuanlipin(Map<String, Object> shoujihao);
	public List<Duihuanlipin> getAll(Map<String, Object> map);
	public List<Duihuanlipin> getsyduihuanlipin1(Map<String, Object> map);
	public List<Duihuanlipin> getsyduihuanlipin3(Map<String, Object> map);
	public List<Duihuanlipin> getsyduihuanlipin2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Duihuanlipin> getByPage(Map<String, Object> map);
	public List<Duihuanlipin> select(Map<String, Object> map);
//	所有List
}

