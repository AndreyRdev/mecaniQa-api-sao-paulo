package br.com.mecaniQA.api.controller;

import br.com.mecaniQA.api.service.ServicosService;
import br.com.mecaniQA.api.model.Servicos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class servicosContoller {
    private final ServicosService servicosRepository;
    public servicosContoller(ServicosService service) { this.servicosRepository = service; }

    @GetMapping
    public List<Servicos> listarServicos(){
        return servicosRepository.listarTodos();
    }

    @PostMapping("/cadastar")
    public ResponseEntity<Servicos> cadastrarServico(@RequestBody Servicos servicos){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicosRepository.cadastrar(servicos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicos> atulizarServico(@PathVariable Long id,@RequestBody Servicos servicos){
        Servicos servicos1= servicosRepository.atualizar(id, servicos);
        if(servicos1==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servicos> deletarServico(@PathVariable Long id){
        Servicos servicos =servicosRepository.deletarServico(id);
        if(servicos==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
