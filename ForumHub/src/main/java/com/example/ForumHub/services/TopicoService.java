package com.example.ForumHub.services;

import com.example.ForumHub.entities.Topico;
import com.example.ForumHub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    // Método para listar todos os tópicos
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();  // Retorna todos os tópicos
    }

    // Método para criar um tópico
    public Topico criarTopico(Topico topico) {
        return topicoRepository.save(topico);  // Salva o tópico no banco de dados
    }

    // Método para buscar um tópico por ID
    public Optional<Topico> buscarTopicoPorId(Long id) {
        return topicoRepository.findById(id);  // Retorna o tópico encontrado ou um Optional vazio se não encontrar
    }

    // Método para excluir um tópico
    public void excluirTopico(Long id) {
        topicoRepository.deleteById(id);  // Exclui o tópico do banco de dados
    }
}
