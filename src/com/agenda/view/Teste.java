package com.agenda.view;

/**
 * @author SLM
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.agenda.DAO.ContatoDAO;
import com.agenda.model.Contato;

public class Teste {

	public static void main(String[] args) throws SQLException {

		// CONTATO C1 = NEW CONTATO();
		// TELEFONE T1 = NEW TELEFONE();

		// T1.SETRESIDENCIAL("666666666");
		// T1.SETCELULAR("999999999");
		// // C1.SETID(5);
		// C1.SETNOME("BART");
		// C1.SETENDERECO("RUA T 66");
		// C1.SETEMAIL("BART@GMAIL.COM");
		// C1.SETTELEFONE(T1);

		//
		// INT ID = NEW CONTATODAO().ADICIONACONTATO(C1);
		// SYSTEM.OUT.PRINTLN(ID);
		// NEW TELEFONEDAO().ADICIONATELEFONE(T1, ID);

		// CONTATO CONTATO = NEW CONTATO();
		// CONTATO.SETID(5);
		// CONTATODAO DAO = NEW CONTATODAO();
		// DAO.REMOVE(CONTATO);
		//

		 ContatoDAO dao = new ContatoDAO();
		 List<Contato> lista = dao.getLista("sergio");
		 System.out.println("-----------------------------------");
		 for (Contato contato : lista) {
		 System.out.println(contato.getId());
		 System.out.println(contato.getNome());
		 System.out.println(contato.getEndereco());
		 System.out.println(contato.getEmail());
		  System.out.println(contato.getTelefone().getResidencial());
		  System.out.println(contato.getTelefone().getCelular());
		 System.out.println("-----------------------------------");
		
		 }

//		Contato contato = new Contato();
//		contato.setId(4);
//		contato.setNome("beti");
//		contato.setEndereco("rua gg 33");
//		contato.setEmail("beti@gmail.com");
//		ContatoDAO dao = new ContatoDAO();
//		dao.alteraContato(contato);
//		
//		Telefone telefone = new Telefone();
//		telefone.setId_contato(4);
//		telefone.setResidencial("33445566");
//		telefone.setCelular("919133455");
//		TelefoneDao tdao = new TelefoneDao();
//		tdao.alteraTelefone(telefone);

	}
}
