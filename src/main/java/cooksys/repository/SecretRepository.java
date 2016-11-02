package cooksys.repository;

import cooksys.entity.SecretTechnique;

public interface SecretRepository {

	SecretTechnique get(long id);
}
