package br.ufc.jornal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	private String texto;
	
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
	
}
