package packageModel;

public class Fornecedor {
	
	private String idFornecedor;
	private String Nome;
	private String CNPJ;
	private String Email;
	private String Telefone;
	private String Endereco;
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(String idFornecedor, String nome, String cNPJ, String email, String telefone, String endereco) {
		super();
		this.idFornecedor = idFornecedor;
		Nome = nome;
		CNPJ = cNPJ;
		Email = email;
		Telefone = telefone;
		Endereco = endereco;
	}

	public String getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(String idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
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

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
}
