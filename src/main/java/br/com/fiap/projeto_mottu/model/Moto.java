    package br.com.fiap.projeto_mottu.model;

    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Size;

    @Entity
    @Table(name = "moto")
    public class Moto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_moto")
        private Long idMoto;

        @ManyToOne
        @JoinColumn(name = "id_cliente", nullable = false)
        @NotNull(message = "A moto deve estar relacionada a um cliente!")
        private Cliente cliente;

        @Size(max = 10, message = "Valor da placa inválido")
        @Column(name = "nm_placa")
        private String nmPlaca;

        @NotNull(message = "Não é possível inserir uma moto sem seu modelo (Sport, E ou Pop)")
        @Enumerated(EnumType.STRING)
        @Column(name = "nm_modelo")
        private ModeloEnum nmModelo;

        @ManyToOne
        @JoinColumn(name = "id_filial_departamento", nullable = false)
        @NotNull(message = "A moto deve estar vinculada a uma filial departamento")
        private FilialDepartamento filialDepartamento;

        @NotNull(message = "Não é possível inserir uma moto sem sua situação/condição (Manutenção, Funcionamento ou Pátio)")
        @Enumerated(EnumType.STRING)
        @Column(name = "st_moto")
        private SituacaoEnum stMoto;

        @Column(name = "km_rodado")
        private Double kmRodado;

        // Getters e Setters manuais
        public Long getIdMoto() {
            return idMoto;
        }

        public void setIdMoto(Long idMoto) {
            this.idMoto = idMoto;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public String getNmPlaca() {
            return nmPlaca;
        }

        public void setNmPlaca(String nmPlaca) {
            this.nmPlaca = nmPlaca;
        }

        public ModeloEnum getNmModelo() {
            return nmModelo;
        }

        public void setNmModelo(ModeloEnum nmModelo) {
            this.nmModelo = nmModelo;
        }

        public FilialDepartamento getFilialDepartamento() {
            return filialDepartamento;
        }

        public void setFilialDepartamento(FilialDepartamento filialDepartamento) {
            this.filialDepartamento = filialDepartamento;
        }

        public SituacaoEnum getStMoto() {
            return stMoto;
        }

        public void setStMoto(SituacaoEnum stMoto) {
            this.stMoto = stMoto;
        }

        public Double getKmRodado() {
            return kmRodado;
        }

        public void setKmRodado(Double kmRodado) {
            this.kmRodado = kmRodado;
        }
    }
