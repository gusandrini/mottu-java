package br.com.fiap.projeto_mottu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_mottu.model.Bairro;
import br.com.fiap.projeto_mottu.projection.BairroProjection;

import java.util.List;

public interface BairroRepository extends JpaRepository<Bairro, Long>{

	// Busca bairros por cidade
    @Query("select b.nm_bairro as nm_bairro, b.cidade.nm_cidade as cidadeNome from Bairro b where b.cidade.id_cidade = :idCidade")
    List<BairroProjection> findByCidade(Long idCidade);

	// Busca só nome do bairro + nome da cidade
    @Query("select b.nm_bairro as nm_bairro, b.cidade.nm_cidade as cidadeNome from Bairro b")
    List<BairroProjection> listarBairrosComNomeDeCidade();
}

