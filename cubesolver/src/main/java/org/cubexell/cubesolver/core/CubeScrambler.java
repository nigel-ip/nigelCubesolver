package org.cubexell.cubesolver.core;

import static org.cubexell.cubesolver.core.CubeConstants.POSSIBLE_MOVES;

public class CubeScrambler {
	private Robot robot;
	public CubeScrambler() {
	}

	public CubeScrambler(Robot robot) {
		this.robot = robot;
	}

	protected String randomScrambleMove() {
		//TODO declare an int called randomIndex and assign to it a random value between 0 and 17
		int randomIndex = ;//TODO assign a random value between 0 and 17 using Math.random(), and casting to int with (int)
		return POSSIBLE_MOVES[randomIndex];
	}

	protected char getFace(String move){
		return move.charAt(0);
	}

	public static final Map<Character, Character> scrambleDictionary = new HashMap<>();
		static{
			scrambleDictionary.put('U', 'D');
			scrambleDictionary.put('D', 'U');
			scrambleDictionary.put('R', 'L');
			scrambleDictionary.put('L', 'R');
			scrambleDictionary.put('F', 'B');
			scrambleDictionary.put('B', 'F');
		}
	}

	public String[] getScramble(int numMoves){
		String[] scramble = new String[numMoves];
		scramble[0] = randomScrambleMove();
		String scrambleMove;
		boolean getScrambleRepeat;
		for (int i = 1, i < numMoves, i++){
			getScrambleRepeat = true;
			while (getScrambleRepeat){
				scrambleMove = randomScrambleMove();
				if (getFace(scrambleMove) != getFace(scramble[i - 1]){
					if (i >= 2){
						if ((getFace(scramble[i - 1]) == scrambleDictionary.get(getFace(scrambleMove)))){
							if (getFace(scrambleMove) != getFace(scramble[i - 2])){
								getScrambleRepeat = false;
							}
						} else{
							getScrambleRepeat = false;
						}
					} else if (i == 1){
						getScrambleRepeat = false;
					}
				}
			}
			scramble[i] = scrambleMove;
		}


		/*hint: declare and initialize a String array with length numMoves. Then, generate the first random move
		by calling randomScrambleMove(). Next, use a for loop to go through the rest of the moves, but resetting each
		iteration if the face turned by a turn is the same as the previous turn (check using getFace(String move)).
		Finally, return complete sequence of random moves.

		 */
	}

	public char[][][] scramble(String[] scrambleMoves){
	    Cube cube = new Cube(Helper.createSolvedCubeColors());
		cube.simulateMoves(scrambleMoves);
		if(robot!=null){
			robot.executeMoves(scrambleMoves);
		}
		return cube.getCubeColors();
	}

	public char[][][] randomScramble(){
	    Cube cube = new Cube(Helper.createSolvedCubeColors());
		String[] scrambleMoves = getScramble(20);
	    cube.simulateMoves(scrambleMoves);
		if(robot!=null){
			robot.executeMoves(scrambleMoves);
		}
		return cube.getCubeColors();
	}
	
}
