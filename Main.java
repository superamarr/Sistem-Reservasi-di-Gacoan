/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.posttest;

/**
 *
 * @author Aspire5
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    String Nama;
    String meja;
    String Harga;
    String waktu;
    String preOrder;
    String namaMenu;
    int no = 1;
    
    public Main(String Nama,String waktu, String meja, String preOrder, String namaMenu, String Harga){
        this.Nama = Nama;
        this.waktu = waktu;
        this.meja = meja;
        this.preOrder = preOrder;
        this.namaMenu = namaMenu;
        this.Harga = Harga;
        }
    
    public Main ( String namaMenu, String waktu, String meja, String preOrder, String Harga){
        this.namaMenu = namaMenu;
        this.waktu = waktu;
        this.meja = meja;
        this.preOrder = preOrder;
        this.Harga = Harga;   
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList <Main> invoice = new ArrayList <>();
        
        invoice.add(new Main("Taufik", "12:30", "Meja 1", "Ya", "Mie Gacoan Lv 3" , "15000"));
        invoice.add(new Main("Sadikin", "15.30", "Meja 5", "Ya", "Mie Gacoan Lv 3" + ", " + "Udang Keju" , "15000"));
        
            while (true) {
                System.out.println("Masukkan pilihan: \n1. Lihat \n2. Reservasi \n3. Update Reservasi \n4. Hapus Reservasi \n5. Keluar dari Program.");
                String pilih = input.nextLine();
                
                switch(pilih){
                    case "1" : lihatData(invoice); 
                                break;
                    case "2" : tambahReservasi(invoice); 
                                break;
                    case "3" : ubahReservasi (invoice);
                                break;
                    case "4" : hapusReservasi(invoice);
                                break;
                    case "5" : System.exit(0);
                    default:   System.out.println("Pilihan salah!");
                }
                    
            }
    }
            
    public static void lihatData(ArrayList <Main> invoice){
        Scanner user = new Scanner(System.in);
        int no = 1;
        for (Main b:invoice){
            System.out.println("\n");
            System.out.println("=======================");
            System.out.println("No.             : " + no++);
            System.out.println("Nama Pemesan    : " + b.Nama);
            System.out.println("Waktu Reservasi : " + b.waktu);
            System.out.println("Meja            : " + b.meja);
            System.out.println("PreOrder        : " + b.preOrder);
            System.out.println("Pesanan         : " + b.namaMenu);
            System.out.println("Harga           : " + b.Harga);
            System.out.println("=======================");
        }
    }
    
    public static void tampilkanMenu() {
        System.out.println("=== Daftar Menu Gacoan ===");
        System.out.println("1. Mie Gacoan Lv 1 - 13000");
        System.out.println("2. Mie Gacoan Lv 2 - 14000");
        System.out.println("3. Mie Gacoan Lv 3 - 15000");
        System.out.println("4. Udang Rambutan - 10000");
        System.out.println("5. Udang Keju - 12000");
        System.out.println("6. Pangsit Goreng - 11000");
        System.out.println("==========================");
    }
    
    public static void tambahReservasi(ArrayList <Main> invoice){
        Scanner user = new Scanner(System.in);

        System.out.println("Nama(ketik 0 utuk kembali): ");
        String Nama = user.nextLine();
        if (Nama.equals("0")) return;
        
        System.out.println("Waktu Reservasi: ");
        String waktu = user.nextLine();
        
        System.out.println("Nomor Meja: ");
        String meja = user.nextLine();
        
        System.out.println("Apakah ingin pre-Order? (y/n):) ");
        String preOrder = user.nextLine();
       
        String namaMenu = "-";
        int totalHarga = 0;
        
        if (preOrder.equalsIgnoreCase("y")) {
            tampilkanMenu();
            System.out.println("Masukkan nomor invoice yang ingin dipesan (pisahkan dengan koma, contoh: 1,3,5): \n(ketik 0 utuk kembali).");
            String pilihan = user.nextLine();
            if (Nama.equals("0")) return;
            String[] pilihSplit = pilihan.split(",");
            
            StringBuilder pesanan = new StringBuilder();
            for (String p : pilihSplit) {
                switch (p.trim()) {
                    case "1": pesanan.append("Mie Gacoan Lv 1, "); totalHarga += 13000; break;
                    case "2": pesanan.append("Mie Gacoan Lv 2, "); totalHarga += 14000; break;
                    case "3": pesanan.append("Mie Gacoan Lv 3, "); totalHarga += 15000; break;
                    case "4": pesanan.append("Udang Rambutan, "); totalHarga += 10000; break;
                    case "5": pesanan.append("Udang Keju, "); totalHarga += 12000; break;
                    case "6": pesanan.append("Pangsit Goreng, "); totalHarga += 11000; break;
                    default: System.out.println("Pilihan " + p + " tidak valid.");
                }
            }
            if (pesanan.length() > 0) {
                namaMenu = pesanan.substring(0, pesanan.length()-2);
            }
        } 
        
        invoice.add(new Main(Nama, waktu, meja, preOrder, namaMenu, String.valueOf(totalHarga)));
        System.out.println("Reservasi Berhasil!");
        if (preOrder.equalsIgnoreCase("y")) {
            System.out.println("Total harga pesanan: Rp " + totalHarga);
        }
    }
    
    public static void ubahReservasi(ArrayList <Main> invoice){
        Scanner user = new Scanner(System.in);

        if (invoice.isEmpty()) {
            System.out.println("Belum ada reservasi untuk diubah.");
            return;
        }

        int no = 1;
        for (Main b:invoice){
            System.out.println("\n=======================");
            System.out.println("No.             : " + no++);
            System.out.println("Nama Pemesan    : " + b.Nama);
            System.out.println("Waktu Reservasi : " + b.waktu);
            System.out.println("Meja            : " + b.meja);
            System.out.println("PreOrder        : " + b.preOrder);
            System.out.println("Pesanan         : " + b.namaMenu);
            System.out.println("Harga           : " + b.Harga);
            System.out.println("=======================\n");
        }

        System.out.print("Pilih nomor reservasi yang ingin diubah (Ketik 0 untuk kembali): ");
        int update = user.nextInt();
        user.nextLine(); // buang enter

        if (update == 0) {
            return;
        }

        if (update > 0 && update <= invoice.size()) {
            Main baru = invoice.get(update - 1);

            System.out.print("Nama Pemesan baru (" + baru.Nama + "): ");
            String Nama = user.nextLine();
            if (!Nama.isEmpty()) baru.Nama = Nama;

            System.out.print("Waktu Reservasi baru (" + baru.waktu + "): ");
            String waktu = user.nextLine();
            if (!waktu.isEmpty()) baru.waktu = waktu;

            System.out.print("Nomor Meja baru (" + baru.meja + "): ");
            String meja = user.nextLine();
            if (!meja.isEmpty()) baru.meja = meja;

            System.out.print("Apakah ingin pre-Order? (y/n) [" + baru.preOrder + "]: ");
            String preOrder = user.nextLine();
            if (!preOrder.isEmpty()) baru.preOrder = preOrder;

            String namaMenu = baru.namaMenu;  
            int totalHarga = Integer.parseInt(baru.Harga);

            if (baru.preOrder.equalsIgnoreCase("y")) {
                tampilkanMenu();
                System.out.println("Masukkan nomor menu yang ingin dipesan (pisahkan dengan koma, atau Enter untuk biarkan tetap): ");
                String pilihan = user.nextLine();

                if (!pilihan.isEmpty()) {
                    String[] pilihSplit = pilihan.split(",");
                    StringBuilder pesanan = new StringBuilder();
                    totalHarga = 0;

                    for (String p : pilihSplit) {
                        switch (p.trim()) {
                            case "1": pesanan.append("Mie Gacoan Lv 1, "); totalHarga += 13000; break;
                            case "2": pesanan.append("Mie Gacoan Lv 2, "); totalHarga += 14000; break;
                            case "3": pesanan.append("Mie Gacoan Lv 3, "); totalHarga += 15000; break;
                            case "4": pesanan.append("Udang Rambutan, "); totalHarga += 10000; break;
                            case "5": pesanan.append("Udang Keju, "); totalHarga += 12000; break;
                            case "6": pesanan.append("Pangsit Goreng, "); totalHarga += 11000; break;
                            default: System.out.println("Pilihan " + p + " tidak valid.");
                        }
                    }

                    if (pesanan.length() > 0) {
                        namaMenu = pesanan.substring(0, pesanan.length() - 2);
                    }
                }
            } else {
                namaMenu = "-";
                totalHarga = 0;
            }

            baru.namaMenu = namaMenu;
            baru.Harga = String.valueOf(totalHarga);

            System.out.println("Reservasi berhasil diperbarui!");
        } else {
            System.out.println("Pilihan tidak tersedia.");
        }
    }


    
    public static void hapusReservasi(ArrayList <Main> invoice){
        Scanner user = new Scanner(System.in);
        System.out.println("==== Hapus Reservasi ====");
        if (invoice.isEmpty()){
            System.out.println("Belum Ada Reservasi");
        } else {
            int index = 1;
            for (Main b:invoice){
                System.out.println(index++ + ". " + b.Nama + " pada waktu "+ b.waktu + " di meja " + b.meja);
            }    
            System.out.println("Pilih Nomor Reservasi yang ingin di hapus: \n (Ketik 0 jika ingin kembali)");
            int hapus = user.nextInt();
            user.nextLine();
                
            if (hapus == 0){
                return;
            }
                
            if (hapus > 0 && hapus <= invoice.size()){
                Main diHapus  = invoice.remove(hapus -1);
                    
                System.out.println("==== Reservasi " + diHapus.Nama + " pada waktu " + diHapus.waktu  + " berhasil di hapus.");
            } else {
                System.out.println("Pilihan tidak tersedia.");
            }
                
                
            }
        
    }
}
    

