package com.test.modelsisspringbootfullstack.services;


import com.test.modelsisspringbootfullstack.dto.UtilisateurDTO;
import com.test.modelsisspringbootfullstack.entities.Role;
import com.test.modelsisspringbootfullstack.entities.Utilisateur;

public interface AccountService
{
    public Utilisateur saveUser(String username, String password, String confirmedPassword);
    public Utilisateur saveUtilisateur(UtilisateurDTO utilisateurDTO);
    public Role saveRole(Role role);
    public Utilisateur loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
}
