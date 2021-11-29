package br.com.bluebank.squad3.models;


import javax.persistence.CascadeType;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "login", uniqueConstraints = { @UniqueConstraint(columnNames = {"email","id_cliente"})})
public class Login {

	@Id
	@Column(name = "id_login")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_login;

	@NotNull(message = "Email não pode ser nulo e nem vazio")
	@Email
	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;

	@NotNull(message = "Senha não pode ser nula e nem vazia")
	@Column(name = "senha")
	private String senha;
	
	@NotNull(message = "O cliente deve estar cadastrado")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente", unique = true, nullable = false)
	private Cliente cliente;

	public Long getId_login() {
		return id_login;
	}

	public void setId_login(Long id_login) {
		this.id_login = id_login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente id_cliente) {
		this.cliente = id_cliente;
	}
//sera se pode comentar isso aqui
//	public Login(Long id_login, @NotNull(message = "Email não pode ser nulo e nem vazio") String email,
//			@NotNull(message = "Senha não pode ser nula e nem vazia") String senha) {
//		super();
//		this.id_login = id_login;
//		this.email = email;
//		this.senha = senha;
//	}
//
//	public Login() {
//
//	}

}
