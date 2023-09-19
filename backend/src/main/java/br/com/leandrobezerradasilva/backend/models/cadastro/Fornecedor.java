package br.com.leandrobezerradasilva.backend.models.cadastro;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fornecedor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Preencha corretamente o campo Nome.")
    @Size(min = 3, max = 50, message = "Deve ter no mínimo 3 e no máximo 50 caracteres.")
    @Column(length = 50, nullable = false)
    private String nome;

    @NotBlank(message = "Preencha corretamente o campo Razão Social.")
    @Size(min = 3, max = 150, message = "Deve ter no mínimo 3 e no máximo 150 caracteres.")
    @Column(length = 150, nullable = false, unique = true)
    private String razao_social;

    @NotNull(message = "Preencha corretamente o campo CNPJ.")
    @Min(14)
    @Max(15)
    @Column(length = 15, nullable = false, unique = true)
    private Long cnpj;

    @NotBlank(message = "Preencha corretamente o campo E-mail.")
    @Email(message = "Preencha com um E-mail válido.")
    @Size(min = 10, max = 150, message = "Deve ter no mínimo 3 e no máximo 150 caracteres.")
    @Column(length = 150, nullable = false)
    private String email;

    @Email(message = "Preencha com um E-mail válido.")
    @Max(150)
    private String email2;

    @NotNull(message = "Preencha corretamente o campo telefone.")
    @Min(14)
    @Max(15)
    @Column(length = 14, nullable = false)
    private Long telefone;

    @Column(length = 14)
    private Long telefone2;

    @NotNull(message = "Preencha corretamente o campo Celular.")
    @Min(14)
    @Max(15)
    @Column(length = 15, nullable = false)
    private Long celuar;

    @NotNull(message = "Preencha corretamente o campo número de WhatsApp.")
    @Min(14)
    @Max(15)
    @Column(length = 15, nullable = false)
    private Long whatsapp;

    @NotNull(message = "Preencha corretamente o campo CEP.")
    @Min(8)
    @Max(9)
    @Column(length = 9, nullable = false)
    private Long cep;

    @NotBlank(message = "Preencha corretamente o campo Logradouro.")
    @Size(min = 3, max = 80, message = "Deve ter no mínimo 3 e no máximo 80 caracteres.")
    @Column(length = 80, nullable = false)
    private String logradouro;

    @NotNull(message = "Preencha corretamente o campo número de Residencia.")
    @Max(6)
    @Column(length = 6, nullable = false)
    private Integer numero = 0;

    private String complemento;

    @NotBlank(message = "Preencha corretamente o campo Bairro.")
    @Size(min = 3, max = 100, message = "Deve ter no mínimo 3 e no máximo 100 caracteres.")
    @Column(length = 100, nullable = false)
    private String bairro;

    @NotBlank(message = "Preencha corretamente o campo Cidade.")
    @Size(min = 3, max = 50, message = "Deve ter no mínimo 3 e no máximo 50 caracteres.")
    @Column(length = 50, nullable = false)
    private String cidade;

    @NotBlank(message = "Preencha corretamente o campo Estado.")
    @Size(min = 3, max = 50, message = "Deve ter no mínimo 3 e no máximo 50 caracteres.")
    @Column(length = 50, nullable = false)
    private String estado;

    @NotBlank(message = "Preencha corretamente o campo País.")
    @Size(min = 3, max = 50, message = "Deve ter no mínimo 3 e no máximo 50 caracteres.")
    @Column(length = 50, nullable = false)
    private String pais;
}
