-- Pais
INSERT INTO pais (nm_pais) VALUES ('Brasil');
INSERT INTO pais (nm_pais) VALUES ('Argentina');
INSERT INTO pais (nm_pais) VALUES ('Chile');
INSERT INTO pais (nm_pais) VALUES ('Peru');
INSERT INTO pais (nm_pais) VALUES ('Uruguai');

-- Estado
INSERT INTO estado (nm_estado, id_pais) VALUES ('SP', 1);
INSERT INTO estado (nm_estado, id_pais) VALUES ('RJ', 1);
INSERT INTO estado (nm_estado, id_pais) VALUES ('BA', 1);
INSERT INTO estado (nm_estado, id_pais) VALUES ('MG', 1);
INSERT INTO estado (nm_estado, id_pais) VALUES ('RS', 1);

-- Cidade
INSERT INTO cidade (nm_cidade, id_estado) VALUES ('São Paulo', 1);
INSERT INTO cidade (nm_cidade, id_estado) VALUES ('Rio de Janeiro', 2);
INSERT INTO cidade (nm_cidade, id_estado) VALUES ('Salvador', 3);
INSERT INTO cidade (nm_cidade, id_estado) VALUES ('Belo Horizonte', 4);
INSERT INTO cidade (nm_cidade, id_estado) VALUES ('Porto Alegre', 5);

-- Bairro
INSERT INTO bairro (nm_bairro, id_cidade) VALUES ('Centro', 1);
INSERT INTO bairro (nm_bairro, id_cidade) VALUES ('Jardins', 1);
INSERT INTO bairro (nm_bairro, id_cidade) VALUES ('Copacabana', 2);
INSERT INTO bairro (nm_bairro, id_cidade) VALUES ('Pituba', 3);
INSERT INTO bairro (nm_bairro, id_cidade) VALUES ('Savassi', 4);

-- Logradouro
INSERT INTO logradouro (nm_logradouro, nr_logradouro, nm_complemento, id_bairro) VALUES ('Rua A', 100, 'Apto 1', 1);
INSERT INTO logradouro (nm_logradouro, nr_logradouro, nm_complemento, id_bairro) VALUES ('Av. Paulista', 1500, 'Conj. 5', 2);
INSERT INTO logradouro (nm_logradouro, nr_logradouro, nm_complemento, id_bairro) VALUES ('Rua Atlântica', 200, NULL, 3);
INSERT INTO logradouro (nm_logradouro, nr_logradouro, nm_complemento, id_bairro) VALUES ('Rua Bahia', 50, 'Casa', 4);
INSERT INTO logradouro (nm_logradouro, nr_logradouro, nm_complemento, id_bairro) VALUES ('Av. Cristóvão Colombo', 3000, NULL, 5);

-- Filial
INSERT INTO filial (nm_filial, id_logradouro) VALUES ('Filial Centro', 1);
INSERT INTO filial (nm_filial, id_logradouro) VALUES ('Filial Jardins', 2);
INSERT INTO filial (nm_filial, id_logradouro) VALUES ('Filial Copacabana', 3);
INSERT INTO filial (nm_filial, id_logradouro) VALUES ('Filial Pituba', 4);
INSERT INTO filial (nm_filial, id_logradouro) VALUES ('Filial Savassi', 5);

-- Departamento
INSERT INTO departamento (nm_departamento, ds_departamento) VALUES ('Logística', 'Departamento responsável pela logística da empresa');
INSERT INTO departamento (nm_departamento, ds_departamento) VALUES ('RH', 'Departamento de Recursos Humanos');
INSERT INTO departamento (nm_departamento, ds_departamento) VALUES ('Financeiro', 'Departamento de controle financeiro');
INSERT INTO departamento (nm_departamento, ds_departamento) VALUES ('TI', 'Departamento de tecnologia da informação');
INSERT INTO departamento (nm_departamento, ds_departamento) VALUES ('Comercial', 'Departamento de vendas e atendimento');

-- FilialDepartamento
INSERT INTO filial_departamento (id_filial, id_departamento, dt_entrada, dt_saida) VALUES (1, 1, '2023-01-01', NULL);
INSERT INTO filial_departamento (id_filial, id_departamento, dt_entrada, dt_saida) VALUES (2, 2, '2023-02-01', NULL);
INSERT INTO filial_departamento (id_filial, id_departamento, dt_entrada, dt_saida) VALUES (3, 3, '2023-03-01', NULL);
INSERT INTO filial_departamento (id_filial, id_departamento, dt_entrada, dt_saida) VALUES (4, 4, '2023-04-01', NULL);
INSERT INTO filial_departamento (id_filial, id_departamento, dt_entrada, dt_saida) VALUES (5, 5, '2023-05-01', NULL);

-- Cliente
INSERT INTO cliente (nm_cliente, nr_cpf, nm_email, id_logradouro) VALUES ('João Silva', '12345678901', 'joao@email.com', 1);
INSERT INTO cliente (nm_cliente, nr_cpf, nm_email, id_logradouro) VALUES ('Maria Souza', '23456789012', 'maria@email.com', 2);
INSERT INTO cliente (nm_cliente, nr_cpf, nm_email, id_logradouro) VALUES ('Carlos Lima', '34567890123', 'carlos@email.com', 3);
INSERT INTO cliente (nm_cliente, nr_cpf, nm_email, id_logradouro) VALUES ('Ana Costa', '45678901234', 'ana@email.com', 4);
INSERT INTO cliente (nm_cliente, nr_cpf, nm_email, id_logradouro) VALUES ('Lucas Rocha', '56789012345', 'lucas@email.com', 5);

-- Telefone
INSERT INTO telefone (nr_telefone, nr_ddi, nr_ddd, id_cliente) VALUES ('912345678', '+55', '11', 1);
INSERT INTO telefone (nr_telefone, nr_ddi, nr_ddd, id_cliente) VALUES ('998877665', '+55', '21', 2);
INSERT INTO telefone (nr_telefone, nr_ddi, nr_ddd, id_cliente) VALUES ('987654321', '+55', '31', 3);
INSERT INTO telefone (nr_telefone, nr_ddi, nr_ddd, id_cliente) VALUES ('977112233', '+55', '71', 4);
INSERT INTO telefone (nr_telefone, nr_ddi, nr_ddd, id_cliente) VALUES ('966554433', '+55', '51', 5);

-- Moto
INSERT INTO moto (nm_placa, nm_modelo, st_moto, km_rodado, id_cliente, id_filial_departamento) VALUES ('ABC1234', 'SPORT', 'FUNCIONANDO', 1200.5, 1, 1);
INSERT INTO moto (nm_placa, nm_modelo, st_moto, km_rodado, id_cliente, id_filial_departamento) VALUES ('DEF5678', 'E', 'MANUTENCAO', 800.0, 2, 2);
INSERT INTO moto (nm_placa, nm_modelo, st_moto, km_rodado, id_cliente, id_filial_departamento) VALUES ('GHI9012', 'POP', 'PATIO', 3000.8, 3, 3);
INSERT INTO moto (nm_placa, nm_modelo, st_moto, km_rodado, id_cliente, id_filial_departamento) VALUES ('JKL3456', 'SPORT', 'FUNCIONANDO', 150.3, 4, 4);
INSERT INTO moto (nm_placa, nm_modelo, st_moto, km_rodado, id_cliente, id_filial_departamento) VALUES ('MNO7890', 'E', 'MANUTENCAO', 2200.0, 5, 5);

-- Manutencao
INSERT INTO manutencao (id_moto, dt_entrada, dt_saida, ds_manutencao) VALUES (1, '2024-01-01', '2024-01-05', 'Troca de óleo e revisão geral');
INSERT INTO manutencao (id_moto, dt_entrada, dt_saida, ds_manutencao) VALUES (2, '2024-02-10', '2024-02-15', 'Troca de pneu traseiro');
INSERT INTO manutencao (id_moto, dt_entrada, dt_saida, ds_manutencao) VALUES (3, '2024-03-20', NULL, 'Correção elétrica');
INSERT INTO manutencao (id_moto, dt_entrada, dt_saida, ds_manutencao) VALUES (4, '2024-04-12', '2024-04-14', 'Alinhamento e balanceamento');
INSERT INTO manutencao (id_moto, dt_entrada, dt_saida, ds_manutencao) VALUES (5, '2024-05-01', NULL, 'Troca de pastilha de freio');

-- Funcionario
INSERT INTO funcionario (nm_funcionario, nm_email_corporativo, nm_senha, nm_cargo, id_filial) VALUES ('Carlos Silva', 'carlos.silva@empresa.com', '$2a$12$GIvYJh.SCMRj6446O7nUNODzXLWYPLeldObZGb8q.nTwoNEEj1.S6', 'GERENTE', 1);
INSERT INTO funcionario (nm_funcionario, nm_email_corporativo, nm_senha, nm_cargo, id_filial) VALUES ('Fernanda Costa', 'fernanda.costa@empresa.com', '$2a$12$GIvYJh.SCMRj6446O7nUNODzXLWYPLeldObZGb8q.nTwoNEEj1.S6', 'ANALISTA', 2);
INSERT INTO funcionario (nm_funcionario, nm_email_corporativo, nm_senha, nm_cargo, id_filial) VALUES ('João Pereira', 'joao.pereira@empresa.com', '$2a$12$GIvYJh.SCMRj6446O7nUNODzXLWYPLeldObZGb8q.nTwoNEEj1.S6', 'ADMIN', 3);
INSERT INTO funcionario (nm_funcionario, nm_email_corporativo, nm_senha, nm_cargo, id_filial) VALUES ('Mariana Oliveira', 'mariana.oliveira@empresa.com', '$2a$12$GIvYJh.SCMRj6446O7nUNODzXLWYPLeldObZGb8q.nTwoNEEj1.S6', 'SUPORTE', 4);
INSERT INTO funcionario (nm_funcionario, nm_email_corporativo, nm_senha, nm_cargo, id_filial) VALUES ('Roberto Souza', 'roberto.souza@empresa.com', '$2a$12$GIvYJh.SCMRj6446O7nUNODzXLWYPLeldObZGb8q.nTwoNEEj1.S6', 'FINANCEIRO', 5);




