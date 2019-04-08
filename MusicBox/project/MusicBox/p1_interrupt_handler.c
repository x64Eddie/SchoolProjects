#include <msp430.h>
#include "switches.h"
#include "stateMachine.h"
#include "led.h"
/* Switch on P1 (S2) */
void
__interrupt_vec(PORT2_VECTOR) Port_1(){
  if (P2IFG & SWITCHES) {	      /* did a button cause this interrupt? */
    P2IFG &= ~SWITCHES;		      /* clear pending sw interrupts */
    switch_interrupt_handler();	/* single handler for all switches */
  }
}

void
__interrupt_vec(WDT_VECTOR) WDT(){
	static char blink_count = 0;
	if(++blink_count == 125){
		sm_fast_clock();
		blink_count = 0;
	}
	sm_fast_clock();
	sm_update_led();
	//updateState(2);

	led_update();
}

