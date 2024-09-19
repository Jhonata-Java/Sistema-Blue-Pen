package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnectng.ConnectionDATABASE;
import packageModel.Vendedor;

public class VendedorDAO {

	public void create(Vendedor v) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO Vendedor(nome, CPF, email, telefone, dataNasc, dataCont, Endereco) VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, v.getNome());
			stmt.setString(2, v.getCPF());
			stmt.setString(3, v.getEmail());
			stmt.setString(4, v.getTelefone());
			stmt.setString(5, v.getDataNasc());
			stmt.setString(6, v.getDataCont());
			stmt.setString(7, v.getEndereco());

			stmt.executeUpdate();
			System.out.println("FOI INSERIDO!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void update(Vendedor v){
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE Vendedor SET nome = ?, CPF = ?, email = ?, telefone = ?, dataNasc = ?, dataCont = ?, Endereco = ? WHERE CPF = ?");
			stmt.setString(1, v.getNome());
			stmt.setString(2, v.getCPF());
			stmt.setString(3, v.getEmail());
			stmt.setString(4, v.getTelefone());
			stmt.setString(5, v.getDataNasc());
			stmt.setString(6, v.getDataCont());
			stmt.setString(7, v.getEndereco());
			stmt.setString(8, v.getCPF());

			stmt.executeUpdate();
			System.out.println("FOI ATUALIZADO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void delete(String CPF) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM Vendedor WHERE CPF = ?");
			stmt.setString(1, CPF);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public Vendedor autenticarUser(String user, String password) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Vendedor vendedor = new Vendedor();
		try {
			stmt = con.prepareStatement("SELECT*FROM Vendedor WHERE PASSWORD = ? AND CPF = ? OR email = ?");
			stmt.setString(1, password);
			stmt.setString(2, user);
			stmt.setString(3, user);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Vendedor v = new Vendedor();
				v.setIdVendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDataNasc(rs.getString(6));
				v.setDataCont(rs.getString(7));
				v.setTotalVend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				v.setPassword(rs.getString(10));
				
				vendedor = v;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return vendedor;
	}
	public ArrayList<Vendedor> read() {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Vendedor> vendedor = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Vendedor");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Vendedor v = new Vendedor();
				v.setIdVendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDataNasc(rs.getString(6));
				v.setDataCont(rs.getString(7));
				v.setTotalVend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				vendedor.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return vendedor;
	}
	public ArrayList<Vendedor> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Vendedor> vendedor = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Vendedor WHERE Nome LIKE ? OR idVendedor LIKE ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Vendedor v = new Vendedor();
				v.setIdVendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDataNasc(rs.getString(6));
				v.setDataCont(rs.getString(7));
				v.setTotalVend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				vendedor.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return vendedor;
	}
}
