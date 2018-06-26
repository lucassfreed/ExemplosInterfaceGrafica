package exemplo08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploJCheckBox01 implements JFrameBaseInterface {

    private JFrame jFrame;
    private JCheckBox jCheckBoxEuAceitoOsTermos, jCheckBoxEuLiOsTermos;
    private JButton jButtonSalvar, jButtonLimpar;

    public ExemploJCheckBox01() {
        instanciarComponentes();
        gerarTela();
        gerarDimencoes();
        gerarLocalizacoes();
        adicionarComponentes();
        acaoBotaoLimpar();
        acaoBotaoSalvar();
        jFrame.setVisible(true);

    }

    @Override
    public void instanciarComponentes() {
        jButtonLimpar = new JButton("Limpar");
        jButtonSalvar = new JButton("Salvar");
        jCheckBoxEuAceitoOsTermos = new JCheckBox("Eu aceito os termos");
        jCheckBoxEuLiOsTermos = new JCheckBox("Eu li os termos");
    }

    @Override
    public void gerarTela() {
        jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setLayout(null);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void gerarDimencoes() {
        jButtonLimpar.setSize(100, 20);
        jButtonSalvar.setSize(100, 20);
        jCheckBoxEuAceitoOsTermos.setSize(250, 20);
        jCheckBoxEuLiOsTermos.setSize(250, 20);
    }

    @Override
    public void gerarLocalizacoes() {
        jCheckBoxEuLiOsTermos.setLocation(10, 10);
        jCheckBoxEuAceitoOsTermos.setLocation(10, 35);
        jButtonLimpar.setLocation(10, 60);
        jButtonSalvar.setLocation(115, 60);
    }

    @Override
    public void adicionarComponentes() {
        jFrame.add(jCheckBoxEuAceitoOsTermos);
        jFrame.add(jCheckBoxEuLiOsTermos);
        jFrame.add(jButtonSalvar);
        jFrame.add(jButtonLimpar);
    }

    public void acaoBotaoLimpar() {
        jButtonLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jCheckBoxEuLiOsTermos.setSelected(false);
                jCheckBoxEuAceitoOsTermos.setSelected(false);
            }
        });
    }

    public void acaoBotaoSalvar() {
        jButtonSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jCheckBoxEuLiOsTermos.isSelected() 
                        && !jCheckBoxEuAceitoOsTermos.isSelected()) {
                    JOptionPane.showMessageDialog(null,
                            "Para prosseguir, você precisa ler e aceitar os termos.");
                    return;
                } else if (!jCheckBoxEuLiOsTermos.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Leia os termos");
                    return;
                } else if (!jCheckBoxEuAceitoOsTermos.isSelected()){
                    JOptionPane.showMessageDialog(null, "Aceite os termos");
                    return;
                }
                JOptionPane.showMessageDialog(null, 
                        "Você acaba de vender livros");
            }
        });
    }

}
