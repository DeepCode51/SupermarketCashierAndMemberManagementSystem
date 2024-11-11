package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Huiyuanxinxi;

public interface HuiyuanxinxiServer {

  public int add(Huiyuanxinxi po);

  public int update(Huiyuanxinxi po);
  
  
  
  public int delete(int id);

  public List<Huiyuanxinxi> getAll(Map<String,Object> map);
  public List<Huiyuanxinxi> getsyhuiyuanxinxi1(Map<String,Object> map);
  public List<Huiyuanxinxi> getsyhuiyuanxinxi2(Map<String,Object> map);
  public List<Huiyuanxinxi> getsyhuiyuanxinxi3(Map<String,Object> map);
  public Huiyuanxinxi quchongHuiyuanxinxi(Map<String, Object> acount);

  public Huiyuanxinxi getById( int id);

  public List<Huiyuanxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Huiyuanxinxi> select(Map<String, Object> map);
}
//	所有List
