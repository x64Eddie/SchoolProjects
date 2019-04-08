	#include "msp430.h"	
	PUBLIC turn_green_on	;Function that we are going to write in assembly
	RSEG CODE		;Code is relocatable, from TIs docs

turn_green_on;
	mov.b #40h, &P1OUT
	END
		
