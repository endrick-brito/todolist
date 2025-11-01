package com.suacasarendemais.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suacasarendemais.todolist.entity.Tarefa;
import com.suacasarendemais.todolist.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    /* Listar todas as tarefas */
    public List<Tarefa> findAll(){
        return tarefaRepository.findAll();
    }

    /* Buscar tarefa por id */
    public Tarefa findById(Long id){
        return tarefaRepository.findById(id).orElse(null);
    }
    
    /* Inserir nova tarefa */
    public Tarefa insertNew(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    /* Atualizar tarefa */
    public Tarefa update(Long id, Tarefa tarefaAtualizada){
        Tarefa tarefaExistente = findById(id);
        tarefaExistente.setNome(tarefaAtualizada.getNome());
        tarefaExistente.setConcluida(tarefaAtualizada.getConcluida());
        return tarefaRepository.save(tarefaExistente);
    }

    /* Deletar tarefa */
    public Boolean deleteById(Long id){
        Tarefa tarefaExistente = findById(id);
        if(tarefaExistente != null){
            tarefaRepository.delete(tarefaExistente);
            return true;
        }
        return false;
    }
}
