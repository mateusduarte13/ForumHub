package com.example.ForumHub.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity(name = "Topico") // Define o nome da entidade
@Table(name = "topicos")  // Define o nome da tabela no banco de dados
@EqualsAndHashCode(of = "id")  // Gera os métodos equals() e hashCode() com base no id
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Título é obrigatório")
    private String titulo;

    @NotEmpty(message = "Mensagem é obrigatória")
    private String mensagem;

    @NotEmpty(message = "Autor é obrigatório")
    private String autor;

    @NotEmpty(message = "Curso é obrigatório")
    private String curso;

    private boolean estado; // Estado do tópico (aberto ou fechado)

    private LocalDateTime dataCriacao; // Agora é LocalDateTime, não mais String

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
