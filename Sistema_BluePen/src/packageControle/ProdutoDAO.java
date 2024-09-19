package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageConnectng.ConnectionDATABASE;
import packageModel.Produto;

public class ProdutoDAO {
	public void create(Produto p) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO Produto VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCodigo());
			stmt.setString(3, p.getEstoque());
			stmt.setString(4, p.getProcoUN());
			stmt.setString(5, p.getTipoUN());
			stmt.setString(6, p.getDataFab());
			stmt.setString(7, p.getDataVal());

			stmt.executeUpdate();
			System.out.println("FOI INSERIDO!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void update(Produto p){
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE Produto SET nome = ?, codigo = ?, estoque = ?, precoUn = ?, tipoUn = ?, dataFab = ?, dataVal = ? WHERE codigo = ?");
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCodigo());
			stmt.setString(3, p.getEstoque());
			stmt.setString(4, p.getProcoUN());
			stmt.setString(5, p.getTipoUN());
			stmt.setString(6, p.getDataFab());
			stmt.setString(7, p.getDataVal());
			stmt.setString(8, p.getCodigo());

			stmt.executeUpdate();
			System.out.println("FOI ATUALIZADO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void delete(String codigo) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM Produto WHERE codigo = ?");
			stmt.setString(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public ArrayList<Produto> read() {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> produto = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Produto");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setIdProduto(rs.getString(1));
				p.setNome(rs.getString(2));
				p.setCodigo(rs.getString(3));
				p.setEstoque(rs.getString(4));
				p.setProcoUN(rs.getString(5));
				p.setTipoUN(rs.getString(6));
				p.setDataFab(rs.getString(7));
				p.setDataVal(rs.getString(8));
				produto.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return produto;
	}
	public ArrayList<Produto> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> produto = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Produto WHERE Nome LIKE ? OR codigo LIKE ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				Produto p = new Produto();
				p.setIdProduto(rs.getString(1));
				p.setNome(rs.getString(2));
				p.setCodigo(rs.getString(3));
				p.setEstoque(rs.getString(4));
				p.setProcoUN(rs.getString(5));
				p.setTipoUN(rs.getString(6));
				p.setDataFab(rs.getString(7));
				p.setDataVal(rs.getString(8));
				produto.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return produto;
	}
}
