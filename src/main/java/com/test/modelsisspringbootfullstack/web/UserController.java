package com.test.modelsisspringbootfullstack.web;
import com.test.modelsisspringbootfullstack.dao.UtilisateurRepository;
import com.test.modelsisspringbootfullstack.dto.UtilisateurDTO;
import com.test.modelsisspringbootfullstack.entities.SResponse;
import com.test.modelsisspringbootfullstack.services.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @PostMapping("register")
    public SResponse registerUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        SResponse response = new SResponse();
        if (!utilisateurDTO.getPassword().equals(utilisateurDTO.getConfirmPassword())) {
            response.setStatut(403);
            response.setDescription("Les mots de passe ne sont pas identique!!");
        } else if (accountService.loadUserByUsername(utilisateurDTO.getUsername()) == null) {
            try {
                accountService.saveUtilisateur(utilisateurDTO);
                response.setStatut(200);
                response.setDescription("Inscription réussie");
            } catch (Exception ex) {
                response.setStatut(500);
                response.setDescription("Inscription non réussie. Vérifier les informations saisies!");
            }
        } else {
            response.setStatut(500);
            response.setDescription("Le nom d'utilisateur est déjà attribué.");
        }
        return response;
    }


}

