package br.com.bluebank.squad3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.bluebank.squad3.models.Cliente;
import br.com.bluebank.squad3.models.Login;
import br.com.bluebank.squad3.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	public Login cadastrar(Login login) {

		login.setSenha(codificarSenha(login.getSenha()));

		return loginRepository.save(login);
	}

	public List<Login> listar() {
		return loginRepository.findAll();
	}

	public Login listarPorId(Long id_login) {
		Optional<Login> login = loginRepository.findById(id_login);
		return login.get();
	}

	public void alterar(Long id_login, Login login) {
		loginRepository.findById(id_login);
		login.setId_login(id_login);
		login.setSenha(codificarSenha(login.getSenha()));
		loginRepository.save(login);
	}
	public void deletar(Long idlogin){
		loginRepository.deleteById(idlogin);

	}

	public String codificarSenha(String senha) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		// $2a$10$.qwDM9DtiVyy6GFNXuRoS.1sECJx9pZ0d3ih.sIYa0UIE2LC2lKhC

		return encoder.encode(senha);
	}

	public Login verificaCredenciais(String email, String senha) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		List<Login> listaLogin = loginRepository.findByEmail(email);

		if (!listaLogin.isEmpty()) {
			Login login = listaLogin.get(0);

			if (encoder.matches(senha, login.getSenha())) {
				return login;
			}
		}

		return null;
	}
}
