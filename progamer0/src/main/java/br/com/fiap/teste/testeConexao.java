package br.com.fiap.teste;

import br.com.fiap.dao.SetupDAO;
import br.com.fiap.model.Setup;

public class testeConexao {
	
	public static void main(String[] args) {
		
		SetupDAO dao =  new SetupDAO();
		
		Setup setup = new Setup();
		
		try {
			dao.create(setup);
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		
	}

}
