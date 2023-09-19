package br.com.leandrobezerradasilva.backend.models.cadastro;

import java.util.UUID;

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
@Table(name = "local_armazenamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LocalArmazenamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "O campo Nome do Local deve ser Preenchido corretamente.")
    @Size(min = 3, max = 80, message = "O campo Nome do Local deve ter no mínimo 3 e no máximo 80 caracteres.")
    @Column(length = 80, nullable = false)
    private String nome_local;

    @NotNull(message = "O campo Ativo não deve ser Nulo.")
    @Column(nullable = false)
    private Boolean ativo = true;
}
