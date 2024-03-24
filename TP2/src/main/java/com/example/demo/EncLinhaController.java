package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EncLinhaController {

	@Autowired
	private EncLinhaRepository elr;
	
	/*
	@RequestMapping("/encomendas")
	public ModelAndView listEncLinha() {
		ModelAndView mv = new ModelAndView("index_encomenda");
		Iterable<EncLinha> encLinha = elr.findAll();
		mv.addObject("encLinha", encLinha);
		
		return mv;
	}
	
	*/
	
	
}
