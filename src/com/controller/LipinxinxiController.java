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

import com.entity.Lipinxinxi;
import com.server.LipinxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class LipinxinxiController {
	@Resource
	private LipinxinxiServer lipinxinxiService;


   
	@RequestMapping("addLipinxinxi.do")
	public String addLipinxinxi(HttpServletRequest request,Lipinxinxi lipinxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		lipinxinxi.setAddtime(time.toString().substring(0, 19));
		lipinxinxiService.add(lipinxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "lipinxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:lipinxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateLipinxinxi.do")
	public String doUpdateLipinxinxi(int id,ModelMap map,Lipinxinxi lipinxinxi){
		lipinxinxi=lipinxinxiService.getById(id);
		map.put("lipinxinxi", lipinxinxi);
		return "lipinxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("lipinxinxiDetail.do")
	public String lipinxinxiDetail(int id,ModelMap map,Lipinxinxi lipinxinxi){
		lipinxinxi=lipinxinxiService.getById(id);
		map.put("lipinxinxi", lipinxinxi);
		return "lipinxinxi_detail";
	}
//	前台详细
	@RequestMapping("lpxxDetail.do")
	public String lpxxDetail(int id,ModelMap map,Lipinxinxi lipinxinxi){
		lipinxinxi=lipinxinxiService.getById(id);
		map.put("lipinxinxi", lipinxinxi);
		return "lipinxinxidetail";
	}
//	
	@RequestMapping("updateLipinxinxi.do")
	public String updateLipinxinxi(int id,ModelMap map,Lipinxinxi lipinxinxi,HttpServletRequest request,HttpSession session){
		lipinxinxiService.update(lipinxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:lipinxinxiList.do";
	}

//	分页查询
	@RequestMapping("lipinxinxiList.do")
	public String lipinxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Lipinxinxi lipinxinxi, String lipintupian, String lipinbianhao, String lipinmingcheng, String suoxujifen1,String suoxujifen2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(lipintupian==null||lipintupian.equals("")){pmap.put("lipintupian", null);}else{pmap.put("lipintupian", lipintupian);}
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen1==null||suoxujifen1.equals("")){pmap.put("suoxujifen1", null);}else{pmap.put("suoxujifen1", suoxujifen1);}
		if(suoxujifen2==null||suoxujifen2.equals("")){pmap.put("suoxujifen2", null);}else{pmap.put("suoxujifen2", suoxujifen2);}
		
		int total=lipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Lipinxinxi> list=lipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "lipinxinxi_list";
	}
	
	@RequestMapping("lipinxinxi_yanben1.do")
	public String lipinxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Lipinxinxi lipinxinxi, String lipintupian, String lipinbianhao, String lipinmingcheng, String suoxujifen1,String suoxujifen2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(lipintupian==null||lipintupian.equals("")){pmap.put("lipintupian", null);}else{pmap.put("lipintupian", lipintupian);}
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen1==null||suoxujifen1.equals("")){pmap.put("suoxujifen1", null);}else{pmap.put("suoxujifen1", suoxujifen1);}
		if(suoxujifen2==null||suoxujifen2.equals("")){pmap.put("suoxujifen2", null);}else{pmap.put("suoxujifen2", suoxujifen2);}
		
		int total=lipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Lipinxinxi> list=lipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "lipinxinxi_yanben1";
	}
	@RequestMapping("lipinxinxi_yanben2.do")
	public String lipinxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Lipinxinxi lipinxinxi, String lipintupian, String lipinbianhao, String lipinmingcheng, String suoxujifen1,String suoxujifen2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(lipintupian==null||lipintupian.equals("")){pmap.put("lipintupian", null);}else{pmap.put("lipintupian", lipintupian);}
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen1==null||suoxujifen1.equals("")){pmap.put("suoxujifen1", null);}else{pmap.put("suoxujifen1", suoxujifen1);}
		if(suoxujifen2==null||suoxujifen2.equals("")){pmap.put("suoxujifen2", null);}else{pmap.put("suoxujifen2", suoxujifen2);}
		
		int total=lipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Lipinxinxi> list=lipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "lipinxinxi_yanben2";
	}
	@RequestMapping("lipinxinxi_yanben3.do")
	public String lipinxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Lipinxinxi lipinxinxi, String lipintupian, String lipinbianhao, String lipinmingcheng, String suoxujifen1,String suoxujifen2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(lipintupian==null||lipintupian.equals("")){pmap.put("lipintupian", null);}else{pmap.put("lipintupian", lipintupian);}
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen1==null||suoxujifen1.equals("")){pmap.put("suoxujifen1", null);}else{pmap.put("suoxujifen1", suoxujifen1);}
		if(suoxujifen2==null||suoxujifen2.equals("")){pmap.put("suoxujifen2", null);}else{pmap.put("suoxujifen2", suoxujifen2);}
		
		int total=lipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Lipinxinxi> list=lipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "lipinxinxi_yanben3";
	}
	@RequestMapping("lipinxinxi_yanben4.do")
	public String lipinxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Lipinxinxi lipinxinxi, String lipintupian, String lipinbianhao, String lipinmingcheng, String suoxujifen1,String suoxujifen2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(lipintupian==null||lipintupian.equals("")){pmap.put("lipintupian", null);}else{pmap.put("lipintupian", lipintupian);}
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen1==null||suoxujifen1.equals("")){pmap.put("suoxujifen1", null);}else{pmap.put("suoxujifen1", suoxujifen1);}
		if(suoxujifen2==null||suoxujifen2.equals("")){pmap.put("suoxujifen2", null);}else{pmap.put("suoxujifen2", suoxujifen2);}
		
		int total=lipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Lipinxinxi> list=lipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "lipinxinxi_yanben4";
	}
	@RequestMapping("lipinxinxi_yanben5.do")
	public String lipinxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Lipinxinxi lipinxinxi, String lipintupian, String lipinbianhao, String lipinmingcheng, String suoxujifen1,String suoxujifen2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(lipintupian==null||lipintupian.equals("")){pmap.put("lipintupian", null);}else{pmap.put("lipintupian", lipintupian);}
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen1==null||suoxujifen1.equals("")){pmap.put("suoxujifen1", null);}else{pmap.put("suoxujifen1", suoxujifen1);}
		if(suoxujifen2==null||suoxujifen2.equals("")){pmap.put("suoxujifen2", null);}else{pmap.put("suoxujifen2", suoxujifen2);}
		
		int total=lipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Lipinxinxi> list=lipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "lipinxinxi_yanben5";
	}
	
	
	
	@RequestMapping("lpxxList.do")
	public String lpxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Lipinxinxi lipinxinxi, String lipintupian, String lipinbianhao, String lipinmingcheng, String suoxujifen1,String suoxujifen2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(lipintupian==null||lipintupian.equals("")){pmap.put("lipintupian", null);}else{pmap.put("lipintupian", lipintupian);}
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen1==null||suoxujifen1.equals("")){pmap.put("suoxujifen1", null);}else{pmap.put("suoxujifen1", suoxujifen1);}
		if(suoxujifen2==null||suoxujifen2.equals("")){pmap.put("suoxujifen2", null);}else{pmap.put("suoxujifen2", suoxujifen2);}
		
		int total=lipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Lipinxinxi> list=lipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "lipinxinxilist";
	}
	@RequestMapping("lpxxListtp.do")
	public String lpxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Lipinxinxi lipinxinxi, String lipintupian, String lipinbianhao, String lipinmingcheng, String suoxujifen1,String suoxujifen2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(lipintupian==null||lipintupian.equals("")){pmap.put("lipintupian", null);}else{pmap.put("lipintupian", lipintupian);}
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen1==null||suoxujifen1.equals("")){pmap.put("suoxujifen1", null);}else{pmap.put("suoxujifen1", suoxujifen1);}
		if(suoxujifen2==null||suoxujifen2.equals("")){pmap.put("suoxujifen2", null);}else{pmap.put("suoxujifen2", suoxujifen2);}
		
		int total=lipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Lipinxinxi> list=lipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "lipinxinxilisttp";
	}
	
	@RequestMapping("deleteLipinxinxi.do")
	public String deleteLipinxinxi(int id,HttpServletRequest request){
		lipinxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:lipinxinxiList.do";
	}
	
	
}
