package com.database.Controller;


import com.database.Entity.Escola;
import com.database.Repository.EscolaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prova")
public class EscolaController {

    //Declararemos nosso repository
    private final EscolaRepository escolaRepository;
    public EscolaController(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }



    //No json, alguem pode tentar enviar a prova, so que com presença falsa
    @PostMapping("/realizar")
    public ResponseEntity<Escola> enviar(@RequestBody Escola escola) {
    //O que não faz sentido. E então...


        if (escola.isEstaPresente()) {
            Escola salvo = escolaRepository.save(escola);

            //Se tiver tudo certo...
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);

        }
        //Se tentar submeter com false, o sistema barra
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(escola);
    }

    @GetMapping("/Dados")
    public ResponseEntity<List<Escola>> verTodos() {

        //Retorna todo mundo mesmo os que nao concluiram
        return ResponseEntity.ok(escolaRepository.findAll());
    }

    //Aqui filtra por quem ainda não terminou a prova
    @GetMapping("/pendencias")
    public ResponseEntity<List<Escola>> encontrarAusencia() {


        return ResponseEntity.ok(escolaRepository.findByProvaCompletaFalse());
    }




}
