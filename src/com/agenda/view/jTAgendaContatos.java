package com.agenda.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.agenda.DAO.ContatoDAO;
import com.agenda.DAO.TelefoneDao;
import com.agenda.model.Contato;
import com.agenda.model.Telefone;

public class jTAgendaContatos extends JFrame {

	// MODELO DE TABELA DEFAULT
	DefaultTableModel tmContato = new DefaultTableModel(null, new String[] {
			"Nome", "Endereco", "Email", "Residencial", "Celular" });
	List<Contato> contatos;
	ListSelectionModel lsmContato;
	// private Object ListSelectionM­odel;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFNome;
	private JTextField tFEndereco;
	private JTextField tFEmail;
	private JTextField tFResidencial;
	private JTextField tFCelular;
	private JTextField tFPesquisa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jTAgendaContatos frame = new jTAgendaContatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jTAgendaContatos() {

		setTitle("Agenda de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 613);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(10, 81, 621, 191);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(20, 11, 580, 167);
		panel.add(panel_2);
		panel_2.setLayout(null);

		tFNome = new JTextField();
		tFNome.setFont(new Font("Arial", Font.BOLD, 13));
		tFNome.setBounds(303, 11, 247, 20);
		panel_2.add(tFNome);
		tFNome.setColumns(10);

		tFEmail = new JTextField();
		tFEmail.setFont(new Font("Arial", Font.BOLD, 13));
		tFEmail.setBounds(303, 73, 247, 20);
		panel_2.add(tFEmail);
		tFEmail.setText("");
		tFEmail.setColumns(10);

		tFEndereco = new JTextField();
		tFEndereco.setFont(new Font("Arial", Font.BOLD, 13));
		tFEndereco.setBounds(303, 42, 247, 20);
		panel_2.add(tFEndereco);
		tFEndereco.setText("");
		tFEndereco.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(229, 80, 64, 14);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o:");
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(229, 50, 118, 14);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(229, 20, 46, 14);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Telefone Residencial:");
		lblNewLabel_4.setForeground(new Color(25, 25, 112));
		lblNewLabel_4.setBounds(229, 110, 151, 14);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));

		tFResidencial = new JTextField();
		tFResidencial.setFont(new Font("Arial", Font.BOLD, 13));
		tFResidencial.setBounds(389, 104, 161, 20);
		panel_2.add(tFResidencial);
		tFResidencial.setText("");
		tFResidencial.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Telefone Celular:");
		lblNewLabel_5.setForeground(new Color(25, 25, 112));
		lblNewLabel_5.setBounds(229, 140, 127, 14);
		panel_2.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));

		tFCelular = new JTextField();
		tFCelular.setFont(new Font("Arial", Font.BOLD, 13));
		tFCelular.setBounds(389, 135, 161, 20);
		panel_2.add(tFCelular);
		tFCelular.setText("");
		tFCelular.setColumns(10);

		JLabel lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon("imagem/agenda2.jpg"));
		lblFoto.setBounds(26, 16, 175, 135);
		panel_2.add(lblFoto);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_3.setBackground(new Color(248, 248, 255));
		panel_3.setBounds(10, 12, 621, 58);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		// PESQUISA
		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.setHorizontalTextPosition(SwingConstants.LEFT);
		btnPesquisa.setIcon(new ImageIcon("imagem/pesquisa3.png"));

		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarContatos();
			}
		});
		btnPesquisa.setBounds(458, 17, 113, 23);
		panel_3.add(btnPesquisa);

		tFPesquisa = new JTextField();
		tFPesquisa.setBounds(62, 19, 386, 20);
		panel_3.add(tFPesquisa);
		tFPesquisa.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(21, 11, 579, 36);
		panel_3.add(panel_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_4.setBackground(new Color(248, 248, 255));
		panel_4.setBounds(10, 283, 621, 63);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_6.setBackground(new Color(135, 206, 250));
		panel_6.setBounds(22, 11, 576, 41);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		// NOVO
		JButton btnNovo = new JButton("Novo");
		btnNovo.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNovo.setIcon(new ImageIcon("imagem/novo.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitaDados();
				tFNome.setText("");
				tFEndereco.setText("");
				tFEmail.setText("");
				tFResidencial.setText("");
				tFCelular.setText("");
			}
		});
		btnNovo.setBounds(21, 9, 100, 23);
		panel_6.add(btnNovo);

		// ALTERAR
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAlterar.setIcon(new ImageIcon("imagem/altera.png"));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alteraContato(table);
				listarContatos();
			}

		});
		btnAlterar.setBounds(241, 9, 100, 23);
		panel_6.add(btnAlterar);

		// SAIR
		JButton btnSair = new JButton("Sair");
		btnSair.setHorizontalTextPosition(SwingConstants.LEFT);
		btnSair.setIcon(new ImageIcon("imagem/close2.png"));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(461, 9, 100, 23);
		panel_6.add(btnSair);

		// SALVAR
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnSalvar.setIcon(new ImageIcon("imagem/salvar2.png"));
		btnSalvar.setBounds(131, 9, 100, 23);
		panel_6.add(btnSalvar);

		// EXCLUIR
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setHorizontalTextPosition(SwingConstants.LEFT);
		btnExcluir.setIcon(new ImageIcon("imagem/delete.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					excluirContato();
					listarContatos();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(351, 9, 100, 23);
		panel_6.add(btnExcluir);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (verificaDados()) {
					Contato c1 = new Contato();
					c1.setNome(tFNome.getText());
					c1.setEndereco(tFEndereco.getText());
					c1.setEmail(tFEmail.getText());

					Telefone f1 = new Telefone();
					f1.setResidencial(tFResidencial.getText());
					f1.setCelular(tFCelular.getText());

					try {
						ContatoDAO cd = new ContatoDAO();
						int id = cd.adicionaContato(c1);
						TelefoneDao td = new TelefoneDao();
						td.adicionaTelefone(f1, id);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				desabilitaDados();
			}
		});

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_5.setBackground(new Color(248, 248, 255));
		panel_5.setBounds(10, 357, 621, 207);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_7.setBackground(new Color(135, 206, 235));
		panel_7.setBounds(23, 11, 575, 185);
		panel_5.add(panel_7);
		panel_7.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel_8.setBounds(28, 11, 518, 16);
		panel_7.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Nome");
		lblNewLabel_6.setBounds(32, 1, 46, 14);
		panel_8.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Endere\u00E7o");
		lblNewLabel_7.setBounds(130, 1, 71, 14);
		panel_8.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Email");
		lblNewLabel_8.setBounds(238, 1, 46, 14);
		panel_8.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Residencial");
		lblNewLabel_9.setBounds(325, 1, 78, 14);
		panel_8.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Celular");
		lblNewLabel_10.setBounds(433, 1, 46, 14);
		panel_8.add(lblNewLabel_10);

		// TABELA
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		// adicionando evento
		lsmContato = table.getSelectionModel();
		lsmContato.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					tableLinhaSelecionada(table);
				}
			}
		});
		//
		table.setBounds(28, 41, 518, 133);
		table.setModel(tmContato);
		panel_7.add(table);
		desabilitaDados();
	}

	// MÉTODO QUE LISTA OS CONTATOS
	public void listarContatos() {

		ContatoDAO dao = new ContatoDAO();
		try {
			contatos = dao.getLista("%" + tFPesquisa.getText() + "%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		mostraPesquisa(contatos);
	}

	// MÉTODO PARA ALTERAR CONTATO
	private void alteraContato(JTable tabela) {
		if (table.getSelectedRow() != -1) {
			// pega o id da linha da tabela
			int num = (contatos.get(tabela.getSelectedRow()).getId());
			if (verificaDados())
				try {
					{

						Contato c1 = new Contato();
						Telefone t1 = new Telefone();
						ContatoDAO cd = new ContatoDAO();
						TelefoneDao td = new TelefoneDao();
						t1.setResidencial(tFResidencial.getText());
						t1.setCelular(tFCelular.getText());

						c1.setId(num);
						t1.setId_contato(c1.getId());
						System.out.println(c1.getId());
						c1.setNome(tFNome.getText());
						c1.setEndereco(tFEndereco.getText());
						c1.setEmail(tFEmail.getText());
						c1.setTelefone(t1);

						cd.alteraContato(c1);
						td.alteraTelefone(t1);
						JOptionPane.showMessageDialog(null,
								"Contato alterado com sucesso");

					}
				} catch (HeadlessException | SQLException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
		}

	}

	// MÉTODO PARA EXCLUIR CONTATO

	public void excluirContato() {
		int resp = JOptionPane.showConfirmDialog(this,
				"Deseja realmente excluir este contato?", "Confirmação",
				JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_NO_OPTION) {

			ContatoDAO dao = new ContatoDAO();
			try {
				dao.remove(contatos.get(table.getSelectedRow()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			mostraPesquisa(contatos);

		}
	}

	// MÉTODO QUE SELECIONA A LINHA NA TABELA
	private void tableLinhaSelecionada(JTable tabela) {

		if (table.getSelectedRow() != -1) {
			habilitaDados();
			tFNome.setText(contatos.get(tabela.getSelectedRow()).getNome());
			tFEndereco.setText(contatos.get(tabela.getSelectedRow())
					.getEndereco());
			tFEmail.setText(contatos.get(tabela.getSelectedRow()).getEmail());
			tFResidencial.setText(contatos.get(tabela.getSelectedRow())
					.getTelefone().getResidencial());
			tFCelular.setText(contatos.get(tabela.getSelectedRow())
					.getTelefone().getCelular());
		} else {
			tFNome.setText("");
			tFEndereco.setText("");
			tFEmail.setText("");
			tFResidencial.setText("");
			tFCelular.setText("");
		}
	}

	// MÉTODO PARA MOSTRAR A PESQUISA
	private void mostraPesquisa(List<Contato> contatos) {
		while (tmContato.getRowCount() > 0) {
			tmContato.removeRow(0);
		}
		if (contatos.size() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum contato cadastrado!");
		} else {
			String[] linha = new String[] { null, null, null, null, null };
			for (int i = 0; i < contatos.size(); i++) {
				tmContato.addRow(linha);
				tmContato.setValueAt(contatos.get(i).getNome(), i, 0);
				tmContato.setValueAt(contatos.get(i).getEndereco(), i, 1);
				tmContato.setValueAt(contatos.get(i).getEmail(), i, 2);
				tmContato.setValueAt(contatos.get(i).getTelefone()
						.getResidencial(), i, 3);
				tmContato.setValueAt(
						contatos.get(i).getTelefone().getCelular(), i, 4);
			}
		}
	}

	// MÉTODO QUE VERIFICA SE OS CAMPOS FORAM PREENCHIDOS
	public boolean verificaDados() {

		if (!tFNome.getText().equals("") && !tFEndereco.getText().equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Campos Nome e Endereço são obrigatórios");
			return false;
		}

	}

	// MÉTODO DESABILITA TEXTFIELDS
	public void desabilitaDados() {
		tFNome.setEditable(false);
		tFEndereco.setEditable(false);
		tFEmail.setEditable(false);
		tFResidencial.setEditable(false);
		tFCelular.setEditable(false);
	}

	// MÉTODO HABILITA TEXTFIELDS
	public void habilitaDados() {
		tFNome.setEditable(true);
		tFEndereco.setEditable(true);
		tFEmail.setEditable(true);
		tFResidencial.setEditable(true);
		tFCelular.setEditable(true);
	}
}
