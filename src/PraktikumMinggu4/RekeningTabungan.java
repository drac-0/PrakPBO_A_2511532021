package PraktikumMinggu4;

public class RekeningTabungan extends Rekening{
	private double sukuBunga;
	private int hitung = 0;
	
	public RekeningTabungan(String nomor, String nama, double saldoAwal, String pinAwal, double sukuBunga) {
		super(nomor,nama,saldoAwal,pinAwal);
		this.sukuBunga = sukuBunga;
	}
	public void tambahBungaAkhirBulan() {
		double nominalBunga = saldo * (sukuBunga / 100);
		saldo += nominalBunga;
		
		String idTrx = "TRX-B-" + System.currentTimeMillis();
		riwayatTransaksi.add(new Transaksi(idTrx, "Bunga", nominalBunga));
		
		System.out.println("Bunga " + sukuBunga + "% berhasil ditambahkan : Rp" + nominalBunga);
		hitung += 1;
	}
	
	public void tambahBungaAkhirTahun() {
		if (saldo > 10000000) {
			if (hitung >= 12) {
				System.out.println("Uang sebesar Rp" + saldo * sukuBunga/100 + " berhasil ditambahkan" );
				saldo += (saldo * sukuBunga / 100);
				System.out.printf("Saldo sekarang : Rp%f", saldo);
			}
			else {
				System.out.println("Tambah akhir bulan harus sudah 12 kali");
			}
			
		}
		
		else {
			System.out.println("Tabungan harus lebih besar dari 10000000");	
		}
	}
	
}
