#for printing and looking nice
state = {0:'start', 1:'move', 2:'back', 3:'halt', 4:'unaccepted'}
symbol = {0:0, 1:1, 2:'_'}

'''
n - Number of states
m - Number of symbols
states - Rules for States
symbols - Rules for Symbols
leftRight - Rules foes left and right direction
tape - input
'''
def initTuringMachine(n, m, states, symbols, leftRight, tape):
    head = 0
    currentState = 0
    newSymbol = 0
    while(currentState < n-2):
        currentSymbol = tape[head]
        newSymbol = symbols[currentState][currentSymbol]
        tape[head] = newSymbol
        if leftRight[currentState][currentSymbol] == 'l':head-=1
        else: head+=1
        print("Current State: %s Current Symbol: %s Direction: %s"% (currentState, currentSymbol, leftRight[currentState][currentSymbol]))

        currentState = states[currentState][currentSymbol]
    print("Tape Final Readings:" ,tape)

states = [[4, 4, 1],[2, 1, 2],[2, 2, 3], [3, 3, 3]]
symbols = [[2, 2, 2], [1, 0, 1], [0, 1, 2], [2, 2, 2], [3, 3, 3]]
leftRight = [['r', 'r', 'r'], ['l', 'r', 'l'], ['l', 'l', 'l'], ['l', 'l', 'l'], ['l', 'l', 'l']]
tape = [2, 1, 1, 0]
n = 5
m = 3
initTuringMachine(n, m, states, symbols, leftRight, tape)
    
