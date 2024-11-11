package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zhanghaochongzhi;

public interface ZhanghaochongzhiServer {

  public int add(Zhanghaochongzhi po);

  public int update(Zhanghaochongzhi po);
  
  
  
  public int delete(int id);

  public List<Zhanghaochongzhi> getAll(Map<String,Object> map);
  public List<Zhanghaochongzhi> getsyzhanghaochongzhi1(Map<String,Object> map);
  public List<Zhanghaochongzhi> getsyzhanghaochongzhi2(Map<String,Object> map);
  public List<Zhanghaochongzhi> getsyzhanghaochongzhi3(Map<String,Object> map);
  public Zhanghaochongzhi quchongZhanghaochongzhi(Map<String, Object> acount);

  public Zhanghaochongzhi getById( int id);

  public List<Zhanghaochongzhi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zhanghaochongzhi> select(Map<String, Object> map);
}
//	所有List
