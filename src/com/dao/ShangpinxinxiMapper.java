package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shangpinxinxi;

public interface ShangpinxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shangpinxinxi record);

    int insertSelective(Shangpinxinxi record);

    Shangpinxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shangpinxinxi record);
	
    int updateByPrimaryKey(Shangpinxinxi record);
	public Shangpinxinxi quchongShangpinxinxi(Map<String, Object> shangpinbianhao);
	public List<Shangpinxinxi> getAll(Map<String, Object> map);
	public List<Shangpinxinxi> getsyshangpinxinxi1(Map<String, Object> map);
	public List<Shangpinxinxi> getsyshangpinxinxi3(Map<String, Object> map);
	public List<Shangpinxinxi> getsyshangpinxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shangpinxinxi> getByPage(Map<String, Object> map);
	public List<Shangpinxinxi> select(Map<String, Object> map);
//	所有List
}

