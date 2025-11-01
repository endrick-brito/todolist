package com.suacasarendemais.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suacasarendemais.todolist.entity.Tarefa;
import com.suacasarendemais.todolist.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService; 

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll(){
        List<Tarefa> tarefas = tarefaService.findAll();
        return ResponseEntity.ok().body(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findById(Long id){
        Tarefa tarefa = tarefaService.findById(id);
        return ResponseEntity.ok().body(tarefa);
    }

    @PostMapping
    public ResponseEntity<Tarefa> insertNew(@RequestBody Tarefa tarefa){
        Tarefa novaTarefa = tarefaService.insertNew(tarefa);
        return ResponseEntity.ok().body(novaTarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(Long id, @RequestBody Tarefa tarefaAtualizada){
        Tarefa tarefa = tarefaService.update(id, tarefaAtualizada);
        return ResponseEntity.ok().body(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(Long id){
        Boolean flag = tarefaService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
