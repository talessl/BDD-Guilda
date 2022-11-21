package BD_Guilda;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testaConexao {

	public static void main(String[] args) {
		
		try {
		
			ControleMercador ctr_mercador = new ControleMercador();
			ControleMercadoria ctr_mercadoria = new ControleMercadoria();
			ControleVende ctr_vende = new ControleVende();
			
			Mercador mercador = new Mercador();
			Mercadoria mercadoria = new Mercadoria();
			Vende vende = new Vende();
			
			//Insere um mercador de exemplo no banco
			
			mercador.setId_mercador(3);
			mercador.setNome("Maria");
			mercador.setRaca("Tiefling");
			mercador.setGenero("Feminino");
			mercador.setNivel_maestria(6);
			
			//ctr_mercador.create(mercador);
			
			ctr_mercador.update(mercador);
			
			//ctr_mercador.delete(mercador);
			
			mercadoria.setId_mercadoria(3);
			mercadoria.setNome_produto("Martelo de Guerra");
			mercadoria.setPreco(4000);
			mercadoria.setRaridade("Super-Raro");
			
			//ctr_mercadoria.create(mercadoria);
			
			vende.setId_mercador(3);
			vende.setId_mercadoria(3);
			
			//ctr_vende.create(vende);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
