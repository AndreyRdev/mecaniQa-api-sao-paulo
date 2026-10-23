package br.com.mecaniQA.api.controller;

import br.com.mecaniQA.api.service.PecasService;
import br.com.mecaniQA.api.model.Pecas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pecas")
public class pecasController {
    private final PecasService pecasRepository;
    public pecasController(PecasService service) { this.pecasRepository = service; }

    @GetMapping
    public ResponseEntity<List<Pecas>>listarTodas(){
        return ResponseEntity.ok().body(pecasRepository.listarTodas());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Pecas> cadastrarPeca(@RequestBody Pecas pecas){
        System.out.println(pecas.getNome()+" "+pecas.getFornecedorMarca());
        Pecas novaPeca =  pecasRepository.cadastrar(pecas);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPeca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pecas> deletarPeca(@PathVariable Long id){
        Pecas pecas = pecasRepository.deletarPeca(id);
        if(pecas==null){
            return ResponseEntity.notFound().build();
        }
        return   ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pecas> buscarPorCodigo(@PathVariable Long id){
        Pecas peca =pecasRepository.buscarPorCodigo(id);
        if(peca==null){
            return   ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(peca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pecas>alterarPeca(@PathVariable Long id,@RequestBody Pecas pecas ){
        Pecas pecas1 = pecasRepository.atualizar(id, pecas);
        if(pecas1==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
