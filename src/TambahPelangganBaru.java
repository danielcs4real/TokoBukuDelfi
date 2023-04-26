import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TambahPelangganBaru extends JFrame implements ActionListener {
    private TokoBuku tokoBuku;
    private JLabel headerLabel= new JLabel("Tambah Pelanggan Baru");
    private JLabel namaLabel = new JLabel("Nama");
    private JTextField namaField = new JTextField();
//    private JLabel jumlahBukuLabel = new JLabel("Jumlah Buku");
//    private JTextField jumlahBukuField = new JTextField();
    private JPanel panel = new JPanel();
    private JButton tambahButton = new JButton("Tambah");
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem[] menuItems = new JMenuItem[]{};
    private String[] Labels = new String[] {
            "Tambah Buku Baru", "Hapus Buku", "Tambah Koleksi Baru",
            "Hapus Koleksi", "Tambah Transaksi Baru",
            "Tampilkan Riwayat Transaksi", "Tambah Pelanggan Baru",
            "Keluar", "Akhiri Sesi"
    };
    public TambahPelangganBaru(TokoBuku tokoBuku){
        this.tokoBuku = tokoBuku;
        this.setTitle("Tambah Pelanggan Baru");
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
        for (String l: Labels){
            JMenuItem item = new JMenuItem(l);
            item.addActionListener(this);
            item.setFocusable(false);
            fileMenu.add(item);
            fileMenu.addSeparator();
        }
        //dummy local pelanggan
        Pelanggan pelanggan1 = new Pelanggan("Pelanggan1", "PL0001", 12);
        Pelanggan pelanggan2 = new Pelanggan("Pelanggan2", "PL0002", 10);
        Pelanggan pelanggan3 = new Pelanggan("Pelanggan3", "PL0003", 8);
        daftarPelanggan.add(pelanggan1);
        daftarPelanggan.add(pelanggan2);
        daftarPelanggan.add(pelanggan3);


        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setBounds(0,20,800,100);
        add(headerLabel, BorderLayout.NORTH);


        namaLabel.setBounds(40,30,230,30);
        namaLabel.setForeground(Color.BLACK);
        panel.add(namaLabel);
        namaField.setBounds(150,30,200,30);
        panel.add(namaField);

        panel.setBounds(200,100,400,200);
        panel.setBackground(Color.GRAY);
        tambahButton.addActionListener(this);
        tambahButton.setBackground(Color.BLACK);
        tambahButton.setForeground(Color.WHITE);
        tambahButton.setBounds(150, 140, 100, 30);
        panel.add(tambahButton);

        setLocationRelativeTo(null);
        panel.setLayout(null);
        add(panel,BorderLayout.CENTER);

        setLayout(null);
        getContentPane().setBackground(Color.lightGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage((new ImageIcon(this.getClass().getResource("icon.png"))).getImage());
        setBounds(300, 90, 800, 490);
        setVisible(true);
        setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tambahButton)
        {
            if(namaField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                return;
            }
            else
            {
                String nama = namaField.getText();
                String ID = String.format("PL%03d",daftarPelanggan.size()+1);
//                String jumlahBuku = jumlahBukuField.getText();
                //Gua ubah jdi string, ini sebenernya dia cmn butuh nama, tar yg id nya digenerate pada saat buttonnya diklik

                Pelanggan pelanggan = new Pelanggan(nama, ID);
                daftarPelanggan.add(pelanggan);
                JOptionPane.showInternalMessageDialog(null, "Data Berhasil Ditambahkan");
                System.out.println("ID = " + ID);
                int res = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menambahkan data lagi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                //yes = 0 , no = 1
                if (res==1) {
                    dispose();
                } else if (res==0) {
                    namaField.setText("");
//                    jumlahBukuField.setText("");
                }

            }
        }
        if(e.getSource() instanceof JMenuItem item){
            String option = item.getText();
            if (option.equals("Tambah Buku Baru")) {
                int res = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin berpindah halaman? Proses yang belum anda simpan tidak akan disimpan.", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    new TambahBukuBaru(tokoBuku);
                    dispose();
                }
            } else if (option.equals("Hapus Buku")) {
                int res = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin berpindah halaman? Proses yang belum anda simpan tidak akan disimpan.", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    new HapusBuku(tokoBuku);
                    dispose();
                }
            } else if (option.equals("Tambah Koleksi Baru")) {
//                int res = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin berpindah halaman? Proses yang belum anda simpan tidak akan disimpan.", "Konfirmasi", JOptionPane.YES_NO_OPTION);
//                if (res == JOptionPane.YES_OPTION) {
//                    new TambahKoleksiBaru(tokoBuku);
//                    dispose();
//                }
            } else if (option.equals("Hapus Koleksi")) {
                int res = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin berpindah halaman? Proses yang belum anda simpan tidak akan disimpan.", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    new HapusKoleksi(tokoBuku);
                    dispose();
                }
            } else if (option.equals("Tambah Transaksi Baru")) {
                int res = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin berpindah halaman? Proses yang belum anda simpan tidak akan disimpan.", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    new TambahTransaksiBaru(tokoBuku);
                    dispose();
                }
            } else if (option.equals("Tampilkan Riwayat Transaksi")) {
                int res = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin berpindah halaman? Proses yang belum anda simpan tidak akan disimpan.", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    new TampilkanRiwayatTransaksi(tokoBuku);
                    dispose();
                }
            } else if (option.equals("Tambah Pelanggan Baru")) {
                // do nothing karena sudah berada pada page yang dituju
            } else if (option.equals("Keluar")) {
                int res = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin keluar? Anda akan diminta untuk memasukkan id dan password anda kembali.", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    new Keluar(tokoBuku);
                    dispose();
                }
            } else if (option.equals("Akhiri Sesi")) {
                int res = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengakhiri sesi ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        }
    }
}

