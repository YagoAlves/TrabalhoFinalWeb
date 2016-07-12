package br.ufc.jornal.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity(name="secao")
public class Secao {
	
	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titulo;
	@Lob
	private String descricao;
	private boolean ativo;
	
	@OneToMany(mappedBy="secao",
			   targetEntity=Noticia.class,
			   fetch = FetchType.EAGER)
	private Collection<Noticia> noticias;
	
	public Collection<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
