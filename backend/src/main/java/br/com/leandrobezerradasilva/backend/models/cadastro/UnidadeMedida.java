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
@Table(name = "un_med")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UnidadeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome da Unidade deve ser preenchido.")
    @Size(min = 3, max = 20, message = "O campo deve ter no mínimo 3 caracteres e no máximo 20.")
    @Column(length = 20, unique = true, nullable = false)
    private String nome_unidade;

    @NotBlank(message = "O Nome da Unidade deve ser preenchido.")
    @Column(length = 2, unique = true, nullable = false)
    @Size(min = 3, max = 20, message = "O campo deve ter no mínimo 3 caracteres e no máximo 20.")
    private String sigla;

    @NotNull(message = "O campo Ativo deve estar preenchido.")
    @Column(nullable = false)
    private Boolean ativo = true;
}
