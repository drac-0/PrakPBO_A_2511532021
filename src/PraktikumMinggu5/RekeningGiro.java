package PraktikumMinggu5;

public class RekeningGiro extends Rekening{
	private double batasOverdraft;
	public RekeningGiro(String nomor, String nama, double saldoAwal, String pinAwal, double batasOverdraft) {
		super(nomor,nama,saldoAwal,pinAwal);
		this.batasOverdraft = batasOverdraft;
	}
	
	@Override
	public boolean tarikTunai(double nominal) {
		if (nominal <= 0) {
			System.out.println("Gagal: Nominal tarik giro harus lebih dari 0");
			return false;
		}
		else if(nominal > (saldo + batasOverdraft)) {
			System.out.println("Gagal: Melebihi batas overdraft! Maksimal penarikan: Rp" + (batasOverdraft + saldo) );
			return false;
		}
		
		else {
			saldo -= nominal;
			
			String idTrx = "TRX-G-" + System.currentTimeMillis();
			riwayatTransaksi.add(new Transaksi(idTrx, "Debit giro", nominal));
			return true;
		}
	}
	
	public double getBatasOverdraft() {
		return batasOverdraft;
	}
}
