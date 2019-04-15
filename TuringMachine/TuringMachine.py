#for printing and looking nice
state = {0:'start', 1:'move', 2:'back', 3:'halt', 4:'unaccepted'}
symbol = {0:0, 1:1, 2:'_'}

def initTuringMachine(states, symbols, leftRight):
    print("______________________________")
    print("states:%s\nsymbols%s\nleftRight:%s",states,symbols, leftRight)

def printingState(s0, s1, sym, symbols):
     print('%s --%d--> %s'%
    (('(S%s)'% s0 if symbols[s0] else 'S'+str(s0)),str(symbol[sym]),
    ('(S%s)'% s1 if symbols[s1] else 'S'+str(s1))))


states = [[4, 4, 1],[2, 1, 2],[2, 2, 3], [3, 3, 3]]
symbols = [[2, 2, 2], [1, 0, 1], [0, 1, 2], [2, 2, 2], [3, 3, 3]]
leftRight = [['r', 'r', 'r'], ['l', 'r', 'l'], ['l', 'l', 'l'], ['l', 'l', 'l'], ['l', 'l', 'l']]

    
