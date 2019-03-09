#include <stdlib.h>
#include <stdio.h>
#include "tokenizer.h"

typedef struct s_Item {
	int id;
	char * str;
	struct s_Item* next;
}Item;

typedef struct s_List{
	struct s_Item* root;
}List;

//initializing the List
List* init_history(){
	List* list = (List*) malloc(sizeof(List));
	list -> root = NULL;
	return list;
}

//adding the history to the list
void add_history(List* list, char* str){
	Item * new_node = (Item*) malloc(sizeof(Item));
	if(list->root == NULL)new_node->id = 0;
	else new_node->id = ((list->root->id)+1);
	new_node->str = str;
	new_node->next = list->root;
	list->root = new_node;
}

//Searching for the history
char * get_history(List* list, int id){
	for(Item* i = list->root; i != NULL; i = i->next)
		if(i->id == id)
			return i->str;
	return "\nError\n";
}

//printing the history
void print_history(List* list){
	for(Item* i = list->root; i != NULL; i = i -> next)
		printf("%d)%s\n", i->id, i->str);
}

//freeing the history
void free_history(List* list){
	for(Item* i = list->root; i != NULL; i = i -> next)
		free(i);
	free(list);
}

int main(){
	List* l = init_history();
	add_history(l, "Eddie");
	print_history(l);
	return 1;
}
