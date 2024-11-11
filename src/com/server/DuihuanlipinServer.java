package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Duihuanlipin;

public interface DuihuanlipinServer {

  public int add(Duihuanlipin po);

  public int update(Duihuanlipin po);
  
  
  
  public int delete(int id);

  public List<Duihuanlipin> getAll(Map<String,Object> map);
  public List<Duihuanlipin> getsyduihuanlipin1(Map<String,Object> map);
  public List<Duihuanlipin> getsyduihuanlipin2(Map<String,Object> map);
  public List<Duihuanlipin> getsyduihuanlipin3(Map<String,Object> map);
  public Duihuanlipin quchongDuihuanlipin(Map<String, Object> acount);

  public Duihuanlipin getById( int id);

  public List<Duihuanlipin> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Duihuanlipin> select(Map<String, Object> map);
}
//	所有List
