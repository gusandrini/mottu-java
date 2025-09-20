package br.com.fiap.projeto_mottu.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.projeto_mottu.model.Funcionario;
import br.com.fiap.projeto_mottu.repository.FuncionarioRepository;

@Service
public class FuncionarioUserDetailsService implements UserDetailsService {
    private final FuncionarioRepository repo;

    public FuncionarioUserDetailsService(FuncionarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Funcionario f = repo.findByEmailCorporativo(email)
                .orElseThrow(() -> new UsernameNotFoundException("Funcionário não encontrado"));

        String role = "ROLE_USER";
        if (f.getCargo() != null && f.getCargo().trim().equalsIgnoreCase("ADMIN")) {
            role = "ROLE_ADMIN";
        }
        return new User(f.getEmailCorporativo(), f.getSenhaHash(),
                List.of(new SimpleGrantedAuthority(role)));
    }
}
