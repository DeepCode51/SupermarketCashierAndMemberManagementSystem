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

import com.entity.Zhanghaochongzhi;
import com.server.ZhanghaochongzhiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZhanghaochongzhiController {
	@Resource
	private ZhanghaochongzhiServer zhanghaochongzhiService;


   
	@RequestMapping("addZhanghaochongzhi.do")
	public String addZhanghaochongzhi(HttpServletRequest request,Zhanghaochongzhi zhanghaochongzhi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zhanghaochongzhi.setAddtime(time.toString().substring(0, 19));
		zhanghaochongzhiService.add(zhanghaochongzhi);
		db dbo = new db();dbo.hsgexecute("update huiyuanxinxi set yue=yue+"+zhanghaochongzhi.getChongzhijine()+" where shoujihao='"+zhanghaochongzhi.getShoujihao()+"'");
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zhanghaochongzhiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zhanghaochongzhiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZhanghaochongzhi.do")
	public String doUpdateZhanghaochongzhi(int id,ModelMap map,Zhanghaochongzhi zhanghaochongzhi){
		zhanghaochongzhi=zhanghaochongzhiService.getById(id);
		map.put("zhanghaochongzhi", zhanghaochongzhi);
		return "zhanghaochongzhi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("zhanghaochongzhiDetail.do")
	public String zhanghaochongzhiDetail(int id,ModelMap map,Zhanghaochongzhi zhanghaochongzhi){
		zhanghaochongzhi=zhanghaochongzhiService.getById(id);
		map.put("zhanghaochongzhi", zhanghaochongzhi);
		return "zhanghaochongzhi_detail";
	}
//	前台详细
	@RequestMapping("zhczDetail.do")
	public String zhczDetail(int id,ModelMap map,Zhanghaochongzhi zhanghaochongzhi){
		zhanghaochongzhi=zhanghaochongzhiService.getById(id);
		map.put("zhanghaochongzhi", zhanghaochongzhi);
		return "zhanghaochongzhidetail";
	}
//	
	@RequestMapping("updateZhanghaochongzhi.do")
	public String updateZhanghaochongzhi(int id,ModelMap map,Zhanghaochongzhi zhanghaochongzhi,HttpServletRequest request,HttpSession session){
		zhanghaochongzhiService.update(zhanghaochongzhi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhanghaochongzhiList.do";
	}

//	分页查询
	@RequestMapping("zhanghaochongzhiList.do")
	public String zhanghaochongzhiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanghaochongzhi zhanghaochongzhi, String xingming, String shoujihao, String yue, String chongzhijine1,String chongzhijine2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		if(chongzhijine1==null||chongzhijine1.equals("")){pmap.put("chongzhijine1", null);}else{pmap.put("chongzhijine1", chongzhijine1);}
		if(chongzhijine2==null||chongzhijine2.equals("")){pmap.put("chongzhijine2", null);}else{pmap.put("chongzhijine2", chongzhijine2);}
		
		int total=zhanghaochongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanghaochongzhi> list=zhanghaochongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanghaochongzhi_list";
	}
	
	@RequestMapping("zhanghaochongzhi_yanben1.do")
	public String zhanghaochongzhi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanghaochongzhi zhanghaochongzhi, String xingming, String shoujihao, String yue, String chongzhijine1,String chongzhijine2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		if(chongzhijine1==null||chongzhijine1.equals("")){pmap.put("chongzhijine1", null);}else{pmap.put("chongzhijine1", chongzhijine1);}
		if(chongzhijine2==null||chongzhijine2.equals("")){pmap.put("chongzhijine2", null);}else{pmap.put("chongzhijine2", chongzhijine2);}
		
		int total=zhanghaochongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanghaochongzhi> list=zhanghaochongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanghaochongzhi_yanben1";
	}
	@RequestMapping("zhanghaochongzhi_yanben2.do")
	public String zhanghaochongzhi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanghaochongzhi zhanghaochongzhi, String xingming, String shoujihao, String yue, String chongzhijine1,String chongzhijine2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		if(chongzhijine1==null||chongzhijine1.equals("")){pmap.put("chongzhijine1", null);}else{pmap.put("chongzhijine1", chongzhijine1);}
		if(chongzhijine2==null||chongzhijine2.equals("")){pmap.put("chongzhijine2", null);}else{pmap.put("chongzhijine2", chongzhijine2);}
		
		int total=zhanghaochongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanghaochongzhi> list=zhanghaochongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanghaochongzhi_yanben2";
	}
	@RequestMapping("zhanghaochongzhi_yanben3.do")
	public String zhanghaochongzhi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanghaochongzhi zhanghaochongzhi, String xingming, String shoujihao, String yue, String chongzhijine1,String chongzhijine2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		if(chongzhijine1==null||chongzhijine1.equals("")){pmap.put("chongzhijine1", null);}else{pmap.put("chongzhijine1", chongzhijine1);}
		if(chongzhijine2==null||chongzhijine2.equals("")){pmap.put("chongzhijine2", null);}else{pmap.put("chongzhijine2", chongzhijine2);}
		
		int total=zhanghaochongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanghaochongzhi> list=zhanghaochongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanghaochongzhi_yanben3";
	}
	@RequestMapping("zhanghaochongzhi_yanben4.do")
	public String zhanghaochongzhi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanghaochongzhi zhanghaochongzhi, String xingming, String shoujihao, String yue, String chongzhijine1,String chongzhijine2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		if(chongzhijine1==null||chongzhijine1.equals("")){pmap.put("chongzhijine1", null);}else{pmap.put("chongzhijine1", chongzhijine1);}
		if(chongzhijine2==null||chongzhijine2.equals("")){pmap.put("chongzhijine2", null);}else{pmap.put("chongzhijine2", chongzhijine2);}
		
		int total=zhanghaochongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanghaochongzhi> list=zhanghaochongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanghaochongzhi_yanben4";
	}
	@RequestMapping("zhanghaochongzhi_yanben5.do")
	public String zhanghaochongzhi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanghaochongzhi zhanghaochongzhi, String xingming, String shoujihao, String yue, String chongzhijine1,String chongzhijine2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		if(chongzhijine1==null||chongzhijine1.equals("")){pmap.put("chongzhijine1", null);}else{pmap.put("chongzhijine1", chongzhijine1);}
		if(chongzhijine2==null||chongzhijine2.equals("")){pmap.put("chongzhijine2", null);}else{pmap.put("chongzhijine2", chongzhijine2);}
		
		int total=zhanghaochongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanghaochongzhi> list=zhanghaochongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanghaochongzhi_yanben5";
	}
	
	@RequestMapping("zhanghaochongzhiList2.do")
	public String zhanghaochongzhiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanghaochongzhi zhanghaochongzhi, String xingming, String shoujihao, String yue, String chongzhijine1,String chongzhijine2,HttpServletRequest request){
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
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		if(chongzhijine1==null||chongzhijine1.equals("")){pmap.put("chongzhijine1", null);}else{pmap.put("chongzhijine1", chongzhijine1);}
		if(chongzhijine2==null||chongzhijine2.equals("")){pmap.put("chongzhijine2", null);}else{pmap.put("chongzhijine2", chongzhijine2);}
		
		
		int total=zhanghaochongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanghaochongzhi> list=zhanghaochongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanghaochongzhi_list2";
	}
	
	
	@RequestMapping("zhczList.do")
	public String zhczList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanghaochongzhi zhanghaochongzhi, String xingming, String shoujihao, String yue, String chongzhijine1,String chongzhijine2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		if(chongzhijine1==null||chongzhijine1.equals("")){pmap.put("chongzhijine1", null);}else{pmap.put("chongzhijine1", chongzhijine1);}
		if(chongzhijine2==null||chongzhijine2.equals("")){pmap.put("chongzhijine2", null);}else{pmap.put("chongzhijine2", chongzhijine2);}
		
		int total=zhanghaochongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanghaochongzhi> list=zhanghaochongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanghaochongzhilist";
	}
	@RequestMapping("zhczListtp.do")
	public String zhczListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanghaochongzhi zhanghaochongzhi, String xingming, String shoujihao, String yue, String chongzhijine1,String chongzhijine2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(yue==null||yue.equals("")){pmap.put("yue", null);}else{pmap.put("yue", yue);}
		if(chongzhijine1==null||chongzhijine1.equals("")){pmap.put("chongzhijine1", null);}else{pmap.put("chongzhijine1", chongzhijine1);}
		if(chongzhijine2==null||chongzhijine2.equals("")){pmap.put("chongzhijine2", null);}else{pmap.put("chongzhijine2", chongzhijine2);}
		
		int total=zhanghaochongzhiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanghaochongzhi> list=zhanghaochongzhiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanghaochongzhilisttp";
	}
	
	@RequestMapping("deleteZhanghaochongzhi.do")
	public String deleteZhanghaochongzhi(int id,HttpServletRequest request){
		zhanghaochongzhiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhanghaochongzhiList.do";
	}
	
	
}
