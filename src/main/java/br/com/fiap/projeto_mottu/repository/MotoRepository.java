package br.com.fiap.projeto_mottu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_mottu.model.Moto;
import br.com.fiap.projeto_mottu.projection.MotoProjection;

public interface MotoRepository extends JpaRepository<Moto, Long>{

	// Busca motos por situação
    @Query("SELECT m.nm_placa AS nmPlaca, " +
           "m.nm_modelo AS nmModelo, " +
           "m.st_moto AS stMoto, " +
           "m.cliente.nome AS clienteNome, " +
           "m.filial_departamento.nome AS filialDepartamentoNome " +
           "FROM Moto m WHERE m.st_moto = :situacao")
    List<MotoProjection> buscarPorSituacao(String situacao);
    
    // Busca moto por placa
    @Query("SELECT m FROM Moto m WHERE m.nm_placa = :placa")
    Optional<Moto> buscarPorPlaca(String placa);

    //Busca moto por nome da filial
    @Query("SELECT m.nm_placa AS nmPlaca, m.nm_modelo AS nmModelo, m.st_moto AS stMoto " +
            "FROM Moto m " +
            "WHERE m.filial_departamento.filial.nome_filial = :nomeFilial")
     List<MotoProjection> buscarMotosPorNomeDaFilial(String nomeFilial);
}
