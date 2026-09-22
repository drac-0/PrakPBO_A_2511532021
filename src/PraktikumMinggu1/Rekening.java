package PraktikumMinggu1;
import java.text.Format;
import java.util.*;

public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
	
	public Rekening(String nomor, String nama, double saldoAwal) {
		this.namaPemilik = nama; 
		this.nomorRekening = nomor;
		this.saldo = saldoAwal;		
	}
	
	public void setorTunai(double nominal) {
		if (nominal > 0 ) {
			saldo += nominal;
			System.out.println("Setor tunai Rp" + nominal + " Berhasil, Saldo saat ini: Rp" + saldo);
		}
		else {
			System.out.println("Gagal: Nominal setor harus lebih dari 0");
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
}