package br.com.fiap.projeto_mottu.service;

import br.com.fiap.projeto_mottu.dto.FuncionarioDTO;
import br.com.fiap.projeto_mottu.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioCachingService cacheFunc;

	@Transactional(readOnly = true)
	public Page<FuncionarioDTO> paginar(PageRequest req) {
		Page<Funcionario> funcionarios = cacheFunc.findAll(req);
		return funcionarios.map(FuncionarioDTO::new);
	}
}
