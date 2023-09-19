package br.com.leandrobezerradasilva.backend.models.cadastro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "marca_produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MarcaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha o campo Marca")
    @Size(min = 3, max = 50, message = "O campo Marca deve ter no mínimo 3 e no máximo 50 caracteres.")
    @Column(length = 50, nullable = false)
    private String marca;

    @Column(nullable = false)
    @NotNull(message = "O campo Ativo deve estar preenchido.")
    private Boolean ativo = true;
}
