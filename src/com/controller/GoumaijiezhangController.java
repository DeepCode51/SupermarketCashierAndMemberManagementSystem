package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Goumaijiezhang;
import com.server.GoumaijiezhangServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GoumaijiezhangController {
	@Resource
	private GoumaijiezhangServer goumaijiezhangService;


   
	@RequestMapping("addGoumaijiezhang.do")
	public String addGoumaijiezhang(HttpServletRequest request,Goumaijiezhang goumaijiezhang,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		goumaijiezhang.setAddtime(time.toString().substring(0, 19));
		goumaijiezhangService.add(goumaijiezhang);
		db dbo = new db();dbo.hsgexecute("update shangpinxinxi set kucun=kucun-"+goumaijiezhang.getGoumaishuliang()+" where shangpinbianhao='"+goumaijiezhang.getShangpinbianhao()+"'");
dbo.hsgexecute("update huiyuanxinxi set jifen=jifen+"+goumaijiezhang.getGoumaijine()+" , yue=yue-"+goumaijiezhang.getGoumaijine()+"  where shoujihao='"+goumaijiezhang.getShoujihao()+"'");
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "goumaijiezhangList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:goumaijiezhangList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGoumaijiezhang.do")
	public String doUpdateGoumaijiezhang(int id,ModelMap map,Goumaijiezhang goumaijiezhang){
		goumaijiezhang=goumaijiezhangService.getById(id);
		map.put("goumaijiezhang", goumaijiezhang);
		return "goumaijiezhang_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("goumaijiezhangDetail.do")
	public String goumaijiezhangDetail(int id,ModelMap map,Goumaijiezhang goumaijiezhang){
		goumaijiezhang=goumaijiezhangService.getById(id);
		map.put("goumaijiezhang", goumaijiezhang);
		return "goumaijiezhang_detail";
	}
//	前台详细
	@RequestMapping("gmjzDetail.do")
	public String gmjzDetail(int id,ModelMap map,Goumaijiezhang goumaijiezhang){
		goumaijiezhang=goumaijiezhangService.getById(id);
		map.put("goumaijiezhang", goumaijiezhang);
		return "goumaijiezhangdetail";
	}
//	
	@RequestMapping("updateGoumaijiezhang.do")
	public String updateGoumaijiezhang(int id,ModelMap map,Goumaijiezhang goumaijiezhang,HttpServletRequest request,HttpSession session){
		goumaijiezhangService.update(goumaijiezhang);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:goumaijiezhangList.do";
	}

//	分页查询
	@RequestMapping("goumaijiezhangList.do")
	public String goumaijiezhangList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Goumaijiezhang goumaijiezhang, String shangpinbianhao, String shangpinmingcheng, String leibie, String jiage, String kucun, String goumaishuliang1,String goumaishuliang2, String goumaijine, String xingming, String shoujihao, String yue){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(goumaijine==null||goumaijine.equals("")){pmap.put("goumaijine", null);}else{pmap.put("goumaijine", goumaijine);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		
		int total=goumaijiezhangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Goumaijiezhang> list=goumaijiezhangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "goumaijiezhang_list";
	}
	
	@RequestMapping("goumaijiezhang_yanben1.do")
	public String goumaijiezhang_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Goumaijiezhang goumaijiezhang, String shangpinbianhao, String shangpinmingcheng, String leibie, String jiage, String kucun, String goumaishuliang1,String goumaishuliang2, String goumaijine, String xingming, String shoujihao, String yue){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(goumaijine==null||goumaijine.equals("")){pmap.put("goumaijine", null);}else{pmap.put("goumaijine", goumaijine);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		
		int total=goumaijiezhangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Goumaijiezhang> list=goumaijiezhangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "goumaijiezhang_yanben1";
	}
	@RequestMapping("goumaijiezhang_yanben2.do")
	public String goumaijiezhang_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Goumaijiezhang goumaijiezhang, String shangpinbianhao, String shangpinmingcheng, String leibie, String jiage, String kucun, String goumaishuliang1,String goumaishuliang2, String goumaijine, String xingming, String shoujihao, String yue){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(goumaijine==null||goumaijine.equals("")){pmap.put("goumaijine", null);}else{pmap.put("goumaijine", goumaijine);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		
		int total=goumaijiezhangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Goumaijiezhang> list=goumaijiezhangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "goumaijiezhang_yanben2";
	}
	@RequestMapping("goumaijiezhang_yanben3.do")
	public String goumaijiezhang_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Goumaijiezhang goumaijiezhang, String shangpinbianhao, String shangpinmingcheng, String leibie, String jiage, String kucun, String goumaishuliang1,String goumaishuliang2, String goumaijine, String xingming, String shoujihao, String yue){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(goumaijine==null||goumaijine.equals("")){pmap.put("goumaijine", null);}else{pmap.put("goumaijine", goumaijine);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		
		int total=goumaijiezhangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Goumaijiezhang> list=goumaijiezhangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "goumaijiezhang_yanben3";
	}
	@RequestMapping("goumaijiezhang_yanben4.do")
	public String goumaijiezhang_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Goumaijiezhang goumaijiezhang, String shangpinbianhao, String shangpinmingcheng, String leibie, String jiage, String kucun, String goumaishuliang1,String goumaishuliang2, String goumaijine, String xingming, String shoujihao, String yue){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(goumaijine==null||goumaijine.equals("")){pmap.put("goumaijine", null);}else{pmap.put("goumaijine", goumaijine);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		
		int total=goumaijiezhangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Goumaijiezhang> list=goumaijiezhangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "goumaijiezhang_yanben4";
	}
	@RequestMapping("goumaijiezhang_yanben5.do")
	public String goumaijiezhang_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Goumaijiezhang goumaijiezhang, String shangpinbianhao, String shangpinmingcheng, String leibie, String jiage, String kucun, String goumaishuliang1,String goumaishuliang2, String goumaijine, String xingming, String shoujihao, String yue){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(goumaijine==null||goumaijine.equals("")){pmap.put("goumaijine", null);}else{pmap.put("goumaijine", goumaijine);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		
		int total=goumaijiezhangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Goumaijiezhang> list=goumaijiezhangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "goumaijiezhang_yanben5";
	}
	
	@RequestMapping("goumaijiezhangList2.do")
	public String goumaijiezhangList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Goumaijiezhang goumaijiezhang, String shangpinbianhao, String shangpinmingcheng, String leibie, String jiage, String kucun, String goumaishuliang1,String goumaishuliang2, String goumaijine, String xingming, String shoujihao, String yue,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("shoujihao", (String)request.getSession().getAttribute("username"));
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(goumaijine==null||goumaijine.equals("")){pmap.put("goumaijine", null);}else{pmap.put("goumaijine", goumaijine);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		
		
		int total=goumaijiezhangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Goumaijiezhang> list=goumaijiezhangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "goumaijiezhang_list2";
	}
	
	
	@RequestMapping("gmjzList.do")
	public String gmjzList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Goumaijiezhang goumaijiezhang, String shangpinbianhao, String shangpinmingcheng, String leibie, String jiage, String kucun, String goumaishuliang1,String goumaishuliang2, String goumaijine, String xingming, String shoujihao, String yue){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(goumaijine==null||goumaijine.equals("")){pmap.put("goumaijine", null);}else{pmap.put("goumaijine", goumaijine);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		
		int total=goumaijiezhangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Goumaijiezhang> list=goumaijiezhangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "goumaijiezhanglist";
	}
	@RequestMapping("gmjzListtp.do")
	public String gmjzListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Goumaijiezhang goumaijiezhang, String shangpinbianhao, String shangpinmingcheng, String leibie, String jiage, String kucun, String goumaishuliang1,String goumaishuliang2, String goumaijine, String xingming, String shoujihao, String yue){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(goumaijine==null||goumaijine.equals("")){pmap.put("goumaijine", null);}else{pmap.put("goumaijine", goumaijine);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		
		int total=goumaijiezhangService.getCount(pmap);
		pageBean.setTotal(total);
		List<Goumaijiezhang> list=goumaijiezhangService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "goumaijiezhanglisttp";
	}
	
	@RequestMapping("deleteGoumaijiezhang.do")
	public String deleteGoumaijiezhang(int id,HttpServletRequest request){
		goumaijiezhangService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:goumaijiezhangList.do";
	}
	
	
}
