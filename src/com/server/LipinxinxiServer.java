package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Lipinxinxi;

public interface LipinxinxiServer {

  public int add(Lipinxinxi po);

  public int update(Lipinxinxi po);
  
  
  
  public int delete(int id);

  public List<Lipinxinxi> getAll(Map<String,Object> map);
  public List<Lipinxinxi> getsylipinxinxi1(Map<String,Object> map);
  public List<Lipinxinxi> getsylipinxinxi2(Map<String,Object> map);
  public List<Lipinxinxi> getsylipinxinxi3(Map<String,Object> map);
  public Lipinxinxi quchongLipinxinxi(Map<String, Object> acount);

  public Lipinxinxi getById( int id);

  public List<Lipinxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Lipinxinxi> select(Map<String, Object> map);
}
//	所有List
