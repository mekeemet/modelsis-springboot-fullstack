package com.test.modelsisspringbootfullstack.dao;

import com.test.modelsisspringbootfullstack.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    public Utilisateur findByUsername(String username);
}
