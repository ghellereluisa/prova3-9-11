package com.prova4.prova.controller;


import com.prova4.prova.model.Contatos;
import com.prova4.prova.service.ContatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contatos")
public class ContatosController {

    @Autowired
    private ContatosService cServ;

    @GetMapping
    public List<Contatos> listContatos (){
        return cServ.listContatos();
    }

    @PostMapping
    public ResponseEntity<Contatos> registerContatos (@RequestBody Contatos contatos){
        contatos = cServ.registerContatos(contatos);
        return ResponseEntity.ok().body(contatos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Contatos> findContatoById(@PathVariable Long id){
        Contatos obj = cServ.findContatoById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Contatos> alterContatos(@RequestBody Contatos contatos, @PathVariable Long id){
        contatos = cServ.alterContatos(id, contatos);
        return ResponseEntity.ok().body(contatos);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<void> deleteContatos(@PathVariable Long id){
        cServ.deleteContatos(id);
        return ResponseEntity.noContent().build();
    }

}
























