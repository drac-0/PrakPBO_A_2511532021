package PraktikumMinggu2;
import java.util.*;

public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
	double Tsetor ;
	double Lsetor = 1000000;
	double Ttarik;
	double Lta = 1000000;
	double fSal = 0;
	double tAR = 0;
	
	
	ArrayList<Transaksi> riwayatTransaksi;
	
	public Rekening(String norek, String nama, double saldo) {
		this.nomorRekening = norek;
		this.namaPemilik = nama;
		this.saldo = saldo;
		this.fSal = saldo;
		
		this.riwayatTransaksi = new ArrayList<>();
		System.out.println("Rekening atas nama : " + namaPemilik + " Berhasil dibuat.");
	}
	
	public void setorTunai(double nominal) {
		if (nominal > 0) {
			if (nominal > Tsetor) {
				Tsetor = nominal;
			}
			
			else if (nominal < Lsetor) {
				Lsetor = nominal;
			}
			
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
	    	if (nominal > Ttarik) {
				Ttarik = nominal;
			}
			
			else if (nominal < Lta) {
				Lta = nominal;
			}
		
	        saldo -= nominal;
	        String idTrx = "TRX-T-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi(idTrx, "Kredit", nominal);
			riwayatTransaksi.add(trxBaru);
	        System.out.println("Tarik tunai Rp" + nominal + 
	                           " Berhasil, Saldo saat ini: Rp" + saldo);
	        tAR += nominal;
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
		int len = riwayatTransaksi.size() - 1;
		
		if (len != 0) {
			if (len >= 3) {
				for (int i = len; i > len - 3; i--) {	
					riwayatTransaksi.get(i).cetakDetail();
				}
			}
			else {
				for (int i = 0; i <= len; i++) {	
					riwayatTransaksi.get(i).cetakDetail();
				}
			}
			
		}
		else {
			System.out.println("Tidak ada transaksi yang dilakukan");
		}
	}
	
	public void CetakTer() {
		System.out.println("Tarikan terendah " + Lta);
		System.out.println("Tarikan tertinggi " + Ttarik);
		System.out.println("Setoran terendah " + Lsetor);
		System.out.println("Setoran tertinggi " + Tsetor);
	}
	
	public void CetakInfo() {
		int len = riwayatTransaksi.size();
		double Ts = 0;
		double ST = 0;
			
		for (int i = 0; i < len - 1; i++) {
			if (riwayatTransaksi.get(i).idTransaksi.contains("TRX-S-") ) {
				Ts += riwayatTransaksi.get(i).nominal;
			}
		}
		System.out.println("Total setor " + Ts);
		System.out.println("Total tarik " + tAR);
		System.out.println("Akumulasi " + (Ts - tAR));
		System.out.println("Saldo saat bikin akun" + fSal);
		System.out.println("Salso saat ini" + ((Ts -tAR) + fSal));
	}
}
