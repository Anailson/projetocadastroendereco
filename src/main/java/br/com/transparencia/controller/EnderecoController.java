package br.com.transparencia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.transparencia.model.Endereco;
import br.com.transparencia.repository.EnderecoRepository;

@Controller
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastroendereco")
	public ModelAndView inicio() {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroendereco");
		Iterable<Endereco> enderecoIt = enderecoRepository.findAll();
		modelAndView.addObject("enderecos", enderecoIt);
		modelAndView.addObject("enderecoobj", new Endereco());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "**/salvarendereco")
	public ModelAndView salvar(@Valid Endereco endereco, BindingResult bindingResult) {

		// VALIDA TODAS AS MSG E DEPOIS SALVAR OS REGISTROS
		if (bindingResult.hasErrors()) { //SER TIVER ERRO FICA NA TELA
			//₢aso tenha ERRo
			ModelAndView modelAndView  = new ModelAndView("cadastro/cadastroendereco");
			Iterable<Endereco> enderecoIt = enderecoRepository.findAll();
			modelAndView .addObject("enderecos", enderecoIt);
			modelAndView .addObject("enderecoobj", endereco);//da o erro e deixa o form preenchido com os objejots

			//lista mostrando as validações na tela
			List<String> msg = new ArrayList<>();
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				msg.add(objectError.getDefaultMessage());//vem das anotações @notNull etc
			}

			modelAndView .addObject("msg", msg);
			return modelAndView ;
		}

		enderecoRepository.save(endereco);
		
		ModelAndView andView = new ModelAndView("cadastro/cadastroendereco");
		Iterable<Endereco> enderecoIt = enderecoRepository.findAll();
		andView.addObject("enderecos", enderecoIt);
		andView.addObject("enderecoobj", new Endereco());
		
		return andView;
	}

	// PESQUISA ENDEREÇO
	// CONSULTA PELO A REPOSITORY COM SQL
	@PostMapping("**/pesquisaendereco")
	public ModelAndView pesquisa(@RequestParam("nomepesquisa") String nomepesquisa) {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroendereco");
		modelAndView.addObject("enderecos", enderecoRepository.findEnderecoByLogradouro(nomepesquisa));
		modelAndView.addObject("enderecoobj", new Endereco());

		return modelAndView;
	}

}
