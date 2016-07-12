package br.ufc.jornal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity(name="comentario")
public class Comentario {
	
	@Column(insertable=false, 
			updatable=false,
			nullable=false)
	private Long id_noticia;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_noticia", 
	referencedColumnName="id")
	private Noticia noticia;
	
	
	@Column(insertable=false, 
			updatable=false,
			nullable=false)
	private Long id_usuario;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_usuario", 
	referencedColumnName="id")
	private Usuario usuario;
		
	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Lob
	private String texto;
	
	private boolean ativo;
	
	public Long getId_noticia() {
		return id_noticia;
	}
	public void setId_noticia(Long id_noticia) {
		this.id_noticia = id_noticia;
	}
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
