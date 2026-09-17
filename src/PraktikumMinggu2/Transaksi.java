package PraktikumMinggu2;


public class Transaksi {
	String idTransaksi;
	String jenis;
	double nominal;
	
	public Transaksi(String id, String jenis, double nom) {
		this.idTransaksi = id;
		this.jenis = jenis;
		this.nominal = nom;
	}
	
	public void cetakDetail() {
		System.out.println("ID: " + idTransaksi + " | Jenis: " + 
				jenis + " | Nominal : Rp" + nominal);
	}
	
	
	
}
