package com.skilldistillery.bootformbaas.controllers;
import java.util.List;

import com.skilldistillery.bootformbaas.data.MetalDAO;
import com.skilldistillery.metalbandsandawesomesongs.entities.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.metalbandsandawesomesongs.entities.*;

@Controller
public class MetalBandController {
	private final MetalDAO dao;
	public MetalBandController(MetalDAO dao) {
		this.dao = dao;
	}
	@GetMapping(path={ "/", "home.do", "index.do" })
	   public String index(Model model) {
		List<MetalBand> metalBand = dao.allMetalBands();
		model.addAttribute("metalBand", metalBand);
	    return "index"; 
	   }
	@GetMapping("findBandById.do")
	public ModelAndView getMetalBandById(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		MetalBand metalBand = new MetalBand();
		try {
			metalBand = dao.findBandById(id);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		mv.addObject("metalBand", metalBand);
		mv.setViewName("Show");
		return mv;
	}
	@GetMapping("addNewBand.do")
	public ModelAndView addNewBand(@RequestParam("id") int id, @RequestParam("Name_Of_Band") String nameOfBand,
																@RequestParam("Year_Founded") int yearFounded, @RequestParam("Popular_Song") String popularSong) {
	ModelAndView mv = new ModelAndView();
	MetalBand metalBand = new MetalBand();
	try {
		metalBand = dao.addNewBand(metalBand);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	mv.addObject("metalBand", metalBand);
	mv.setViewName("addband");
	return mv;
	}
	
	
	@GetMapping("deleteMetalBand.do")
	public ModelAndView deleteMetalBand(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		MetalBand metalBand = new MetalBand();
		try {
		boolean	removeMetalBand = dao.deleteMetalBand(id);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return mv;
	}
	@GetMapping("updateBandInfo.do")
	public ModelAndView updateBandInfo(@RequestParam("Name_Of_Band") String nameOfBand,
										@RequestParam("Year_Founded") int yearFounded, @RequestParam("Popular_Song") String popularSong) {
											
	
	ModelAndView mv = new ModelAndView();
	MetalBand metalBand = new MetalBand();
	try {
		metalBand = dao.updateBandInfo(metalBand, id);
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return mv;
}
}
