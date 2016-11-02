package cooksys.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import cooksys.entity.SecretTechnique;
import cooksys.repository.SecretRepository;

@Repository
public class SecretRepositoryImpl implements SecretRepository {

	EntityManager entityManager;
	
	public SecretRepositoryImpl(EntityManager em) {
		entityManager = em;
	}
	
	@Override
	public SecretTechnique get(long id) {
		return entityManager.find(SecretTechnique.class, id);
	}
}
