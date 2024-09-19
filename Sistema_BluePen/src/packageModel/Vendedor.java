package packageModel;

public class Vendedor {
	
	private String idVendedor;
	private String Nome;
	private String CPF;
	private String Email;
	private String Telefone;
	private String DataNasc;
	private String DataCont;
	private String TotalVend;
	private String Endereco;
	private String Password;
	
	public Vendedor() {
		super();
	}

	public Vendedor(String idVendedor, String nome, String cPF, String email, String telefone, String dataNasc,
			String dataCont, String totalVend, String endereco, String password) {
		super();
		this.idVendedor = idVendedor;
		Nome = nome;
		CPF = cPF;
		Email = email;
		Telefone = telefone;
		DataNasc = dataNasc;
		DataCont = dataCont;
		TotalVend = totalVend;
		Endereco = endereco;
		Password = password;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getDataNasc() {
		return DataNasc;
	}

	public void setDataNasc(String dataNasc) {
		DataNasc = dataNasc;
	}

	public String getDataCont() {
		return DataCont;
	}

	public void setDataCont(String dataCont) {
		DataCont = dataCont;
	}

	public String getTotalVend() {
		return TotalVend;
	}

	public void setTotalVend(String totalVend) {
		TotalVend = totalVend;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
}
