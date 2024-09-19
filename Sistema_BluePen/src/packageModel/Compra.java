package packageModel;

public class Compra {
	
	private String idCompra;
	private String idCliente;
	private String idVendedor;
	private String idProduto;
	private String Quantidade;
	private String PrecoTotal;
	
	public Compra() {
		super();
	}

	public Compra(String idCompra, String idCliente, String idVendedor, String idProduto, String quantidade,
			String precoTotal) {
		super();
		this.idCompra = idCompra;
		this.idCliente = idCliente;
		this.idVendedor = idVendedor;
		this.idProduto = idProduto;
		Quantidade = quantidade;
		PrecoTotal = precoTotal;
	}

	public String getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(String quantidade) {
		Quantidade = quantidade;
	}

	public String getPrecoTotal() {
		return PrecoTotal;
	}

	public void setPrecoTotal(String precoTotal) {
		PrecoTotal = precoTotal;
	}
}
