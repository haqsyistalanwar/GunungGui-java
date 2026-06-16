public class Bayar {

    int total;

    public Bayar(int total) {

        this.total = total;

    }

    // DISKON
    public int diskon() {

        if (total >= 150000) {

            return 20000;

        } else {

            return 0;
        }
    }

    // TOTAL BAYAR
    public int totalBayar() {

        return total - diskon();

    }
}