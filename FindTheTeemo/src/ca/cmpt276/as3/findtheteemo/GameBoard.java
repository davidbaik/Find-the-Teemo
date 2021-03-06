package ca.cmpt276.as3.findtheteemo;

import java.util.Random;

public class GameBoard {
	private final static int SMALL_NUM_ROWS = 3;
	private final static int SMALL_NUM_COLS = 4;
	private final static int MEDIUM_NUM_ROWS = 4;
	private final static int MEDIUM_NUM_COLS = 6;
	private final static int LARGE_NUM_ROWS = 6;
	private final static int LARGE_NUM_COLS = 10;
	
	private static Bush[][] gameBoard = null;
	private static int boardWidth = 0;
	private static int boardHeight = 0;
	
	public GameBoard(String boardSize, int numOfTeemos) {
		if (boardSize.equals("small")) {
			gameBoard = new Bush[SMALL_NUM_ROWS][SMALL_NUM_COLS];
			boardHeight = SMALL_NUM_ROWS;
			boardWidth = SMALL_NUM_COLS;
		} else if (boardSize.equals("medium")) {
			gameBoard = new Bush[MEDIUM_NUM_ROWS][MEDIUM_NUM_COLS];
			boardHeight = MEDIUM_NUM_ROWS;
			boardWidth = MEDIUM_NUM_COLS;
		} else {
			gameBoard = new Bush[LARGE_NUM_ROWS][LARGE_NUM_COLS];
			boardHeight = LARGE_NUM_ROWS;
			boardWidth = LARGE_NUM_COLS;
		}
		initializeGameBoard(boardWidth, boardHeight);
		hideTeemos(numOfTeemos);
	}

	private void initializeGameBoard(int numCols, int numRows) {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				gameBoard[row][col] = new Bush();
			}
		}
	}
	
	private void hideTeemos(int numOfTeemos) {
		int numOfTeemosHidden = 0;
		Random randomNumGenerator = new Random();
		while (numOfTeemosHidden < numOfTeemos) {
			int randomColumn = randomNumGenerator.nextInt(boardWidth);
			int randomRow = randomNumGenerator.nextInt(boardHeight);
			if (gameBoard[randomRow][randomColumn].getIsTeemo() == false) {
				gameBoard[randomRow][randomColumn].setTeemo();
				numOfTeemosHidden++;
			}	
		}
		
		updateAllTeemosData();
	}
	private void updateAllTeemosData() {
		for (int col = 0; col < boardWidth; col++) {
			int numTeemosInCurrentCol = 0;
			for(int colScanner = 0; colScanner < boardHeight; colScanner++) {
				if (gameBoard[colScanner][col].getIsTeemo()) {
					numTeemosInCurrentCol++;
				}
			}
			for (int row = 0; row < boardHeight; row++) {
				int numTeemosInCurrentRow = 0;
				for(int rowScanner = 0; rowScanner < boardWidth; rowScanner++) {
					if (gameBoard[row][rowScanner].getIsTeemo()) {
						numTeemosInCurrentRow++;
					}
				}
				gameBoard[row][col].setNumTeemosOnHorizontal(numTeemosInCurrentRow);
				gameBoard[row][col].setNumTeemosOnVertical(numTeemosInCurrentCol);
			}
		}
	}
	
	public void updateNearbyTeemosData(int column, int row) {
		for (int x = 0; x < boardWidth; x++) {
			gameBoard[row][x].lowerNumOfTeemosOnHorizontal();
		}
		for (int y = 0; y < boardHeight; y++) {
			gameBoard[y][column].lowerNumOfTeemosOnVertical();
		}
	}

	public boolean getIsTeemo(int column, int row) {
		boolean isTeemoInBush = gameBoard[row][column].getIsTeemo();
		return isTeemoInBush;
	}
	
	public boolean getIsScanned(int column, int row) {
		boolean isBushScanned = gameBoard[row][column].getIsScanned();
		return isBushScanned;
	}
	
	public void setScanned(int column, int row) {
		gameBoard[row][column].setScanned();
	}
	
	public boolean getIsRevealed(int column, int row) {
		boolean isBushRevealed = gameBoard[row][column].getIsRevealed();
		return isBushRevealed;
	}
	
	public void setRevealed(int column, int row) {
		gameBoard[row][column].setRevealed();
	}
	
	public int getTeemosAround(int column, int row) {
		int nearbyTeemos = gameBoard[row][column].getNumOfTeemosOnHorizontalAndVertical();
		return nearbyTeemos;
	}
}