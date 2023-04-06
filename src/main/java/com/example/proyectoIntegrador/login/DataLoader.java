package com.example.proyectoIntegrador.login;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123");
        String password1 = passwordEncoder.encode("123");

        usuarioRepository.save(new Usuario("Joni","joni","joni@joni.com",password,UsuarioRol.ADMIN));
        usuarioRepository.save(new Usuario("Pame","pame","pame@pame.com",password1,UsuarioRol.USER));

    }
}
