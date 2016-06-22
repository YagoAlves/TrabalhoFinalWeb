package br.ufc.jornal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="classificado")
public class Classificado {
	
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
	private String titulo;
	private String texto; 
	private float preco;
	private String telefone;
	private float melhor_oferta;
	private Date data_oferta;
	
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public float getMelhor_oferta() {
		return melhor_oferta;
	}
	public void setMelhor_oferta(float melhor_oferta) {
		this.melhor_oferta = melhor_oferta;
	}
	public Date getData_oferta() {
		return data_oferta;
	}
	public void setData_oferta(Date data_oferta) {
		this.data_oferta = data_oferta;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof Classificado))
			return false;
		
		Classificado ref = (Classificado)obj;
		if(ref.getId()==this.id)
			return true;
		return false;
	}
}
