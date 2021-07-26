package com.brewer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "cerveja")
public class Cerveja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	// @SKU
	@NotBlank
	private String sku;

	@NotBlank
	private String nome;

	@NotBlank
	@Size(max = 250)
	private String descricao;

	@NotNull
	@DecimalMin(value = "0.50")
	@DecimalMax(value = "9999999.99")
	private BigDecimal valor;

	@NotNull
	@DecimalMax(value = "100.0")
	@Column(name = "teor_alcoolico")
	private BigDecimal teorAlcoolico;

	@NotNull
	@DecimalMax(value = "100.0")
	private BigDecimal comissao;

	@NotNull
	@Max(value = 9999)
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Origem origem;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Sabor sabor;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;

	private String foto;

	@Column(name = "content_type")
	private String contentType;

	@Transient
	private boolean novaFoto;

	@PrePersist
	@PreUpdate
	private void prePersistUpdate() {
		sku = sku.toUpperCase();

	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public boolean isNovaFoto() {
		return novaFoto;
	}

	public void setNovaFoto(boolean novaFoto) {
		this.novaFoto = novaFoto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((comissao == null) ? 0 : comissao.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estilo == null) ? 0 : estilo.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (novaFoto ? 1231 : 1237);
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + ((quantidadeEstoque == null) ? 0 : quantidadeEstoque.hashCode());
		result = prime * result + ((sabor == null) ? 0 : sabor.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + ((teorAlcoolico == null) ? 0 : teorAlcoolico.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (comissao == null) {
			if (other.comissao != null)
				return false;
		} else if (!comissao.equals(other.comissao))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estilo == null) {
			if (other.estilo != null)
				return false;
		} else if (!estilo.equals(other.estilo))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (novaFoto != other.novaFoto)
			return false;
		if (origem != other.origem)
			return false;
		if (quantidadeEstoque == null) {
			if (other.quantidadeEstoque != null)
				return false;
		} else if (!quantidadeEstoque.equals(other.quantidadeEstoque))
			return false;
		if (sabor != other.sabor)
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (teorAlcoolico == null) {
			if (other.teorAlcoolico != null)
				return false;
		} else if (!teorAlcoolico.equals(other.teorAlcoolico))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cerveja [codigo=" + codigo + ", sku=" + sku + ", nome=" + nome + ", descricao=" + descricao + ", valor="
				+ valor + ", teorAlcoolico=" + teorAlcoolico + ", comissao=" + comissao + ", quantidadeEstoque="
				+ quantidadeEstoque + ", origem=" + origem + ", sabor=" + sabor + ", estilo=" + estilo + ", foto="
				+ foto + ", contentType=" + contentType + ", novaFoto=" + novaFoto + "]";
	}
}
