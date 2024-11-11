package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Goumaijiezhang;

public interface GoumaijiezhangServer {

  public int add(Goumaijiezhang po);

  public int update(Goumaijiezhang po);
  
  
  
  public int delete(int id);

  public List<Goumaijiezhang> getAll(Map<String,Object> map);
  public List<Goumaijiezhang> getsygoumaijiezhang1(Map<String,Object> map);
  public List<Goumaijiezhang> getsygoumaijiezhang2(Map<String,Object> map);
  public List<Goumaijiezhang> getsygoumaijiezhang3(Map<String,Object> map);
  public Goumaijiezhang quchongGoumaijiezhang(Map<String, Object> acount);

  public Goumaijiezhang getById( int id);

  public List<Goumaijiezhang> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Goumaijiezhang> select(Map<String, Object> map);
}
//	所有List
