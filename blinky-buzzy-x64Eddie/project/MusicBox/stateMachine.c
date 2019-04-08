#include "switches.h"
#include "../libTimer.h"
#include "buzzer.h"
#include "led.h"

static enum {off=0, dim=1, bright=2}ledMode;
static char pwmCount = 0;
extern void turn_green_on(void);

void sm_slow_clock(){
	ledMode = (ledMode + 1) % 3;
}

void sm_fast_clock(){
	pwmCount = (pwmCount + 1) & 3;
}

void sm_update_led(){
	char new_red_on;
	switch(ledMode){
	case off:
		new_red_on = 0;
		green_on = 0;
		break;
	case bright:
		new_red_on = 1;
		break;
	case dim:
		new_red_on = (pwmCount < 1);
		break;
	}
	if(red_on != new_red_on){
		red_on = new_red_on;
		led_changed = 1;
	}
}

void switchOneEvent(){
	buzzer_set_period(6067);
	ledMode = 0;
	sm_update_led();
}

void switchTwoEvent(){
	buzzer_set_period(5726);
	ledMode = 1;
	sm_update_led();
}

void switchThreeEvent(){
	buzzer_set_period(5102);
	ledMode = 2;
	sm_update_led();
}

void switchFourEvent(){
	buzzer_set_period(4545);
	green_on = 1;
	sm_update_led();
}

void updateState(char state){
	//here we are going to update the switch
	switch(state){
	case 1: switchOneEvent();break;
	case 2: switchTwoEvent();break;
	case 3: switchThreeEvent();break;
	case 4: switchFourEvent();break;
	}
}

