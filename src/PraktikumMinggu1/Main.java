package PraktikumMinggu1;
import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Rekening akunAktif = null;
		boolean isRunning = true;
		
		System.out.println("SYTEM PERBANKAN");
		
		while(isRunning) {
			System.out.println("\nMenu Utama");
			System.out.println("1. Buka Rekening Baru");
			System.out.println("2. Setor Tunai");
			System.out.println("3. Tarik Tunai");
			System.out.println("4. Cetak informasi Rekening");
			System.out.println("0. Keluar");
			System.out.println("Pilih menu");
			int pilihan = input.nextInt();
			input.nextLine();
			
			switch(pilihan) {
				case 1:
					System.out.println("Masukkan no rekening: ");
					String no = input.nextLine();
					System.out.println("Masukkan nama pemilik: ");
					String nama = input.nextLine();
					System.out.println("Masukkan saldo awal: ");
					double saldo = input.nextDouble();
					
					if (saldo >= 50000) {
						akunAktif = new Rekening(no,nama, saldo);
					}
					else {
						System.out.println("Minimal saldo awal 50000");
					}
					break;
					
				case 2:
					if (akunAktif == null) {
						System.out.println("Error: Anda belum memiliki rekening");
					} 
					else {
						
						System.out.println("Masukkan nominal setor: ");
						double setor = input.nextDouble();
						if (setor > 10000) {
							akunAktif.setorTunai(setor);
						}
						else {
							System.out.println("Minimal setor tunai 10.000");
						}
						
					}
					break;
				
				case 3:
					if (akunAktif == null) {
						System.out.println("Error: Anda belum memiliki rekening");
					}
					else {
						System.out.println("Masukkan nominal tarik: ");
						double setor = input.nextDouble();
						akunAktif.tarikTunai(setor);
					}
					break;
					
					
					
				case 4:
					if (akunAktif == null) {
						System.out.println("Error: Anda belum memiliki rekening");
					}
					else {
						akunAktif.cekInformasi();
					}
					break;
					
				case 0:
					isRunning = false;
					System.out.println("Sistem ditutup, terima kasih");
					break;
				
				default:
					System.out.println("Opsi tidak valid");
			}
		}
		input.close();
	}

}
