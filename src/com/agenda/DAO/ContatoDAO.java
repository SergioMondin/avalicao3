package com.agenda.DAO;

/**
 * @author SLM
 */
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agenda.model.Contato;
import com.agenda.model.Telefone;

public class ContatoDAO {

	private Connection conexao;

	public ContatoDAO() {
		try {
			this.conexao = CriaConexao.getConexao();
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	/* MÉTODO DE INSERÇÃO DE CONTATO */
	public int adicionaContato(Contato ct) throws SQLException {
		int id = 0;
		// prepara a conexão
		String sql = "Insert into contatos(nome,endereco,email)"
				+ " values (?,?,?)";
		PreparedStatement stmt = null;
		try {

			stmt = conexao.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			// seta os valores
			stmt.setString(1, ct.getNome());
			stmt.setString(2, ct.getEndereco());
			stmt.setString(3, ct.getEmail());
			// exucuta o codigo sql
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}

			System.out.println(id);
			System.out.println("contato inserido com sucesso!");

		} catch (SQLException e) {
			System.out.println("erro" + e.getMessage());
		} finally {
			stmt.close();
		}
		return id;
	}

	// MÉTODO PARA LISTAR CONTATOS

	public List<Contato> getLista(String nome) throws SQLException {
		String sql = "select * from contatos c join telefones t on c.id=t.id_contatos where nome like ?";
		PreparedStatement stmt = null;
		List<Contato> MinhaLista = new ArrayList<>();
		try {
			stmt = this.conexao.prepareStatement(sql);

			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato c1 = new Contato();
				Telefone t1 = new Telefone();
				t1.setResidencial(rs.getString("residencial"));
				t1.setCelular(rs.getString("celular"));
				c1.setId(Integer.valueOf(rs.getString("id")));
				c1.setNome(rs.getString("nome"));
				c1.setEndereco(rs.getString("endereco"));
				c1.setEmail(rs.getString("email"));
				c1.setTelefone(t1);
				MinhaLista.add(c1);

			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} finally {
			stmt.close();
		}

		return MinhaLista;
	}

	/* MÉTODO PARA ALTERAR O CONTATO */

	public void alteraContato(Contato ct) throws SQLException {
		String sql = "update contatos set nome=? ,endereco=?,email=?"
				+ "where id=?";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, ct.getNome());
			stmt.setString(2, ct.getEndereco());
			stmt.setString(3, ct.getEmail());
			stmt.setInt(4, ct.getId());
			// exucuta o codigo sql
			stmt.execute();
			System.out.println("contato alterado con sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} finally {
			stmt.close();
		}

	}

	/* MÉTODO PARA REMOVER O CONTATO */

	public void remove(Contato ct) throws SQLException {
		String sql = "delete from contatos where id=?";
		PreparedStatement stmt = null;
		try {
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, ct.getId());
			stmt.execute();
			System.out.println("contato removido com sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} finally {
			stmt.close();
		}

	}
}
