package com.studydays.studydays.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studydays.studydays.model.Jogo;
import com.studydays.studydays.repository.JogoRepository;
import com.studydays.studydays.repository.UsuarioRepository;

@RestController 
@RequestMapping("/jogo")
public class JogoController {
    private final JogoRepository repository;
    private final UsuarioRepository usuariorepository;

    public JogoController(JogoRepository repository, UsuarioRepository usuariorepository){
        this.repository = repository;
        this.usuariorepository = usuariorepository;
    }

    @PostMapping("/cadastrarJogo")
    public ResponseEntity<Jogo> cadastrarJogo(@RequestBody Jogo jogo){
        jogo.setId(null);
        Jogo salvo = repository.save(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{usuarioID}/jogo/{jogoID}")
    public ResponseEntity<Jogo> adicionarJogador(
        @PathVariable Long usuarioID,
        @PathVariable Long jogoID){
            
        var jogador = usuariorepository.findById(usuarioID);
        var jogo = repository.findById(jogoID);

        if(jogador.isEmpty() || jogo.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        jogo.get().setJogador(jogador.get());

        Jogo atualizado = repository.save(jogo.get());
        return ResponseEntity.ok(atualizado);
    }
}
