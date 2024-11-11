package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShangpinleibieMapper;
import com.entity.Shangpinleibie;
import com.server.ShangpinleibieServer;
@Service
public class ShangpinleibieServerImpi implements ShangpinleibieServer {
   @Resource
   private ShangpinleibieMapper gdao;
	@Override
	public int add(Shangpinleibie po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shangpinleibie po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shangpinleibie> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shangpinleibie> getsyshangpinleibie1(Map<String, Object> map) {
		return gdao.getsyshangpinleibie1(map);
	}
	public List<Shangpinleibie> getsyshangpinleibie2(Map<String, Object> map) {
		return gdao.getsyshangpinleibie2(map);
	}
	public List<Shangpinleibie> getsyshangpinleibie3(Map<String, Object> map) {
		return gdao.getsyshangpinleibie3(map);
	}
	
	@Override
	public Shangpinleibie quchongShangpinleibie(Map<String, Object> account) {
		return gdao.quchongShangpinleibie(account);
	}

	@Override
	public List<Shangpinleibie> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shangpinleibie> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shangpinleibie getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

