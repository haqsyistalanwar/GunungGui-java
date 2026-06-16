import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hiking extends JFrame {

    JLabel title, subTitle, namaUser, alat, hari, bayar, lblInfoHarga;
    JComboBox<String> cbAlat;
    JTextField txtHari, txtBayar;
    JButton btnBayar, btnReset, btnLogout;
    JTextArea hasil;

    public Hiking(String user) {
        setTitle("AQSYIST ADVENTURE - Professional Rental");
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 242, 245));

        // --- HEADER ---
        // Ganti path "pangrango.jpg" dengan warna atau hapus jika tidak ada file gambarnya
        JPanel header = new JPanel();
        header.setBounds(0, 0, 1200, 240);
        header.setBackground(new Color(50, 50, 50));
        header.setLayout(null);
        add(header);

        title = new JLabel("AQSYIST ADVENTURE");
        title.setBounds(350, 60, 600, 50);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 45));
        header.add(title);

        subTitle = new JLabel("Sewa Alat Hiking Kualitas Premium");
        subTitle.setBounds(420, 115, 400, 30);
        subTitle.setForeground(new Color(200, 200, 200));
        subTitle.setFont(new Font("SansSerif", Font.ITALIC, 18));
        header.add(subTitle);

        // --- PANEL UTAMA ---
        JPanel panel = new JPanel();
        panel.setBounds(250, 280, 700, 380);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        add(panel);

        namaUser = new JLabel("Halo, " + user + "! Siap mendaki hari ini?");
        namaUser.setBounds(30, 20, 400, 30);
        namaUser.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(namaUser);

        int xCol = 30;
        int yStart = 70;

        alat = new JLabel("Pilih Alat:");
        alat.setBounds(xCol, yStart, 200, 25);
        panel.add(alat);

        String dataAlat[] = {"Tenda", "Carrier", "Sleeping Bag", "Kompor Portable", "Headlamp"};
        cbAlat = new JComboBox<>(dataAlat);
        cbAlat.setBounds(xCol, yStart + 25, 270, 40);
        panel.add(cbAlat);

        lblInfoHarga = new JLabel("Pilih alat untuk cek harga...");
        lblInfoHarga.setBounds(xCol, yStart + 65, 270, 20);
        lblInfoHarga.setForeground(new Color(50, 150, 50));
        panel.add(lblInfoHarga);

        hari = new JLabel("Durasi (Hari):");
        hari.setBounds(xCol, yStart + 100, 200, 25);
        panel.add(hari);
        txtHari = new JTextField();
        txtHari.setBounds(xCol, yStart + 125, 270, 40);
        panel.add(txtHari);

        bayar = new JLabel("Jumlah Uang:");
        bayar.setBounds(xCol, yStart + 175, 200, 25);
        panel.add(bayar);
        txtBayar = new JTextField();
        txtBayar.setBounds(xCol, yStart + 200, 270, 40);
        panel.add(txtBayar);

        hasil = new JTextArea();
        hasil.setBounds(350, 20, 320, 250);
        hasil.setEditable(false);
        hasil.setBorder(BorderFactory.createTitledBorder(" Struk Transaksi "));
        panel.add(hasil);

        btnBayar = new JButton("PROSES BAYAR");
        btnBayar.setBounds(350, 280, 150, 45);
        btnBayar.setBackground(new Color(45, 200, 100));
        btnBayar.setForeground(Color.WHITE);
        panel.add(btnBayar);

        btnReset = new JButton("RESET");
        btnReset.setBounds(510, 280, 80, 45);
        panel.add(btnReset);

        btnLogout = new JButton("LOGOUT");
        btnLogout.setBounds(600, 280, 80, 45);
        btnLogout.setBackground(new Color(255, 100, 100));
        btnLogout.setForeground(Color.WHITE);
        panel.add(btnLogout);

        // --- LOGIKA LISTENER ---
        cbAlat.addActionListener(e -> {
            String sel = cbAlat.getSelectedItem().toString();
            int h = 0;
            if (sel.equals("Tenda")) h = 70000;
            else if (sel.equals("Carrier")) h = 40000;
            else if (sel.equals("Sleeping Bag")) h = 20000;
            else if (sel.equals("Kompor Portable")) h = 20000;
            else if (sel.equals("Headlamp")) h = 15000;
            lblInfoHarga.setText("Harga per unit: Rp " + h);
        });

        btnBayar.addActionListener(e -> {
            try {
                String sel = cbAlat.getSelectedItem().toString();
                int h = 0;
                if (sel.equals("Tenda")) h = 70000;
                else if (sel.equals("Carrier")) h = 40000;
                else if (sel.equals("Sleeping Bag")) h = 20000;
                else if (sel.equals("Kompor Portable")) h = 20000;
                else if (sel.equals("Headlamp")) h = 15000;

                int d = Integer.parseInt(txtHari.getText());
                int u = Integer.parseInt(txtBayar.getText());
                int total = h * d;

                if (u < total) {
                    hasil.setText("TRANSAKSI GAGAL\nUang kurang Rp " + (total - u));
                } else {
                    hasil.setText("=== STRUK ADVENTURE ===\n\n" +
                                  "Alat : " + sel + "\n" +
                                  "Durasi : " + d + " Hari\n" +
                                  "Total : Rp " + total + "\n" +
                                  "Uang : Rp " + u + "\n" +
                                  "Kembali : Rp " + (u - total) + "\n" +
                                  "Status : LUNAS");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Inputan harus angka, Bray!");
            }
        });

        btnReset.addActionListener(e -> {
            txtHari.setText("");
            txtBayar.setText("");
            hasil.setText("");
        });

        btnLogout.addActionListener(e -> {
            System.exit(0); // Menutup aplikasi
        });
        
        setVisible(true);
    }
}