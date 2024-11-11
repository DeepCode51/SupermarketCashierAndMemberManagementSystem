package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DuihuanlipinMapper;
import com.entity.Duihuanlipin;
import com.server.DuihuanlipinServer;
@Service
public class DuihuanlipinServerImpi implements DuihuanlipinServer {
   @Resource
   private DuihuanlipinMapper gdao;
	@Override
	public int add(Duihuanlipin po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Duihuanlipin po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Duihuanlipin> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Duihuanlipin> getsyduihuanlipin1(Map<String, Object> map) {
		return gdao.getsyduihuanlipin1(map);
	}
	public List<Duihuanlipin> getsyduihuanlipin2(Map<String, Object> map) {
		return gdao.getsyduihuanlipin2(map);
	}
	public List<Duihuanlipin> getsyduihuanlipin3(Map<String, Object> map) {
		return gdao.getsyduihuanlipin3(map);
	}
	
	@Override
	public Duihuanlipin quchongDuihuanlipin(Map<String, Object> account) {
		return gdao.quchongDuihuanlipin(account);
	}

	@Override
	public List<Duihuanlipin> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Duihuanlipin> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Duihuanlipin getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

