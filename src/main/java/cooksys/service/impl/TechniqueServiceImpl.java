package cooksys.service.impl;

import org.springframework.stereotype.Service;

import cooksys.entity.SecretTechnique;
import cooksys.repository.SecretRepository;
import cooksys.service.TechniqueService;

@Service
public class TechniqueServiceImpl implements TechniqueService {
	
	private SecretRepository secretRepo;
	
	public TechniqueServiceImpl(SecretRepository secretRepo) {
		this.secretRepo = secretRepo;
	}

	public SecretTechnique getById(long id) {
		return secretRepo.get(id);
	}

}
