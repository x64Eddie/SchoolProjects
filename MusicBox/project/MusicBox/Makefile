#
#akfile configuration
COMMON_OBJECTS  = 
CPU             = msp430g2553
CFLAGS          = -mmcu=${CPU} -I../h -L/opt/ti/msp430_gcc/include
SFLAGS		= -D_GNU_ASSEMBLER_ -x assembler-with-cpp

#switch the compiler (for the internal make rules)
CC              = msp430-elf-gcc
AS              = msp430-elf-as

all:	buzzer.elf  

#additional rules for files
buzzer.elf: ${COMMON_OBJECTS} switches.o buzzer.o main.o led.o stateMachine.o p1_interrupt_handler.o ../lib/libTimer.a
	${CC} ${CFLAGS} -o $@ $^

load: buzzer.elf
	mspdebug rf2500 "prog buzzer.elf"

clean:
	rm -f *.o *.elf *~

reset:
	mspdebug rf2500 "erase"

switches.c: switches.h
buzzer.c: buzzer.h
buzzerMain.c: buzzer.h
ledController.o:
	gcc ledController.s -o ledController.o


