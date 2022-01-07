import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {
	static double scoreForAI=0;
	static double scoreForUser=0;
	static double scoreForAITotal=0;
	static double scoreForUserTotal=0;
	static boolean isGameFinished=false;
	static boolean isGameReallyFinished=false;
	static int counterForMoves=0;
	
	static int profitForAI=0;
	
	static int userCircles=4;
	static int aiTriangles=4;
	static String[][] gameBoard = new String[7][7];
	static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])  {
		 
		 int start=0;
		
		while(true) {
			if(start==0) {
				startGameBoard(); 
				getGameBoard();
				start=1;
			}
			if(isGameReallyFinished) {
				break;
			}
			if(isGameFinished) {
				start=0;
				isGameFinished=false;
				isGameReallyFinished=false;
				counterForMoves=0;
				profitForAI=0;
				userCircles=4;
				aiTriangles=4;
				scoreForAI=0;
				scoreForUser=0;
			}
			if(start==1) {
				playAI();
				playUser();
			}
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void startGameBoard() {
		System.out.println("Game Started!");
		System.out.println("----------------------------------------");
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				if((i==0 && j==0)||(i==2 && j==0)||(i==4 && j==6)||(i==6 && j==6)) {
					gameBoard[i][j]="^";
				}
				else if((i==0 && j==6)||(i==2 && j==6)||(i==4 && j==0)||(i==6 && j==0)) {
					gameBoard[i][j]="O";
				}
				else {
					gameBoard[i][j]="_";
				}
				
			}
		}
		
		
		
	}
	public static void getGameBoard() {
		System.out.println("    0  1  2  3  4  5  6");
		System.out.print("\n");
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				if(j==0) {
					System.out.print(i+"  |"+gameBoard[i][j]+"|");	
				}else {
					System.out.print("|"+gameBoard[i][j]+"|");
				}
				
			}
			System.out.print("\n");
		}
		int ailoss=4-aiTriangles;
		int userloss=4-userCircles;
		scoreForUser=0.5*ailoss-0.5*userloss;
		scoreForAI=0.5*userloss-0.5*ailoss;
		
		if(aiTriangles==0 || userCircles==0) {
			if(aiTriangles==userCircles) {
				System.out.println("The Game Is Draw!");
				scoreForAI+=0.5;
				scoreForUser+=0.5;
				scoreForAITotal+=scoreForAI;
				scoreForUserTotal+=scoreForUser;
			}
			else if(aiTriangles>userCircles) {
				System.out.println("Winner Is AI!");
				scoreForAI+=2;
				scoreForUser-=2;
				scoreForAITotal+=scoreForAI;
				scoreForUserTotal+=scoreForUser;
			}
			else {
				System.out.println("Winner Is USER!");
				scoreForAI-=2;
				scoreForUser+=2;
				scoreForAITotal+=scoreForAI;
				scoreForUserTotal+=scoreForUser;
			}
			System.out.println("#UserCircles="+userCircles+" #AITriangles="+aiTriangles+" TotalMoves="+counterForMoves+" UserScore="+scoreForUser+" AIScore="+scoreForAI);
			System.out.println("UserTotalScore="+scoreForUserTotal+" AITotalScore="+scoreForAITotal);
			while(true) {
				System.out.println("Game Finished. If you want to play again press 1, or press 0 to quit game!");
				System.out.print("=>");
				int choice=scanner.nextInt();
				if(choice==0) {
					counterForMoves=0;
					isGameFinished=true;
					isGameReallyFinished=true;
					break;
				}
				else if(choice==1) {
					counterForMoves=0;
					isGameFinished=true;
					break;
				}
				else {
					System.out.println("You pressed wrong!!");
				}
				
			}
		}
		else if(counterForMoves==50) {
			if(aiTriangles==userCircles) {
				System.out.println("The Game Is Draw!");
				scoreForAI+=0.5;
				scoreForUser+=0.5;
				scoreForAITotal+=scoreForAI;
				scoreForUserTotal+=scoreForUser;
			}
			else if(aiTriangles>userCircles) {
				System.out.println("Winner Is AI!");
				scoreForAI+=2;
				scoreForUser-=2;
				scoreForAITotal+=scoreForAI;
				scoreForUserTotal+=scoreForUser;
			}
			else {
				System.out.println("Winner Is USER!");
				scoreForAI-=2;
				scoreForUser+=2;
				scoreForAITotal+=scoreForAI;
				scoreForUserTotal+=scoreForUser;
			}
			System.out.println("#UserCircles="+userCircles+" #AITriangles="+aiTriangles+" TotalMoves="+counterForMoves+" UserScore="+scoreForUser+" AIScore="+scoreForAI);
			System.out.println("UserTotalScore="+scoreForUserTotal+" AITotalScore="+scoreForAITotal);
			while(true) {
				System.out.println("Game Finished. If you want to play again press 1, or press 0 to quit game!");
				System.out.print("=>");
				int choice=scanner.nextInt();
				if(choice==0) {
					counterForMoves=0;
					isGameFinished=true;
					isGameReallyFinished=true;
					break;
				}
				else if(choice==1) {
					counterForMoves=0;
					isGameFinished=true;
					break;
				}
				else {
					System.out.println("You pressed wrong!!");
				}
				
			}
			
			
		}
		else {System.out.println("#UserCircles="+userCircles+" #AITriangles="+aiTriangles+" TotalMoves="+counterForMoves+" UserScore="+scoreForUser+" AIScore="+scoreForAI);
		}
		
		System.out.println("----------------------------------------");
	}
	public static void setGameBoard(int fromrow,int fromcolumn,int gorow,int gocolumn,String userORai,boolean isTest) {
		String ourSymbol="";
		String enemySymbol="";
		if(userORai.equals("user")) {
			ourSymbol="O";enemySymbol="^";
		}
		else {
			ourSymbol="^";enemySymbol="O";
		}
		
		boolean isDeath=false;int[] deletedRows = new int[50];int[] deletedColumns = new int[50];int deletedIndx=0; 
		
		
		//between wall
		
		
		//up between wall die
		if(!isDeath) {
			int friendCounter=0;
			int enemyRow=-1;
			for(int i=gorow+1;i<7;i++) {
				if(gameBoard[i][gocolumn].equals(enemySymbol)) {
					enemyRow=i;break;
				}
			}
			if(enemyRow!=-1) {
				for(int i=enemyRow-1;i>=0;i--) {
					if((i!=gorow&&gocolumn!=fromcolumn)&&(gameBoard[i][gocolumn].equals(ourSymbol))) {
						friendCounter++;
					}
				}
				if(friendCounter==enemyRow-1) {
					isDeath=true;
					deletedRows[deletedIndx]=fromrow;
					deletedColumns[deletedIndx]=fromcolumn;
					deletedIndx++;
					if(ourSymbol.equals("O")&&!isTest) {userCircles-=1;}
					if(ourSymbol.equals("^")&&!isTest) {aiTriangles-=1;}
					if(isTest) {profitForAI--;}
					for(int i=enemyRow-1;i>=0;i--) {
						if(i!=gorow) {
							deletedRows[deletedIndx]=i;
							deletedColumns[deletedIndx]=gocolumn;
							deletedIndx++;
							if(ourSymbol.equals("O")&&!isTest) {userCircles-=1;}
							if(ourSymbol.equals("^")&&!isTest) {aiTriangles-=1;}
							if(isTest) {profitForAI--;}
						}
						
					}
					
				}
			}
		}
		
		//down between wall die
		if(!isDeath) {
			int friendCounter=0;
			int enemyRow=-1;
			for(int i=gorow-1;i>=0;i--) {
				if(gameBoard[i][gocolumn].equals(enemySymbol)) {
					enemyRow=i;break;
				}
			}
			if(enemyRow!=-1) {
				for(int i=enemyRow+1;i<7;i++) {
					if((i!=gorow&&gocolumn!=fromcolumn)&&(gameBoard[i][gocolumn].equals(ourSymbol))) {
						friendCounter++;
					}
				}
				if(friendCounter==6-enemyRow-1) {
					isDeath=true;
					deletedRows[deletedIndx]=fromrow;
					deletedColumns[deletedIndx]=fromcolumn;
					deletedIndx++;
					if(ourSymbol.equals("O")&&!isTest) {userCircles-=1;}
					if(ourSymbol.equals("^")&&!isTest) {aiTriangles-=1;}
					if(isTest) {profitForAI--;}
					for(int i=enemyRow+1;i<7;i++) {
						if(i!=gorow) {
							deletedRows[deletedIndx]=i;
							deletedColumns[deletedIndx]=gocolumn;
							deletedIndx++;
							if(ourSymbol.equals("O")&&!isTest) {userCircles-=1;}
							if(ourSymbol.equals("^")&&!isTest) {aiTriangles-=1;}
							if(isTest) {profitForAI--;}
						}
						
					}
					
				}
			}
		}
		
		//right between wall die
		if(!isDeath) {
			int friendCounter=0;
			int enemyColumn=-1;
			for(int i=gocolumn-1;i>=0;i--) {
				if(gameBoard[gorow][i].equals(enemySymbol)) {
					enemyColumn=i;break;
				}
			}
			if(enemyColumn!=-1) {
				for(int i=enemyColumn+1;i<7;i++) {
					if((i!=gocolumn&&gorow!=fromrow)&&(gameBoard[gorow][i].equals(ourSymbol))) {
						friendCounter++;
					}
				}
				if(friendCounter==6-enemyColumn-1) {
					isDeath=true;
					deletedRows[deletedIndx]=fromrow;
					deletedColumns[deletedIndx]=fromcolumn;
					deletedIndx++;
					if(ourSymbol.equals("O")&&!isTest) {userCircles-=1;}
					if(ourSymbol.equals("^")&&!isTest) {aiTriangles-=1;}
					if(isTest) {profitForAI--;}
					for(int i=enemyColumn+1;i<7;i++) {
						if(i!=gocolumn) {
							deletedRows[deletedIndx]=gorow;
							deletedColumns[deletedIndx]=i;
							deletedIndx++;
							if(ourSymbol.equals("O")&&!isTest) {userCircles-=1;}
							if(ourSymbol.equals("^")&&!isTest) {aiTriangles-=1;}
							if(isTest) {profitForAI--;}
						}
						
					}
					
				}
			}
		}
		
		//left between wall die
		if(!isDeath) {
			int friendCounter=0;
			int enemyColumn=-1;
			for(int i=gocolumn+1;i<7;i++) {
				if(gameBoard[gorow][i].equals(enemySymbol)) {
					enemyColumn=i;break;
				}
			}
			if(enemyColumn!=-1) {
				for(int i=enemyColumn-1;i>=0;i--) {
					if((i!=gocolumn&&gorow!=fromrow)&&(gameBoard[gorow][i].equals(ourSymbol))) {
						friendCounter++;
					}
				}
				if(friendCounter==enemyColumn-1) {
					isDeath=true;
					deletedRows[deletedIndx]=fromrow;
					deletedColumns[deletedIndx]=fromcolumn;
					deletedIndx++;
					if(ourSymbol.equals("O")&&!isTest) {userCircles-=1;}
					if(ourSymbol.equals("^")&&!isTest) {aiTriangles-=1;}
					if(isTest) {profitForAI--;}
					for(int i=enemyColumn-1;i>=0;i--) {
						if(i!=gocolumn) {
							deletedRows[deletedIndx]=gorow;
							deletedColumns[deletedIndx]=i;
							deletedIndx++;
							if(ourSymbol.equals("O")&&!isTest) {userCircles-=1;}
							if(ourSymbol.equals("^")&&!isTest) {aiTriangles-=1;}
							if(isTest) {profitForAI--;}
						}
						
					}
					
				}
			}
		}
		
		
		
		//between enemy die
		boolean noCorner=true;
		if(gorow==0 && gocolumn==0) {noCorner=false;}
		if(gorow==0 && gocolumn==6) {noCorner=false;}
		if(gorow==6 && gocolumn==0) {noCorner=false;}
		if(gorow==6 && gocolumn==6) {noCorner=false;}
		if(noCorner&&!isDeath) {
			//same row, different column
			
			
			boolean isRightSideEnemyExist=false;int rightEnemyColumn=0;
			boolean isLeftSideEnemyExist=false;int leftEnemyColumn=0;
			for(int i=gocolumn+1;i<7;i++) {
				if(gameBoard[gorow][i].equals(enemySymbol)) {
					isRightSideEnemyExist=true;rightEnemyColumn=i;break;
				}
				
			}
			for(int i=gocolumn-1;i>=0;i--) {
				if(gameBoard[gorow][i].equals(enemySymbol)) {
					isLeftSideEnemyExist=true;leftEnemyColumn=i;break;
				}
				
			}
			if(isRightSideEnemyExist&&isLeftSideEnemyExist) {
				if(rightEnemyColumn-leftEnemyColumn<=5 && rightEnemyColumn-leftEnemyColumn>1) {
					int bw=rightEnemyColumn-leftEnemyColumn-1;int counterForbw=0;
					for(int i=leftEnemyColumn+1;i<rightEnemyColumn;i++) {
						if(i!=gocolumn&&gorow!=fromrow) {
							if(gameBoard[gorow][i].equals(ourSymbol)) {
								counterForbw++;
							}
						}
					}
					if(counterForbw+1==bw) {
						for(int i=leftEnemyColumn+1;i<rightEnemyColumn;i++) {
							//gameBoard[gorow][i]="_";
							isDeath=true;
							deletedRows[deletedIndx]=gorow;
							deletedColumns[deletedIndx]=i;
							deletedIndx++;
						}
						//gameBoard[fromrow][fromcolumn]="_";
						deletedRows[deletedIndx]=fromrow;
						deletedColumns[deletedIndx]=fromcolumn;
						deletedIndx++;
						int deletecount=counterForbw+1;
						if(ourSymbol.equals("O")&&!isTest) {userCircles-=deletecount;}
						if(ourSymbol.equals("^")&&!isTest) {aiTriangles-=deletecount;}
						if(isTest) {profitForAI-=deletecount;}
					}
				}
			}
			
			//same column, different row
			
			boolean isUpSideEnemyExist=false;int upEnemyRow=0;
			boolean isDownSideEnemyExist=false;int downEnemyRow=0;
			for(int i=gorow+1;i<7;i++) {
				if(gameBoard[i][gocolumn].equals(enemySymbol)) {
					isDownSideEnemyExist=true;downEnemyRow=i;break;
				}
				
			}
			for(int i=gorow-1;i>=0;i--) {
				if(gameBoard[i][gocolumn].equals(enemySymbol)) {
					isUpSideEnemyExist=true;upEnemyRow=i;break;
				}
				
			}
			if(isDownSideEnemyExist&&isUpSideEnemyExist) {
				if(downEnemyRow-upEnemyRow<=5 && downEnemyRow-upEnemyRow>1) {
					int bw=downEnemyRow-upEnemyRow-1;int counterForbw=0;
					for(int i=upEnemyRow+1;i<downEnemyRow;i++) {
						if(i!=gorow&&gocolumn!=fromcolumn) {
							if(gameBoard[i][gocolumn].equals(ourSymbol)) {
								counterForbw++;
							}
						}
					}
					if(counterForbw+1==bw) {
						for(int i=upEnemyRow+1;i<downEnemyRow;i++) {
							//gameBoard[i][gocolumn]="_";
							isDeath=true;
							deletedRows[deletedIndx]=i;
							deletedColumns[deletedIndx]=gocolumn;
							deletedIndx++;
						}
						//gameBoard[fromrow][fromcolumn]="_";
						deletedRows[deletedIndx]=fromrow;
						deletedColumns[deletedIndx]=fromcolumn;
						deletedIndx++;
						int deletecount=counterForbw+1;
						if(ourSymbol.equals("O")&&!isTest) {userCircles-=deletecount;}
						if(ourSymbol.equals("^")&&!isTest) {aiTriangles-=deletecount;}
						if(isTest) {profitForAI-=deletecount;}
					}
				}
			}
			
			
			
		}
		
		
		//killing..
		//kill between up wall
		int upNearWallEnemyCounter=0;
		for(int i=gorow-1;i>=0;i--) {
			if(gameBoard[i][gocolumn].equals(enemySymbol)) {
				upNearWallEnemyCounter++;
			}
		}
		if(upNearWallEnemyCounter==gorow) {
			for(int i=gorow-1;i>=0;i--) {
				//gameBoard[i][gocolumn]="_";
				deletedRows[deletedIndx]=i;
				deletedColumns[deletedIndx]=gocolumn;
				deletedIndx++;
			}
			if(enemySymbol.equals("O")&&!isTest) {userCircles-=upNearWallEnemyCounter;}
			if(enemySymbol.equals("^")&&!isTest) {aiTriangles-=upNearWallEnemyCounter;}
			if(isTest) {profitForAI+=upNearWallEnemyCounter;}
		}
		
		//kill between down wall
		int downNearWallEnemyCounter=0;
		for(int i=gorow+1;i<7;i++) {
			if(gameBoard[i][gocolumn].equals(enemySymbol)) {
				downNearWallEnemyCounter++;
			}
		}
		if(downNearWallEnemyCounter==(6-gorow)) {
			for(int i=gorow+1;i<7;i++) {
				//gameBoard[i][gocolumn]="_";
				deletedRows[deletedIndx]=i;
				deletedColumns[deletedIndx]=gocolumn;
				deletedIndx++;
			}
			if(enemySymbol.equals("O")&&!isTest) {userCircles-=downNearWallEnemyCounter;}
			if(enemySymbol.equals("^")&&!isTest) {aiTriangles-=downNearWallEnemyCounter;}
			if(isTest) {profitForAI+=downNearWallEnemyCounter;}
		}
		//kill between right wall
		int rightNearWallEnemyCounter=0;
		for(int i=gocolumn+1;i<7;i++) {
			if(gameBoard[gorow][i].equals(enemySymbol)) {
				rightNearWallEnemyCounter++;
			}
		}
		if(rightNearWallEnemyCounter==(6-gocolumn)) {
			for(int i=gocolumn+1;i<7;i++) {
				//gameBoard[gorow][i]="_";
				deletedRows[deletedIndx]=gorow;
				deletedColumns[deletedIndx]=i;
				deletedIndx++;
			}
			if(enemySymbol.equals("O")&&!isTest) {userCircles-=rightNearWallEnemyCounter;}
			if(enemySymbol.equals("^")&&!isTest) {aiTriangles-=rightNearWallEnemyCounter;}
			if(isTest) {profitForAI+=rightNearWallEnemyCounter;}
		}
		//kill between left wall
		int leftNearWallEnemyCounter=0;
		for(int i=gocolumn-1;i>=0;i--) {
			if(gameBoard[gorow][i].equals(enemySymbol)) {
				leftNearWallEnemyCounter++;
			}
		}
		if(leftNearWallEnemyCounter==gocolumn) {
			for(int i=gocolumn-1;i>=0;i--) {
				//gameBoard[gorow][i]="_";
				deletedRows[deletedIndx]=gorow;
				deletedColumns[deletedIndx]=i;
				deletedIndx++;
			}
			if(enemySymbol.equals("O")&&!isTest) {userCircles-=leftNearWallEnemyCounter;}
			if(enemySymbol.equals("^")&&!isTest) {aiTriangles-=leftNearWallEnemyCounter;}
			if(isTest) {profitForAI+=leftNearWallEnemyCounter;}
		}
		
		//kill between my right friend
		int rightFriendBwEnemiesCounter=0;int rightFriendIndxColumn=-1;
		for(int i=gocolumn+1;i<7;i++) {
			if(gameBoard[gorow][i].equals(ourSymbol)) {
				rightFriendIndxColumn=i;
				break;
			}
		}
		if(rightFriendIndxColumn!=-1) {
			for(int i=gocolumn+1;i<rightFriendIndxColumn;i++) {
				if(gameBoard[gorow][i].equals(enemySymbol)) {
					rightFriendBwEnemiesCounter++;
				}
			}
		}
		if(rightFriendBwEnemiesCounter==rightFriendIndxColumn-gocolumn-1) {
			for(int i=gocolumn+1;i<rightFriendIndxColumn;i++) {
				//gameBoard[gorow][i]="_";
				deletedRows[deletedIndx]=gorow;
				deletedColumns[deletedIndx]=i;
				deletedIndx++;
			}
			if(enemySymbol.equals("O")&&!isTest) {userCircles-=rightFriendBwEnemiesCounter;}
			if(enemySymbol.equals("^")&&!isTest) {aiTriangles-=rightFriendBwEnemiesCounter;}
			if(isTest) {profitForAI+=rightFriendBwEnemiesCounter;}
		}
		//kill between my left friend
		int leftFriendBwEnemiesCounter=0;int leftFriendIndxColumn=-1;
		for(int i=gocolumn-1;i>=0;i--) {
			if(gameBoard[gorow][i].equals(ourSymbol)) {
				leftFriendIndxColumn=i;
				break;
			}
		}
		if(leftFriendIndxColumn!=-1) {
			for(int i=gocolumn-1;i>leftFriendIndxColumn;i--) {
				if(gameBoard[gorow][i].equals(enemySymbol)) {
					leftFriendBwEnemiesCounter++;
				}
			}
		}
		if(leftFriendBwEnemiesCounter==gocolumn-leftFriendIndxColumn-1) {
			for(int i=gocolumn-1;i>leftFriendIndxColumn;i--) {
				//gameBoard[gorow][i]="_";
				deletedRows[deletedIndx]=gorow;
				deletedColumns[deletedIndx]=i;
				deletedIndx++;
			}
			if(enemySymbol.equals("O")&&!isTest) {userCircles-=leftFriendBwEnemiesCounter;}
			if(enemySymbol.equals("^")&&!isTest) {aiTriangles-=leftFriendBwEnemiesCounter;}
			if(isTest) {profitForAI+=leftFriendBwEnemiesCounter;}
		}
		//kill between my down friend
		int downFriendBwEnemiesCounter=0;int downFriendIndxRow=-1;
		for(int i=gorow+1;i<7;i++) {
			if(gameBoard[i][gocolumn].equals(ourSymbol)) {
				downFriendIndxRow=i;
				break;
			}
		}
		if(downFriendIndxRow!=-1) {
			for(int i=gorow+1;i<downFriendIndxRow;i++) {
				if(gameBoard[i][gocolumn].equals(enemySymbol)) {
					downFriendBwEnemiesCounter++;
				}
			}
		}
		if(downFriendBwEnemiesCounter==downFriendIndxRow-gorow-1) {
			for(int i=gorow+1;i<downFriendIndxRow;i++) {
				//gameBoard[i][gocolumn]="_";
				deletedRows[deletedIndx]=i;
				deletedColumns[deletedIndx]=gocolumn;
				deletedIndx++;
			}
			if(enemySymbol.equals("O")&&!isTest) {userCircles-=downFriendBwEnemiesCounter;}
			if(enemySymbol.equals("^")&&!isTest) {aiTriangles-=downFriendBwEnemiesCounter;}
			if(isTest) {profitForAI+=downFriendBwEnemiesCounter;}
		}
		//kill between my up friend
		int upFriendBwEnemiesCounter=0;int upFriendIndxRow=-1;
		for(int i=gorow-1;i>=0;i--) {
			if(gameBoard[i][gocolumn].equals(ourSymbol)) {
				upFriendIndxRow=i;
				break;
			}
		}
		if(upFriendIndxRow!=-1) {
			for(int i=gorow-1;i>upFriendIndxRow;i--) {
				if(gameBoard[i][gocolumn].equals(enemySymbol)) {
					upFriendBwEnemiesCounter++;
				}
			}
		}
		if(upFriendBwEnemiesCounter==gorow-upFriendIndxRow-1) {
			for(int i=gorow-1;i>upFriendIndxRow;i--) {
				//gameBoard[i][gocolumn]="_";
				deletedRows[deletedIndx]=i;
				deletedColumns[deletedIndx]=gocolumn;
				deletedIndx++;
			}
			if(enemySymbol.equals("O")&&!isTest) {userCircles-=upFriendBwEnemiesCounter;}
			if(enemySymbol.equals("^")&&!isTest) {aiTriangles-=upFriendBwEnemiesCounter;}
			if(isTest) {profitForAI+=upFriendBwEnemiesCounter;}
		}
		
		
		for(int i=0;i<deletedIndx;i++) {
			if(!isTest) {gameBoard[deletedRows[i]][deletedColumns[i]]="_";}
		}
		if(!isDeath&&!isTest) {
			gameBoard[fromrow][fromcolumn]="_";
			gameBoard[gorow][gocolumn]=ourSymbol;
		}
		
		
	}
	public static void playUser() {
		int[] usedRows=new int[20];int[] usedColumns=new int[20];int usedIndx=0;int isUsed=0;
		if(userCircles>1 && isGameFinished==false && isGameReallyFinished==false) {
			System.out.println("Select the circle which you want to play firstly. You can choose;");
			int c=0; String[] locations= new String[4];String[] ways= new String[4];
			for(int m=0;m<4;m++) {ways[m]="";}
			for(int i=0;i<7;i++) {
				for(int j=0;j<7;j++) {
					if(gameBoard[i][j].equals("O")) {
						int flag=0;
						for(int mm=0;mm<usedIndx;mm++) {
							if(usedRows[mm]==i && usedColumns[mm]==j) {
								flag=1;
							}
						}
						if(flag==1) {isUsed=1;}
					}
					if(gameBoard[i][j].equals("O")&&isUsed==0) {
						int goWays=0;
						if(i+1<7) {
							if(gameBoard[i+1][j].equals("_")) {
								ways[c]+=Integer.toString(i+1)+".row "+Integer.toString(j)+".column-";
								goWays++;
							}
						}
						if(i-1>=0) {
							if(gameBoard[i-1][j].equals("_")) {
								ways[c]+=Integer.toString(i-1)+".row "+Integer.toString(j)+".column-";
								goWays++;		
							}
						}
						if(j+1<7) {
							if(gameBoard[i][j+1].equals("_")) {
								ways[c]+=Integer.toString(i)+".row "+Integer.toString(j+1)+".column-";
								goWays++;		
							}
						}
						if(j-1>=0) {
							if(gameBoard[i][j-1].equals("_")) {
								ways[c]+=Integer.toString(i)+".row "+Integer.toString(j-1)+".column-";
								goWays++;		
							}
						}
						if(goWays!=0) {
							System.out.println("To play with "+i+".row "+j+".column circle press "+c);
							locations[c]=Integer.toString(i)+" "+Integer.toString(j);
							c++;
						}
						
					}
					isUsed=0;
				}
				
			}
			int slc=-1;
			while(true) {
				System.out.print("=>");
				int selection=scanner.nextInt();
				if(selection<0 || selection>=c) {
					System.out.println("Your selection is wrong! Please select again properly.");
				}else {
					slc=selection;
					break;
				}
			}
			StringTokenizer st1 = new StringTokenizer(locations[slc]," ");
			int fromrow=Integer.parseInt(st1.nextToken());int fromcolumn=Integer.parseInt(st1.nextToken());
			//System.out.println(fromrow+"fr"+fromcolumn+"fc");
			System.out.println("Which location do you want to move your circle?. You can choose;");
			StringTokenizer st = new StringTokenizer(ways[slc],"-");
			int slcForWay=0;String[] selectionWays= new String[4];
			while (st.hasMoreTokens()) {  
				 selectionWays[slcForWay]=st.nextToken();
		         System.out.println("To move circle to the "+selectionWays[slcForWay]+" press "+slcForWay);
		         slcForWay++;
		     }
			int realSelectionForWay=-1;int gorow=-1;int gocolumn=-1;
			while(true) {
				System.out.print("=>");
				realSelectionForWay=scanner.nextInt();
				if(realSelectionForWay>=0 && realSelectionForWay<slcForWay) {
					int indexForRow=selectionWays[realSelectionForWay].indexOf(".row");
					int indexForColumn=selectionWays[realSelectionForWay].indexOf(".column");
					String row1=selectionWays[realSelectionForWay].substring(0,indexForRow);
					String column1=selectionWays[realSelectionForWay].substring(indexForRow+5,indexForColumn);
					gorow=Integer.parseInt(row1);gocolumn=Integer.parseInt(column1);
					break;}
				else {System.out.println("Your selection is wrong! Please select again properly.");}
			}
			//System.out.println(gorow+"r"+gocolumn+"c");
			setGameBoard(fromrow,fromcolumn,gorow,gocolumn,"user",false);
			counterForMoves++;
			if(gameBoard[gorow][gocolumn].equals("O")) {
				usedRows[usedIndx]=gorow;
				usedColumns[usedIndx]=gocolumn;
				usedIndx++;
			}
			getGameBoard();
			
			if(isGameFinished==false && isGameReallyFinished==false) {
				System.out.println("Select the circle which you want to play secondly. You can choose;");
				int cc=0; String[] locationss= new String[4];String[] wayss= new String[4];
				for(int m=0;m<4;m++) {wayss[m]="";}
				for(int i=0;i<7;i++) {
					for(int j=0;j<7;j++) {
						if(gameBoard[i][j].equals("O")) {
							int flag=0;
							for(int mm=0;mm<usedIndx;mm++) {
								if(usedRows[mm]==i && usedColumns[mm]==j) {
									flag=1;
								}
							}
							if(flag==1) {isUsed=1;}
						}
						if(gameBoard[i][j].equals("O")&&isUsed==0) {
							int goWayss=0;
							if(i+1<7) {
								if(gameBoard[i+1][j].equals("_")) {
									wayss[cc]+=Integer.toString(i+1)+".row "+Integer.toString(j)+".column-";
									goWayss++;
								}
							}
							if(i-1>=0) {
								if(gameBoard[i-1][j].equals("_")) {
									wayss[cc]+=Integer.toString(i-1)+".row "+Integer.toString(j)+".column-";
									goWayss++;		
								}
							}
							if(j+1<7) {
								if(gameBoard[i][j+1].equals("_")) {
									wayss[cc]+=Integer.toString(i)+".row "+Integer.toString(j+1)+".column-";
									goWayss++;		
								}
							}
							if(j-1>=0) {
								if(gameBoard[i][j-1].equals("_")) {
									wayss[cc]+=Integer.toString(i)+".row "+Integer.toString(j-1)+".column-";
									goWayss++;		
								}
							}
							if(goWayss!=0) {
								System.out.println("To play with "+i+".row "+j+".column circle press "+cc);
								locationss[cc]=Integer.toString(i)+" "+Integer.toString(j);
								cc++;
							}
							
						}
						isUsed=0;
					}
					
				}
				int slcc=-1;
				while(true) {
					System.out.print("=>");
					int selectionn=scanner.nextInt();
					if(selectionn<0 || selectionn>=cc) {
						System.out.println("Your selection is wrong! Please select again properly.");
					}else {
						slcc=selectionn;
						break;
					}
				}
				StringTokenizer st11 = new StringTokenizer(locationss[slcc]," ");
				int fromroww=Integer.parseInt(st11.nextToken());int fromcolumnn=Integer.parseInt(st11.nextToken());
				
				System.out.println("Which location do you want to move your circle?. You can choose;");
				StringTokenizer stt = new StringTokenizer(wayss[slcc],"-");
				int slcForWayy=0;String[] selectionWayss= new String[4];
				while (stt.hasMoreTokens()) {  
					 selectionWayss[slcForWayy]=stt.nextToken();
			         System.out.println("To move circle to the "+selectionWayss[slcForWayy]+" press "+slcForWayy);
			         slcForWayy++;
			     }
				int realSelectionForWayy=-1;int goroww=-1;int gocolumnn=-1;
				while(true) {
					System.out.print("=>");
					realSelectionForWayy=scanner.nextInt();
					if(realSelectionForWayy>=0 && realSelectionForWayy<slcForWayy) {
						int indexForRoww=selectionWayss[realSelectionForWayy].indexOf(".row");
						int indexForColumnn=selectionWayss[realSelectionForWayy].indexOf(".column");
						String row11=selectionWayss[realSelectionForWayy].substring(0,indexForRoww);
						String column11=selectionWayss[realSelectionForWayy].substring(indexForRoww+5,indexForColumnn);
						goroww=Integer.parseInt(row11);gocolumnn=Integer.parseInt(column11);
						break;}
					else {System.out.println("Your selection is wrong! Please select again properly.");}
				}
				setGameBoard(fromroww,fromcolumnn,goroww,gocolumnn,"user",false);
				counterForMoves++;
				if(gameBoard[gorow][gocolumn].equals("O")) {
					usedRows[usedIndx]=gorow;
					usedColumns[usedIndx]=gocolumn;
					usedIndx++;
				}
				getGameBoard();
			}
			
			
		}
		
		else if(userCircles==1 && isGameFinished==false && isGameReallyFinished==false) {
			
			System.out.println("Select the circle which you want to play. You can choose;");
			int c=0; String[] locations= new String[4];String[] ways= new String[4];
			for(int m=0;m<4;m++) {ways[m]="";}
			for(int i=0;i<7;i++) {
				for(int j=0;j<7;j++) {
					if(gameBoard[i][j].equals("O")) {
						int goWays=0;
						if(i+1<7) {
							if(gameBoard[i+1][j].equals("_")) {
								ways[c]+=Integer.toString(i+1)+".row "+Integer.toString(j)+".column-";
								goWays++;
							}
						}
						if(i-1>=0) {
							if(gameBoard[i-1][j].equals("_")) {
								ways[c]+=Integer.toString(i-1)+".row "+Integer.toString(j)+".column-";
								goWays++;		
							}
						}
						if(j+1<7) {
							if(gameBoard[i][j+1].equals("_")) {
								ways[c]+=Integer.toString(i)+".row "+Integer.toString(j+1)+".column-";
								goWays++;		
							}
						}
						if(j-1>=0) {
							if(gameBoard[i][j-1].equals("_")) {
								ways[c]+=Integer.toString(i)+".row "+Integer.toString(j-1)+".column-";
								goWays++;		
							}
						}
						if(goWays!=0) {
							System.out.println("To play with "+i+".row "+j+".column circle press "+c);
							locations[c]=Integer.toString(i)+" "+Integer.toString(j);
							c++;
						}
						
					}
				}
				
			}
			int slc=-1;
			while(true) {
				System.out.print("=>");
				int selection=scanner.nextInt();
				if(selection<0 || selection>=c) {
					System.out.println("Your selection is wrong! Please select again properly.");
				}else {
					slc=selection;
					break;
				}
			}
			StringTokenizer st1 = new StringTokenizer(locations[slc]," ");
			int fromrow=Integer.parseInt(st1.nextToken());int fromcolumn=Integer.parseInt(st1.nextToken());
			//System.out.println(fromrow+"fr"+fromcolumn+"fc");
			System.out.println("Which location do you want to move your circle?. You can choose;");
			StringTokenizer st = new StringTokenizer(ways[slc],"-");
			int slcForWay=0;String[] selectionWays= new String[4];
			while (st.hasMoreTokens()) {  
				 selectionWays[slcForWay]=st.nextToken();
		         System.out.println("To move circle to the "+selectionWays[slcForWay]+" press "+slcForWay);
		         slcForWay++;
		     }
			int realSelectionForWay=-1;int gorow=-1;int gocolumn=-1;
			while(true) {
				System.out.print("=>");
				realSelectionForWay=scanner.nextInt();
				if(realSelectionForWay>=0 && realSelectionForWay<slcForWay) {
					int indexForRow=selectionWays[realSelectionForWay].indexOf(".row");
					int indexForColumn=selectionWays[realSelectionForWay].indexOf(".column");
					String row1=selectionWays[realSelectionForWay].substring(0,indexForRow);
					String column1=selectionWays[realSelectionForWay].substring(indexForRow+5,indexForColumn);
					gorow=Integer.parseInt(row1);gocolumn=Integer.parseInt(column1);
					break;}
				else {System.out.println("Your selection is wrong! Please select again properly.");}
			}
			//System.out.println(gorow+"r"+gocolumn+"c");
			setGameBoard(fromrow,fromcolumn,gorow,gocolumn,"user",false);
			counterForMoves++;
			getGameBoard();
		}
		
		
		
	}
	
	public static void playAI() {
		
		int usedGoRow=-1; 
		int usedGoColumn=-1;
		boolean isGreaterThan1=false;
		 if(aiTriangles>1&& isGameFinished==false && isGameReallyFinished==false) {
			 System.out.println("AI PLAYED;");
			 	isGreaterThan1=true;
			 	profitForAI=0;
				int[] aiSymbolsFromRows = new int[4];int[] aiSymbolsFromColumns = new int[4];int aiSymbolsIndx=0;
				int[] userSymbolsFromRows = new int[4];int[] userSymbolsFromColumns = new int[4];int userSymbolsIndx=0;
				
				String[] aiSelectionWayForSymbol= new String[4];int aiSelectionWayIndx=0;
				int[] aiMaxProfitForSymbol=new int[4];
				
				String[] userSelectionWayForSymbol= new String[4];int userSelectionWayIndx=0;
				int[] userMaxProfitForSymbol=new int[4];
			 
			 for(int i=0;i<7;i++) {//Getting rows and columns of symbols.
				 for(int j=0;j<7;j++) {
					 if(gameBoard[i][j].equals("^")) {
						 aiSymbolsFromRows[aiSymbolsIndx]=i;
						 aiSymbolsFromColumns[aiSymbolsIndx]=j;
						 aiSymbolsIndx++;
					 }
					 if(gameBoard[i][j].equals("O")) {
						 userSymbolsFromRows[userSymbolsIndx]=i;
						 userSymbolsFromColumns[userSymbolsIndx]=j;
						 userSymbolsIndx++;
					 }
				 }
			 }
			 for(int i=0;i<aiSymbolsIndx;i++) {//Finding best way for every symbol.
				 int profitForLeft=0;int profitForRight=0;int profitForUp=0;int profitForDown=0;int maxProfit=-1000;
				 boolean canGoLeft=false;boolean canGoRight=false;boolean canGoUp=false;boolean canGoDown=false;
				 if(aiSymbolsFromColumns[i]-1>=0 && gameBoard[aiSymbolsFromRows[i]][aiSymbolsFromColumns[i]-1].equals("_")) {//Can go left
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i],aiSymbolsFromColumns[i]-1,"ai",true);
					 canGoLeft=true;
					 profitForLeft=profitForAI;profitForAI=0;
				 }
				 if(aiSymbolsFromColumns[i]+1<7 && gameBoard[aiSymbolsFromRows[i]][aiSymbolsFromColumns[i]+1].equals("_")) {//Can go right
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i],aiSymbolsFromColumns[i]+1,"ai",true);
					 canGoRight=true;
					 profitForRight=profitForAI;profitForAI=0;
				 }
				 if(aiSymbolsFromRows[i]-1>=0 && gameBoard[aiSymbolsFromRows[i]-1][aiSymbolsFromColumns[i]].equals("_")) {//Can go up
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i]-1,aiSymbolsFromColumns[i],"ai",true);
					 canGoUp=true;
					 profitForUp=profitForAI;profitForAI=0;
				 }
				 if(aiSymbolsFromRows[i]+1<7 && gameBoard[aiSymbolsFromRows[i]+1][aiSymbolsFromColumns[i]].equals("_")) {//Can go down
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i]+1,aiSymbolsFromColumns[i],"ai",true);
					 canGoDown=true;
					 profitForDown=profitForAI;profitForAI=0;
				 }
				 ////
				 
				 if(profitForLeft>maxProfit) {//Selecting maxprofit way.
					 maxProfit=profitForLeft;
				 }
				 if(profitForRight>maxProfit) {
					 maxProfit=profitForRight;
				 }
				 if(profitForUp>maxProfit) {
					 maxProfit=profitForUp;
				 }
				 if(profitForDown>maxProfit) {
					 maxProfit=profitForDown;
				 }
				 ///
				 
				 String maxWayss="";
				 if(maxProfit==profitForLeft&&canGoLeft) {maxWayss+="L";}//Finding which ways are containing maxprofit way.
				 if(maxProfit==profitForRight&&canGoRight) {maxWayss+="R";}
				 if(maxProfit==profitForUp&&canGoUp) {maxWayss+="U";}
				 if(maxProfit==profitForDown&&canGoDown) {maxWayss+="D";}
				 ///
				
				 //System.out.println(maxWayss+maxWayss.length());
				 //getGameBoard();
				 
				 if(maxWayss.length()>1) {//Max path is greater than 1
					 if(aiSymbolsFromRows[i]==0) {//If my symbol at up
						 if(maxWayss.contains("D")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="D";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else if(aiSymbolsFromRows[i]==6) {//If my symbol at down
						 if(maxWayss.contains("U")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="U";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else if(aiSymbolsFromColumns[i]==0) {//If my symbol at left
						 if(maxWayss.contains("R")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="R";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else if(aiSymbolsFromColumns[i]==6) {//If my symbol at right
						 if(maxWayss.contains("L")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="L";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else {
						 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
						 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
						 aiSelectionWayIndx++;
					 }
					 
				 }
				 else {
					 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss;
					 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
					 aiSelectionWayIndx++;
					 
				 }
				 ///
				 
				 
				 
			 }
			 ////same things for user symbols..
			 for(int i=0;i<userSymbolsIndx;i++) {
				 
				 int profitForLeftUser=0;int profitForRightUser=0;int profitForUpUser=0;int profitForDownUser=0;int maxProfitUser=-1000;
				 
				 boolean canGoLeftUser=false;boolean canGoRightUser=false;boolean canGoUpUser=false;boolean canGoDownUser=false;
				 
				 ////
				 if(userSymbolsFromColumns[i]-1>=0 && gameBoard[userSymbolsFromRows[i]][userSymbolsFromColumns[i]-1].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i],userSymbolsFromColumns[i]-1,"user",true);
					 canGoLeftUser=true;
					 profitForLeftUser=profitForAI;profitForAI=0;
				 }
				 if(userSymbolsFromColumns[i]+1<7 && gameBoard[userSymbolsFromRows[i]][userSymbolsFromColumns[i]+1].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i],userSymbolsFromColumns[i]+1,"user",true);
					 canGoRightUser=true;
					 profitForRightUser=profitForAI;profitForAI=0;
				 }
				 if(userSymbolsFromRows[i]-1>=0 && gameBoard[userSymbolsFromRows[i]-1][userSymbolsFromColumns[i]].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i]-1,userSymbolsFromColumns[i],"user",true);
					 canGoUpUser=true;
					 profitForUpUser=profitForAI;profitForAI=0;
				 }
				 if(userSymbolsFromRows[i]+1<7 && gameBoard[userSymbolsFromRows[i]+1][userSymbolsFromColumns[i]].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i]+1,userSymbolsFromColumns[i],"user",true);
					 canGoDownUser=true;
					 profitForDownUser=profitForAI;profitForAI=0;
				 }
				 
				 ///
				 if(profitForLeftUser>maxProfitUser) {
					 maxProfitUser=profitForLeftUser;
				 }
				 if(profitForRightUser>maxProfitUser) {
					 maxProfitUser=profitForRightUser;
				 }
				 if(profitForUpUser>maxProfitUser) {
					 maxProfitUser=profitForUpUser;
				 }
				 if(profitForDownUser>maxProfitUser) {
					 maxProfitUser=profitForDownUser;
				 }
				 
				 ///
				 String maxWayssUser="";
				 if(maxProfitUser==profitForLeftUser&&canGoLeftUser) {maxWayssUser+="L";}
				 if(maxProfitUser==profitForRightUser&&canGoRightUser) {maxWayssUser+="R";}
				 if(maxProfitUser==profitForUpUser&&canGoUpUser) {maxWayssUser+="U";}
				 if(maxProfitUser==profitForDownUser&&canGoDownUser) {maxWayssUser+="D";}
				 //System.out.println(maxWayss+maxWayss.length());
				 //getGameBoard();
				 
				 
				 ///
				 if(maxWayssUser.length()>1) {
					 if(userSymbolsFromRows[i]==0) {
						 if(maxWayssUser.contains("D")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="D";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else if(userSymbolsFromRows[i]==6) {
						 if(maxWayssUser.contains("U")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="U";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else if(userSymbolsFromColumns[i]==0) {
						 if(maxWayssUser.contains("R")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="R";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else if(userSymbolsFromColumns[i]==6) {
						 if(maxWayssUser.contains("L")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="L";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else {
						 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
						 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
						 userSelectionWayIndx++;
					 }
				 }
				 else {
					 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser;
					 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
					 userSelectionWayIndx++;
				 }
				 
				 
			 }
			 
			 //Finding which symbol has maxprofit way
			 int realMaxProfit=-1000;String realMaxProfitSymbolWay="";
			 int maxProfitFromRow=-1;int maxProfitFromColumn=-1;
			 for(int i=0;i<aiSelectionWayIndx;i++) {
				 //System.out.println(aiSelectionWayForSymbol[i]+" Akýllýca yol");
				 String way=aiSelectionWayForSymbol[i];
				 int maxprofit=aiMaxProfitForSymbol[i];
				 if(maxprofit>realMaxProfit) {
					 realMaxProfit=maxprofit;
					 
					 maxProfitFromRow=aiSymbolsFromRows[i];
					 maxProfitFromColumn=aiSymbolsFromColumns[i];
					 realMaxProfitSymbolWay=way;
				 }
			 }
			 ///
			 int realMaxProfitUser=-1000;String realMaxProfitSymbolWayUser="";
			 int maxProfitFromRowUser=-1;int maxProfitFromColumnUser=-1;
			 for(int i=0;i<userSelectionWayIndx;i++) {
				 //System.out.println(aiSelectionWayForSymbol[i]+" Akýllýca yol");
				 String way=userSelectionWayForSymbol[i];
				 int maxprofit=userMaxProfitForSymbol[i];
				 if(maxprofit>realMaxProfitUser) {
					 realMaxProfitUser=maxprofit;
					 maxProfitFromRowUser=userSymbolsFromRows[i];
					 maxProfitFromColumnUser=userSymbolsFromColumns[i];
					 realMaxProfitSymbolWayUser=way;
				 }
			 }
			 //System.out.println(realMaxProfit+" realmaxprft "+maxProfitFromRow+" fr "+maxProfitFromColumn+" fc " +realMaxProfitSymbolWay+"bestWay");
			 //System.out.println(realMaxProfitUser+" realmaxprftusr "+maxProfitFromRowUser+" frUsr "+maxProfitFromColumnUser+" fcUsr " +realMaxProfitSymbolWayUser+"bestWayUsr");
			 
			 if(realMaxProfit>=realMaxProfitUser) {// ai's maxprofit >= user's maxprofit, than play for maxprofit ai way..
				 if(realMaxProfitSymbolWay.equals("U")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow-1,maxProfitFromColumn,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow-1)+" GoColumn:"+maxProfitFromColumn);
					 if(gameBoard[maxProfitFromRow-1][maxProfitFromColumn].equals("^")) {
						 usedGoRow=maxProfitFromRow-1;
						 usedGoColumn=maxProfitFromColumn;
					 }
					 getGameBoard();
				 }
				 else if(realMaxProfitSymbolWay.equals("D")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow+1,maxProfitFromColumn,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow+1)+" GoColumn:"+maxProfitFromColumn);
					 if(gameBoard[maxProfitFromRow+1][maxProfitFromColumn].equals("^")) {
						 usedGoRow=maxProfitFromRow+1;
						 usedGoColumn=maxProfitFromColumn;
					 }
					 getGameBoard();
				 }
				 else if(realMaxProfitSymbolWay.equals("R")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn+1,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn+1));
					 if(gameBoard[maxProfitFromRow][maxProfitFromColumn+1].equals("^")) {
						 usedGoRow=maxProfitFromRow;
						 usedGoColumn=maxProfitFromColumn+1;
					 }
					 getGameBoard();
				 }
				 else if(realMaxProfitSymbolWay.equals("L")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn-1,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn-1));
					 if(gameBoard[maxProfitFromRow][maxProfitFromColumn-1].equals("^")) {
						 usedGoRow=maxProfitFromRow;
						 usedGoColumn=maxProfitFromColumn-1;
					 }
					 getGameBoard();
				 }
				 
				 
			 }
			 else if(realMaxProfit<realMaxProfitUser) {// ai's maxprofit < user's maxprofit
				 //run away symbol which user gonna kill (maxprofit) VS ai's maxProfit way - user's maxProfit way
				 //select which one is better choice
				 int myProblemSymbolRow=-1;
				 int myProblemSymbolColumn=-1;
				 if(realMaxProfitSymbolWayUser.equals("U")) {
					 myProblemSymbolRow=maxProfitFromRowUser-1;
					 myProblemSymbolColumn=maxProfitFromColumnUser;
				 }
				 else if(realMaxProfitSymbolWayUser.equals("D")) {
					 myProblemSymbolRow=maxProfitFromRowUser+1;
					 myProblemSymbolColumn=maxProfitFromColumnUser;
				 }
				 else if(realMaxProfitSymbolWayUser.equals("R")) {
					 myProblemSymbolRow=maxProfitFromRowUser;
					 myProblemSymbolColumn=maxProfitFromColumnUser+1;
				 }
				 else if(realMaxProfitSymbolWayUser.equals("L")) {
					 myProblemSymbolRow=maxProfitFromRowUser;
					 myProblemSymbolColumn=maxProfitFromColumnUser-1;
				 }
				 
				 int ýndx=-1;
				 if(myProblemSymbolRow!=-1 && myProblemSymbolColumn!=-1) {
					 for(int i=0;i<4;i++) {
						 if(aiSymbolsFromRows[i]==myProblemSymbolRow && aiSymbolsFromColumns[i]==myProblemSymbolColumn) {
							 ýndx=i;break;
						 }
					 }
					 //System.out.println(aiSelectionWayForSymbol[ýndx]+"caner"); en iyi yol o karakter için
					 int runAwayMovementProfit=-1000;//profit for runaway symbol which gonna die if not escape
					 if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("U")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow-1,myProblemSymbolColumn,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("D")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow+1,myProblemSymbolColumn,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("R")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn+1,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("L")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn-1,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 
					 //aimaxProfit-usermaxProfit
					 int diff=realMaxProfit-realMaxProfitUser;//ai and user did best move
					 if(diff<runAwayMovementProfit) {//run away symbol which is gonna die
						 if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("U")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow-1,myProblemSymbolColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow-1)+" GoColumn:"+(myProblemSymbolColumn));
							 if(gameBoard[myProblemSymbolRow-1][myProblemSymbolColumn].equals("^")) {
								 usedGoRow=myProblemSymbolRow-1;
								 usedGoColumn=myProblemSymbolColumn;
							 }
							 getGameBoard();
						 }
						 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("D")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow+1,myProblemSymbolColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow+1)+" GoColumn:"+(myProblemSymbolColumn));
							 if(gameBoard[myProblemSymbolRow+1][myProblemSymbolColumn].equals("^")) {
								 usedGoRow=myProblemSymbolRow+1;
								 usedGoColumn=myProblemSymbolColumn;
							 }
							 getGameBoard();
						 }
						 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("R")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn+1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow)+" GoColumn:"+(myProblemSymbolColumn+1));
							 if(gameBoard[myProblemSymbolRow][myProblemSymbolColumn+1].equals("^")) {
								 usedGoRow=myProblemSymbolRow;
								 usedGoColumn=myProblemSymbolColumn+1;
							 }
							 getGameBoard();
						 }
						 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("L")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn-1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow)+" GoColumn:"+(myProblemSymbolColumn-1));
							 if(gameBoard[myProblemSymbolRow][myProblemSymbolColumn-1].equals("^")) {
								 usedGoRow=myProblemSymbolRow;
								 usedGoColumn=myProblemSymbolColumn-1;
							 }
							 getGameBoard();
						 }
					 }
					 else if(diff>=runAwayMovementProfit) {//ai go for best way
						 if(realMaxProfitSymbolWay.equals("U")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow-1,maxProfitFromColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow-1)+" GoColumn:"+(maxProfitFromColumn));
							 if(gameBoard[maxProfitFromRow-1][maxProfitFromColumn].equals("^")) {
								 usedGoRow=maxProfitFromRow-1;
								 usedGoColumn=maxProfitFromColumn;
							 }
							 getGameBoard();
						 }
						 else if(realMaxProfitSymbolWay.equals("D")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow+1,maxProfitFromColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow+1)+" GoColumn:"+(maxProfitFromColumn));
							 if(gameBoard[maxProfitFromRow+1][maxProfitFromColumn].equals("^")) {
								 usedGoRow=maxProfitFromRow+1;
								 usedGoColumn=maxProfitFromColumn;
							 }
							 getGameBoard();
						 }
						 else if(realMaxProfitSymbolWay.equals("R")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn+1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn+1));
							 if(gameBoard[maxProfitFromRow][maxProfitFromColumn+1].equals("^")) {
								 usedGoRow=maxProfitFromRow;
								 usedGoColumn=maxProfitFromColumn+1;
							 }
							 getGameBoard();
						 }
						 else if(realMaxProfitSymbolWay.equals("L")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn-1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn-1));
							 if(gameBoard[maxProfitFromRow][maxProfitFromColumn-1].equals("^")) {
								 usedGoRow=maxProfitFromRow;
								 usedGoColumn=maxProfitFromColumn-1;
							 }
							 getGameBoard();
						 }
					 }
					 
				 }
				 
			 }
			 
			 //other conditions contains same algorithm..
			 
		 }
		 else if(aiTriangles==1&& isGameFinished==false && isGameReallyFinished==false) {
			 System.out.println("AI PLAYED;");
			 profitForAI=0;
				int[] aiSymbolsFromRows = new int[4];int[] aiSymbolsFromColumns = new int[4];int aiSymbolsIndx=0;
				int[] userSymbolsFromRows = new int[4];int[] userSymbolsFromColumns = new int[4];int userSymbolsIndx=0;
				
				String[] aiSelectionWayForSymbol= new String[4];int aiSelectionWayIndx=0;
				int[] aiMaxProfitForSymbol=new int[4];
				
				String[] userSelectionWayForSymbol= new String[4];int userSelectionWayIndx=0;
				int[] userMaxProfitForSymbol=new int[4];
			 
			 for(int i=0;i<7;i++) {
				 for(int j=0;j<7;j++) {
					 if(gameBoard[i][j].equals("^")) {
						 aiSymbolsFromRows[aiSymbolsIndx]=i;
						 aiSymbolsFromColumns[aiSymbolsIndx]=j;
						 aiSymbolsIndx++;
					 }
					 if(gameBoard[i][j].equals("O")) {
						 userSymbolsFromRows[userSymbolsIndx]=i;
						 userSymbolsFromColumns[userSymbolsIndx]=j;
						 userSymbolsIndx++;
					 }
				 }
			 }
			 for(int i=0;i<aiSymbolsIndx;i++) {
				 int profitForLeft=0;int profitForRight=0;int profitForUp=0;int profitForDown=0;int maxProfit=-1000;
				 boolean canGoLeft=false;boolean canGoRight=false;boolean canGoUp=false;boolean canGoDown=false;
				 if(aiSymbolsFromColumns[i]-1>=0 && gameBoard[aiSymbolsFromRows[i]][aiSymbolsFromColumns[i]-1].equals("_")) {
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i],aiSymbolsFromColumns[i]-1,"ai",true);
					 canGoLeft=true;
					 profitForLeft=profitForAI;profitForAI=0;
				 }
				 if(aiSymbolsFromColumns[i]+1<7 && gameBoard[aiSymbolsFromRows[i]][aiSymbolsFromColumns[i]+1].equals("_")) {
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i],aiSymbolsFromColumns[i]+1,"ai",true);
					 canGoRight=true;
					 profitForRight=profitForAI;profitForAI=0;
				 }
				 if(aiSymbolsFromRows[i]-1>=0 && gameBoard[aiSymbolsFromRows[i]-1][aiSymbolsFromColumns[i]].equals("_")) {
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i]-1,aiSymbolsFromColumns[i],"ai",true);
					 canGoUp=true;
					 profitForUp=profitForAI;profitForAI=0;
				 }
				 if(aiSymbolsFromRows[i]+1<7 && gameBoard[aiSymbolsFromRows[i]+1][aiSymbolsFromColumns[i]].equals("_")) {
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i]+1,aiSymbolsFromColumns[i],"ai",true);
					 canGoDown=true;
					 profitForDown=profitForAI;profitForAI=0;
				 }
				 ////
				 
				 if(profitForLeft>maxProfit) {//
					 maxProfit=profitForLeft;
				 }
				 if(profitForRight>maxProfit) {
					 maxProfit=profitForRight;
				 }
				 if(profitForUp>maxProfit) {
					 maxProfit=profitForUp;
				 }
				 if(profitForDown>maxProfit) {
					 maxProfit=profitForDown;
				 }
				 ///
				 
				 String maxWayss="";
				 if(maxProfit==profitForLeft&&canGoLeft) {maxWayss+="L";}
				 if(maxProfit==profitForRight&&canGoRight) {maxWayss+="R";}
				 if(maxProfit==profitForUp&&canGoUp) {maxWayss+="U";}
				 if(maxProfit==profitForDown&&canGoDown) {maxWayss+="D";}
				 ///
				
				 //System.out.println(maxWayss+maxWayss.length());
				 //getGameBoard();
				 
				 if(maxWayss.length()>1) {
					 if(aiSymbolsFromRows[i]==0) {
						 if(maxWayss.contains("D")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="D";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else if(aiSymbolsFromRows[i]==6) {
						 if(maxWayss.contains("U")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="U";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else if(aiSymbolsFromColumns[i]==0) {
						 if(maxWayss.contains("R")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="R";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else if(aiSymbolsFromColumns[i]==6) {
						 if(maxWayss.contains("L")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="L";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else {
						 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
						 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
						 aiSelectionWayIndx++;
					 }
				 }
				 else {
					 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss;
					 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
					 aiSelectionWayIndx++;
				 }
				 ///
				 
				 
				 
			 }
			 ////
			 for(int i=0;i<userSymbolsIndx;i++) {
				 
				 int profitForLeftUser=0;int profitForRightUser=0;int profitForUpUser=0;int profitForDownUser=0;int maxProfitUser=-1000;
				 
				 boolean canGoLeftUser=false;boolean canGoRightUser=false;boolean canGoUpUser=false;boolean canGoDownUser=false;
				 
				 ////
				 if(userSymbolsFromColumns[i]-1>=0 && gameBoard[userSymbolsFromRows[i]][userSymbolsFromColumns[i]-1].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i],userSymbolsFromColumns[i]-1,"user",true);
					 canGoLeftUser=true;
					 profitForLeftUser=profitForAI;profitForAI=0;
				 }
				 if(userSymbolsFromColumns[i]+1<7 && gameBoard[userSymbolsFromRows[i]][userSymbolsFromColumns[i]+1].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i],userSymbolsFromColumns[i]+1,"user",true);
					 canGoRightUser=true;
					 profitForRightUser=profitForAI;profitForAI=0;
				 }
				 if(userSymbolsFromRows[i]-1>=0 && gameBoard[userSymbolsFromRows[i]-1][userSymbolsFromColumns[i]].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i]-1,userSymbolsFromColumns[i],"user",true);
					 canGoUpUser=true;
					 profitForUpUser=profitForAI;profitForAI=0;
				 }
				 if(userSymbolsFromRows[i]+1<7 && gameBoard[userSymbolsFromRows[i]+1][userSymbolsFromColumns[i]].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i]+1,userSymbolsFromColumns[i],"user",true);
					 canGoDownUser=true;
					 profitForDownUser=profitForAI;profitForAI=0;
				 }
				 
				 ///
				 if(profitForLeftUser>maxProfitUser) {
					 maxProfitUser=profitForLeftUser;
				 }
				 if(profitForRightUser>maxProfitUser) {
					 maxProfitUser=profitForRightUser;
				 }
				 if(profitForUpUser>maxProfitUser) {
					 maxProfitUser=profitForUpUser;
				 }
				 if(profitForDownUser>maxProfitUser) {
					 maxProfitUser=profitForDownUser;
				 }
				 
				 ///
				 String maxWayssUser="";
				 if(maxProfitUser==profitForLeftUser&&canGoLeftUser) {maxWayssUser+="L";}
				 if(maxProfitUser==profitForRightUser&&canGoRightUser) {maxWayssUser+="R";}
				 if(maxProfitUser==profitForUpUser&&canGoUpUser) {maxWayssUser+="U";}
				 if(maxProfitUser==profitForDownUser&&canGoDownUser) {maxWayssUser+="D";}
				 //System.out.println(maxWayss+maxWayss.length());
				 //getGameBoard();
				 
				 
				 ///
				 if(maxWayssUser.length()>1) {
					 if(userSymbolsFromRows[i]==0) {
						 if(maxWayssUser.contains("D")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="D";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else if(userSymbolsFromRows[i]==6) {
						 if(maxWayssUser.contains("U")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="U";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else if(userSymbolsFromColumns[i]==0) {
						 if(maxWayssUser.contains("R")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="R";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else if(userSymbolsFromColumns[i]==6) {
						 if(maxWayssUser.contains("L")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="L";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else {
						 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
						 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
						 userSelectionWayIndx++;
					 }
				 }
				 else {
					 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser;
					 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
					 userSelectionWayIndx++;
				 }
				 
				 
			 }
			 
			 
			 int realMaxProfit=-1000;String realMaxProfitSymbolWay="";
			 int maxProfitFromRow=-1;int maxProfitFromColumn=-1;
			 for(int i=0;i<aiSelectionWayIndx;i++) {
				 //System.out.println(aiSelectionWayForSymbol[i]+" Akýllýca yol");
				 String way=aiSelectionWayForSymbol[i];
				 int maxprofit=aiMaxProfitForSymbol[i];
				 if(maxprofit>realMaxProfit) {
					 realMaxProfit=maxprofit;
					 maxProfitFromRow=aiSymbolsFromRows[i];
					 maxProfitFromColumn=aiSymbolsFromColumns[i];
					 realMaxProfitSymbolWay=way;
				 }
			 }
			 ///
			 int realMaxProfitUser=-1000;String realMaxProfitSymbolWayUser="";
			 int maxProfitFromRowUser=-1;int maxProfitFromColumnUser=-1;
			 for(int i=0;i<userSelectionWayIndx;i++) {
				 //System.out.println(aiSelectionWayForSymbol[i]+" Akýllýca yol");
				 String way=userSelectionWayForSymbol[i];
				 int maxprofit=userMaxProfitForSymbol[i];
				 if(maxprofit>realMaxProfitUser) {
					 realMaxProfitUser=maxprofit;
					 maxProfitFromRowUser=userSymbolsFromRows[i];
					 maxProfitFromColumnUser=userSymbolsFromColumns[i];
					 realMaxProfitSymbolWayUser=way;
				 }
			 }
			 //System.out.println(realMaxProfit+" realmaxprft "+maxProfitFromRow+" fr "+maxProfitFromColumn+" fc " +realMaxProfitSymbolWay+"bestWay");
			 //System.out.println(realMaxProfitUser+" realmaxprftusr "+maxProfitFromRowUser+" frUsr "+maxProfitFromColumnUser+" fcUsr " +realMaxProfitSymbolWayUser+"bestWayUsr");
			 
			 if(realMaxProfit>=realMaxProfitUser) {
				 if(realMaxProfitSymbolWay.equals("U")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow-1,maxProfitFromColumn,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow-1)+" GoColumn:"+(maxProfitFromColumn));
					 getGameBoard();
				 }
				 else if(realMaxProfitSymbolWay.equals("D")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow+1,maxProfitFromColumn,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow+1)+" GoColumn:"+(maxProfitFromColumn));
					 getGameBoard();
				 }
				 else if(realMaxProfitSymbolWay.equals("R")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn+1,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn+1));
					 getGameBoard();
				 }
				 else if(realMaxProfitSymbolWay.equals("L")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn-1,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn-1));
					 getGameBoard();
				 }
				 
				 
			 }
			 else if(realMaxProfit<realMaxProfitUser) {
				 int myProblemSymbolRow=-1;
				 int myProblemSymbolColumn=-1;
				 if(realMaxProfitSymbolWayUser.equals("U")) {
					 myProblemSymbolRow=maxProfitFromRowUser-1;
					 myProblemSymbolColumn=maxProfitFromColumnUser;
				 }
				 else if(realMaxProfitSymbolWayUser.equals("D")) {
					 myProblemSymbolRow=maxProfitFromRowUser+1;
					 myProblemSymbolColumn=maxProfitFromColumnUser;
				 }
				 else if(realMaxProfitSymbolWayUser.equals("R")) {
					 myProblemSymbolRow=maxProfitFromRowUser;
					 myProblemSymbolColumn=maxProfitFromColumnUser+1;
				 }
				 else if(realMaxProfitSymbolWayUser.equals("L")) {
					 myProblemSymbolRow=maxProfitFromRowUser;
					 myProblemSymbolColumn=maxProfitFromColumnUser-1;
				 }
				 
				 int ýndx=-1;
				 if(myProblemSymbolRow!=-1 && myProblemSymbolColumn!=-1) {
					 for(int i=0;i<4;i++) {
						 if(aiSymbolsFromRows[i]==myProblemSymbolRow && aiSymbolsFromColumns[i]==myProblemSymbolColumn) {
							 ýndx=i;break;
						 }
					 }
					 //System.out.println(aiSelectionWayForSymbol[ýndx]+"caner"); en iyi yol o karakter için
					 int runAwayMovementProfit=-1000;
					 if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("U")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow-1,myProblemSymbolColumn,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("D")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow+1,myProblemSymbolColumn,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("R")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn+1,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("L")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn-1,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 
					 //aimaxProfit-usermaxProfit
					 int diff=realMaxProfit-realMaxProfitUser;
					 if(diff<runAwayMovementProfit) {
						 if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("U")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow-1,myProblemSymbolColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow-1)+" GoColumn:"+(myProblemSymbolColumn));
							 getGameBoard();
						 }
						 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("D")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow+1,myProblemSymbolColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow+1)+" GoColumn:"+(myProblemSymbolColumn));
							 getGameBoard();
						 }
						 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("R")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn+1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow)+" GoColumn:"+(myProblemSymbolColumn+1));
							 getGameBoard();
						 }
						 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("L")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn-1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow)+" GoColumn:"+(myProblemSymbolColumn-1));
							 getGameBoard();
						 }
					 }
					 else if(diff>=runAwayMovementProfit) {
						 if(realMaxProfitSymbolWay.equals("U")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow-1,maxProfitFromColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow-1)+" GoColumn:"+(maxProfitFromColumn));
							 getGameBoard();
						 }
						 else if(realMaxProfitSymbolWay.equals("D")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow+1,maxProfitFromColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow+1)+" GoColumn:"+(maxProfitFromColumn));
							 getGameBoard();
						 }
						 else if(realMaxProfitSymbolWay.equals("R")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn+1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn+1));
							 getGameBoard();
						 }
						 else if(realMaxProfitSymbolWay.equals("L")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn-1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn-1));
							 getGameBoard();
						 }
					 }
					 
				 }
				 
			 }
		 }
		 
		 if(isGreaterThan1&& isGameFinished==false && isGameReallyFinished==false) {
			 System.out.println("AI PLAYED;");
			 profitForAI=0;
				int[] aiSymbolsFromRows = new int[4];int[] aiSymbolsFromColumns = new int[4];int aiSymbolsIndx=0;
				int[] userSymbolsFromRows = new int[4];int[] userSymbolsFromColumns = new int[4];int userSymbolsIndx=0;
				
				String[] aiSelectionWayForSymbol= new String[4];int aiSelectionWayIndx=0;
				int[] aiMaxProfitForSymbol=new int[4];
				
				String[] userSelectionWayForSymbol= new String[4];int userSelectionWayIndx=0;
				int[] userMaxProfitForSymbol=new int[4];
			 
			 for(int i=0;i<7;i++) {
				 for(int j=0;j<7;j++) {
					 if(i!=usedGoRow && j!=usedGoColumn) {
						 if(gameBoard[i][j].equals("^")) {
							 aiSymbolsFromRows[aiSymbolsIndx]=i;
							 aiSymbolsFromColumns[aiSymbolsIndx]=j;
							 aiSymbolsIndx++;
						 }
					 }
					 
					 if(gameBoard[i][j].equals("O")) {
						 userSymbolsFromRows[userSymbolsIndx]=i;
						 userSymbolsFromColumns[userSymbolsIndx]=j;
						 userSymbolsIndx++;
					 }
				 }
			 }
			 for(int i=0;i<aiSymbolsIndx;i++) {
				 int profitForLeft=0;int profitForRight=0;int profitForUp=0;int profitForDown=0;int maxProfit=-1000;
				 boolean canGoLeft=false;boolean canGoRight=false;boolean canGoUp=false;boolean canGoDown=false;
				 if(aiSymbolsFromColumns[i]-1>=0 && gameBoard[aiSymbolsFromRows[i]][aiSymbolsFromColumns[i]-1].equals("_")) {
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i],aiSymbolsFromColumns[i]-1,"ai",true);
					 canGoLeft=true;
					 profitForLeft=profitForAI;profitForAI=0;
				 }
				 if(aiSymbolsFromColumns[i]+1<7 && gameBoard[aiSymbolsFromRows[i]][aiSymbolsFromColumns[i]+1].equals("_")) {
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i],aiSymbolsFromColumns[i]+1,"ai",true);
					 canGoRight=true;
					 profitForRight=profitForAI;profitForAI=0;
				 }
				 if(aiSymbolsFromRows[i]-1>=0 && gameBoard[aiSymbolsFromRows[i]-1][aiSymbolsFromColumns[i]].equals("_")) {
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i]-1,aiSymbolsFromColumns[i],"ai",true);
					 canGoUp=true;
					 profitForUp=profitForAI;profitForAI=0;
				 }
				 if(aiSymbolsFromRows[i]+1<7 && gameBoard[aiSymbolsFromRows[i]+1][aiSymbolsFromColumns[i]].equals("_")) {
					 setGameBoard(aiSymbolsFromRows[i],aiSymbolsFromColumns[i],aiSymbolsFromRows[i]+1,aiSymbolsFromColumns[i],"ai",true);
					 canGoDown=true;
					 profitForDown=profitForAI;profitForAI=0;
				 }
				 ////
				 
				 if(profitForLeft>maxProfit) {
					 maxProfit=profitForLeft;
				 }
				 if(profitForRight>maxProfit) {
					 maxProfit=profitForRight;
				 }
				 if(profitForUp>maxProfit) {
					 maxProfit=profitForUp;
				 }
				 if(profitForDown>maxProfit) {
					 maxProfit=profitForDown;
				 }
				 ///
				 
				 String maxWayss="";
				 if(maxProfit==profitForLeft&&canGoLeft) {maxWayss+="L";}
				 if(maxProfit==profitForRight&&canGoRight) {maxWayss+="R";}
				 if(maxProfit==profitForUp&&canGoUp) {maxWayss+="U";}
				 if(maxProfit==profitForDown&&canGoDown) {maxWayss+="D";}
				 ///
				
				 //System.out.println(maxWayss+maxWayss.length());
				 //getGameBoard();
				 
				 if(maxWayss.length()>1) {
					 if(aiSymbolsFromRows[i]==0) {
						 if(maxWayss.contains("D")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="D";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else if(aiSymbolsFromRows[i]==6) {
						 if(maxWayss.contains("U")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="U";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else if(aiSymbolsFromColumns[i]==0) {
						 if(maxWayss.contains("R")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="R";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else if(aiSymbolsFromColumns[i]==6) {
						 if(maxWayss.contains("L")) {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]="L";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
						 else {
							 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
							 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
							 aiSelectionWayIndx++;
						 }
					 }
					 else {
						 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss.charAt(0)+"";
						 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
						 aiSelectionWayIndx++;
					 }
				 }
				 else {
					 aiSelectionWayForSymbol[aiSelectionWayIndx]=maxWayss;
					 aiMaxProfitForSymbol[aiSelectionWayIndx]=maxProfit;
					 aiSelectionWayIndx++;
				 }
				 ///
				 
				 
				 
			 }
			 ////
			 for(int i=0;i<userSymbolsIndx;i++) {
				 
				 int profitForLeftUser=0;int profitForRightUser=0;int profitForUpUser=0;int profitForDownUser=0;int maxProfitUser=-1000;
				 
				 boolean canGoLeftUser=false;boolean canGoRightUser=false;boolean canGoUpUser=false;boolean canGoDownUser=false;
				 
				 ////
				 if(userSymbolsFromColumns[i]-1>=0 && gameBoard[userSymbolsFromRows[i]][userSymbolsFromColumns[i]-1].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i],userSymbolsFromColumns[i]-1,"user",true);
					 canGoLeftUser=true;
					 profitForLeftUser=profitForAI;profitForAI=0;
				 }
				 if(userSymbolsFromColumns[i]+1<7 && gameBoard[userSymbolsFromRows[i]][userSymbolsFromColumns[i]+1].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i],userSymbolsFromColumns[i]+1,"user",true);
					 canGoRightUser=true;
					 profitForRightUser=profitForAI;profitForAI=0;
				 }
				 if(userSymbolsFromRows[i]-1>=0 && gameBoard[userSymbolsFromRows[i]-1][userSymbolsFromColumns[i]].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i]-1,userSymbolsFromColumns[i],"user",true);
					 canGoUpUser=true;
					 profitForUpUser=profitForAI;profitForAI=0;
				 }
				 if(userSymbolsFromRows[i]+1<7 && gameBoard[userSymbolsFromRows[i]+1][userSymbolsFromColumns[i]].equals("_")) {
					 setGameBoard(userSymbolsFromRows[i],userSymbolsFromColumns[i],userSymbolsFromRows[i]+1,userSymbolsFromColumns[i],"user",true);
					 canGoDownUser=true;
					 profitForDownUser=profitForAI;profitForAI=0;
				 }
				 
				 ///
				 if(profitForLeftUser>maxProfitUser) {
					 maxProfitUser=profitForLeftUser;
				 }
				 if(profitForRightUser>maxProfitUser) {
					 maxProfitUser=profitForRightUser;
				 }
				 if(profitForUpUser>maxProfitUser) {
					 maxProfitUser=profitForUpUser;
				 }
				 if(profitForDownUser>maxProfitUser) {
					 maxProfitUser=profitForDownUser;
				 }
				 
				 ///
				 String maxWayssUser="";
				 if(maxProfitUser==profitForLeftUser&&canGoLeftUser) {maxWayssUser+="L";}
				 if(maxProfitUser==profitForRightUser&&canGoRightUser) {maxWayssUser+="R";}
				 if(maxProfitUser==profitForUpUser&&canGoUpUser) {maxWayssUser+="U";}
				 if(maxProfitUser==profitForDownUser&&canGoDownUser) {maxWayssUser+="D";}
				 //System.out.println(maxWayss+maxWayss.length());
				 //getGameBoard();
				 
				 
				 ///
				 if(maxWayssUser.length()>1) {
					 if(userSymbolsFromRows[i]==0) {
						 if(maxWayssUser.contains("D")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="D";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else if(userSymbolsFromRows[i]==6) {
						 if(maxWayssUser.contains("U")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="U";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else if(userSymbolsFromColumns[i]==0) {
						 if(maxWayssUser.contains("R")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="R";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else if(userSymbolsFromColumns[i]==6) {
						 if(maxWayssUser.contains("L")) {
							 userSelectionWayForSymbol[userSelectionWayIndx]="L";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
						 else {
							 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
							 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
							 userSelectionWayIndx++;
						 }
					 }
					 else {
						 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser.charAt(0)+"";
						 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
						 userSelectionWayIndx++;
					 }
				 }
				 else {
					 userSelectionWayForSymbol[userSelectionWayIndx]=maxWayssUser;
					 userMaxProfitForSymbol[userSelectionWayIndx]=maxProfitUser;
					 userSelectionWayIndx++;
				 }
				 
				 
			 }
			 
			 ////
			 
			 int realMaxProfit=-1000;String realMaxProfitSymbolWay="";
			 int maxProfitFromRow=-1;int maxProfitFromColumn=-1;
			 for(int i=0;i<aiSelectionWayIndx;i++) {
				 //System.out.println(aiSelectionWayForSymbol[i]+" Akýllýca yol");
				 String way=aiSelectionWayForSymbol[i];
				 int maxprofit=aiMaxProfitForSymbol[i];
				 if(maxprofit>realMaxProfit) {
					 realMaxProfit=maxprofit;
					 maxProfitFromRow=aiSymbolsFromRows[i];
					 maxProfitFromColumn=aiSymbolsFromColumns[i];
					 realMaxProfitSymbolWay=way;
				 }
			 }
			 ///
			 int realMaxProfitUser=-1000;String realMaxProfitSymbolWayUser="";
			 int maxProfitFromRowUser=-1;int maxProfitFromColumnUser=-1;
			 for(int i=0;i<userSelectionWayIndx;i++) {
				 //System.out.println(aiSelectionWayForSymbol[i]+" Akýllýca yol");
				 String way=userSelectionWayForSymbol[i];
				 int maxprofit=userMaxProfitForSymbol[i];
				 if(maxprofit>realMaxProfitUser) {
					 realMaxProfitUser=maxprofit;
					 maxProfitFromRowUser=userSymbolsFromRows[i];
					 maxProfitFromColumnUser=userSymbolsFromColumns[i];
					 realMaxProfitSymbolWayUser=way;
				 }
			 }
			 //System.out.println(realMaxProfit+" realmaxprft "+maxProfitFromRow+" fr "+maxProfitFromColumn+" fc " +realMaxProfitSymbolWay+"bestWay");
			 //System.out.println(realMaxProfitUser+" realmaxprftusr "+maxProfitFromRowUser+" frUsr "+maxProfitFromColumnUser+" fcUsr " +realMaxProfitSymbolWayUser+"bestWayUsr");
			 
			 if(realMaxProfit>=realMaxProfitUser) {// 
				 if(realMaxProfitSymbolWay.equals("U")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow-1,maxProfitFromColumn,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow-1)+" GoColumn:"+(maxProfitFromColumn));
					 getGameBoard();
				 }
				 else if(realMaxProfitSymbolWay.equals("D")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow+1,maxProfitFromColumn,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow+1)+" GoColumn:"+(maxProfitFromColumn));
					 getGameBoard();
				 }
				 else if(realMaxProfitSymbolWay.equals("R")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn+1,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn+1));
					 getGameBoard();
				 }
				 else if(realMaxProfitSymbolWay.equals("L")) {
					 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn-1,"ai",false);
					 counterForMoves++;
					 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn-1));
					 getGameBoard();
				 }
				 
				 
			 }
			 else if(realMaxProfit<realMaxProfitUser) {
				 int myProblemSymbolRow=-1;
				 int myProblemSymbolColumn=-1;
				 if(realMaxProfitSymbolWayUser.equals("U")) {
					 myProblemSymbolRow=maxProfitFromRowUser-1;
					 myProblemSymbolColumn=maxProfitFromColumnUser;
				 }
				 else if(realMaxProfitSymbolWayUser.equals("D")) {
					 myProblemSymbolRow=maxProfitFromRowUser+1;
					 myProblemSymbolColumn=maxProfitFromColumnUser;
				 }
				 else if(realMaxProfitSymbolWayUser.equals("R")) {
					 myProblemSymbolRow=maxProfitFromRowUser;
					 myProblemSymbolColumn=maxProfitFromColumnUser+1;
				 }
				 else if(realMaxProfitSymbolWayUser.equals("L")) {
					 myProblemSymbolRow=maxProfitFromRowUser;
					 myProblemSymbolColumn=maxProfitFromColumnUser-1;
				 }
				 
				 int ýndx=-1;
				 if(myProblemSymbolRow!=-1 && myProblemSymbolColumn!=-1) {
					 for(int i=0;i<4;i++) {
						 if(aiSymbolsFromRows[i]==myProblemSymbolRow && aiSymbolsFromColumns[i]==myProblemSymbolColumn) {
							 ýndx=i;break;
						 }
					 }
					 //System.out.println(aiSelectionWayForSymbol[ýndx]+"caner"); en iyi yol o karakter için
					 int runAwayMovementProfit=-1000;
					 if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("U")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow-1,myProblemSymbolColumn,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("D")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow+1,myProblemSymbolColumn,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("R")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn+1,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("L")) {
						 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn-1,"ai",true);
						 runAwayMovementProfit=profitForAI;profitForAI=0;
					 }
					 
					 //aimaxProfit-usermaxProfit
					 int diff=realMaxProfit-realMaxProfitUser;
					 if(diff<runAwayMovementProfit) {
						 if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("U")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow-1,myProblemSymbolColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow-1)+" GoColumn:"+(myProblemSymbolColumn));
							 getGameBoard();
						 }
						 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("D")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow+1,myProblemSymbolColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow+1)+" GoColumn:"+(myProblemSymbolColumn));
							 getGameBoard();
						 }
						 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("R")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn+1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow)+" GoColumn:"+(myProblemSymbolColumn+1));
							 getGameBoard();
						 }
						 else if(ýndx!=-1&&aiSelectionWayForSymbol[ýndx].equals("L")) {
							 setGameBoard(myProblemSymbolRow,myProblemSymbolColumn,myProblemSymbolRow,myProblemSymbolColumn-1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+myProblemSymbolRow+" FromColumn:"+myProblemSymbolColumn+" GoRow:"+(myProblemSymbolRow)+" GoColumn:"+(myProblemSymbolColumn-1));
							 getGameBoard();
						 }
					 }
					 else if(diff>=runAwayMovementProfit) {
						 if(realMaxProfitSymbolWay.equals("U")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow-1,maxProfitFromColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow-1)+" GoColumn:"+(maxProfitFromColumn));
							 getGameBoard();
						 }
						 else if(realMaxProfitSymbolWay.equals("D")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow+1,maxProfitFromColumn,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow+1)+" GoColumn:"+(maxProfitFromColumn));
							 getGameBoard();
						 }
						 else if(realMaxProfitSymbolWay.equals("R")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn+1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn+1));
							 getGameBoard();
						 }
						 else if(realMaxProfitSymbolWay.equals("L")) {
							 setGameBoard(maxProfitFromRow,maxProfitFromColumn,maxProfitFromRow,maxProfitFromColumn-1,"ai",false);
							 counterForMoves++;
							 System.out.println("FromRow:"+maxProfitFromRow+" FromColumn:"+maxProfitFromColumn+" GoRow:"+(maxProfitFromRow)+" GoColumn:"+(maxProfitFromColumn-1));
							 getGameBoard();
						 }
					 }
					 
				 }
				 
			 }
		 }
		
		
		
	}
	
	
}
