package com.prjcadcliente.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prjcadcliente.dominio.Cliente;

/**
 * <b>CRUDCliente</b><b>
 * Essa classe permite manipular as informa��es do cliente. Aqui voc� encontrar�  os seguintes comandos:
 * <ul>
 *   <li>Cadastro</li>
 *   <li>Pesquisar por nome e por id</li>
 *   <li>Atualizar</li>
 *   <li>Deletar</li>
 *   </ul>  
 * @author thales.dlima
 *
 */
public class CRUDCliente {
	
	String msg = "";
	
	//Decla��o das inst�ncias de comunica��o com o banco de dados
	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	
	public String cadastrar(Cliente cliente) {
		
		//Cra��o dos objetos para a conex�o com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Drive").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
			
			String consulta = "INSERT INTO tbcliente(nome,email,telefone,idade)values(?,?,?,?)";
			
			pst = con.prepareStatement(consulta);
			
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getTelefone());
			pst.setInt(4, cliente.getIdade());
			
			int r = pst.executeUpdate();
			
			if(r > 0);
				msg = "Cadastro realizado com sucesso!";
			else
				msg = "N�o foi poss�vel cadastrar!";
			
			
			
			}
			catch(SQLException ex) {
				msg = "Erro ao tentar cadastrar: "+ex.getMessage();
			}
		    catch(Exception e) {
		    	msg = "Erro inesperado: "+e.getMessage();
		    }
			finally {
				try{con.close();}catch(Exception e) {e.printStackTrace();}
			}
			return msg;
	
		
		return null;
   }
	public String atualizar(Cliente cliente) {
		return null;
	}
	public String deletar(Cliente cliente) {
		return null;
	}
	public List<Cliente>PesquisarPorNome(String nome){
		return null;
	}
	public List<Cliente>PesquisarPorId(int id){
		return null;
	}
	public List<Cliente>PesquisarTodos(){
		return null;
	}
}	
