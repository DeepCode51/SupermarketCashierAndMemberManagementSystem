package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HuiyuanxinxiMapper;
import com.entity.Huiyuanxinxi;
import com.server.HuiyuanxinxiServer;
@Service
public class HuiyuanxinxiServerImpi implements HuiyuanxinxiServer {
   @Resource
   private HuiyuanxinxiMapper gdao;
	@Override
	public int add(Huiyuanxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Huiyuanxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Huiyuanxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Huiyuanxinxi> getsyhuiyuanxinxi1(Map<String, Object> map) {
		return gdao.getsyhuiyuanxinxi1(map);
	}
	public List<Huiyuanxinxi> getsyhuiyuanxinxi2(Map<String, Object> map) {
		return gdao.getsyhuiyuanxinxi2(map);
	}
	public List<Huiyuanxinxi> getsyhuiyuanxinxi3(Map<String, Object> map) {
		return gdao.getsyhuiyuanxinxi3(map);
	}
	
	@Override
	public Huiyuanxinxi quchongHuiyuanxinxi(Map<String, Object> account) {
		return gdao.quchongHuiyuanxinxi(account);
	}

	@Override
	public List<Huiyuanxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Huiyuanxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Huiyuanxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

