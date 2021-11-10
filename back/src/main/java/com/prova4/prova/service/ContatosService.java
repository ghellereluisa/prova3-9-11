package com.prova4.prova.service;


import com.prova4.prova.model.Contatos;
import com.prova4.prova.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatosService {

    @Autowired
    private ContatosRepository cRep;

    public List<Contatos> listContatos () {
        return cRep.findAll();
    }

    public Contatos findContatoById(Long id){
        Optional<Contatos> obj = cRep.findById(id);
        return obj.get();
    }

    public Contatos registerContatos (Contatos contatos){
        return cRep.save(contatos);
    }

    public void deleteContatos (Long id){
        cRep.deleteById(id);
    }

    public Contatos alterContatos (Long id, Contatos contatos){
        Contatos entity = cRep.getOne(id);
        updateData(entity, contatos);
        return cRep.save(entity);
    }

    private void updateData(Contatos entity, Contatos obj) {
        entity.setName(obj.getName());
        entity.getEmail(obj.getEmail());
        entity.getNumber(obj.getNumber());
    }


}
