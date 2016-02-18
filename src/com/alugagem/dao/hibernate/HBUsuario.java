package com.alugagem.dao.hibernate;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alugagem.entidades.Usuario;

import com.alugagem.dao.DAOUsuario;
import com.alugagem.dao.hibernate.HBUsuario;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoUsuario")
public class HBUsuario extends HBDAO<Usuario> implements DAOUsuario {
	
	

	
	protected Class getClazz() {
		return Usuario.class;
	}

	public Usuario getUsuario(String login, String senha) {
		Query query = getSession().createQuery("from Usuario usr where usr.login = ? and usr.hashSenha = ?");
		query.setString(0, login);
		query.setString(1, senha);
		return (Usuario) query.uniqueResult();				   
	}

	public Usuario getUsuario(String login) {
		Query query = getSession().createQuery("from Usuario usr where usr.login = ?");
		query.setString(0, login);
		return (Usuario) query.uniqueResult();
	}

	
	
}
