
#I will assume that all the states are going to be represeted as integers
def finiteAutomata(numStates, numSym, state, final):
    print("All states")

    for sym in range(numSym):
        for st in range(numStates):
            printState(st, state[sym][st], sym, final)
    
    #I am checking if the following sequence is accepted
    sequence = [1, 0, 1, 1, 1, 0]
    currSt = 0
    print(60*"_")
    print(f'Checking following sequence: {sequence}')
    for num in sequence:
        if num >= numSym or num < 0:
            print("Invalid symbol: %d"%num)
        else:
            printState(currSt, state[num][currSt], num, final)
            currSt = state[num][currSt]
    print("Final State: S%d"%currSt)

#Just for formating the print of the states and the symbol
def printState(s0, s1, sym, final):
    print('%s --%d--> %s'%
    (('(S%s)'% s0 if final[s0] else 'S'+str(s0)),sym,
    ('(S%s)'% s1 if final[s1] else 'S'+str(s1))))
    pass   


#Example of detecting 1(On) and 0(Off)
states = [
[0, 0],#if you get 0 in state 0, you remain in zero and vice versa
[1, 1] #if you are in state 1 and get 1, you remain in 1 and vice versa
]
finals = [False, True]
finiteAutomata(2, 2, states, finals)