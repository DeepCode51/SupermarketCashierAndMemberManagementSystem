package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShangpinxinxiMapper;
import com.entity.Shangpinxinxi;
import com.server.ShangpinxinxiServer;
@Service
public class ShangpinxinxiServerImpi implements ShangpinxinxiServer {
   @Resource
   private ShangpinxinxiMapper gdao;
	@Override
	public int add(Shangpinxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shangpinxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shangpinxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shangpinxinxi> getsyshangpinxinxi1(Map<String, Object> map) {
		return gdao.getsyshangpinxinxi1(map);
	}
	public List<Shangpinxinxi> getsyshangpinxinxi2(Map<String, Object> map) {
		return gdao.getsyshangpinxinxi2(map);
	}
	public List<Shangpinxinxi> getsyshangpinxinxi3(Map<String, Object> map) {
		return gdao.getsyshangpinxinxi3(map);
	}
	
	@Override
	public Shangpinxinxi quchongShangpinxinxi(Map<String, Object> account) {
		return gdao.quchongShangpinxinxi(account);
	}

	@Override
	public List<Shangpinxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shangpinxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shangpinxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

