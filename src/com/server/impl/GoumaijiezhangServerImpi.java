package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GoumaijiezhangMapper;
import com.entity.Goumaijiezhang;
import com.server.GoumaijiezhangServer;
@Service
public class GoumaijiezhangServerImpi implements GoumaijiezhangServer {
   @Resource
   private GoumaijiezhangMapper gdao;
	@Override
	public int add(Goumaijiezhang po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Goumaijiezhang po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Goumaijiezhang> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Goumaijiezhang> getsygoumaijiezhang1(Map<String, Object> map) {
		return gdao.getsygoumaijiezhang1(map);
	}
	public List<Goumaijiezhang> getsygoumaijiezhang2(Map<String, Object> map) {
		return gdao.getsygoumaijiezhang2(map);
	}
	public List<Goumaijiezhang> getsygoumaijiezhang3(Map<String, Object> map) {
		return gdao.getsygoumaijiezhang3(map);
	}
	
	@Override
	public Goumaijiezhang quchongGoumaijiezhang(Map<String, Object> account) {
		return gdao.quchongGoumaijiezhang(account);
	}

	@Override
	public List<Goumaijiezhang> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Goumaijiezhang> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Goumaijiezhang getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

