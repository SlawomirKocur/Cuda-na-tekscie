import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JTree;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;



public class Okno {

    private JFrame frmCudaNaTekcie;
    private JTextField wybranaLitera;
    private JLabel lblWpiszText, lblilerazy, lblpoliczoneLitery;
    private JButton btnLiczLitery, btnZamienLitery;
    public JTextArea txtrWpiszSwoj;
    private JScrollPane scrollPane;
    private JLabel lblZnaki;
    public JLabel lblZnakiWynik;

    
    
    public String ZnakiWynikStrStart = "w tekœcie jest ??? znaków";
    public String WpisanyTekst = "Tutaj wpissz swój tekst...";
    private JLabel lblNewLabel;
    private JButton btnOk;
    
    
   

	Okno() {
    	
    	UIManager.put("ScrollPane.thumb", SystemColor.black);
    	UIManager.put("ScrollPane.trackForeground", SystemColor.black);
    	UIManager.put("ScrollPane.track", SystemColor.black);
    	UIManager.put("ScrollPane.knob", SystemColor.black);
    	UIManager.put("ScrollPane._key_", SystemColor.black);
    	
        frmCudaNaTekcie = new JFrame();
        frmCudaNaTekcie.setResizable(false);
        frmCudaNaTekcie.getContentPane().setBackground(SystemColor.controlDkShadow);
        frmCudaNaTekcie.setTitle("Cuda na tek\u015Bcie");
        frmCudaNaTekcie.setForeground(Color.BLACK);
        frmCudaNaTekcie.setBackground(SystemColor.controlDkShadow);
        frmCudaNaTekcie.setVisible(true);
        frmCudaNaTekcie.setBounds(100, 100, 994, 662);
        frmCudaNaTekcie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCudaNaTekcie.getContentPane().setLayout(null);

        lblWpiszText = new JLabel("Wpisz sw\u00F3j tekst lub wczytaj z pliku");
        lblWpiszText.setForeground(Color.BLACK);
        lblWpiszText.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblWpiszText.setBounds(96, 32, 266, 25);
        frmCudaNaTekcie.getContentPane().add(lblWpiszText);

        lblilerazy = new JLabel("liczy ile razy wystapila litera");
        lblilerazy.setForeground(Color.BLACK);
        lblilerazy.setBounds(54, 431, 162, 14);
        frmCudaNaTekcie.getContentPane().add(lblilerazy);

        wybranaLitera = new JTextField();
        wybranaLitera.setToolTipText("Wpisz jak\u0105 liter\u0119 mam policzy\u0107. Liczy pierwsz\u0105 wpisan\u0105 litere");
        wybranaLitera.setBounds(243, 419, 46, 26);
        frmCudaNaTekcie.getContentPane().add(wybranaLitera);
        wybranaLitera.setColumns(10);

        lblZnakiWynik = new JLabel(ZnakiWynikStrStart);
        lblZnakiWynik.setForeground(Color.BLACK);
        lblZnakiWynik.setBounds(372, 462, 164, 14);
        frmCudaNaTekcie.getContentPane().add(lblZnakiWynik);
        
        btnLiczLitery = new JButton("LICZENIE");
        btnLiczLitery.setForeground(Color.BLACK);
        btnLiczLitery.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	        		
        		lblZnakiWynik.setText("w tekœcie jest " + txtrWpiszSwoj.getText().length() + " znaków");
     
        	}
        });
        btnLiczLitery.setBackground(SystemColor.scrollbar);
        btnLiczLitery.setBounds(243, 456, 119, 26);
        frmCudaNaTekcie.getContentPane().add(btnLiczLitery);

        lblpoliczoneLitery = new JLabel("Litera X wyst\u0105pi\u0142a Y razy");
        lblpoliczoneLitery.setForeground(Color.BLACK);
        lblpoliczoneLitery.setBounds(369, 431, 162, 14);
        frmCudaNaTekcie.getContentPane().add(lblpoliczoneLitery);

        btnZamienLitery = new JButton("ZMIE\u0143");
        btnZamienLitery.setForeground(Color.BLACK);
        btnZamienLitery.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		        		
        		String PobranyTekst = txtrWpiszSwoj.getText();
        		String ZmienionyTekst = PobranyTekst.toUpperCase();
        		txtrWpiszSwoj.setText(ZmienionyTekst);
        		
        		
        	}
        });
        btnZamienLitery.setBackground(SystemColor.scrollbar);
        btnZamienLitery.setToolTipText("Zmienia wielko\u015B\u0107 wprowadzonych liter");
        btnZamienLitery.setBounds(243, 493, 119, 23);
        frmCudaNaTekcie.getContentPane().add(btnZamienLitery);
        
        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(98, 79, 781, 323);
        frmCudaNaTekcie.getContentPane().add(scrollPane);
        
        txtrWpiszSwoj = new JTextArea();
        scrollPane.setViewportView(txtrWpiszSwoj);
        scrollPane.setBorder(null);
       // scrollPane.setBackground(SystemColor.scrollbar);
        //scrollPane.setForeground(SystemColor.controlDkShadow);
       
        
        txtrWpiszSwoj.setForeground(Color.BLACK);
        txtrWpiszSwoj.setText(WpisanyTekst);
        frmCudaNaTekcie.getContentPane().add(scrollPane);
        
        JButton btnWczytajPlik = new JButton("Wczytaj z pliku");
        btnWczytajPlik.setForeground(Color.BLACK);
        btnWczytajPlik.setBackground(SystemColor.scrollbar);
        btnWczytajPlik.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		  JFileChooser jf = new JFileChooser();
 
        		    int returnval=jf.showDialog(null, null);
        		    File file = null;
        		    if(returnval == JFileChooser.APPROVE_OPTION)     
        		     file = jf.getSelectedFile(); 
        		    
        		   try {
        		        byte bt[]= Files.readAllBytes(file.toPath());   
        		        WpisanyTekst=new String(bt,"UTF-8");
        		        txtrWpiszSwoj.setText(WpisanyTekst);
        		   }catch(IOException ex) {}		    
        		        
        		
        	}
        });
        btnWczytajPlik.setBounds(370, 35, 124, 23);
        frmCudaNaTekcie.getContentPane().add(btnWczytajPlik);
        
        lblZnaki = new JLabel("liczy ile znak\u00F3w jest w tek\u015Bcie");
        lblZnaki.setForeground(Color.BLACK);
        lblZnaki.setBounds(54, 463, 179, 14);
        frmCudaNaTekcie.getContentPane().add(lblZnaki);
        
        lblNewLabel = new JLabel("zmienia wielko\u015B\u0107 liter na du\u017Ce");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(54, 497, 179, 14);
        frmCudaNaTekcie.getContentPane().add(lblNewLabel);
        
        JButton btnZamienLitery_1 = new JButton("ZMIE\u0143");
        btnZamienLitery_1.setForeground(Color.BLACK);
        btnZamienLitery_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String PobranyTekst = txtrWpiszSwoj.getText();
        		String ZmienionyTekst = PobranyTekst.toLowerCase();
        		txtrWpiszSwoj.setText(ZmienionyTekst);
        		
        	}
        });
        btnZamienLitery_1.setToolTipText("Zmienia wielko\u015B\u0107 wprowadzonych liter");
        btnZamienLitery_1.setBackground(SystemColor.scrollbar);
        btnZamienLitery_1.setBounds(243, 527, 119, 23);
        frmCudaNaTekcie.getContentPane().add(btnZamienLitery_1);
        
        JLabel lblZmieniaWielkoLiter = new JLabel("zmienia wielko\u015B\u0107 liter na ma\u0142e");
        lblZmieniaWielkoLiter.setForeground(Color.BLACK);
        lblZmieniaWielkoLiter.setBounds(54, 531, 179, 14);
        frmCudaNaTekcie.getContentPane().add(lblZmieniaWielkoLiter);
        
        btnOk = new JButton("OK");
        btnOk.setForeground(Color.BLACK);
        btnOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        	String ch = wybranaLitera.getText();
        	 
        	String ch2 = txtrWpiszSwoj.getText();      	
        	int licznik = 0;
        	
        	char[] tablica = ch2.toCharArray();
        	char[] tablica2 = ch.toCharArray();
        	
        	for(int i = 0; i < tablica.length; i++) {
        		if (tablica [i] == tablica2[0])
        			licznik++;
        		
        	}
        	 
        	
        	lblpoliczoneLitery.setText("Litera " +ch+ " wyst¹pi³a " +licznik+ " razy");
        	
        	}
        	
        });
        btnOk.setBackground(SystemColor.scrollbar);
        btnOk.setBounds(299, 419, 63, 26);
        frmCudaNaTekcie.getContentPane().add(btnOk);
        
       
        
        
        
        
    }
}


