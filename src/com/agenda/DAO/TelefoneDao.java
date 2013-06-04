package com.agenda.DAO;

/**
 * @author SLM
 */
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.agenda.model.Telefone;

public class TelefoneDao {

	private Connection conexao;

	public TelefoneDao() {
		try {
			this.conexao = CriaConexao.getConexao();
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	/* MÉTODO PARA ADICIONAR TELEFONE */
	public void adicionaTelefone(Telefone t, int id) throws SQLException {

		String sql = "insert into telefones (residencial,celular,id_contatos) values(?,?,?)";

		PreparedStatement ps = null;

		try {
			ps = conexao.prepareStatement(sql);

			ps.setString(1, t.getResidencial());
			ps.setString(2, t.getCelular());
			ps.setLong(3, id);

			ps.execute();
			System.out.println("telefone adicionado com sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} finally {
			ps.close();
		}
	}

	/* MÉTODO PARA ALTERAR O TELEFONE */

	public void alteraTelefone(Telefone t) throws SQLException{
		String sql = "update telefones set residencial=? ,celular=?"
				+ "where id_contatos=?";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, t.getResidencial());
			stmt.setString(2, t.getCelular());
			stmt.setInt(3, t.getId_contato());
			// exucuta o codigo sql
			stmt.execute();
			System.out.println("telefone alterado con sucesso");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}finally{
			stmt.close();
		}
	
	}
}
