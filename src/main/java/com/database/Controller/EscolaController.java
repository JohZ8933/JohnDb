package com.database.Controller;


import com.database.Entity.Escola;
import com.database.Repository.EscolaRepository;
import com.database.dto.EscolaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
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
    //E enviar com LocalDate atrasado em relação ao now()
    @PostMapping("/realizar")
    public ResponseEntity<Escola> enviar(@RequestBody Escola escola) {
    //O que não faz sentido. E então...



        if (!escola.isEstaPresente() || escola.getTempoComeco().isBefore(LocalTime.now())) {

            //Se tentar submeter com false, o sistema barra
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(escola);



        }
        //Se tiver tudo certo...
        Escola salvo = escolaRepository.save(escola);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);

    }

    @GetMapping("/Dados")
    public ResponseEntity<List<Escola>> verTodos() {

        //Retorna todo mundo mesmo os que nao concluiram
        return ResponseEntity.ok(escolaRepository.findAll());
    }

    //Aqui filtra por quem ainda não terminou a prova
    @GetMapping("/pendencias")
    public ResponseEntity<List<EscolaResponse>> encontrarAusencia() {

        List<EscolaResponse> listaPendencias = escolaRepository.findByProvaCompletaFalse();
        return ResponseEntity.ok(listaPendencias);
    }




}
