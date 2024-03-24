package com.example.demo;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EncomendaController {

	@Autowired
	private EncomendaRepository er;
	
	@Autowired
	private EncLinhaRepository elr;
	
	@Autowired
	private LogOperationsRepository lor;
	
	
	@GetMapping(path="/")
	public String main (Model model) {
	 	return "index";
	}
	
	@RequestMapping(value="/pesquisarEncomenda", method=RequestMethod.GET)
	public String form() {
		return "formEncomenda.html";
	}
	
	@RequestMapping(value="/pesquisarEncomenda", method=RequestMethod.POST)
	public String form(@Validated Encomenda encomenda, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Erro, verifique os parâmetros!");
			return "redirect:/{idEnc}";
		}
		er.save(encomenda);
		attributes.addFlashAttribute("mensagem", "Encomenda adicionada com sucesso!");
		return "redirect:/idEnc";
	}
		
	@RequestMapping("/encomendas")
	public ModelAndView listEncomendas() {
		ModelAndView mv = new ModelAndView("index_encomenda");
		Iterable<Encomenda> encomenda = er.findAll();
		
		mv.addObject("encomenda", encomenda);

		return mv;
	}
	
	@RequestMapping("/logOperations")
	public ModelAndView listlogOperations() {
		ModelAndView mv = new ModelAndView("logOperations");
		Iterable<LogOperations> logOperations = lor.findAll();
		
		mv.addObject("logOperations", logOperations);

		return mv;
	}
	
	
	@RequestMapping(value="/{idEnc}", method=RequestMethod.GET)
	public ModelAndView encomendaDetails(@PathVariable("idEnc") int EncId) {
		Encomenda encomenda = er.findByEncId(EncId);

		ModelAndView mv = new ModelAndView("encomendaDetails");
		mv.addObject("encomenda", encomenda);
		
		// Necessário definir manualmente a coluna do ProdutoId
		EncLinha encLinha = elr.findByEncLinhaid(new EncLinhaId(EncId, 1));
		
		//Iterable<EncLinha> encLinha = elr.findByEncLinhaid(new EncLinhaId(EncId, 2));
		
		mv.addObject("encLinhas", encLinha);
			
			
		System.out.println("id Enc: " +EncId );
		//System.out.println("id produto: " +ProdutoId );
	
		return mv;
	}
	
	@RequestMapping(value="/{idEnc}", method=RequestMethod.POST)
	public String encomendaDetailsPost(@PathVariable("idEnc") int EncId, @Validated Encomenda encomenda, @Validated EncLinha enclinha, BindingResult result, RedirectAttributes attributes, HttpServletRequest req) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Erro, verifique os parâmetros!");
			return "redirect:/{idEnc}";
		}
		
		encomenda = er.findByEncId(EncId);

		// chave composta a partir do EncId
		enclinha = elr.findByEncLinhaid(new EncLinhaId(EncId, 1));
		
		String morada = req.getParameter("morada");
		
		encomenda.setMorada(morada);
		er.save(encomenda);
		
		int produtoid = Integer.parseInt(req.getParameter("idproduto"));
		double qtd = Double.parseDouble(req.getParameter("qtd"));
		if(encomenda.getEncId() == enclinha.getEncId() && enclinha.getProdutoId() == produtoid) {
			enclinha.setQtd(qtd);
			elr.save(enclinha);
		}
		
		System.out.println("id produto: " +produtoid );
		System.out.println("qtd: " +qtd );
		attributes.addFlashAttribute("mensagem", "Morada Alterada com sucesso!");
		return "redirect:/{idEnc}";
	}
	
	
	@RequestMapping("/deleteEncomenda")
	public String deleteEncomenda(int EncId) {	
		Encomenda encomenda = er.findByEncId(EncId);
		er.delete(encomenda);
		
		return "redirect:/encomendas";
	}	
}
