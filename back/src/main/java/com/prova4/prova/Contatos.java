package com.prova4.prova;

import javax.persistence.*;

@Entity
public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String number;
    






}
