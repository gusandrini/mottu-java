package br.com.fiap.projeto_mottu.control;

import br.com.fiap.projeto_mottu.dto.AuthResponse;
import br.com.fiap.projeto_mottu.dto.LoginRequest;
import br.com.fiap.projeto_mottu.model.Funcionario;
import br.com.fiap.projeto_mottu.repository.FuncionarioRepository;
import br.com.fiap.projeto_mottu.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final FuncionarioRepository repo;
    private final JwtService jwt;

    public AuthController(AuthenticationManager am, FuncionarioRepository r, JwtService j) {
        this.authManager = am;
        this.repo = r;
        this.jwt = j;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        try {
            // dispara autenticação pelo Spring Security
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.email(), req.password())
            );

            // busca funcionário no banco
            Funcionario f = repo.findByEmailCorporativo(req.email())
                    .orElseThrow(() -> new UsernameNotFoundException("Funcionário não encontrado"));

            // gera token
            String token = jwt.generateToken(f.getEmailCorporativo());

            return ResponseEntity.ok(new AuthResponse(
                    token,
                    f.getId(),
                    f.getNome(),
                    f.getEmailCorporativo(),
                    f.getCargo()
            ));

        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Erro: Funcionário não encontrado -> " + req.email());
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Erro: Senha incorreta para o email " + req.email());
        } catch (Exception e) {
            e.printStackTrace(); // 👈 vai mostrar detalhes no console
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro inesperado: " + e.getMessage());
        }
    }
}
