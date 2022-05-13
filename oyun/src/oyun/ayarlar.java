package oyun;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ayarlar {
	
	public ayarlar() {
		
		int tahtaBoyutuTut;
		int hamleAdimTut;
		int altinYuzdesiTut;
		int gizliAltinYuzdesiTut;
		int baslangicAltinTut;
		int aHamleTut;
		int bHamleTut;
		int cHamleTut;
		int dHamleTut;
		int aHedefTut;
		int bHedefTut;
		int cHedefTut;
		int dHedefTut;
		
		
		
		oyunTahtasi oyun= new oyunTahtasi();

		

		JFrame frame = new JFrame("Altin toplama oyununa hoþgeldiniz!");
		frame.setSize(700,700);
		frame.setLocation(500, 0);
		frame.getContentPane().setLayout(null); // butonlarýn vs. konumunu ve boyutunu degistirmeyi saglar
		frame.getContentPane().setBackground(Color.gray);
		
		
		JLabel tahtaBoyutuLabel = new JLabel();
		JLabel hamleAdimLabel = new JLabel();
		JLabel altinYuzdesiLabel = new JLabel();
		JLabel gizliAltinYuzdesiLabel = new JLabel();
		JLabel baslangicAltinLabel = new JLabel();
		JLabel oyunLabel = new JLabel();
		JLabel aHamleLabel = new JLabel();
		JLabel bHamleLabel = new JLabel();
		JLabel cHamleLabel = new JLabel();
		JLabel dHamleLabel = new JLabel();
		JLabel aHedefLabel = new JLabel();
		JLabel bHedefLabel = new JLabel();
		JLabel cHedefLabel = new JLabel();
		JLabel dHedefLabel = new JLabel();

		

		JTextField tahtaBoyutuTextField = new JTextField(100);
		JTextField hamleAdimTextField = new JTextField(100);
		JTextField altinYuzdesiTextField = new JTextField(100);
		JTextField gizliAltinYuzdesiTextField = new JTextField(100);
		JTextField baslangicAltinTextField = new JTextField(100);
		JTextField aHamleTextField = new JTextField();
		JTextField bHamleTextField = new JTextField();
		JTextField cHamleTextField = new JTextField();
		JTextField dHamleTextField = new JTextField();
		JTextField aHedefTextField = new JTextField();
		JTextField bHedefTextField = new JTextField();
		JTextField cHedefTextField = new JTextField();
		JTextField dHedefTextField = new JTextField();
		
		JButton basla = new JButton("Baþla");
		
		basla.setSize(100,100);
		basla.setLocation(560, 530);
		basla.setBackground(Color.yellow);
		
		oyunLabel.setText("ALTIN TOPLAMA OYUNU");
		tahtaBoyutuLabel.setText("Tahta boyutunu giriniz: ");
		hamleAdimLabel.setText("Tek hamlede gidebileceði adým sayýsýný giriniz: ");
		altinYuzdesiLabel.setText("Karelerde altýn bulunma yüzdesini giriniz: ");
		gizliAltinYuzdesiLabel.setText("Karelerde gizli altýn bulunma yüzdesini giriniz: ");
		baslangicAltinLabel.setText("Oyuncularýn oyuna baþlayacaðý altýn miktarýný giriniz: ");
		aHamleLabel.setText("A oyuncusunun hamle bedelini giriniz: ");
		bHamleLabel.setText("B oyuncusunun hamle bedelini giriniz: ");
		cHamleLabel.setText("C oyuncusunun hamle bedelini giriniz: ");
		dHamleLabel.setText("D oyuncusunun hamle bedelini giriniz: ");
		aHedefLabel.setText("A oyuncusunun hedef belirleme bedelini giriniz: ");
		bHedefLabel.setText("B oyuncusunun hedef belirleme bedelini giriniz: ");
		cHedefLabel.setText("C oyuncusunun hedef belirleme bedelini giriniz: ");
		dHedefLabel.setText("D oyuncusunun hedef belirleme bedelini giriniz: ");

		oyunLabel.setLocation(300,5);
		oyunLabel.setSize(200, 100);

		
		tahtaBoyutuLabel.setLocation(10, 50);
		tahtaBoyutuLabel.setSize(200, 100);
		tahtaBoyutuTextField.setLocation(140, 90);
		tahtaBoyutuTextField.setSize(40, 25);

		hamleAdimLabel.setLocation(10, 90);
		hamleAdimLabel.setSize(300, 100);
		hamleAdimTextField.setLocation(280,130);
		hamleAdimTextField.setSize(40,25);
		
		altinYuzdesiLabel.setLocation(10, 130);
		altinYuzdesiLabel.setSize(300, 100);
		altinYuzdesiTextField.setLocation(250, 170);
		altinYuzdesiTextField.setSize(40, 25);
		
		gizliAltinYuzdesiLabel.setLocation(10, 170);
		gizliAltinYuzdesiLabel.setSize(300, 100);
		gizliAltinYuzdesiTextField.setLocation(270, 210);
		gizliAltinYuzdesiTextField.setSize(40, 25);
	
		baslangicAltinLabel.setLocation(10,250);
		baslangicAltinLabel.setSize(300, 100);
		baslangicAltinTextField.setLocation(310, 290);
		baslangicAltinTextField.setSize(40, 25);
		
		aHamleLabel.setLocation(10,290);
		aHamleLabel.setSize(300, 100);
		aHamleTextField.setLocation(230,330);
		aHamleTextField.setSize(40, 25);
		
		
		bHamleLabel.setLocation(10,330);
		bHamleLabel.setSize(300, 100);
		bHamleTextField.setLocation(230,370);
		bHamleTextField.setSize(40, 25);
		
			
		cHamleLabel.setLocation(10,370);
		cHamleLabel.setSize(300, 100);
		cHamleTextField.setLocation(230,410);
		cHamleTextField.setSize(40, 25);
		
		
		dHamleLabel.setLocation(10,410);
		dHamleLabel.setSize(300, 100);
		dHamleTextField.setLocation(230,450);
		dHamleTextField.setSize(40, 25);
		
		
		aHedefLabel.setLocation(10,450);
		aHedefLabel.setSize(300, 100);
		aHedefTextField.setLocation(285,490);
		aHedefTextField.setSize(40, 25);
		
		
		bHedefLabel.setLocation(10,490);
		bHedefLabel.setSize(300, 100);
		bHedefTextField.setLocation(285,530);
		bHedefTextField.setSize(40, 25);
		
		
		cHedefLabel.setLocation(10,530);
		cHedefLabel.setSize(300, 100);
		cHedefTextField.setLocation(285,570);
		cHedefTextField.setSize(40, 25);
		
		
		dHedefLabel.setLocation(10,570);
		dHedefLabel.setSize(300, 100);
		dHedefTextField.setLocation(285,610);
		dHedefTextField.setSize(40, 25);
		
		
		
		frame.getContentPane().add(oyunLabel);
		frame.getContentPane().add(basla);
		frame.getContentPane().add(tahtaBoyutuTextField);
		frame.getContentPane().add(tahtaBoyutuLabel);
		frame.getContentPane().add(hamleAdimLabel);
		frame.getContentPane().add(hamleAdimTextField);
		frame.getContentPane().add(altinYuzdesiLabel);
		frame.getContentPane().add(altinYuzdesiTextField);
		frame.getContentPane().add(gizliAltinYuzdesiLabel);
		frame.getContentPane().add(gizliAltinYuzdesiTextField);
		frame.getContentPane().add(baslangicAltinLabel);
		frame.getContentPane().add(baslangicAltinTextField);
		frame.getContentPane().add(aHamleLabel);
		frame.getContentPane().add(bHamleLabel);
		frame.getContentPane().add(cHamleLabel);
		frame.getContentPane().add(dHamleLabel);
		frame.getContentPane().add(aHedefLabel);
		frame.getContentPane().add(bHedefLabel);
		frame.getContentPane().add(cHedefLabel);
		frame.getContentPane().add(dHedefLabel);
		frame.getContentPane().add(aHamleTextField);
		frame.getContentPane().add(bHamleTextField);
		frame.getContentPane().add(cHamleTextField);
		frame.getContentPane().add(dHamleTextField);
		frame.getContentPane().add(aHedefTextField);
		frame.getContentPane().add(bHedefTextField);
		frame.getContentPane().add(cHedefTextField);
		frame.getContentPane().add(dHedefTextField);

		

		
		
		
		hamleAdimTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				
				
				String str = hamleAdimTextField.getText();
				int hamleAdimTut = Integer.parseInt(str);
				oyun.hamleAdim=hamleAdimTut;
				
				
			}
	
			
		});
		
		tahtaBoyutuTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = tahtaBoyutuTextField.getText();
				int tahtaBoyutuTut = Integer.parseInt(str);
				oyun.tahtaBoyutu=tahtaBoyutuTut;
				
			}
	
			
		});
		
		altinYuzdesiTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = altinYuzdesiTextField.getText();
				int altinYuzdesiTut = Integer.parseInt(str);
				
			}
	
			
		});
		
		gizliAltinYuzdesiTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = gizliAltinYuzdesiTextField.getText();
				int gizliAltinYuzdesiTut = Integer.parseInt(str);
				
			}
	
			
		});
		
		baslangicAltinTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = baslangicAltinTextField.getText();
				int baslangicAltinTut = Integer.parseInt(str);
				oyun.A.baslangicAltin=baslangicAltinTut;
				oyun.B.baslangicAltin=baslangicAltinTut;
				oyun.C.baslangicAltin=baslangicAltinTut;
				oyun.D.baslangicAltin=baslangicAltinTut;
				
			}
	
			
		});
		
		aHamleTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = aHamleTextField.getText();
				int aHamleTut = Integer.parseInt(str);
				oyun.A.hamleBedeli=aHamleTut;
				
			}
	
			
		});
		
		bHamleTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = bHamleTextField.getText();
				int bHamleTut = Integer.parseInt(str);
				oyun.B.hamleBedeli=bHamleTut;
				
			}
	
			
		});
		
		cHamleTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = cHamleTextField.getText();
				int cHamleTut = Integer.parseInt(str);
				oyun.C.hamleBedeli=cHamleTut;
				
			}
	
			
		});
		
		dHamleTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = dHamleTextField.getText();
				int dHamleTut = Integer.parseInt(str);
				oyun.D.hamleBedeli=dHamleTut;
				
			}
	
			
		});
		
		aHedefTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = aHedefTextField.getText();
				int aHedefTut = Integer.parseInt(str);
				oyun.A.hedefBedeli=aHedefTut;
				
			}
	
			
		});
		
		bHedefTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = bHedefTextField.getText();
				int bHedefTut = Integer.parseInt(str);
				oyun.B.hedefBedeli=bHedefTut;
				
			}
	
			
		});
		
		cHedefTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = cHedefTextField.getText();
				int cHedefTut = Integer.parseInt(str);
				oyun.C.hedefBedeli=cHedefTut;
				
			}
	
			
		});
		
		dHedefTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String str = dHedefTextField.getText();
				int dHedefTut = Integer.parseInt(str);
				oyun.D.hedefBedeli=dHedefTut;
				
			}
	
			
		});
			
			
				

		basla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				frame.setVisible(false);
				oyun.gir();
				oyun.goster();

				
			}
	
			
		});
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
	}
}
