package br.com.fiap.projeto_mottu.control;

import br.com.fiap.projeto_mottu.dto.AuthResponse;
import br.com.fiap.projeto_mottu.dto.LoginRequest;
import br.com.fiap.projeto_mottu.model.Funcionario;
import br.com.fiap.projeto_mottu.repository.FuncionarioRepository;
import br.com.fiap.projeto_mottu.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final FuncionarioRepository repo;
    private final JwtService jwt;

    public AuthController(AuthenticationManager am, FuncionarioRepository r, JwtService j) {
        this.authManager = am; this.repo = r; this.jwt = j;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        var auth = new UsernamePasswordAuthenticationToken(req.email(), req.password());
        authManager.authenticate(auth);
        Funcionario f = repo.findByEmailCorporativo(req.email()).orElseThrow();
        String token = jwt.generateToken(f.getEmailCorporativo());
        return ResponseEntity.ok(new AuthResponse(token, f.getId(), f.getNome(), f.getEmailCorporativo(), f.getCargo()));
    }
}
