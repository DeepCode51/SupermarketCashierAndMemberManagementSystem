package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.LipinxinxiMapper;
import com.entity.Lipinxinxi;
import com.server.LipinxinxiServer;
@Service
public class LipinxinxiServerImpi implements LipinxinxiServer {
   @Resource
   private LipinxinxiMapper gdao;
	@Override
	public int add(Lipinxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Lipinxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Lipinxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Lipinxinxi> getsylipinxinxi1(Map<String, Object> map) {
		return gdao.getsylipinxinxi1(map);
	}
	public List<Lipinxinxi> getsylipinxinxi2(Map<String, Object> map) {
		return gdao.getsylipinxinxi2(map);
	}
	public List<Lipinxinxi> getsylipinxinxi3(Map<String, Object> map) {
		return gdao.getsylipinxinxi3(map);
	}
	
	@Override
	public Lipinxinxi quchongLipinxinxi(Map<String, Object> account) {
		return gdao.quchongLipinxinxi(account);
	}

	@Override
	public List<Lipinxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Lipinxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Lipinxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

