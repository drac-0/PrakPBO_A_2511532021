package PraktikumMinggu1;
import java.util.*;

public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
	
	public Rekening(String nomor, String nama, double saldoAwal) {
		
			this.namaPemilik = nomor; 
			this.nomorRekening = nama;
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
		if (nominal > 0) {
			if ((saldo - nominal) >= 0 ) {
				saldo -= nominal;
				System.out.println("Tarik tunai Rp" + nominal + " Berhasil, Saldo saat ini: Rp" + saldo);
			}
		}
		else {
			System.out.println("Mohon masukkan nilai non negatif");
		}
		
	}
	
	public void cekInformasi() {
		System.out.println("--- Info Rekening ---");
		System.out.println("No. Rekening : " + nomorRekening);
		System.out.println("Nama Pemiliki : " + namaPemilik);
		System.out.println("Saldo Akhir : Rp" + saldo );
		System.out.println("---------------------");
	}
}


