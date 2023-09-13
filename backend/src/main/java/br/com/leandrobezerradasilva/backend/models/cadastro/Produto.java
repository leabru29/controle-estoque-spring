package br.com.leandrobezerradasilva.backend.models.cadastro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private Long codigo;

    @Column(length = 100, nullable = false, unique = true)
    private String nome;

    @Column(length = 10, nullable = false)
    private Double preco;

    @Column(length = 6, nullable = false)
    private Integer quantidade_estoque;

    @Column(nullable = false)
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    private GrupoProduto grupoProduto;

    @ManyToOne
    @JoinColumn(name = "id_lc_arz", nullable = false)
    private LocalArmazenamento localArmazenamento;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private MarcaProduto marcaProduto;

    @ManyToOne
    @JoinColumn(name = "id_un_med", nullable = false)
    private UnidadeMedida unidadeMedida;
}
