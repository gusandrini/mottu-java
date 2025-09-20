package br.com.fiap.projeto_mottu.dto;

public record AuthResponse(String token, Long idFuncionario, String nome, String email, String cargo) {}
