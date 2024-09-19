package packageModel;

public class Produto {
	
	private String idProduto;
	private String Nome;
	private String Codigo;
	private String Estoque;
	private String ProcoUN;
	private String TipoUN;
	private String DataFab;
	private String DataVal;
	
	
	public Produto() {
		super();
	}

	public Produto(String idProduto, String nome, String codigo, String estoque, String procoUN, String tipoUN,
			String dataFab, String dataVal) {
		super();
		this.idProduto = idProduto;
		Nome = nome;
		Codigo = codigo;
		Estoque = estoque;
		ProcoUN = procoUN;
		TipoUN = tipoUN;
		DataFab = dataFab;
		DataVal = dataVal;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getEstoque() {
		return Estoque;
	}

	public void setEstoque(String estoque) {
		Estoque = estoque;
	}

	public String getProcoUN() {
		return ProcoUN;
	}

	public void setProcoUN(String procoUN) {
		ProcoUN = procoUN;
	}

	public String getTipoUN() {
		return TipoUN;
	}

	public void setTipoUN(String tipoUN) {
		TipoUN = tipoUN;
	}

	public String getDataFab() {
		return DataFab;
	}

	public void setDataFab(String dataFab) {
		DataFab = dataFab;
	}

	public String getDataVal() {
		return DataVal;
	}

	public void setDataVal(String dataVal) {
		DataVal = dataVal;
	}
}
