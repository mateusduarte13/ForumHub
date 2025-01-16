package com.example.ForumHub.services;

import com.example.ForumHub.entities.Usuario;
import com.example.ForumHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Método para criar um novo usuário
    public Usuario criarUsuario(Usuario usuario) {
        // Verifica se já existe um usuário com o e-mail fornecido
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Já existe um usuário com esse e-mail.");
        }

        // Criptografando a senha antes de salvar no banco de dados
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        // Salva o usuário no banco de dados
        return usuarioRepository.save(usuario);
    }
}
