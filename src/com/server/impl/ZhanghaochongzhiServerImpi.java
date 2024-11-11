package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZhanghaochongzhiMapper;
import com.entity.Zhanghaochongzhi;
import com.server.ZhanghaochongzhiServer;
@Service
public class ZhanghaochongzhiServerImpi implements ZhanghaochongzhiServer {
   @Resource
   private ZhanghaochongzhiMapper gdao;
	@Override
	public int add(Zhanghaochongzhi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhanghaochongzhi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhanghaochongzhi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhanghaochongzhi> getsyzhanghaochongzhi1(Map<String, Object> map) {
		return gdao.getsyzhanghaochongzhi1(map);
	}
	public List<Zhanghaochongzhi> getsyzhanghaochongzhi2(Map<String, Object> map) {
		return gdao.getsyzhanghaochongzhi2(map);
	}
	public List<Zhanghaochongzhi> getsyzhanghaochongzhi3(Map<String, Object> map) {
		return gdao.getsyzhanghaochongzhi3(map);
	}
	
	@Override
	public Zhanghaochongzhi quchongZhanghaochongzhi(Map<String, Object> account) {
		return gdao.quchongZhanghaochongzhi(account);
	}

	@Override
	public List<Zhanghaochongzhi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhanghaochongzhi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhanghaochongzhi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

