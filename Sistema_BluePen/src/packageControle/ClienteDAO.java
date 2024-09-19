package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageConnectng.ConnectionDATABASE;
import packageModel.Cliente;

public class ClienteDAO {

	public void create(Cliente c) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO Cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF_CNPJ());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getDataNasc());
			stmt.setString(6, c.getDataPriCom());
			stmt.setString(7, c.getEndereco());
			stmt.setNString(8, c.getTipoJur());

			stmt.executeUpdate();
			System.out.println("FOI INSERIDO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}

	public void update(Cliente c) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE Cliente SET nome = ?, CPF_CNPJ = ?, email = ?, telefone = ?, dataNasc = ?, dataPrimComp = ?, Endereco = ?, tipoJurd = ? WHERE CPF_CNPJ = ?");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF_CNPJ());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getDataNasc());
			stmt.setString(6, c.getDataPriCom());
			stmt.setString(7, c.getEndereco());
			stmt.setString(8, c.getTipoJur());
			stmt.setString(9, c.getCPF_CNPJ());

			stmt.executeUpdate();
			System.out.println("FOI INSERIDO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}

	public void delete(String cpf_cnpj) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM Cliente WHERE CPF_CNPJ = ?");
			stmt.setString(1, cpf_cnpj);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}

	public ArrayList<Cliente> read() {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> cliente = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Cliente");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataPriCom(rs.getString(7));
				c.setEndereco(rs.getString(8));
				c.setTipoJur(rs.getString(9));

				cliente.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return cliente;
	}
	public ArrayList<Cliente> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> cliente = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Cliente WHERE Nome LIKE ? OR CPF_CNPJ LIKE ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataPriCom(rs.getString(7));
				c.setEndereco(rs.getString(8));
				c.setTipoJur(rs.getString(9));
				cliente.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return cliente;
	}
}
