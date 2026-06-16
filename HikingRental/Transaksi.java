public class Transaksi {

    String nama;
    String alat;
    int hari;

    public Transaksi(
            String nama,
            String alat,
            int hari
    ) {

        this.nama = nama;
        this.alat = alat;
        this.hari = hari;

    }

    // HARGA PER HARI
    public int hargaPerHari() {

        switch (alat) {

            case "Tenda":
                return 50000;

            case "Carrier":
                return 40000;

            case "Sleeping Bag":
                return 30000;

            case "Kompor Portable":
                return 25000;

            case "Headlamp":
                return 15000;

            default:
                return 0;
        }
    }

    // TOTAL
    public int hitungTotal() {

        return hargaPerHari() * hari;

    }
}