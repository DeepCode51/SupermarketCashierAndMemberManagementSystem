package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shangpinxinxi;

public interface ShangpinxinxiServer {

  public int add(Shangpinxinxi po);

  public int update(Shangpinxinxi po);
  
  
  
  public int delete(int id);

  public List<Shangpinxinxi> getAll(Map<String,Object> map);
  public List<Shangpinxinxi> getsyshangpinxinxi1(Map<String,Object> map);
  public List<Shangpinxinxi> getsyshangpinxinxi2(Map<String,Object> map);
  public List<Shangpinxinxi> getsyshangpinxinxi3(Map<String,Object> map);
  public Shangpinxinxi quchongShangpinxinxi(Map<String, Object> acount);

  public Shangpinxinxi getById( int id);

  public List<Shangpinxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shangpinxinxi> select(Map<String, Object> map);
}
//	所有List
