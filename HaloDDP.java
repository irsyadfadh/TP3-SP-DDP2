import java.util.Scanner;

public class HaloDDP {
    public static void main(String[] args) {
        int BASE_PRICE = 5000; 
        Scanner input = new Scanner(System.in);
        
        System.out.print("Selamat datang Haloddp. Berapa ukuran lemari obat hari ini? (max row 5) ");
        // TODO : Implementasi validasi input ukuran lemari

        // TODO : Buat objek lemari dengan ukuran yang sudah ditentukan
        String ukuranLemari = input.nextLine();
        
        if (!ukuranLemari.matches("\\d+x\\d+")) {
            System.out.println("Format lemari tidak sesuai. Seharusnya <row>x<column>");
            System.out.println("=============================PROGRAM STOPPED============================");
            System.exit(0);
        }

        String[] ukuran = ukuranLemari.split("x");
        int row = Integer.parseInt(ukuran[0]);
        int column = Integer.parseInt(ukuran[1]);

        if (row < 1 || column < 1) {
            System.out.println("Ukuran lemari tidak bisa < 1");
            System.out.println("=============================PROGRAM STOPPED============================");
            System.exit(0);
        }

        Lemari lemari = new Lemari(row * column);

        System.out.println("Rak obat hari ini berukuran " + row + "x" + column);


        System.out.println("Silahkan tentukan kategori obat untuk setiap rak");
        // TODO : Implementasi input kategori rak
        for (int i = 0; i < lemari.getUkuran(); i++) {
            System.out.print("Rak ke-" + (i+1) + ": ");
            String kategori = input.nextLine();
            Rak rak = new Rak(1, kategori);
            lemari.addRak(rak, i);
            System.out.println("Rak ke-" + (i+1) + " adalah rak obat " + kategori);
        }

        System.out.println("Rak obat hari ini:");
        lemari.print();

        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Tambah obat");
            System.out.println("2. Lihat obat");
            System.out.println("3. Beli obat");
            System.out.println("99. Keluar");
            System.out.print("Pilih menu: ");
            String menu = input.nextLine();

            if (menu.equals("1")) {
                // TODO : Implementasi input obat
                System.out.print("Masukkan nama obat: ");
                String namaObat = input.nextLine();
                System.out.print("Masukkan kategori obat: ");
                String kategoriObat = input.nextLine();

                Rak rakObat = null;
                for (int i = 0; i < lemari.getUkuran(); i++) {
                    Rak rak = lemari.getRak(i);
                    if (rak.getKategoriRak().equals(kategoriObat)) {
                        rakObat = rak;
                        break;
                    }
                }

                if (rakObat == null) {
                    System.out.println("Kategori obat tidak sesuai dengan kategori rak. Penambahan obat dibatalkan.");
                    continue;
                }

                System.out.print("Masukkan posisi obat (format : x,y): ");
                String posisiObat = input.nextLine();
                if (!posisiObat.matches("\\d+,\\d+")) {
                    System.out.println("Format posisi obat tidak sesuai. Penambahan obat dibatalkan.");
                    continue;
                }
                String[] posisi = posisiObat.split(",");
                int x = Integer.parseInt(posisi[0]) - 1;
                int y = Integer.parseInt(posisi[1]) - 1;

                if (x < 0 || x >= rakObat.getSize() || y < 0 || y >= rakObat.getSize()) {
                    System.out.println("Posisi tidak valid. Penambahan obat dibatalkan.");
                    continue;
                }

                if (rakObat.getObat(x, y) != null) {
                    System.out.println("Rak sudah terisi obat. Penambahan obat dibatalkan.");
                    continue;
                }

                System.out.print("Masukkan stok obat: ");
                int stokObat = input.nextInt();
                input.nextLine(); // Membuang newline character

                if (stokObat < 1) {
                    System.out.println("Stok obat tidak boleh kurang dari 1. Penambahan obat dibatalkan.");
                    continue;
                }

                Obat obat = new Obat(namaObat, stokObat, kategoriObat);
                rakObat.tambahObat(obat, x, y);
                System.out.println("Obat berhasil ditambahkan");
            } else if (menu.equals("2")) {
                // TODO : Implementasi print obat
            } else if (menu.equals("3")) {
                // TODO : Implementasi beli obat
            } else if (menu.equals("99")){
                // TODO : Implementasi keluar
                break;
            } else {
                System.out.println("Menu tidak tersedia");
            }
        }

        input.close();
        System.out.println("Terima kasih telah menggunakan Haloddp!");
    }
}
