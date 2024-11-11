package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Lipinxinxi;

public interface LipinxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lipinxinxi record);

    int insertSelective(Lipinxinxi record);

    Lipinxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lipinxinxi record);
	
    int updateByPrimaryKey(Lipinxinxi record);
	public Lipinxinxi quchongLipinxinxi(Map<String, Object> lipinbianhao);
	public List<Lipinxinxi> getAll(Map<String, Object> map);
	public List<Lipinxinxi> getsylipinxinxi1(Map<String, Object> map);
	public List<Lipinxinxi> getsylipinxinxi3(Map<String, Object> map);
	public List<Lipinxinxi> getsylipinxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Lipinxinxi> getByPage(Map<String, Object> map);
	public List<Lipinxinxi> select(Map<String, Object> map);
//	所有List
}

