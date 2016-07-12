package br.ufc.jornal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="usuario")
public class Usuario {
	
	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private String caminho;
	
	@OneToMany(mappedBy="classificados",
			   targetEntity=Usuario.class,
			   fetch = FetchType.EAGER)
	private List<Classificado> classificados;
	
	@OneToMany(mappedBy="noticias",
			   targetEntity=Usuario.class,
			   fetch = FetchType.EAGER)
	private List<Noticia> noticias;
	
	@OneToMany(mappedBy="comentarios",
			   targetEntity=Usuario.class,
			   fetch = FetchType.EAGER)
	private List<Comentario> comentarios;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuario_papel",
		joinColumns=@JoinColumn(name="id_usuario",
								referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="id_papel",
									   referencedColumnName="id")
			  )
	private List<Papel> papeis;
	
	public List<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public List<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Classificado> getClassificados() {
		return classificados;
	}
	public void setClassificados(List<Classificado> classificados) {
		this.classificados = classificados;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
	
}
