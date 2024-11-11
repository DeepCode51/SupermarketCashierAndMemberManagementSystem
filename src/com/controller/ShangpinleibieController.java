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

import com.entity.Shangpinleibie;
import com.server.ShangpinleibieServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShangpinleibieController {
	@Resource
	private ShangpinleibieServer shangpinleibieService;


   
	@RequestMapping("addShangpinleibie.do")
	public String addShangpinleibie(HttpServletRequest request,Shangpinleibie shangpinleibie,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shangpinleibie.setAddtime(time.toString().substring(0, 19));
		shangpinleibieService.add(shangpinleibie);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shangpinleibieList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shangpinleibieList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShangpinleibie.do")
	public String doUpdateShangpinleibie(int id,ModelMap map,Shangpinleibie shangpinleibie){
		shangpinleibie=shangpinleibieService.getById(id);
		map.put("shangpinleibie", shangpinleibie);
		return "shangpinleibie_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shangpinleibieDetail.do")
	public String shangpinleibieDetail(int id,ModelMap map,Shangpinleibie shangpinleibie){
		shangpinleibie=shangpinleibieService.getById(id);
		map.put("shangpinleibie", shangpinleibie);
		return "shangpinleibie_detail";
	}
//	前台详细
	@RequestMapping("splbDetail.do")
	public String splbDetail(int id,ModelMap map,Shangpinleibie shangpinleibie){
		shangpinleibie=shangpinleibieService.getById(id);
		map.put("shangpinleibie", shangpinleibie);
		return "shangpinleibiedetail";
	}
//	
	@RequestMapping("updateShangpinleibie.do")
	public String updateShangpinleibie(int id,ModelMap map,Shangpinleibie shangpinleibie,HttpServletRequest request,HttpSession session){
		shangpinleibieService.update(shangpinleibie);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shangpinleibieList.do";
	}

//	分页查询
	@RequestMapping("shangpinleibieList.do")
	public String shangpinleibieList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangpinleibie shangpinleibie, String leibie, String shuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}
		
		int total=shangpinleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangpinleibie> list=shangpinleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangpinleibie_list";
	}
	
	@RequestMapping("shangpinleibie_yanben1.do")
	public String shangpinleibie_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangpinleibie shangpinleibie, String leibie, String shuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}
		
		int total=shangpinleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangpinleibie> list=shangpinleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangpinleibie_yanben1";
	}
	@RequestMapping("shangpinleibie_yanben2.do")
	public String shangpinleibie_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangpinleibie shangpinleibie, String leibie, String shuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}
		
		int total=shangpinleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangpinleibie> list=shangpinleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangpinleibie_yanben2";
	}
	@RequestMapping("shangpinleibie_yanben3.do")
	public String shangpinleibie_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangpinleibie shangpinleibie, String leibie, String shuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}
		
		int total=shangpinleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangpinleibie> list=shangpinleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangpinleibie_yanben3";
	}
	@RequestMapping("shangpinleibie_yanben4.do")
	public String shangpinleibie_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangpinleibie shangpinleibie, String leibie, String shuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}
		
		int total=shangpinleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangpinleibie> list=shangpinleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangpinleibie_yanben4";
	}
	@RequestMapping("shangpinleibie_yanben5.do")
	public String shangpinleibie_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangpinleibie shangpinleibie, String leibie, String shuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}
		
		int total=shangpinleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangpinleibie> list=shangpinleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangpinleibie_yanben5";
	}
	
	
	
	@RequestMapping("splbList.do")
	public String splbList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangpinleibie shangpinleibie, String leibie, String shuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}
		
		int total=shangpinleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangpinleibie> list=shangpinleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangpinleibielist";
	}
	@RequestMapping("splbListtp.do")
	public String splbListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangpinleibie shangpinleibie, String leibie, String shuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}
		if(shuoming==null||shuoming.equals("")){pmap.put("shuoming", null);}else{pmap.put("shuoming", shuoming);}
		
		int total=shangpinleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangpinleibie> list=shangpinleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangpinleibielisttp";
	}
	
	@RequestMapping("deleteShangpinleibie.do")
	public String deleteShangpinleibie(int id,HttpServletRequest request){
		shangpinleibieService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shangpinleibieList.do";
	}
	
	
}
