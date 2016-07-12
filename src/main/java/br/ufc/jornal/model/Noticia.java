package br.ufc.jornal.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="noticia")
public class Noticia {
	
	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Lob
	private String titulo;
	@Lob
	private String subtitulo;
	@Lob
	private String texto;
	private Calendar data_noticia;
	private boolean ativo;
	private String caminho;
	
	@OneToMany(mappedBy="comentarios",
			   targetEntity=Noticia.class,
			   fetch = FetchType.EAGER)
	private List<Comentario> comentarios;		
	
	@Column(insertable=false, 
			updatable=false,
			nullable=false)
	private Long id_secao;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_secao", 
	referencedColumnName="id")
	private Secao secao;
	
	@Column(insertable=false, 
			updatable=false,
			nullable=false)
	private Long id_usuario;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_usuario", 
	referencedColumnName="id")
	private Usuario usuario;	
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
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
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Long getId_secao() {
		return id_secao;
	}
	public void setId_secao(Long id_secao) {
		this.id_secao = id_secao;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public Secao getSecao() {
		return secao;
	}
	public void setSecao(Secao secao) {
		this.secao = secao;
	}
	public Calendar getData_noticia() {
		return data_noticia;
	}
	public void setData_noticia(Calendar data_noticia) {
		this.data_noticia = data_noticia;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
