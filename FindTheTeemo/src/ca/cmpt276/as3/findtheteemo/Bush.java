package ca.cmpt276.as3.findtheteemo;

public class Bush {	
	private int numOfTeemosOnHorizontal = 0;
	private int numOfTeemosOnVertical = 0;
	private boolean isTeemo = false;
	private boolean isScanned = false;
	private boolean isRevealed = false;
	
	public Bush() {
		isTeemo = false;
		isScanned = false;
		isRevealed = false;
		numOfTeemosOnHorizontal = 0;
		numOfTeemosOnVertical = 0;
	}
	
	public boolean getIsTeemo() {
		return isTeemo;
	}
	
	public void setTeemo() {
		isTeemo = true;
	}
	
	public boolean getIsScanned() {
		return isScanned;
	}
	
	public void setScanned() {
		isScanned = true;
	}
	
	public boolean getIsRevealed() {
		return isRevealed;
	}
	
	public void setRevealed() {
		isRevealed = true;
	}
	
	public void lowerNumOfTeemosOnHorizontal() {
		numOfTeemosOnHorizontal--;
	}

	public void lowerNumOfTeemosOnVertical() {
		numOfTeemosOnVertical--;
	}

	public int getNumOfTeemosOnHorizontalAndVertical() {
		return numOfTeemosOnHorizontal + numOfTeemosOnVertical;
	}
	
	public void setNumTeemosOnHorizontal(int value) {
		numOfTeemosOnHorizontal = value;
	}
	
	public void setNumTeemosOnVertical(int value) {
		numOfTeemosOnVertical = value;
	}
}

