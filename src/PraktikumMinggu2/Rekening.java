package PraktikumMinggu2;
import java.util.*;

public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
	
	ArrayList<Transaksi> riwayatTransaksi;
	
	public Rekening(String norek, String nama, double saldo) {
		this.nomorRekening = norek;
		this.namaPemilik = nama;
		this.saldo = saldo;
		
		this.riwayatTransaksi = new ArrayList<>();
		System.out.println("Rekening atas nama : " + namaPemilik + " Berhasil dibuat.");
	}
	
	public void setorTunai(double nominal) {
		if (nominal > 0) {
			saldo += nominal;
			String idTrx = "TRX-S-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi(idTrx, "Kredit", nominal);
			riwayatTransaksi.add(trxBaru);
			System.out.println("Setor tunai Rp" + nominal + " Berhasil. Saldo saat ini: Rp" + saldo);
			
		}
		else {
			System.out.println("Gagal: Nominal setor harus lebih dari 0!");
		}
		
		
	}
	
	public void tarikTunai(double nominal) {
	    if (nominal < 10000) {
	        System.out.println("Transaksi Gagal : Minimal nominal penarikan 10.000");
	    }
	    else if (nominal > saldo) {
	        System.out.println("Transaksi Gagal : Saldo tidak mencukupi. Saldo Anda: Rp" + saldo);
	    }
	    else {
	        saldo -= nominal;
	        String idTrx = "TRX-T-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi(idTrx, "Kredit", nominal);
			riwayatTransaksi.add(trxBaru);
	        System.out.println("Tarik tunai Rp" + nominal + 
	                           " Berhasil, Saldo saat ini: Rp" + saldo);
	    }
	}
	
	public void cekInformasi() {
		System.out.println("--- Info Rekening ---");
		System.out.println("No. Rekening : " + nomorRekening);
		System.out.println("Nama Pemiliki : " + namaPemilik);
		System.out.println("Saldo Akhir : Rp" + saldo );
		System.out.println("---------------------");
	}
	
	public String getREK() {
		return this.nomorRekening;
	}
	
	public void CetakMutasi() {
		int len = riwayatTransaksi.size();
		if (len != 0) {
			for (int i = 0; i < len; i++) {
				riwayatTransaksi.get(i).cetakDetail();
			}
		}
		else {
			System.out.println("Tidak ada transaksi yang dilakukan");
		}
	}
}
