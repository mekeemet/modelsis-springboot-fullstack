package com.test.modelsisspringbootfullstack.services;

import com.test.modelsisspringbootfullstack.dao.*;

import com.test.modelsisspringbootfullstack.dto.UtilisateurDTO;
import com.test.modelsisspringbootfullstack.entities.Role;
import com.test.modelsisspringbootfullstack.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RoleRepository appRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Utilisateur saveUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setUsername(utilisateurDTO.getUsername());
        utilisateur.setPassword(bCryptPasswordEncoder.encode(utilisateurDTO.getPassword()));
        utilisateur.setActived(true);
        return utilisateurRepository.saveAndFlush(utilisateur);
    }

    @Override
    public Utilisateur saveUser(String username, String password, String confirmedPassword) {
        Utilisateur user = utilisateurRepository.findByUsername(username);
        if(user != null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("please confirm password");
        Utilisateur appUser = new Utilisateur();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        utilisateurRepository.save(appUser);
        addRoleToUser(username, "ADMIN");
        return appUser;
    }




    @Override
    public Role saveRole(Role role) {
        return appRoleRepository.save(role);
    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return utilisateurRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        Utilisateur appUser=utilisateurRepository.findByUsername(username);
        Role appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
    }


}
