package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageConnectng.ConnectionDATABASE;
import packageModel.Compra;

public class CompraDAO {
	public void create(Compra pc) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO Compra VALUES(?, ?, ?, ?, ?)");
			stmt.setString(1, pc.getIdCliente());
			stmt.setString(2, pc.getIdVendedor());
			stmt.setString(3, pc.getIdProduto());
			stmt.setString(4, pc.getQuantidade());
			stmt.setString(5, pc.getPrecoTotal());

			stmt.executeUpdate();
			System.out.println("FOI INSERIDO!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void update(Compra pc){
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
			"UPDATE Compra SET idCliente = ?, idVendedor = ?, idProduto = ?, Quantidade = ?, PrecoTotal = ? WHERE idCompra = ?");
			stmt.setString(1, pc.getIdCliente());
			stmt.setString(2, pc.getIdVendedor());
			stmt.setString(3, pc.getIdProduto());
			stmt.setString(4, pc.getQuantidade());
			stmt.setString(5, pc.getPrecoTotal());
			stmt.setString(6, pc.getIdCompra());

			stmt.executeUpdate();
			System.out.println("FOI ATUALIZADO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void delete(String idCompra) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM Compra WHERE IdCompra = ?");
			stmt.setString(1, idCompra);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public ArrayList<Compra> read() {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Compra> compra = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT idCompra, V.nome, Cl.nome, P.nome, Cp.quantidade, Cp.precoTotal\r\n"
					+ "FROM Compra Cp INNER JOIN Cliente Cl ON Cl.idCliente = Cp.idCliente\r\n"
					+ "INNER JOIN Produto P ON Cp.idProduto = p.idProduto\r\n"
					+ "INNER JOIN Vendedor V ON Cp.idVendedor = V.idVendedor");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Compra cc = new Compra();
				cc.setIdCompra(rs.getString(1));
				cc.setIdCliente(rs.getString(2));
				cc.setIdVendedor(rs.getString(3));
				cc.setIdProduto(rs.getString(4));
				cc.setQuantidade(rs.getString(5));
				cc.setPrecoTotal(rs.getString(6));
				compra.add(cc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return compra;
	}
	public ArrayList<Compra> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Compra> compra = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Compra WHERE idCompra LIKE ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Compra cc = new Compra();
				cc.setIdCompra(rs.getString(1));
				cc.setIdCliente(rs.getString(2));
				cc.setIdVendedor(rs.getString(3));
				cc.setIdProduto(rs.getString(4));
				cc.setQuantidade(rs.getString(5));
				cc.setPrecoTotal(rs.getString(6));
				compra.add(cc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return compra;
	}
}
