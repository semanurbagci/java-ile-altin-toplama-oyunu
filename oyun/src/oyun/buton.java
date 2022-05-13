package oyun;

import javax.swing.JButton;

public class buton extends JButton{
	private int row,col,goldValue;
	private boolean gold,goldIcon,goldValueIcon,player,playerIcon;
	public buton(int row, int col) {
		this.row = row;
		this.col = col;
		this.gold = false;
		this.goldValueIcon = false;
	}
	public boolean isGoldIcon() {
		return goldIcon;
	}
	public void setGoldIcon(boolean goldIcon) {
		this.goldIcon = goldIcon;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public boolean isGold() {
		return gold;
	}
	public void setGold(boolean gold) {
		this.gold = gold;
	}
	public int getGoldValue() {
		return goldValue;
	}
	public void setGoldValue(int goldValue) {
		this.goldValue = goldValue;
	}
	public boolean isPlayer() {
		return player;
	}
	public void setPlayer(boolean player) {
		this.player = player;
	}
	public boolean isPlayerIcon() {
		return playerIcon;
	}
	public void setPlayerIcon(boolean playerIcon) {
		this.playerIcon = playerIcon;
	}
	public boolean isGoldValueIcon() {
		return goldValueIcon;
	}
	public void setGoldValueIcon(boolean goldValueIcon) {
		this.goldValueIcon = goldValueIcon;
	}
}


