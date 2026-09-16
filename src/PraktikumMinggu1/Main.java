package PraktikumMinggu1;
import java.util.*;


public class Main {
	public static void main(String args[]) {
		ArrayList<Rekening> rekAr = new ArrayList<Rekening>();
		Scanner input = new Scanner(System.in);
		Rekening akunAktif = null;
		boolean isRunning = true;
		boolean ganti= true;
		
		System.out.println("SYTEM PERBANKAN");
		
		while(ganti) {
			System.out.println("\nMenu Akun");
			System.out.println("1. Buka Rekening Baru");
			System.out.println("2. Masuk");
			System.out.println("0. Keluar");
			System.out.println("Pilih menu");
			int pilihan1 = input.nextInt();
			input.nextLine();
			
			switch(pilihan1) {
			case 1:
				System.out.println("Masukkan no rekening: ");
				String no = input.nextLine();
				System.out.println("Masukkan nama pemilik: ");
				String nama = input.nextLine();
				System.out.println("Masukkan saldo awal: ");
				double saldo = input.nextDouble();
				
				if (saldo >= 50000) {
					akunAktif = new Rekening(no,nama, saldo);
					rekAr.add(akunAktif);
				}
				
				else {
					System.out.println("Minimal saldo awal 50000");
				}
				break;
				
			case 2:
				System.out.println("Masukkan no rekening: ");
				String inputRek = input.nextLine();
				System.out.println(inputRek);
				for(int i = 0 ; i < rekAr.size(); i++) {
					if ( rekAr.get(i).getREK().equals(inputRek)) {
						System.out.println(rekAr.get(i).getREK().equals(inputRek));
						DASHBOARD(isRunning, input, rekAr.get(i));
						break;
					}
				}
				System.out.println("Akun tersebut tidak ada");
				break;
				
			case 0:
				ganti = false;
				System.out.println("Program selesai");
				
			}
		}
		input.close();
		
	}
	
	public static void DASHBOARD(boolean isRunning, Scanner input, Rekening akunAktif) {
		while(isRunning) {
			System.out.println("\nMenu Utama");
			System.out.println("1. Setor Tunai");
			System.out.println("2. Tarik Tunai");
			System.out.println("3. Cetak informasi Rekening");
			System.out.println("0. Keluar");
			System.out.println("Pilih menu");
			int pilihan2 = input.nextInt();
			input.nextLine();
			
			switch(pilihan2) {
					
				case 1: 	
						System.out.println("Masukkan nominal setor: ");
						double setor = input.nextDouble();
						if (setor > 10000) {
							akunAktif.setorTunai(setor);
						}
						else {
							System.out.println("Minimal setor tunai 10.000");
					
						
					}
					break;
				
				case 2:
						System.out.println("Masukkan nominal tarik: ");
						double tarik = input.nextDouble();
						if (tarik > 10000) {							
							akunAktif.tarikTunai(tarik);
						}
						else {
							System.out.println("GAGAL");
						}
					break;
					
					
					
				case 3:
						akunAktif.cekInformasi();
				
					break;
					
				case 0:
					isRunning = false;
					System.out.println("Sistem ditutup, terima kasih");
					break;
				
				default:
					System.out.println("Opsi tidak valid");
			}
		}
	}

}
