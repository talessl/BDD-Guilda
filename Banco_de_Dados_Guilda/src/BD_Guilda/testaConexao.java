package BD_Guilda;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testaConexao {

	public static void main(String[] args) {
		
		try {
		
			ControleMercador ctr_mercador = new ControleMercador();
			Mercador mercador = new Mercador();
			
			//Insere um mercador de exemplo no banco
			
			mercador.setId_mercador(3);
			mercador.setNome("Maria");
			mercador.setRaca("Tiefling");
			mercador.setGenero("feminino");
			mercador.setNivel_maestria(6);
			
			//ctr_mercador.create(mercador);
			
			//ctr_mercador.update(mercador);
			
			//ctr_mercador.delete(mercador);
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
