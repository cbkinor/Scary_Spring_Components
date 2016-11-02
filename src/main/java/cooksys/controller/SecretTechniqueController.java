package cooksys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.entity.SecretTechnique;
import cooksys.service.impl.TechniqueServiceImpl;

@RestController
@RequestMapping("pleasework")
public class SecretTechniqueController {
	
	private TechniqueServiceImpl techniqueService;
	
	public SecretTechniqueController(TechniqueServiceImpl techniqueService){
		this.techniqueService = techniqueService;
	}
	
	@GetMapping("secret_techniques/{id}")
	public SecretTechnique getSecretTechnique(@PathVariable long id) {
		return techniqueService.getById(id);
	}
	

}
