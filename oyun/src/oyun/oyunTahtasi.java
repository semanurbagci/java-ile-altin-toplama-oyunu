package oyun;

import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class oyunTahtasi {
	
	JFrame frame;
	int tahtaBoyutu=20;
	int hamleAdim=3;
	int altinYuzde=20;
	int gizliAltinYuzde=10;
	
	buton[][] board = new buton[tahtaBoyutu][tahtaBoyutu];
	
	int toplamAltinSayisi=(int) ((tahtaBoyutu*tahtaBoyutu)*altinYuzde/100);
	int gizliAltinSayisi=(int) (toplamAltinSayisi*gizliAltinYuzde/100);
	int gorunurAltinSayisi=toplamAltinSayisi-gizliAltinSayisi;
	
	oyuncu A = new oyuncu("A",200,5,5,0,0);
	oyuncu B = new oyuncu("B",200,10,5,0,(tahtaBoyutu-1));
	oyuncu C = new oyuncu("C",200,15,5,(tahtaBoyutu-1),0);
	oyuncu D = new oyuncu("D",200,20,5,(tahtaBoyutu-1),(tahtaBoyutu-1));
	
	String strA = new String();
	String strB = new String();
	String strC = new String();
	String strD = new String();
	
	
	public void gir() {
		frame = new JFrame("OYUN");
		frame.setSize(700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(tahtaBoyutu,tahtaBoyutu));
		
		for(int row=0; row<board.length; row++) {
			for(int col=0; col<board[0].length; col++) {
				buton b = new buton(row,col);
				frame.add(b);
				board[row][col]=b;
			}
		}
		
		altinOlustur();
		yazdirBaslangicOyuncu(A.index_i,A.index_j,B.index_i,B.index_j,C.index_i,C.index_j,D.index_i,D.index_j);
		
		System.out.println("OYUN BASLAR..\n");
		
		Timer timer = new Timer();
		TimerTask gorev = new TimerTask() {
			
			@Override
			public void run() {
				if(A.isHedef()==false || board[A.hedef_i][A.hedef_j].isGold()==false) {
					if(A.kasadakiAltin>=A.hedefBedeli && oyunBittiMi()!=true) {
						hedefBelirleA(A.index_i, A.index_j);
						if(A.kasadakiAltin==0) {
							System.out.println("--->A'NIN ALTINI BÝTTÝ, ELENDÝ.");
						}
					}
				}
				if(A.isHedef() && A.kasadakiAltin>=A.hamleBedeli && oyunBittiMi()!=true) {
					hamleYap(A,hamleAdim);
					if(A.kasadakiAltin==0) {
						System.out.println("--->A'NIN ALTINI BÝTTÝ, ELENDÝ.");
					}
					oyuncuIconGuncelle(A);
					goster();
					
				}
				
				
				if(B.isHedef()==false || board[B.hedef_i][B.hedef_j].isGold()==false) {
					if(B.kasadakiAltin>=B.hedefBedeli && oyunBittiMi()!=true) {
						hedefBelirleB(B.index_i, B.index_j);
						if(B.kasadakiAltin==0) {
							System.out.println("--->B'NÝN ALTÝNÝ BÝTTÝ, ELENDÝ.");
						}
					}
				}
				if(B.isHedef() && B.kasadakiAltin>=B.hamleBedeli && oyunBittiMi()!=true) {
					hamleYap(B,hamleAdim);
					if(B.kasadakiAltin==0) {
						System.out.println("--->B'NÝN ALTÝNÝ BÝTTÝ, ELENDÝ.");
					}
					oyuncuIconGuncelle(B);
					goster();
				}
				
				
				if(C.isHedef()==false || board[C.hedef_i][C.hedef_j].isGold()==false) {
					if(C.kasadakiAltin>=C.hedefBedeli && oyunBittiMi()!=true) {
						hedefBelirleC(C.index_i, C.index_j);
						if(C.kasadakiAltin==0) {
							System.out.println("--->C'NÝN ALTÝNÝ BÝTTÝ, ELENDÝ.");
						}
					}
				}
				if(C.isHedef() && C.kasadakiAltin>=C.hamleBedeli && oyunBittiMi()!=true) {
					hamleYap(C,hamleAdim);
					if(C.kasadakiAltin==0) {
						System.out.println("--->C'NÝN ALTÝNÝ BÝTTÝ, ELENDÝ.");
					}
					oyuncuIconGuncelle(C);
					goster();
				}
				
				
				if(D.isHedef()==false || board[D.hedef_i][D.hedef_j].isGold()==false) {
					if(D.kasadakiAltin>=D.hedefBedeli && oyunBittiMi()!=true) {
						hedefBelirleD(D.index_i, D.index_j);
						if(D.kasadakiAltin==0) {
							System.out.println("--->D'NÝN ALTÝNÝ BÝTTÝ, ELENDÝ.");
						}
					}
				}
				if(D.isHedef() && D.kasadakiAltin>=D.hamleBedeli && oyunBittiMi()!=true) {
					hamleYap(D,hamleAdim);
					if(D.kasadakiAltin==0) {
						System.out.println("--->D'NÝN ALTÝNÝ BÝTTÝ, ELENDÝ.");
					}
					oyuncuIconGuncelle(D);
					goster();
				}
				
				
				if(oyunBittiMi()) {
					System.out.println("\nOYUN BÝTTÝ.");
					timer.cancel();
					System.out.println("oyun sonunda tahtada bulunan toplam altin sayýsý:"+altinSayisiBul());
					System.out.println("oyun sonunda tahtada bulunan gizli altin sayýsý:"+gizliAltinSayisiBul());
					System.out.println("\noyun sonunda her bir oyuncunun bulundugu yerler:");
					System.out.println("A:"+A.index_i+" "+A.index_j);
					System.out.println("B:"+B.index_i+" "+B.index_j);
					System.out.println("C:"+C.index_i+" "+C.index_j);
					System.out.println("D:"+D.index_i+" "+D.index_j);
					System.out.println("\nOYUN SONUCU:");
					sonucYazdir();
					try {
						File file = new File("dosya.txt");
				        if (!file.exists()) {
				            file.createNewFile();
				        }

				        FileWriter fileWriter = new FileWriter(file, false);
				        BufferedWriter bWriter = new BufferedWriter(fileWriter);
				        bWriter.write(strA);
				        bWriter.write("\n");
				        bWriter.write(strB);
				        bWriter.write("\n");
				        bWriter.write(strC);
				        bWriter.write("\n");
				        bWriter.write(strD);
				        
				        System.out.println("\nDOSYA ÝÞLEMLERÝ YAPILDI..");
				        bWriter.close();
				        
					    } catch (Exception e) {
					      System.out.println("Something went wrong.");
					    }
				}
			}
		};
		timer.schedule(gorev, 0, 2000);
	
		frame.setVisible(false);
	}
	
	public void altinOlustur(){
		int i=0;
		while(i<toplamAltinSayisi){ 
			int randRow = (int) (Math.random()*board.length);
			int randCol = (int) (Math.random()*board[0].length);
			while(board[randRow][randCol].isGold()) {
				randRow = (int) (Math.random()*board.length);
				randCol = (int) (Math.random()*board[0].length);
			}
			while((randRow==0 && randCol==0) || (randRow==(tahtaBoyutu-1) && randCol==0) || (randRow==0 && randCol==(tahtaBoyutu-1)) || (randRow==(tahtaBoyutu-1) && randCol==(tahtaBoyutu-1))) {
				randRow = (int) (Math.random()*board.length);
				randCol = (int) (Math.random()*board[0].length);
			}
			board[randRow][randCol].setGold(true);
			i++;
		}
		
		int t=0;
		for(int j=0; j<toplamAltinSayisi;j++) {
			int randRow = (int) (Math.random()*board.length);
			int randCol = (int) (Math.random()*board[0].length);
			
			Random rnd = new Random();
			int sayi = rnd.nextInt(20)+5;
			while(sayi%5!=0) {
				sayi = rnd.nextInt(20)+5;
			}
			
			while(board[randRow][randCol].isGoldValueIcon() || board[randRow][randCol].isGold()==false) {
				randRow = (int) (Math.random()*board.length);
				randCol = (int) (Math.random()*board[0].length);
			}
			
			if(t<gorunurAltinSayisi) { 
				board[randRow][randCol].setGoldValue(sayi);
				if(board[randRow][randCol].getGoldValue()==5) {
					board[randRow][randCol].setIcon(new ImageIcon("bes.png"));
				}
				else if(board[randRow][randCol].getGoldValue()==10) {
					board[randRow][randCol].setIcon(new ImageIcon("on.png"));
				}
				else if(board[randRow][randCol].getGoldValue()==15) {
					board[randRow][randCol].setIcon(new ImageIcon("onbes.png"));
				}
				else if(board[randRow][randCol].getGoldValue()==20) {
					board[randRow][randCol].setIcon(new ImageIcon("yirmi.png"));
				}
				
				board[randRow][randCol].setGoldValueIcon(true);
				t++;
			}
			else {
				board[randRow][randCol].setGoldValue(sayi*(-1));
				
				if(board[randRow][randCol].getGoldValue()==-5) {
					board[randRow][randCol].setIcon(new ImageIcon("eksibes.png"));
				}
				else if(board[randRow][randCol].getGoldValue()==-10) {
					board[randRow][randCol].setIcon(new ImageIcon("eksion.png"));
				}
				else if(board[randRow][randCol].getGoldValue()==-15) {
					board[randRow][randCol].setIcon(new ImageIcon("eksionbes.png"));
				}
				else if(board[randRow][randCol].getGoldValue()==-20) {
					board[randRow][randCol].setIcon(new ImageIcon("eksiyirmi.png"));
				}
				
				board[randRow][randCol].setGoldValueIcon(true);
				t++;
			}
			
		}
	}
	
	public void yazdirBaslangicOyuncu(int a_i, int a_j, int b_i, int b_j, int c_i, int c_j, int d_i, int d_j) {
		if(a_i==0 && a_j==0) {
			board[a_i][a_j].setPlayer(true);
			board[a_i][a_j].setIcon(new ImageIcon("A.png"));
			board[a_i][a_j].setPlayerIcon(true);
		}
		if(b_i==0 && b_j==(tahtaBoyutu-1)) {
			board[b_i][b_j].setPlayer(true);
			board[b_i][b_j].setIcon(new ImageIcon("B.png"));
			board[b_i][b_j].setPlayerIcon(true);
		}
		if(c_i==(tahtaBoyutu-1) && c_j==0) {
			board[c_i][c_j].setPlayer(true);
			board[c_i][c_j].setIcon(new ImageIcon("C.png"));
			board[c_i][c_j].setPlayerIcon(true);
		}
		if(d_i==(tahtaBoyutu-1) && d_j==(tahtaBoyutu-1)) {
			board[d_i][d_j].setPlayer(true);
			board[d_i][d_j].setIcon(new ImageIcon("D.png"));
			board[d_i][d_j].setPlayerIcon(true);
		}
	}
	
	public void oyuncuIconGuncelle(oyuncu X) {
		String oyuncuAd = X.getName();
		String oyuncuA="A";
		String oyuncuB="B";
		String oyuncuC="C";
		String oyuncuD="D";
		if(oyuncuAd.equals(oyuncuA)) {
			board[X.index_i][X.index_j].setIcon(new ImageIcon("A.png"));
			board[X.index_i][X.index_j].setPlayer(true);
			board[X.index_i][X.index_j].setPlayerIcon(true);
		}
		else if(oyuncuAd.equals(oyuncuB)) {
			board[X.index_i][X.index_j].setIcon(new ImageIcon("B.png"));
			board[X.index_i][X.index_j].setPlayer(true);
			board[X.index_i][X.index_j].setPlayerIcon(true);
		}
		else if(oyuncuAd.equals(oyuncuC)) {
			board[X.index_i][X.index_j].setIcon(new ImageIcon("C.png"));
			board[X.index_i][X.index_j].setPlayer(true);
			board[X.index_i][X.index_j].setPlayerIcon(true);
		}
		else if(oyuncuAd.equals(oyuncuD)) {
			board[X.index_i][X.index_j].setIcon(new ImageIcon("D.png"));
			board[X.index_i][X.index_j].setPlayer(true);
			board[X.index_i][X.index_j].setPlayerIcon(true);
		}
	}
	
	public buton hedefBelirleA(int a_i, int a_j) {
		int minUzaklik=(tahtaBoyutu-1)+(tahtaBoyutu-1);
		int uzaklikTmp;
		int ha_i=a_i;
		int ha_j=a_j;
		for(int x=0; x<board.length;x++) {
			for(int y=0; y<board[0].length; y++) {
				if(board[x][y].isGold() && board[x][y].getGoldValue()>0) {
					uzaklikTmp=Math.abs(a_i-x)+Math.abs(a_j-y);
					if(uzaklikTmp<minUzaklik) {
						minUzaklik=uzaklikTmp;
						ha_i=x;
						ha_j=y;
					}
				}
			}
		}
		strA=strA.concat("A hedef belirledi.\n");
		System.out.println("A hedef belirledi.");
		A.harcananAltin+=A.hedefBedeli;
		A.kasadakiAltin-=A.hedefBedeli;
		A.hedef_i=ha_i;
		A.hedef_j=ha_j;
		A.setHedef(true);
		return board[ha_i][ha_j];
		
	}
	
	public buton hedefBelirleB(int b_i, int b_j) {
		int maxKar=-1000;
		int karTmp,uzaklik,toplamHamleSayisi,toplamHamleBedeli;
		int bh_i=b_i;
		int bh_j=b_j;
		for(int x=0; x<board.length;x++) {
			for(int y=0; y<board[0].length; y++) {
				if(board[x][y].isGold() && board[x][y].getGoldValue()>0) {
					uzaklik=Math.abs(b_i-x)+Math.abs(b_j-y);
					if(uzaklik%3==0) {
						toplamHamleSayisi=(uzaklik/3);
						toplamHamleBedeli=toplamHamleSayisi*B.hamleBedeli;
					}
					else {
						toplamHamleSayisi=(uzaklik/3)+1;
						toplamHamleBedeli=toplamHamleSayisi*B.hamleBedeli;
					}
					karTmp=board[x][y].getGoldValue()-B.hedefBedeli-toplamHamleBedeli;
					if(karTmp>maxKar) {
						maxKar=karTmp;
						bh_i=x;
						bh_j=y;
					}
				}
			}
		}
		strB=strB.concat("B hedef belirledi.\n");
		System.out.println("B hedef belirledi.");
		B.harcananAltin+=B.hedefBedeli;
		B.kasadakiAltin-=B.hedefBedeli;
		B.hedef_i=bh_i;
		B.hedef_j=bh_j;
		B.setHedef(true);
		return board[bh_i][bh_j];
	}
	
	public buton hedefBelirleC(int c_i, int c_j) {
		int x,y;
		int birinci_i=-1,birinci_j=-1,ikinci_i=-1,ikinci_j=-1;
		int uzaklikTmp;
		
		if(gizliAltinSayisiBul()>=2) {
			int minUzaklik=(tahtaBoyutu-1)+(tahtaBoyutu-1);
			for(x=0; x<board.length; x++) {
				for(y=0; y<board[0].length; y++) {
					if(board[x][y].isGold() && board[x][y].getGoldValue()<0) {
						uzaklikTmp=Math.abs(c_i-x)+Math.abs(c_j-y);
						if(uzaklikTmp<minUzaklik) {
							minUzaklik=uzaklikTmp;
							birinci_i=x;
							birinci_j=y;
						}
					}
				}
			}
			int deger=board[birinci_i][birinci_j].getGoldValue();
			board[birinci_i][birinci_j].setGoldValue(deger*(-1));
			if(board[birinci_i][birinci_j].getGoldValue()==5) {
				board[birinci_i][birinci_j].setIcon(new ImageIcon("bes.png"));
			}
			else if(board[birinci_i][birinci_j].getGoldValue()==10) {
				board[birinci_i][birinci_j].setIcon(new ImageIcon("on.png"));
			}
			else if(board[birinci_i][birinci_j].getGoldValue()==15) {
				board[birinci_i][birinci_j].setIcon(new ImageIcon("onbes.png"));
			}
			else if(board[birinci_i][birinci_j].getGoldValue()==20) {
				board[birinci_i][birinci_j].setIcon(new ImageIcon("yirmi.png"));
			}
			
			minUzaklik=(tahtaBoyutu-1)+(tahtaBoyutu-1);
			
			for(x=0; x<board.length; x++) {
				for(y=0; y<board[0].length; y++) {
					if(board[x][y].isGold() && board[x][y].getGoldValue()<0) {
						uzaklikTmp=Math.abs(c_i-x)+Math.abs(c_j-y);
						if(uzaklikTmp<minUzaklik) {
							minUzaklik=uzaklikTmp;
							ikinci_i=x;
							ikinci_j=y;
						}
					}
				}
			}
			int deger2=board[ikinci_i][ikinci_j].getGoldValue();
			board[ikinci_i][ikinci_j].setGoldValue(deger2*(-1));
			if(board[ikinci_i][ikinci_j].getGoldValue()==5) {
				board[ikinci_i][ikinci_j].setIcon(new ImageIcon("bes.png"));
			}
			else if(board[ikinci_i][ikinci_j].getGoldValue()==10) {
				board[ikinci_i][ikinci_j].setIcon(new ImageIcon("on.png"));
			}
			else if(board[ikinci_i][ikinci_j].getGoldValue()==15) {
				board[ikinci_i][ikinci_j].setIcon(new ImageIcon("onbes.png"));
			}
			else if(board[ikinci_i][ikinci_j].getGoldValue()==20) {
				board[ikinci_i][ikinci_j].setIcon(new ImageIcon("yirmi.png"));
			}
			
			System.out.println("C'nin gorunur yaptýgý altýnlarýn yerleri:"+birinci_i+" "+birinci_j+", "+ikinci_i+" "+ikinci_j);
		}
		
		int uzaklik,karTmp,toplamHamleSayisi,toplamHamleBedeli;
		int maxKar=-1000;
		int ch_i=c_i;
		int ch_j=c_j;
		
		for(x=0; x<board.length;x++) {
			for(y=0; y<board[0].length; y++) {
				if(board[x][y].isGold() && board[x][y].getGoldValue()>0) {
					uzaklik=Math.abs(c_i-x)+Math.abs(c_j-y);
					if(uzaklik%3==0) {
						toplamHamleSayisi=(uzaklik/3);
						toplamHamleBedeli=toplamHamleSayisi*C.hamleBedeli;
					}
					else {
						toplamHamleSayisi=(uzaklik/3)+1;
						toplamHamleBedeli=toplamHamleSayisi*C.hamleBedeli;
					}
					karTmp=board[x][y].getGoldValue()-C.hedefBedeli-toplamHamleBedeli;
					if(karTmp>maxKar) {
						maxKar=karTmp;
						ch_i=x;
						ch_j=y;
					}
				}
			}
		}
		
		strC=strC.concat("C hedef belirledi.\n");
		System.out.println("C hedef belirledi.");
		C.harcananAltin+=C.hedefBedeli;
		C.kasadakiAltin-=C.hedefBedeli;
		C.hedef_i=ch_i;
		C.hedef_j=ch_j;
		C.setHedef(true);
		return board[ch_i][ch_j];
	}

	public buton hedefBelirleD(int d_i, int d_j) {
		int dh_i=d_i;
		int dh_j=d_i;
		int uzaklikFark=(tahtaBoyutu-1)+(tahtaBoyutu-1);
		int uzaklik,karTmp,toplamHamleSayisi,toplamHamleBedeli;
		int maxKar=-1000;
		
		int hedefA_A=Math.abs(A.index_i-A.hedef_i)+Math.abs(A.index_j-A.hedef_j);
		int hedefA_D=Math.abs(D.index_i-A.hedef_i)+Math.abs(D.index_j-A.hedef_j);
		int hedefB_B=Math.abs(B.index_i-B.hedef_i)+Math.abs(B.index_j-B.hedef_j);
		int hedefB_D=Math.abs(D.index_i-B.hedef_i)+Math.abs(D.index_j-B.hedef_j);
		int hedefC_C=Math.abs(C.index_i-C.hedef_i)+Math.abs(C.index_j-C.hedef_j);
		int hedefC_D=Math.abs(D.index_i-C.hedef_i)+Math.abs(D.index_j-C.hedef_j);
		
		if(hedefA_D<hedefA_A || hedefB_D<hedefB_B || hedefC_D<hedefC_C) {
			if(hedefA_D<hedefA_A) {
				if(hedefA_D<uzaklikFark) {
					uzaklikFark=hedefA_D;
					dh_i=A.hedef_i;
					dh_j=A.hedef_j;
				}
			}
			if(hedefB_D<hedefB_B) {
				if(hedefB_D<uzaklikFark) {
					uzaklikFark=hedefB_D;
					dh_i=B.hedef_i;
					dh_j=B.hedef_j;
				}
			}
			if(hedefC_D<hedefC_C) {
				if(hedefC_D<uzaklikFark) {
					uzaklikFark=hedefC_D;
					dh_i=C.hedef_i;
					dh_j=C.hedef_j;
				}
			}
		}
		
		else {
			int x,y;
			for(x=0; x<board.length; x++) {
				for(y=0; y<board[0].length; y++) {
					if(board[x][y].isGold() && board[x][y].getGoldValue()>0 && !(x==A.hedef_i && y==A.hedef_j) && !(x==B.hedef_i && y==B.hedef_j) && !(x==C.hedef_i && y==C.hedef_j)) {
						uzaklik=Math.abs(d_i-x)+Math.abs(d_j-y);
						if(uzaklik%3==0) {
							toplamHamleSayisi=(uzaklik/3);
							toplamHamleBedeli=toplamHamleSayisi*D.hamleBedeli;
						}
						else {
							toplamHamleSayisi=(uzaklik/3)+1;
							toplamHamleBedeli=toplamHamleSayisi*D.hamleBedeli;
						}
						karTmp=board[x][y].getGoldValue()-D.hedefBedeli-toplamHamleBedeli;
						if(karTmp>maxKar) {
							maxKar=karTmp;
							dh_i=x;
							dh_j=y;
						}
					}
				}
			}
		
		}		
		strD=strD.concat("D hedef belirledi.\n");
		System.out.println("D hedef belirledi.");
		D.harcananAltin+=D.hedefBedeli;
		D.kasadakiAltin-=D.hedefBedeli;
		D.hedef_i=dh_i;
		D.hedef_j=dh_j;
		D.setHedef(true);
		return board[dh_i][dh_j];
	}
	
	public int altinSayisiBul() {
		int x,y;
		int altinSayisi=0;
		for(x=0; x<board.length; x++) {
			for(y=0; y<board[0].length; y++) {
				if(board[x][y].isGold()) {
					altinSayisi++;
				}
			}
		}
		return altinSayisi;
	}
	
	public int gizliAltinSayisiBul() {
		int x,y;
		int gizliAltinSayisi=0;
		for(x=0; x<board.length; x++) {
			for(y=0; y<board[0].length; y++) {
				if(board[x][y].isGold() && board[x][y].getGoldValue()<0) {
					gizliAltinSayisi++;
				}
			}
		}
		return gizliAltinSayisi;
	}
	
	public void hamleYap(oyuncu X, int hamledeKacAdim) {
		int eski_i=X.index_i;
		int eski_j=X.index_j;
		int dusey=X.index_i-X.hedef_i;
		int yatay=X.index_j-X.hedef_j;
		int adimSayac=0;
		int asagiSayac=0;
		int yukariSayac=0;
		int sagSayac=0;
		int solSayac=0;
		
		while(X.index_i!=X.hedef_i && adimSayac<hamledeKacAdim) {
			if(dusey<0) {
				X.index_i++;
				asagiSayac++;
				X.toplamAdim++;
				if(board[X.index_i][X.index_j].isGold() && board[X.index_i][X.index_j].getGoldValue()<0) {
					int deger=board[X.index_i][X.index_j].getGoldValue();
					board[X.index_i][X.index_j].setGoldValue(deger*(-1));
					
					if(board[X.index_i][X.index_j].getGoldValue()==5) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("bes.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==10) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("on.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==15) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("onbes.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==20) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("yirmi.png"));
					}
					board[X.index_i][X.index_j].setGoldIcon(true);
				}
				adimSayac++;
			}
			else if(dusey>0) {
				X.index_i--;
				yukariSayac++;
				X.toplamAdim++;
				if(board[X.index_i][X.index_j].isGold() && board[X.index_i][X.index_j].getGoldValue()<0) {
					int deger=board[X.index_i][X.index_j].getGoldValue();
					board[X.index_i][X.index_j].setGoldValue(deger*(-1));
					if(board[X.index_i][X.index_j].getGoldValue()==5) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("bes.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==10) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("on.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==15) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("onbes.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==20) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("yirmi.png"));
					}
					board[X.index_i][X.index_j].setGoldIcon(true);
				}
				adimSayac++;
			}
		}
		
		while(X.index_j!=X.hedef_j && adimSayac<hamledeKacAdim) {
			if(yatay<0) {
				X.index_j++;
				sagSayac++;
				X.toplamAdim++;
				if(board[X.index_i][X.index_j].isGold() && board[X.index_i][X.index_j].getGoldValue()<0) {
					int deger=board[X.index_i][X.index_j].getGoldValue();
					board[X.index_i][X.index_j].setGoldValue(deger*(-1));
					if(board[X.index_i][X.index_j].getGoldValue()==5) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("bes.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==10) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("on.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==15) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("onbes.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==20) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("yirmi.png"));
					}
					board[X.index_i][X.index_j].setGoldIcon(true);
				}
				adimSayac++;
			}
			else if(yatay>0) {
				X.index_j--;
				solSayac++;
				X.toplamAdim++;
				if(board[X.index_i][X.index_j].isGold() && board[X.index_i][X.index_j].getGoldValue()<0) {
					int deger=board[X.index_i][X.index_j].getGoldValue();
					board[X.index_i][X.index_j].setGoldValue(deger*(-1));
					if(board[X.index_i][X.index_j].getGoldValue()==5) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("bes.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==10) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("on.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==15) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("onbes.png"));
					}
					else if(board[X.index_i][X.index_j].getGoldValue()==20) {
						board[X.index_i][X.index_j].setIcon(new ImageIcon("yirmi.png"));
					}
					board[X.index_i][X.index_j].setGoldIcon(true);
				}
				adimSayac++;
			}
		}
		if(board[X.index_i][X.index_j].isPlayer()) {
			int geri=0;
			if(sagSayac>0 && geri==0) {
				X.index_j--;
				sagSayac--;
				X.toplamAdim--;
				adimSayac--;
				geri++;
			}
			if(solSayac>0 && geri==0) {
				X.index_j++;
				solSayac--;
				X.toplamAdim--;
				adimSayac--;
				geri++;
			}
			if(asagiSayac>0 && geri==0) {
				X.index_i--;
				asagiSayac--;
				X.toplamAdim--;
				adimSayac--;
				geri++;
			}
			if(yukariSayac>0 && geri==0) {
				X.index_i++;
				yukariSayac--;
				X.toplamAdim--;
				adimSayac--;
				geri++;
			}
		}
		
		System.out.print(X.getName());
		if(asagiSayac>0) {
			System.out.print(" "+asagiSayac+" asagi");
		}
		if(yukariSayac>0) {
			System.out.print(" "+yukariSayac+" yukari");
		}
		if(sagSayac>0) {
			System.out.print(" "+sagSayac+" sag");
		}
		if(solSayac>0) {
			System.out.print(" "+solSayac+" sol");
		} 
		System.out.println(" seklinde hamle yapti.");
		
		
		
		if(X.getName().equals(A.getName())) {
			
			strA=strA.concat("A ");
			if(asagiSayac>0) {
				strA=strA.concat(" "+asagiSayac+" asagi");
			}
			if(yukariSayac>0) {
				strA=strA.concat(" "+yukariSayac+" yukari");
			}
			if(sagSayac>0) {
				strA=strA.concat(" "+sagSayac+" sag");
			}
			if(solSayac>0) {
				strA=strA.concat(" "+solSayac+" sol");
			} 
			strA=strA.concat(" seklinde hamle yapti.\n");
		}
		
		if(X.getName().equals(B.getName())) {
			strB=strB.concat("B ");
			if(asagiSayac>0) {
				strB=strB.concat(" "+asagiSayac+" asagi");
			}
			if(yukariSayac>0) {
				strB=strB.concat(" "+yukariSayac+" yukari");
			}
			if(sagSayac>0) {
				strB=strB.concat(" "+sagSayac+" sag");
			}
			if(solSayac>0) {
				strB=strB.concat(" "+solSayac+" sol");
			} 
			strB=strB.concat(" seklinde hamle yapti.\n");
		}
		
		if(X.getName().equals(C.getName())) {
			strC=strC.concat("C ");
			if(asagiSayac>0) {
				strC=strC.concat(" "+asagiSayac+" asagi");
			}
			if(yukariSayac>0) {
				strC=strC.concat(" "+yukariSayac+" yukari");
			}
			if(sagSayac>0) {
				strC=strC.concat(" "+sagSayac+" sag");
			}
			if(solSayac>0) {
				strC=strC.concat(" "+solSayac+" sol");
			} 
			strC=strC.concat(" seklinde hamle yapti.\n");
		}
		
		if(X.getName().equals(D.getName())) {
			strD=strD.concat("D ");
			if(asagiSayac>0) {
				strD=strD.concat(" "+asagiSayac+" asagi");
			}
			if(yukariSayac>0) {
				strD=strD.concat(" "+yukariSayac+" yukari");
			}
			if(sagSayac>0) {
				strD=strD.concat(" "+sagSayac+" sag");
			}
			if(solSayac>0) {
				strD=strD.concat(" "+solSayac+" sol");
			} 
			strD=strD.concat(" seklinde hamle yapti.\n");
		}
			
		
		
		if(X.index_i==X.hedef_i && X.index_j==X.hedef_j) {
			int kazanilanAltin;
			kazanilanAltin=board[X.index_i][X.index_j].getGoldValue();
			X.toplananAltin+=kazanilanAltin;
			X.kasadakiAltin+=kazanilanAltin;
			board[X.index_i][X.index_j].setGold(false);
			board[X.index_i][X.index_j].setGoldIcon(false);
			board[X.index_i][X.index_j].setGoldValue(0);
			board[X.index_i][X.index_j].setIcon(null);
			X.setHedef(false);			
			System.out.println(X.getName()+" hedefine ulasti.");
			
			if(X.getName().equals(A.getName())) {
				strA=strA.concat("A hedefine ulaþtý.\n");
			}
			else if(X.getName().equals(B.getName())) {
				strB=strB.concat("B hedefine ulaþtý.\n");
			}
			else if(X.getName().equals(C.getName())) {
				strC=strC.concat("C hedefine ulaþtý.\n");
			}
			else if(X.getName().equals(D.getName())) {
				strD=strD.concat("D hedefine ulaþtý.\n");
			}	
		}
		
		board[eski_i][eski_j].setPlayer(false);
		board[eski_i][eski_j].setPlayerIcon(false);
		board[eski_i][eski_j].setIcon(null);
		oyuncuIconGuncelle(X);
		
		X.harcananAltin+=X.hamleBedeli;
		X.kasadakiAltin-=X.hamleBedeli;
	}
	
	public boolean oyunBittiMi() {
		if((A.kasadakiAltin==0 && B.kasadakiAltin==0 && C.kasadakiAltin==0 && D.kasadakiAltin==0) || altinSayisiBul()==0 || (C.kasadakiAltin==0 && altinSayisiBul()-gizliAltinSayisiBul()==0 )) {
			return true;
		}
		else return false;
	}
	
	public void sonucYazdir() {
		System.out.println("A OYUNCUSU:");
		System.out.println("kasadaki altýn:"+A.kasadakiAltin);
		System.out.println("baþlangýç altýn:"+A.baslangicAltin);
		System.out.println("toplanan altýn:"+A.toplananAltin);
		System.out.println("harcanan altýn:"+A.harcananAltin);
		System.out.println("attýðý adým sayýsý:"+A.toplamAdim);
		
		System.out.println("B OYUNCUSU:");
		System.out.println("kasadaki altýn:"+B.kasadakiAltin);
		System.out.println("baþlangýç altýn:"+B.baslangicAltin);
		System.out.println("toplanan altýn:"+B.toplananAltin);
		System.out.println("harcanan altýn:"+B.harcananAltin);
		System.out.println("attýðý adým sayýsý:"+B.toplamAdim);
		
		System.out.println("C OYUNCUSU:");
		System.out.println("kasadaki altýn:"+C.kasadakiAltin);
		System.out.println("baþlangýç altýn:"+C.baslangicAltin);
		System.out.println("toplanan altýn:"+C.toplananAltin);
		System.out.println("harcanan altýn:"+C.harcananAltin);
		System.out.println("attýðý adým sayýsý:"+C.toplamAdim);
		
		System.out.println("D OYUNCUSU:");
		System.out.println("kasadaki altýn:"+D.kasadakiAltin);
		System.out.println("baþlangýç altýn:"+D.baslangicAltin);
		System.out.println("toplanan altýn:"+D.toplananAltin);
		System.out.println("harcanan altýn:"+D.harcananAltin);
		System.out.println("attýðý adým sayýsý:"+D.toplamAdim);
	}
	
	public void goster() {
		frame.setVisible(true);
	}
}
