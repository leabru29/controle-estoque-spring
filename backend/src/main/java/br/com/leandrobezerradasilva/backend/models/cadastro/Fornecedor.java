package br.com.leandrobezerradasilva.backend.models.cadastro;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String razao_social;

    @Column(length = 15, nullable = false, unique = true)
    private Long cnpj;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String email2;

    @Column(length = 14, nullable = false)
    private Long telefone;

    @Column(length = 14, nullable = false)
    private Long telefone2;

    @Column(length = 15, nullable = false)
    private Long celuar;

    @Column(length = 15, nullable = false)
    private Long whatsapp;

    @Column(length = 9, nullable = false)
    private Long cep;

    @Column(length = 80, nullable = false)
    private String logradouro;

    @Column(length = 6, nullable = false)
    private Integer numero = 0;

    private String complemento;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 50, nullable = false)
    private String cidade;

    @Column(length = 50, nullable = false)
    private String estado;

    @Column(length = 50, nullable = false)
    private String pais;
}
