package PraktikumMinggu3;


public class Transaksi {
	private String idTransaksi;
	private String jenis;
	private double nominal;
	
	public Transaksi(String id, String jenis, double nom) {
		this.idTransaksi = id;
		this.jenis = jenis;
		this.nominal = nom;
	}
	
	public String getIdTransaksi() {
		return this.idTransaksi;
	}
	
	public String getJenis() {
		return this.jenis;
	}
	
	public double getNominal() {
		return this.nominal;
	}
	
	public void cetakDetail() {
		System.out.println("ID: " + idTransaksi + " | Jenis: " + 
				jenis + " | Nominal : Rp" + nominal);
	}
	
	
	
}
