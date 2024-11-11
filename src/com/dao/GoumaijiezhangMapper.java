package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Goumaijiezhang;

public interface GoumaijiezhangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goumaijiezhang record);

    int insertSelective(Goumaijiezhang record);

    Goumaijiezhang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goumaijiezhang record);
	
    int updateByPrimaryKey(Goumaijiezhang record);
	public Goumaijiezhang quchongGoumaijiezhang(Map<String, Object> shoujihao);
	public List<Goumaijiezhang> getAll(Map<String, Object> map);
	public List<Goumaijiezhang> getsygoumaijiezhang1(Map<String, Object> map);
	public List<Goumaijiezhang> getsygoumaijiezhang3(Map<String, Object> map);
	public List<Goumaijiezhang> getsygoumaijiezhang2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Goumaijiezhang> getByPage(Map<String, Object> map);
	public List<Goumaijiezhang> select(Map<String, Object> map);
//	所有List
}

