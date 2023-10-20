package br.com.fiap.live19;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.live19.model.Game;

public class Main {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String usuario = "pf1506";
		String senha = "fiap23";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 1 - Abrir conexão com o banco de dados
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão com sucesso!!");
			
			// Criar o objeto que será persistido no banco
			Game game = new Game();
			game.setTitulo("Street Fighter II");
			game.setDataLancamento(LocalDate.of(1991, 7, 16));
			game.setFinalizado(true);
			
			// Inserir um novo game no banco
//			String comandoSql = "insert into tbl_game (codigo, titulo, data_lancamento, finalizado) "
//					+ "values (sq_game.nextval, ?, ?, ?)";
//			
//			// Criar o objeto que envia o comando SQL para o Banco
//			PreparedStatement ps = conexao.prepareStatement(comandoSql);
//			ps.setString(1, game.getTitulo());
//			
//			Date data = Date.valueOf(game.getDataLancamento());
//			ps.setDate(2, data);
//			
//			int finalizado = game.isFinalizado() ? 1 : 0;
//			ps.setInt(3, finalizado);
			
			//String comandoSql = "DELETE FROM tbl_game WHERE codigo = ?";
			String comandoSql = "SELECT * FROM tbl_game WHERE codigo = ?";
			
			PreparedStatement ps = conexao.prepareStatement(comandoSql);
			ps.setInt(1, 7);
			
			// Executa o comando no banco
			//ps.execute();
			ResultSet resultado = ps.executeQuery();
			
			if (resultado.next()) {
				Game g = new Game();
				g.setCodigo(resultado.getInt("CODIGO"));
				g.setTitulo(resultado.getString("titulo"));
				
				Date dt = resultado.getDate("data_lancamento");
				g.setDataLancamento(dt.toLocalDate());
				
				int finalizado = resultado.getInt("finalizado");
				g.setFinalizado(finalizado == 1 ? true : false);
				
				System.out.println(g);
			}
			
			ps.close();
			conexao.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Erro na conexão " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erro na conexão " + e.getMessage());
		}

	}

}
