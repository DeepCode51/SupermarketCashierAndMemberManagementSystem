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

import com.entity.Duihuanlipin;
import com.server.DuihuanlipinServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class DuihuanlipinController {
	@Resource
	private DuihuanlipinServer duihuanlipinService;


   
	@RequestMapping("addDuihuanlipin.do")
	public String addDuihuanlipin(HttpServletRequest request,Duihuanlipin duihuanlipin,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		duihuanlipin.setAddtime(time.toString().substring(0, 19));
		duihuanlipinService.add(duihuanlipin);
		db dbo = new db();dbo.hsgexecute("update lipinxinxi set jifen=jifen-"+duihuanlipin.getSuoxujifen()+" where shoujihao='"+duihuanlipin.getShoujihao()+"'");
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "duihuanlipinList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:duihuanlipinList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateDuihuanlipin.do")
	public String doUpdateDuihuanlipin(int id,ModelMap map,Duihuanlipin duihuanlipin){
		duihuanlipin=duihuanlipinService.getById(id);
		map.put("duihuanlipin", duihuanlipin);
		return "duihuanlipin_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("duihuanlipinDetail.do")
	public String duihuanlipinDetail(int id,ModelMap map,Duihuanlipin duihuanlipin){
		duihuanlipin=duihuanlipinService.getById(id);
		map.put("duihuanlipin", duihuanlipin);
		return "duihuanlipin_detail";
	}
//	前台详细
	@RequestMapping("dhlpDetail.do")
	public String dhlpDetail(int id,ModelMap map,Duihuanlipin duihuanlipin){
		duihuanlipin=duihuanlipinService.getById(id);
		map.put("duihuanlipin", duihuanlipin);
		return "duihuanlipindetail";
	}
//	
	@RequestMapping("updateDuihuanlipin.do")
	public String updateDuihuanlipin(int id,ModelMap map,Duihuanlipin duihuanlipin,HttpServletRequest request,HttpSession session){
		duihuanlipinService.update(duihuanlipin);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:duihuanlipinList.do";
	}

//	分页查询
	@RequestMapping("duihuanlipinList.do")
	public String duihuanlipinList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duihuanlipin duihuanlipin, String lipinbianhao, String lipinmingcheng, String suoxujifen, String xingming, String shoujihao, String jifen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen==null||suoxujifen.equals("")){pmap.put("suoxujifen", null);}else{pmap.put("suoxujifen", suoxujifen);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}
		
		int total=duihuanlipinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duihuanlipin> list=duihuanlipinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duihuanlipin_list";
	}
	
	@RequestMapping("duihuanlipin_yanben1.do")
	public String duihuanlipin_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duihuanlipin duihuanlipin, String lipinbianhao, String lipinmingcheng, String suoxujifen, String xingming, String shoujihao, String jifen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen==null||suoxujifen.equals("")){pmap.put("suoxujifen", null);}else{pmap.put("suoxujifen", suoxujifen);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}
		
		int total=duihuanlipinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duihuanlipin> list=duihuanlipinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duihuanlipin_yanben1";
	}
	@RequestMapping("duihuanlipin_yanben2.do")
	public String duihuanlipin_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duihuanlipin duihuanlipin, String lipinbianhao, String lipinmingcheng, String suoxujifen, String xingming, String shoujihao, String jifen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen==null||suoxujifen.equals("")){pmap.put("suoxujifen", null);}else{pmap.put("suoxujifen", suoxujifen);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}
		
		int total=duihuanlipinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duihuanlipin> list=duihuanlipinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duihuanlipin_yanben2";
	}
	@RequestMapping("duihuanlipin_yanben3.do")
	public String duihuanlipin_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duihuanlipin duihuanlipin, String lipinbianhao, String lipinmingcheng, String suoxujifen, String xingming, String shoujihao, String jifen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen==null||suoxujifen.equals("")){pmap.put("suoxujifen", null);}else{pmap.put("suoxujifen", suoxujifen);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}
		
		int total=duihuanlipinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duihuanlipin> list=duihuanlipinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duihuanlipin_yanben3";
	}
	@RequestMapping("duihuanlipin_yanben4.do")
	public String duihuanlipin_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duihuanlipin duihuanlipin, String lipinbianhao, String lipinmingcheng, String suoxujifen, String xingming, String shoujihao, String jifen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen==null||suoxujifen.equals("")){pmap.put("suoxujifen", null);}else{pmap.put("suoxujifen", suoxujifen);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}
		
		int total=duihuanlipinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duihuanlipin> list=duihuanlipinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duihuanlipin_yanben4";
	}
	@RequestMapping("duihuanlipin_yanben5.do")
	public String duihuanlipin_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duihuanlipin duihuanlipin, String lipinbianhao, String lipinmingcheng, String suoxujifen, String xingming, String shoujihao, String jifen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen==null||suoxujifen.equals("")){pmap.put("suoxujifen", null);}else{pmap.put("suoxujifen", suoxujifen);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}
		
		int total=duihuanlipinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duihuanlipin> list=duihuanlipinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duihuanlipin_yanben5";
	}
	
	@RequestMapping("duihuanlipinList2.do")
	public String duihuanlipinList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duihuanlipin duihuanlipin, String lipinbianhao, String lipinmingcheng, String suoxujifen, String xingming, String shoujihao, String jifen,HttpServletRequest request){
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
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen==null||suoxujifen.equals("")){pmap.put("suoxujifen", null);}else{pmap.put("suoxujifen", suoxujifen);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}
		
		
		int total=duihuanlipinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duihuanlipin> list=duihuanlipinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duihuanlipin_list2";
	}
	
	
	@RequestMapping("dhlpList.do")
	public String dhlpList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duihuanlipin duihuanlipin, String lipinbianhao, String lipinmingcheng, String suoxujifen, String xingming, String shoujihao, String jifen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen==null||suoxujifen.equals("")){pmap.put("suoxujifen", null);}else{pmap.put("suoxujifen", suoxujifen);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}
		
		int total=duihuanlipinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duihuanlipin> list=duihuanlipinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duihuanlipinlist";
	}
	@RequestMapping("dhlpListtp.do")
	public String dhlpListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Duihuanlipin duihuanlipin, String lipinbianhao, String lipinmingcheng, String suoxujifen, String xingming, String shoujihao, String jifen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(lipinbianhao==null||lipinbianhao.equals("")){pmap.put("lipinbianhao", null);}else{pmap.put("lipinbianhao", lipinbianhao);}
		if(lipinmingcheng==null||lipinmingcheng.equals("")){pmap.put("lipinmingcheng", null);}else{pmap.put("lipinmingcheng", lipinmingcheng);}
		if(suoxujifen==null||suoxujifen.equals("")){pmap.put("suoxujifen", null);}else{pmap.put("suoxujifen", suoxujifen);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shoujihao==null||shoujihao.equals("")){pmap.put("shoujihao", null);}else{pmap.put("shoujihao", shoujihao);}
		if(jifen==null||jifen.equals("")){pmap.put("jifen", null);}else{pmap.put("jifen", jifen);}
		
		int total=duihuanlipinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Duihuanlipin> list=duihuanlipinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "duihuanlipinlisttp";
	}
	
	@RequestMapping("deleteDuihuanlipin.do")
	public String deleteDuihuanlipin(int id,HttpServletRequest request){
		duihuanlipinService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:duihuanlipinList.do";
	}
	
	
}
