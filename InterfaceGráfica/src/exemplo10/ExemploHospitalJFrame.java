package exemplo10;

import exemplo08.JFrameBaseInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class ExemploHospitalJFrame implements JFrameBaseInterface {

    private int linhaSelecionada = -1;
    private JFrame jFrame;
    private JTextField jTextFieldNome;
    private JFormattedTextField jFormattedTextFieldCNPJ;
    private JComboBox jComboBoxCategoria;
    private JCheckBox jCheckBoxPrivado;
    private JTextField jTextFieldRendaAnual, jTextFieldAno;
    private JLabel jLabelAno, jLabelNome, jLabelRendaAnual,
            jLabelCategoria, jLabelCNPJ;
    private JButton jButtonAdicionar, jButtonEditar,
            jButtonExcluir;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private DefaultTableModel dtm;
    private ArrayList<Hospital> hospitais = new ArrayList<>();

    public ExemploHospitalJFrame() {
        gerarTela();
        instanciarComponentes();
        gerarLocalizacoes();
        gerarDimencoes();
        adicionarComponentes();
        acaoBotaoAdicionar();
        acaoEditar();
        acaoExcluir();
        jFrame.setVisible(true);
    }

    @Override
    public void gerarTela() {
        jFrame = new JFrame("Hospital para o seu momento");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(600, 500);
        jFrame.setLocationRelativeTo(null);
    }

    @Override
    public void adicionarComponentes() {
        jFrame.add(jTextFieldAno);
        jFrame.add(jTextFieldNome);
        jFrame.add(jTextFieldRendaAnual);
        jFrame.add(jComboBoxCategoria);
        jFrame.add(jCheckBoxPrivado);
        jFrame.add(jLabelAno);
        jFrame.add(jLabelCategoria);
        jFrame.add(jLabelNome);
        jFrame.add(jLabelRendaAnual);
        jFrame.add(jLabelCNPJ);
        jFrame.add(jButtonAdicionar);
        jFrame.add(jButtonEditar);
        jFrame.add(jButtonExcluir);
        jFrame.add(jFormattedTextFieldCNPJ);
        jFrame.add(jScrollPane);
    }

    @Override
    public void instanciarComponentes() {
        jTable = new JTable();
        configurarJTable();
        jScrollPane = new JScrollPane(jTable);

        jLabelAno = new JLabel("Ano");
        jLabelCategoria = new JLabel("Categoria");
        jLabelRendaAnual = new JLabel("Renda Anual");
        jLabelCNPJ = new JLabel("CNPJ");
        jLabelNome = new JLabel("Nome");
        jTextFieldNome = new JTextField();
        jTextFieldAno = new JTextField();
        jTextFieldRendaAnual = new JTextField();
        jCheckBoxPrivado = new JCheckBox("Privado");
        jComboBoxCategoria = new JComboBox();
        jFormattedTextFieldCNPJ = new JFormattedTextField();
        jButtonAdicionar = new JButton("Adicionar");
        jButtonEditar = new JButton("Editar");
        jButtonExcluir = new JButton("Excluir");
        configurarJComboBox();
        configurarJFormattedTextField();
    }

    @Override
    public void gerarLocalizacoes() {
        jLabelNome.setLocation(10, 10);
        jTextFieldNome.setLocation(10, 35);

        jLabelAno.setLocation(10, 60);
        jTextFieldAno.setLocation(10, 85);

        jLabelCNPJ.setLocation(10, 110);
        jFormattedTextFieldCNPJ.setLocation(10, 135);

        jLabelCategoria.setLocation(10, 160);
        jComboBoxCategoria.setLocation(10, 185);

        jLabelRendaAnual.setLocation(10, 210);
        jTextFieldRendaAnual.setLocation(10, 235);

        jCheckBoxPrivado.setLocation(10, 260);

        jButtonAdicionar.setLocation(10, 285);

        jButtonEditar.setLocation(265, 10);
        jButtonExcluir.setLocation(370, 10);
        jScrollPane.setLocation(170, 35);
    }

    @Override
    public void gerarDimencoes() {
        jLabelNome.setSize(120, 20);
        jTextFieldNome.setSize(150, 20);

        jLabelAno.setSize(150, 20);
        jTextFieldAno.setSize(150, 20);

        jLabelCNPJ.setSize(150, 20);
        jFormattedTextFieldCNPJ.setSize(150, 20);

        jLabelCategoria.setSize(150, 20);
        jComboBoxCategoria.setSize(150, 20);

        jLabelRendaAnual.setSize(150, 20);
        jTextFieldRendaAnual.setSize(150, 20);

        jCheckBoxPrivado.setSize(150, 20);

        jButtonAdicionar.setSize(100, 20);
        jButtonEditar.setSize(100, 20);
        jButtonExcluir.setSize(100, 20);
        jScrollPane.setSize(300, 400);
    }

    private void configurarJComboBox() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("Cardiologia");
        modelo.addElement("Endocrinologia");
        modelo.addElement("Emergência");
        modelo.addElement("Oncologia");
        modelo.addElement("Pronto Socorro");
        modelo.addElement("Reumatologia");
        jComboBoxCategoria.setModel(modelo);
        jComboBoxCategoria.setSelectedIndex(-1);
    }

    private void configurarJFormattedTextField() {
        try {
            MaskFormatter maskFormatter = new MaskFormatter("##.###.###/####-##");
            maskFormatter.install(jFormattedTextFieldCNPJ);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chame o prog");
        }
    }

    private void configurarJTable() {
        dtm = new DefaultTableModel();
        dtm.addColumn("Nome");
        dtm.addColumn("CNPJ");
        dtm.addColumn("Renda Anual");
        jTable.setModel(dtm);

    }

    private void acaoBotaoAdicionar() {
        jButtonAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jFormattedTextFieldCNPJ.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "CNPJ deve ser preenchido");
                    jFormattedTextFieldCNPJ.requestFocus();
                    return;
                }
                //cnpj
                //categoria
                //renda anual
                if (jTextFieldNome.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome deve ser preenchido");
                    jTextFieldNome.requestFocus();
                    return;
                }

                if (jTextFieldNome.getText().trim().length() < 3) {
                    JOptionPane.showMessageDialog(null, "Nome deve conter 3 caracteres");
                    jTextFieldNome.requestFocus();
                    return;
                }

                if (jTextFieldAno.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ano deve ser preenchido");
                    jTextFieldAno.requestFocus();
                    return;
                }

                short ano = 0;
                try {
                    ano = Short.parseShort(jTextFieldAno.getText().trim());
                    if (ano < 1500) {
                        JOptionPane.showMessageDialog(null, "Ano não pode ser menor que 1500");
                        jTextFieldAno.requestFocus();
                        return;
                    }
                    int anoAtual = LocalDate.now().getYear();
                    if (ano > anoAtual) {
                        JOptionPane.showMessageDialog(null, "Ano não deve ser maior que o ano " + anoAtual);
                        jTextFieldAno.requestFocus();
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ano deve conter somente números");
                    jTextFieldAno.requestFocus();
                    return;
                }

                String cnpj = jFormattedTextFieldCNPJ.getText()
                        .replace(".", "")
                        .replace("/", "")
                        .replace("-", "");
                if (cnpj.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "CNPJ deve ser preenchido");
                    jFormattedTextFieldCNPJ.requestFocus();
                    return;
                }

                if (cnpj.length() < 14) {
                    JOptionPane.showMessageDialog(null, "CNPJ deve conter 14 dígitos");
                    jFormattedTextFieldCNPJ.requestFocus();
                    return;
                }

                //if (jComboBoxCategoria.getSelectedIndex == -1)
                if (jComboBoxCategoria.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Categoria deve ser selecionada");
                    jComboBoxCategoria.showPopup();
                    return;
                }
                
                String rendaAnualTexto = jTextFieldRendaAnual.getText().trim().toUpperCase().replace("R", "").replace("$", "").replace(".", "").replace(",", ".").replace(" ", "");
                
                if (rendaAnualTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Renda Anual deve ser preenchida");
                    jTextFieldRendaAnual.requestFocus();
                    return;
                }
                
                double rendaAnual = 0;
                try {
                    rendaAnual = Double.parseDouble(rendaAnualTexto);
                    if (rendaAnual < 0) {
                        JOptionPane.showMessageDialog(null, "Renda Anual deve ser positiva");
                        jTextFieldRendaAnual.requestFocus();
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Renda Anual deve conter somente números");
                    jTextFieldRendaAnual.requestFocus();
                    return;
                }
                Hospital hospital = new Hospital();
                hospital.setNome(jTextFieldNome.getText());
                hospital.setCnpj(cnpj);
                hospital.setRendaAtual(rendaAnual);
                hospital.setAno(ano);
                hospital.setPrivado(jCheckBoxPrivado.isSelected());
                hospital.setCategoria(
                        jComboBoxCategoria.getSelectedItem().toString());
                if (linhaSelecionada == -1) {
                    hospitais.add(hospital);
                    dtm.addRow(new Object[]{
                        hospital.getNome(),
                        hospital.getCnpj(),
                        hospital.getRendaAtual()
                    });
                } else {
                    hospitais.set(linhaSelecionada, hospital);
                    dtm.setValueAt(hospital.getNome(), linhaSelecionada, 0);
                    dtm.setValueAt(hospital.getCnpj(), linhaSelecionada, 1);
                    dtm.setValueAt(hospital.getRendaAtual(), linhaSelecionada, 2);
                }
                limparCampos();
            }
        });
    }

    private void limparCampos() {
        jTextFieldAno.setText("");
        jTextFieldNome.setText("");
        jTextFieldRendaAnual.setText("");
        jCheckBoxPrivado.setSelected(false);
        jComboBoxCategoria.setSelectedIndex(-1);
        jFormattedTextFieldCNPJ.setText("");
        jTextFieldNome.requestFocus();
        linhaSelecionada = -1;
    }

    private void acaoEditar() {
        jButtonEditar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTable.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um registro filho");
                    return;
                }
                linhaSelecionada = jTable.getSelectedRow();
                Hospital hospital = hospitais.get(linhaSelecionada);
                preencherCampos(hospital);
            }
        });
    }

    private void preencherCampos(Hospital hospital) {
        jTextFieldNome.setText(hospital.getNome());
        jTextFieldAno.setText(String.valueOf(hospital.getAno()));
        jTextFieldRendaAnual.setText(String.valueOf(hospital.getRendaAtual()));
        jComboBoxCategoria.setSelectedItem(hospital.getCategoria());
        jCheckBoxPrivado.setSelected(hospital.isPrivado());
        jFormattedTextFieldCNPJ.setText(hospital.getCnpj());
    }

    private void acaoExcluir() {
        jButtonExcluir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTable.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um registro filho");
                    return;
                }

                int escolha = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar?", "Aviso",
                        JOptionPane.YES_NO_OPTION);
                if (escolha == JOptionPane.YES_OPTION) {
                    linhaSelecionada = jTable.getSelectedRow();
                    dtm.removeRow(linhaSelecionada);
                    hospitais.remove(linhaSelecionada);
                    limparCampos();
                }
            }
        });
    }

}
