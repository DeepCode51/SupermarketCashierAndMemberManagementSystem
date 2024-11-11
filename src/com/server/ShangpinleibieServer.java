package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shangpinleibie;

public interface ShangpinleibieServer {

  public int add(Shangpinleibie po);

  public int update(Shangpinleibie po);
  
  
  
  public int delete(int id);

  public List<Shangpinleibie> getAll(Map<String,Object> map);
  public List<Shangpinleibie> getsyshangpinleibie1(Map<String,Object> map);
  public List<Shangpinleibie> getsyshangpinleibie2(Map<String,Object> map);
  public List<Shangpinleibie> getsyshangpinleibie3(Map<String,Object> map);
  public Shangpinleibie quchongShangpinleibie(Map<String, Object> acount);

  public Shangpinleibie getById( int id);

  public List<Shangpinleibie> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shangpinleibie> select(Map<String, Object> map);
}
//	所有List
