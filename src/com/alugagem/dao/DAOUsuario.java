package com.alugagem.dao;

import com.alugagem.entidades.Usuario;

public interface DAOUsuario extends DAOBase<Usuario> {
	
	/** Busca usuario por login e senha */
	public Usuario getUsuario(String login, String senha);
	
	/** Busca usuario pelo login */
	public Usuario getUsuario(String login);
	
}
