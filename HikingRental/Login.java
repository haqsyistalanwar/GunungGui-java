import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    JLabel title, sub;
    JLabel nama, umur;

    JTextField txtNama, txtUmur;

    JButton btnMasuk;

    public Login() {

        // FRAME
        setTitle("AQSYIST ADVENTURE");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // BACKGROUND
        JLabel bg =
                new JLabel(
                        new ImageIcon("pangrango.jpg")
                );

        bg.setBounds(0,0,900,600);

        add(bg);

        // OVERLAY
        JPanel overlay = new JPanel();

        overlay.setBounds(0,0,900,600);

        overlay.setBackground(
                new Color(0,0,0,120)
        );

        overlay.setLayout(null);

        bg.add(overlay);

        // PANEL LOGIN
        JPanel panel = new JPanel();

        panel.setBounds(250,120,400,330);

        panel.setBackground(Color.WHITE);

        panel.setLayout(null);

        overlay.add(panel);

        // TITLE
        title =
                new JLabel(
                        "AQSYIST ADVENTURE"
                );

        title.setBounds(30,25,350,40);

        title.setFont(
                new Font(
                        "Poppins",
                        Font.BOLD,
                        28
                )
        );

        panel.add(title);

        // SUBTITLE
        sub =
                new JLabel(
                        "Sewa Alat Hiking Modern"
                );

        sub.setBounds(85,65,250,25);

        sub.setForeground(Color.GRAY);

        panel.add(sub);

        // NAMA
        nama = new JLabel("Nama");

        nama.setBounds(40,110,100,25);

        nama.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        panel.add(nama);

        txtNama = new JTextField();

        txtNama.setBounds(40,135,300,40);

        panel.add(txtNama);

        // UMUR
        umur = new JLabel("Umur");

        umur.setBounds(40,190,100,25);

        umur.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        panel.add(umur);

        txtUmur = new JTextField();

        txtUmur.setBounds(40,215,300,40);

        panel.add(txtUmur);

        // BUTTON
        btnMasuk =
                new JButton("Masuk");

        btnMasuk.setBounds(115,275,160,45);

        btnMasuk.setBackground(
                new Color(34,197,94)
        );

        btnMasuk.setForeground(Color.WHITE);

        btnMasuk.setFocusPainted(false);

        panel.add(btnMasuk);

        // EVENT
        btnMasuk.addActionListener(e -> {

            String namaUser =
                    txtNama.getText();

            Hiking hiking =
                    new Hiking(namaUser);

            hiking.setVisible(true);

            dispose();

        });
    }

    public static void main(String[] args) {

        new Login().setVisible(true);

    }
}