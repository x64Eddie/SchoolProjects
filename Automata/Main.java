public class Main {
    public static void main(String[]args){
        int states[][] = {
            {0, 0},
            {1, 1}
        };
        boolean [] finals = {false, true};
        automata(2, 2, states, finals);
    }

    public static void automata(int numStates, int numSym, int states[][], boolean[] finals){
        int[] sequence = {1, 1, 1, 0};
        int currentState = 0;
        for(int i = 0; i < sequence.length; i ++){
            if( sequence[i] >= numSym || sequence[i] < 0){
                System.out.println("Invalid symbol");
            }else{
                System.out.println("S"+currentState+" ("+sequence[i]+")---> S"+states[sequence[i]][currentState]);
                currentState = states[sequence[i]][currentState];
            }
        }
    }
}