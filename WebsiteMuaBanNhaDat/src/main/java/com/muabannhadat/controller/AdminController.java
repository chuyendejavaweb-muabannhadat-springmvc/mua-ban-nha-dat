package com.muabannhadat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.muabannhadat.entity.PostNewsEntity;
import com.muabannhadat.service.PostnewService;
import com.muabannhadat.validator.PostnewValidator;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	PostnewService postnewService;
	@Autowired
	PostnewValidator userValidator;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginAdminPage() {
		return "index_Admin";
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutAdmin(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "index";
	}
	@RequestMapping(value = "/list-post-news", method = RequestMethod.GET)
	public ModelAndView getListPostNews() {
		List<PostNewsEntity> listPostNews = postnewService.getAll();
		ModelAndView mav = new ModelAndView("manager_product_chothue");
		mav.addObject("listPostNews", listPostNews);
		return mav;
		
	}
	@RequestMapping("/delete")
	public String deletePostNews(@RequestParam Long id) {
		postnewService.delete(id);;
	    return "redirect:/";       
	}
	
	@RequestMapping("/browse-articles")
	public String browseArticles(@RequestParam Long id) {
		postnewService.browseArticles(id);
		return "redirect:/";       
	}
	@RequestMapping("/view-detail-post-news")
	public ModelAndView viewDetail(@RequestParam Long id) {
	PostNewsEntity postNewsEntity = postnewService.viewDetail(id);
		ModelAndView mav = new ModelAndView("single");
		mav.addObject("postNews", postNewsEntity);
		return mav;       
	}
	
	

}
