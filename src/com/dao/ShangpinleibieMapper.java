package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shangpinleibie;

public interface ShangpinleibieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shangpinleibie record);

    int insertSelective(Shangpinleibie record);

    Shangpinleibie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shangpinleibie record);
	
    int updateByPrimaryKey(Shangpinleibie record);
	public Shangpinleibie quchongShangpinleibie(Map<String, Object> leibie);
	public List<Shangpinleibie> getAll(Map<String, Object> map);
	public List<Shangpinleibie> getsyshangpinleibie1(Map<String, Object> map);
	public List<Shangpinleibie> getsyshangpinleibie3(Map<String, Object> map);
	public List<Shangpinleibie> getsyshangpinleibie2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shangpinleibie> getByPage(Map<String, Object> map);
	public List<Shangpinleibie> select(Map<String, Object> map);
//	所有List
}

