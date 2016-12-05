
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CustomerCard extends javax.swing.JPanel {

    public CustomerCard() {
        initComponents();
        FillTable();
        tableUpdateDeleteButtonEnable();
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFilter(txtSearch.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFilter(txtSearch.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {//ignore this
            }
        });
    }

    protected void updateFilter(String text) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tblCustomer.getRowSorter();
        RowFilter<TableModel, Object> firstFiler = null;
        RowFilter<TableModel, Object> secondFilter = null;
        RowFilter<TableModel, Object> thirdFiler = null;
        RowFilter<TableModel, Object> fourthFiler = null;
        RowFilter<TableModel, Object> fifthFiler = null;
        List<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel, Object>>();
        RowFilter<TableModel, Object> compoundRowFilter = null;
        try {
            firstFiler = RowFilter.regexFilter(text, 0);
            secondFilter = RowFilter.regexFilter(text, 1);
            thirdFiler = RowFilter.regexFilter(text, 2);
            fourthFiler = RowFilter.regexFilter(text, 3);
            fifthFiler = RowFilter.regexFilter(text, 4);

            filters.add(firstFiler);
            filters.add(secondFilter);
            filters.add(thirdFiler);
            filters.add(fourthFiler);
            filters.add(fifthFiler);

            compoundRowFilter = RowFilter.orFilter(filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(compoundRowFilter);
    }

    protected void FillTable() {
        DefaultTableModel model = (DefaultTableModel) tblCustomer.getModel();
        Object rowData[] = new Object[5];

        for (int i = 0; i < UJS.customers.size(); i++) {
            rowData[0] = UJS.customers.get(i).getCustomerID();
            rowData[1] = UJS.customers.get(i).getCustName();
            rowData[2] = UJS.customers.get(i).getCustIC();
            rowData[3] = UJS.customers.get(i).getCustPhoneNo();
            rowData[4] = UJS.customers.get(i).getCustAddress();
            model.addRow(rowData);
        }
    }

    protected void tableUpdateDeleteButtonEnable() {
        tblCustomer.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tblCustomer.getSelectedRowCount() == 1) {
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                } else {
                    btnUpdate.setEnabled(false);
                    btnDelete.setEnabled(false);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        jLabel1.setText("Search:");

        tblCustomer.setAutoCreateRowSorter(true);
        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer Name", "Customer IC", "Customer Phone No", "Customer Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomer.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCustomer);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setVisible(false);
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnRefresh))
                .addGap(9, 9, 9))
        );
    }// </editor-fold>                        

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        DefaultTableModel model = (DefaultTableModel) tblCustomer.getModel();
        new AddCustomer().setVisible(true);
        model.setRowCount(0);
        FillTable();
    }                                      

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int result = JOptionPane.showConfirmDialog(null, "Confirm delete?", "Deleting", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) tblCustomer.getModel();
            int custID = 0;
            custID = (Integer) tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0);
            UJS.deleteCustomer(custID);
            model.removeRow(tblCustomer.getSelectedRow());
        }
    }                                         

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        DefaultTableModel model = (DefaultTableModel) tblCustomer.getModel();
        UpdateCustomer u = new UpdateCustomer();
        int selectedRow = tblCustomer.getSelectedRow();
        int id = (int) model.getValueAt(selectedRow, 0);

        u.lblCustID.setText("" + id);
        u.txtCustName.setText(model.getValueAt(selectedRow, 1).toString());
        u.txtCustIC.setText(model.getValueAt(selectedRow, 2).toString());
        u.txtCustPhoneNo.setText(model.getValueAt(selectedRow, 3).toString());
        u.txtCustAddress.setText(model.getValueAt(selectedRow, 4).toString());
        u.setVisible(true);
        model.setRowCount(0);
        FillTable();
    }                                         

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {                                           
        DefaultTableModel model = (DefaultTableModel) tblCustomer.getModel();
        model.setRowCount(0);
        FillTable();
    }                                          

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration                   
}
