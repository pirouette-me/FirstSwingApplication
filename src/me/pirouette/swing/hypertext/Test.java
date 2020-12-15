package me.pirouette.swing.hypertext;

import java.awt.Checkbox;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Test extends JFrame {

    private static final long serialVersionUID = 4443303248990993973L;


    public Test() {
        super( "KLink component test" );
        this.setSize( 400, 300 );
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

        // --- On récupère le contentPane ---
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout( new FlowLayout() );

        // --- On ajoute des composants graphiques ---
        contentPane.add( new JButton( "Push me!" ) );
        contentPane.add( new Checkbox( "Check me!" ) );

        KLink link = new KLink( "Activate me!" );
        link.addActionListener( (e) -> JOptionPane.showMessageDialog( this, "Link activated" ) );
        contentPane.add( link );
    }


    // --- Point d'entrée du programme ---
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );
        Test frame = new Test();
        frame.setVisible(true);
    }

}