package com.example.ForumHub.repository;
import com.example.ForumHub.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;




public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Topico findByTituloAndMensagem(String titulo, String mensagem);
}
