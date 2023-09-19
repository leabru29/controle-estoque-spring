package br.com.leandrobezerradasilva.backend.models.cadastro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "O campo Código deve estar preenchido e ter no mínimo 5 e no máximo 6 caracteres.")
    @Column(length = 20, nullable = false, unique = true)
    private Long codigo;

    @NotBlank(message = "O campo nome deve ser Preenchido.")
    @Size(min = 3, max = 100, message = "O campo deve ter no mínimo 3 e no máximo 100 caracteres.")
    @Column(length = 100, nullable = false, unique = true)
    private String nome;

    @NotNull(message = "O campo Preço deve ser preenchido.")
    @Column(length = 10, nullable = false)
    private Double preco;

    @NotNull(message = "O campo Quantidade deve ser preenchido.")
    @Column(length = 6, nullable = false)
    private Integer quantidade_estoque;

    @NotNull(message = "O campo Ativo deve ser preenchido.")
    @Column(nullable = false)
    private Boolean ativo = true;

    @NotNull(message = "O campo Fornecedor deve ser preenchido.")
    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    @NotNull(message = "O campo Grupo Produto deve ser preenchido.")
    @ManyToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    private GrupoProduto grupoProduto;

    @NotNull(message = "O campo Local de Armazenamento deve ser preenchido.")
    @ManyToOne
    @JoinColumn(name = "id_lc_arz", nullable = false)
    private LocalArmazenamento localArmazenamento;

    @NotNull(message = "O campo Marca de Produto deve ser preenchido.")
    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private MarcaProduto marcaProduto;

    @NotNull(message = "O campo Unidade de Medida deve ser preenchido.")
    @ManyToOne
    @JoinColumn(name = "id_un_med", nullable = false)
    private UnidadeMedida unidadeMedida;
}
