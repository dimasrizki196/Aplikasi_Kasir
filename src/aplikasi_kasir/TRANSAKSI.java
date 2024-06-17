/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi_kasir;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class TRANSAKSI extends javax.swing.JFrame {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi(); 
    public TRANSAKSI() {
        super("Transaksi Toko");
        initComponents();
        k.connect();
        refreshTable();
        refreshCombo();
    }
    
    class menu_transaksi extends TRANSAKSI{
        int id_transaksi, id_barang, harga, jumlah_beli, total_bayar;
        String nama_pelanggan, tanggal, nama_barang;
        
      
        public menu_transaksi(){
            this.nama_pelanggan = text_nama_pelanggan.getText();
            String combo = combo_id_barang.getSelectedItem().toString();
            String[] arr = combo.split("-");
            this.id_barang = Integer.parseInt(arr[0]);
            try{
                Date date = text_tanggal.getDate();
                DateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
                this.tanggal = dateformat.format(date); 
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getCause().getMessage());
            }
            this.nama_barang = arr[1];
            this.harga = Integer.parseInt(arr[2]);
            this.jumlah_beli = Integer.parseInt(text_jumlah_beli.getText());
            this.total_bayar = this.harga * this.jumlah_beli;
            
        }
    }
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID TRANSAKSI");
        model.addColumn("Nama Pelanggan");
        model.addColumn("ID Barang");
        model.addColumn("Tanggal");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Jumlah Beli");
        model.addColumn("Total Bayar");
        tabel_transaksi.setModel(model);
        try {
            this.stat = k.getCon().prepareStatement("select * from transaksi ");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        text_id_transaksi.setText("");
        text_nama_pelanggan.setText("");
        text_jumlah_beli.setText("");
        text_total_bayar.setText("");
    }
    
    public void refreshCombo(){
        try {
            this.stat = k.getCon().prepareStatement("Select * from barang "
                + "where status = 'Tersedia'");
            this.rs = this.stat.executeQuery();
            while(rs.next()){
                combo_id_barang.addItem(rs.getString("id_barang")+"-"+
                rs.getString("nama_barang")+"-"+rs.getString("harga"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
        public int hitungTotalPemasukanHariIni() {
        int totalPemasukan = 0;
        try {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String todayString = today.format(formatter);

            // Lakukan kueri untuk mengambil total bayar transaksi pada hari ini
            this.stat = k.getCon().prepareStatement("SELECT SUM(total_bayar) FROM transaksi WHERE tanggal = ?");
            this.stat.setString(1, todayString);
            this.rs = this.stat.executeQuery();

            if (rs.next()) {
                totalPemasukan = rs.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return totalPemasukan;
    }
        
    public int hitungTotalPemasukan(String selectedDate) {
        int totalPemasukan = 0;
        try {
            // Lakukan kueri untuk mengambil total bayar transaksi pada tanggal tertentu
            this.stat = k.getCon().prepareStatement("SELECT SUM(total_bayar) FROM transaksi WHERE tanggal = ?");
            this.stat.setString(1, selectedDate);
            this.rs = this.stat.executeQuery();

            if (rs.next()) {
                totalPemasukan = rs.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return totalPemasukan;
    }
         

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        label2 = new java.awt.Label();
        text_id_transaksi = new java.awt.TextField();
        label3 = new java.awt.Label();
        text_nama_pelanggan = new java.awt.TextField();
        label5 = new java.awt.Label();
        combo_id_barang = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_input = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        btn_lihat_barang = new javax.swing.JButton();
        label6 = new java.awt.Label();
        label4 = new java.awt.Label();
        text_jumlah_beli = new java.awt.TextField();
        label7 = new java.awt.Label();
        text_total_bayar = new java.awt.TextField();
        text_tanggal = new com.toedter.calendar.JDateChooser();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSAKSI");

        label2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        label2.setText("ID TRANSAKSI");

        text_id_transaksi.setEnabled(false);
        text_id_transaksi.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        text_id_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_id_transaksiActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        label3.setText("NAMA PELANGGAN");

        text_nama_pelanggan.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        text_nama_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nama_pelangganActionPerformed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        label5.setText("ID Barang");

        combo_id_barang.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_transaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel_transaksi);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        btn_input.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btn_input.setText("INPUT");
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
        });
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_laporan.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btn_laporan.setText("Laporan");
        btn_laporan.setEnabled(false);
        btn_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_input)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        btn_logout.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btn_logout.setText("LOGOUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        btn_lihat_barang.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btn_lihat_barang.setText("Lihat Barang");
        btn_lihat_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lihat_barangActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        label6.setText("Tanggal");

        label4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        label4.setText("Jumlah Beli");

        text_jumlah_beli.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        text_jumlah_beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_jumlah_beliActionPerformed(evt);
            }
        });

        label7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        label7.setText("Total Bayar");

        text_total_bayar.setEnabled(false);
        text_total_bayar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        text_total_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_total_bayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_logout))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_total_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_nama_pelanggan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_id_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combo_id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_lihat_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(text_jumlah_beli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_logout)
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text_id_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text_nama_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo_id_barang)
                    .addComponent(btn_lihat_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(text_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text_jumlah_beli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text_total_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_id_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_id_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_id_transaksiActionPerformed

    private void text_nama_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nama_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nama_pelangganActionPerformed

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        // TODO add your handling code here:
        try {           
            menu_transaksi mt = new menu_transaksi();
            if(mt.jumlah_beli<0){
                    JOptionPane.showMessageDialog(null, "Jumlah Barang Tidak Dapat Negatif", "Error", JOptionPane.ERROR_MESSAGE);
                    text_jumlah_beli.setText("");
                    mt.setVisible(true);
                    this.setVisible(false);
                               
            }else{
               
            text_total_bayar.setText(""+mt.total_bayar);
            this.stat = k.getCon().prepareStatement("insert into transaksi values (?,?,?,?,?,?,?,?)");
            this.stat.setInt(1, 0);
            this.stat.setString(2, mt.nama_pelanggan);
            this.stat.setInt(3, mt.id_barang);
            this.stat.setString(4, mt.tanggal);
            this.stat.setString(5, mt.nama_barang);
            this.stat.setInt(6, mt.harga);
            this.stat.setInt(7, mt.jumlah_beli);
            this.stat.setInt(8, mt.total_bayar);
            int pilihan = JOptionPane.showConfirmDialog(null, 
                    "Tanggal: "+mt.tanggal+
                    "\nNama Pelanggan: "+mt.nama_pelanggan+
                    "\nPembelian: "+mt.jumlah_beli+" "+mt.nama_barang+
                    "\nTotal Bayar: "+mt.total_bayar+"\n",
                    "Tambahakan Transaksi?",
                    JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.YES_OPTION) {
                    this.stat.executeUpdate();
                    refreshTable();
                  
              
            } else if(pilihan == JOptionPane.NO_OPTION){
                refreshTable();
            }}
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }   
        
        
    }//GEN-LAST:event_btn_inputActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            menu_transaksi mt = new menu_transaksi();
            if(mt.jumlah_beli<0){
                    JOptionPane.showMessageDialog(null, "Jumlah Barang Tidak Dapat Negatif", "Error", JOptionPane.ERROR_MESSAGE);
                    text_jumlah_beli.setText("");
                    mt.setVisible(true);
                    this.setVisible(false);
                               
            }else{
            mt.id_transaksi = Integer.parseInt(text_id_transaksi.getText());
            this.stat = k.getCon().prepareStatement("update transaksi set nama_pelanggan=?,"
                    + "id_barang=?, tanggal=?,nama_barang=?, harga=?, jumlah_beli=?, total_bayar=? "
                    + "where id_transaksi=?");
            this.stat.setString(1, mt.nama_pelanggan);
            this.stat.setInt(2, mt.id_barang);
            this.stat.setString(3, mt.tanggal);
            this.stat.setString(4, mt.nama_barang);
            this.stat.setInt(5, mt.harga);
            this.stat.setInt(6, mt.jumlah_beli);
            this.stat.setInt(7, mt.total_bayar);
            this.stat.setInt(8, mt.id_transaksi);
            this.stat.executeUpdate();
            refreshTable();
            int pilihan = JOptionPane.showConfirmDialog(null, 
                    "Tanggal: "+mt.tanggal+
                    "\nNama Pelanggan: "+mt.nama_pelanggan+
                    "\nPembelian: "+mt.jumlah_beli+" "+mt.nama_barang+
                    "\nTotal Bayar: "+mt.total_bayar+"\n",
                    "Tambahakan Transaksi?",
                    JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.YES_OPTION) {
                    this.stat.executeUpdate();
                    refreshTable();
                  
              
            } else if(pilihan == JOptionPane.NO_OPTION){
                refreshTable();
            }}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try {
            menu_transaksi mt = new menu_transaksi();
            mt.id_transaksi = Integer.parseInt(text_id_transaksi.getText());
            this.stat = k.getCon().prepareStatement("delete from transaksi "
                    + "where id_transaksi=?");
            this.stat.setInt(1, mt.id_transaksi);
            this.stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed
    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
        // TODO add your handling code here:
        refreshTable(); // Refresh tabel untuk memastikan data terbaru ditampilkan        
        // Ambil total pemasukan hari ini
        int totalPemasukanHariIni = hitungTotalPemasukanHariIni();      
        DefaultTableModel tableModel = (DefaultTableModel) tabel_transaksi.getModel();
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        // Tambahkan label untuk menampilkan total pemasukan hari ini
        JLabel labelTotalPemasukan = new JLabel("Total Pemasukan Hari Ini: " + totalPemasukanHariIni);
        // Buat panel untuk menampung tabel dan label total pemasukan
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        // Set warna latar belakang panel utama
        panel.setBackground(Color.WHITE);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(labelTotalPemasukan, BorderLayout.SOUTH);
        panel.setOpaque(true);
        // Tampilkan panel dalam JOptionPane
        JOptionPane.showMessageDialog(this, panel, "Laporan Hari Ini", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
    }//GEN-LAST:event_btn_laporanActionPerformed

    private void btn_lihat_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lihat_barangActionPerformed
        // TODO add your handling code here:
        FORM_BARANG fb = new FORM_BARANG();
        fb.setVisible(true);
        this.setVisible(false);
        fb.btn_delete.setEnabled(true);
        fb.btn_input.setEnabled(true);
        fb.btn_update.setEnabled(true);
        fb.btn_transaksi.setEnabled(true);
    }//GEN-LAST:event_btn_lihat_barangActionPerformed
    private void text_jumlah_beliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_jumlah_beliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_jumlah_beliActionPerformed
    private void text_total_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_total_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_total_bayarActionPerformed
    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        FORM_LOGIN l = new FORM_LOGIN();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_logoutActionPerformed
    private void tabel_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_transaksiMouseClicked
        // TODO add your handling code here:
        text_id_transaksi.setText(model.getValueAt(tabel_transaksi.getSelectedRow(),0).toString());
        text_nama_pelanggan.setText(model.getValueAt(tabel_transaksi.getSelectedRow(),1).toString());
        text_jumlah_beli.setText(model.getValueAt(tabel_transaksi.getSelectedRow(),6).toString());
        text_total_bayar.setText(model.getValueAt(tabel_transaksi.getSelectedRow(),7).toString());
    }//GEN-LAST:event_tabel_transaksiMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TRANSAKSI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TRANSAKSI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_delete;
    public javax.swing.JButton btn_input;
    public javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_lihat_barang;
    public javax.swing.JButton btn_logout;
    public javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo_id_barang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JTable tabel_transaksi;
    private java.awt.TextField text_id_transaksi;
    private java.awt.TextField text_jumlah_beli;
    private java.awt.TextField text_nama_pelanggan;
    private com.toedter.calendar.JDateChooser text_tanggal;
    private java.awt.TextField text_total_bayar;
    // End of variables declaration//GEN-END:variables
}
