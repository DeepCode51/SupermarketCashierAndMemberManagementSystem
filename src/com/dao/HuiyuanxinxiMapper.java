package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Huiyuanxinxi;

public interface HuiyuanxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huiyuanxinxi record);

    int insertSelective(Huiyuanxinxi record);

    Huiyuanxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huiyuanxinxi record);
	
    int updateByPrimaryKey(Huiyuanxinxi record);
	public Huiyuanxinxi quchongHuiyuanxinxi(Map<String, Object> shoujihao);
	public List<Huiyuanxinxi> getAll(Map<String, Object> map);
	public List<Huiyuanxinxi> getsyhuiyuanxinxi1(Map<String, Object> map);
	public List<Huiyuanxinxi> getsyhuiyuanxinxi3(Map<String, Object> map);
	public List<Huiyuanxinxi> getsyhuiyuanxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Huiyuanxinxi> getByPage(Map<String, Object> map);
	public List<Huiyuanxinxi> select(Map<String, Object> map);
//	所有List
}

