package br.com.fiap.projeto_mottu.security;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHashTester {

    private final PasswordEncoder encoder;

    public PasswordHashTester(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @PostConstruct
    public void testHash() {
        String hash = "$2a$10$Dow1Zz92H1x4Myqx1zUCeO7rCV5j3c7r.YZozwOKpYF7M4v8Axq.G";
        boolean matches = encoder.matches("123456", hash);
        System.out.println("➡️ Testando senha: '123456' bate com hash no banco? " + matches);
    }
}
