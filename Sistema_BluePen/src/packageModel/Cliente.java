package packageModel;

public class Cliente {
	
	private String idCliente;
	private String Nome;
	private String CPF_CNPJ;
	private String Email;
	private String Telefone;
	private String DataNasc;
	private String DataPriCom;
	private String Endereco;
	private String TipoJur;
	
	public Cliente() {
		super();
	}
	public Cliente(String idCliente, String nome, String cPF_CNPJ, String email, String telefone, String dataNasc,String dataPriCom, String endereco, String tipoJur)
	{
		super();
		this.idCliente = idCliente;
		Nome = nome;
		CPF_CNPJ = cPF_CNPJ;
		Email = email;
		Telefone = telefone;
		DataNasc = dataNasc;
		DataPriCom = dataPriCom;
		Endereco = endereco;
		TipoJur = tipoJur;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCPF_CNPJ() {
		return CPF_CNPJ;
	}
	public void setCPF_CNPJ(String cPF_CNPJ) {
		CPF_CNPJ = cPF_CNPJ;
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
	public String getDataPriCom() {
		return DataPriCom;
	}
	public void setDataPriCom(String dataPriCom) {
		DataPriCom = dataPriCom;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getTipoJur() {
		return TipoJur;
	}
	public void setTipoJur(String tipoJur) {
		TipoJur = tipoJur;
	}
}
