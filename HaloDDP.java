import java.util.Scanner;

public class HaloDDP {
    public static void main(String[] args) {
        int BASE_PRICE = 5000;
        Scanner input = new Scanner(System.in);
        Lemari lemariBaru = null;
        Rak rak = null;

        System.out.print("Selamat datang Haloddp. Berapa ukuran lemari obat hari ini? (max row 5) ");
        String ukuranLemari = input.nextLine();
        if (!ukuranLemari.matches("\\d+x\\d+")) {
            System.out.println("Format lemari tidak sesuai. Seharusnya <row>x<column>");
            System.out.println("=============================PROGRAM STOPPED============================");
            System.exit(0);
        } else {
            String[] komponen = ukuranLemari.split("x");
            int baris = Integer.parseInt(komponen[0]);
            int kolom = Integer.parseInt(komponen[1]);
            if (baris < 1 || baris > 5 || kolom < 1 || kolom > 5) {
                System.out.println("Ukuran lemari tidak bisa < 1");
                System.out.println("=============================PROGRAM STOPPED============================");
                System.exit(0);
            } else {
                System.out.println("Rak obat hari ini berukuran " + baris + "x" + kolom);
                System.out.println();
                int ukuran = baris * kolom;
                lemariBaru = new Lemari(ukuran);
                System.out.println("Silahkan tentukan kategori obat untuk setiap rak");
                String[] kategoriRakSebelumnya = new String[baris];
                for (int i = 0; i < baris; i++) {
                    boolean isKategoriValid = false;
                    while (!isKategoriValid) {
                        System.out.print("Rak ke-" + (i + 1) + ": ");
                        String kategori = input.nextLine();
                        boolean isRakExist = false;
                        for (String kategoriRak : kategoriRakSebelumnya) {
                            if (kategoriRak != null && kategoriRak.equalsIgnoreCase(kategori)) {
                                isRakExist = true;
                                break;
                            }
                        }
                        if (isRakExist) {
                            System.out.println("Kategori rak tidak valid");
                        } else {
                            kategoriRakSebelumnya[i] = kategori;
                            lemariBaru.addRak(new Rak(kolom, kategori), i);
                            System.out.println("Rak ke-" + (i + 1) + " adalah rak obat " + kategori);
                            isKategoriValid = true;
                        }
                    }
                }

                System.out.println("Rak obat hari ini:");
                lemariBaru.print();
            }
        }

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
                System.out.print("Masukkan nama obat: ");
                String namaObat = input.nextLine();
                System.out.print("Masukkan kategori obat: ");
                String kategoriObat = input.nextLine();

                boolean isKategoriValid = false;
                for (int i = 0; i < lemariBaru.getUkuran(); i++) {
                    rak = lemariBaru.getRak(i);
                    if (rak != null && rak.getKategoriRak().equalsIgnoreCase(kategoriObat)) {
                        isKategoriValid = true;
                        break;
                    }
                }

                if (isKategoriValid) {
                    System.out.println("Kategori obat valid");
                    System.out.print("Masukkan posisi obat (baris,kolom): ");
                    String posisi = input.nextLine();
                    String[] posisiArray = posisi.split(",");
                    int baris = Integer.parseInt(posisiArray[0]) - 1;
                    int kolom = Integer.parseInt(posisiArray[1]) - 1;

                    rak = lemariBaru.getRak(baris);
                    if (lemariBaru.isKategoriRakValid(rak, kategoriObat)) {
                        try {
                            if (rak.getListObat()[kolom] != null) {
                                System.out.println("Rak sudah terisi obat");
                            } else {
                                System.out.print("Masukkan stok obat: ");
                                int stok = Integer.parseInt(input.nextLine());
                                int harga = calculateHarga(baris, kolom, BASE_PRICE);
                                System.out.println(harga + "$");
                                Obat obat = new Obat(namaObat, stok, kategoriObat);
                                obat.setHarga(harga);
                                rak.tambahObat(obat, kolom);
                                System.out.println("Obat berhasil ditambahkan");
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Posisi tidak ada di lemari");
                        }
                    } else {
                        System.out.println("Rak bukan untuk kategori obat " + kategoriObat);
                    }
                } else {
                    System.out.println("Kategori obat tidak valid");
                }
            } else if (menu.equals("2")) {
                System.out.println("Lihat obat:");
                lemariBaru.print();
            } else if (menu.equals("3")) {
                System.out.print("Obat apa yang ingin dibeli? ");
                String namaObat = input.nextLine();
                Obat obat = lemariBaru.searchObat(namaObat);
                if (obat != null) {
                    System.out.print("Ingin beli berapa banyak? ");
                    int jumlah = Integer.parseInt(input.nextLine());
                    boolean berhasilBeli = beliObat(lemariBaru, obat, jumlah);
                    if (berhasilBeli) {
                        System.out.println("Berhasil membeli obat");
                    } else {
                        System.out.println("Stok obat tidak mencukupi");
                    }
                } else {
                    System.out.println("Obat tidak ditemukan");
                }
            } else if (menu.equals("99")) {
                //keluar program
                if (rak == null) {
                    System.out.println("Tetap semangat. Besok pasti akan jauh lebih baik!");
                    break;
                } else { //menampulkan riwayat transaksi
                    int counter = 1;
                    System.out.println("Riwayat transaksi hari ini");
                    System.out.println();
                    System.out.println("No. Nama - Jumlah - Total Harga");
                    for (int i = lemariBaru.getUkuran() - 1; i >= 0; i--) {
                        rak = lemariBaru.getRak(i);
                        if (rak != null) {
                            for (int j = rak.getListObat().length - 1; j >= 0; j--) {
                                Obat obat = rak.getListObat()[j];
                                if (obat != null && obat.getJumlahTerjual() > 0) {
                                    System.out.println(counter + ". " + obat.getNama() + " - " +
                                            obat.getJumlahTerjual() + " - " + obat.getTotalPendapatan());
                                    counter++;
                                }
                            }
                        }
                    }
    
                    System.out.println();
                    break;
                }
            } else {
                System.out.println("Menu tidak tersedia");
            }
        }

        input.close();
        System.out.println("Terima kasih telah menggunakan Haloddp!");
    }
    /*Proses Pembelian obat */
    public static boolean beliObat(Lemari lemari, Obat obat, int jumlah) {
        Rak rak = searchRak(lemari, obat);
        if (rak != null) {
            if (obat.getStok() >= jumlah) {
                int totalHarga = obat.getHarga() * jumlah;
                System.out.println(obat.getHarga());
                System.out.println(jumlah);
                System.out.println(totalHarga + "&");
                obat.setStok(obat.getStok() - jumlah);
                tambahTransaksi(rak, obat, jumlah, totalHarga);
                return true;
            }
        }
        return false;
    }
    /*Mencari rak berdasarkan obat */
    private static Rak searchRak(Lemari lemari, Obat obat) {
        for (int i = 0; i < lemari.getUkuran(); i++) {
            Rak rak = lemari.getRak(i);
            if (rak != null && rak.isObatExist(obat)) {
                return rak;
            }
        }
        return null;
    }
    /*Menambahkan transaksi pembelian obat */
    private static void tambahTransaksi(Rak rak, Obat obat, int jumlah, int totalHarga) {
        obat.setTransaksi(jumlah, totalHarga);
    }

    /*Menghitung harga obat */
    private static int calculateHarga(int baris, int kolom, int basePrice) {
        int i = baris;
        int j = kolom;
        return basePrice + (i * 10000) + (j * 5000);
    }
}
