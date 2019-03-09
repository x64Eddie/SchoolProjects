
#include <stdio.h>
#include <stdlib.h>
#define MAX_LENGTH 256

char tString[MAX_LENGTH];
char ** tokens;
typedef enum { false, true } bool;
//going to return the length of the string
int string_length(char* str){
	for(int i = 0; i < MAX_LENGTH; i ++)
		if(str[i] == '\0')return i;
    return 0;
}

//Going to check if the following char is valid
char is_valid_character(char c){
	if(((64 < c)&&(c < 91)) || ((96 < c) && (c< 123)))return '1';
    else return '0';
}

//Find where the word starts, ignoring all the spaces in the front of the word
char* find_word_start(char* str){
    for(int i = 0; i < string_length(str); i ++)
        if(is_valid_character(str[i]) == '1')
		return &str[i];
    return &str[0];
}

//Find the beginning of the final word in the string.
char* find_word_end(char* str){
    bool inWord = false;
    for(int i = string_length(str); i > 0; i--){
        if(is_valid_character(str[i]) == '1'){
            inWord = true;
            continue;
        }
        if(inWord)
            return &str[i+1];
    }
    return &str[0];
}

//We are going to count the words
int count_words(char* str){
	int wordCounter = 0;
	bool inWord = false;
	for(int i = 0; i < string_length(str); i++){
		if(is_valid_character(str[i]) == '1'){
			if(!inWord){
               		    wordCounter ++;
			    inWord = true;
 		            }
            continue;
		}
        inWord = false;
	}
	return wordCounter;
}

//going to copy the first word of str into copy
void copy_word(char* str, char* copy){
    char * p = find_word_start(str);
    int i;
   // copy = (char *) malloc(((string_length(p))*sizeof(char))+1);
    for(i = 0; is_valid_character(p[i]) == '1'; i++)
        copy[i] = p[i];
    copy[i] = '\0';
}

//This will tokenize the screen
char** tokenize(char* str){
int c = count_words(str), n = 0;
   char * tempWord = (char *) malloc(string_length((find_word_start(str)))*sizeof(char));
   char * word = str;

   //assuming that the max word count is 15
   char ** p = (char**)  malloc((c*15)*sizeof(char));
   for(int i = 0; i < c; i++){
       copy_word(word, tempWord); 
       p[i] = tempWord;
       word = (word + string_length(tempWord)+1);
   }
   return p;    
}

//printing the tokens
void print_tokens(char** tokens){
   char** p = tokens;
   for(char * c = *p; c; c=*++p){
        printf("%s\n", c);
   }   
}
void free_tokens(char** tokens){
	for(char * c = *tokens; c; c =*++tokens)
		free(c);
	free(tokens);
}
int main(){
	printf("Enter the String to tokenize\n");
	scanf("%[^\n]", tString);
	printf("Tokenizing: %s\n", tString);
	//testing
	int size = string_length(tString);
	printf("Size:%d\n", size);
        printf("isValid:%c\n",is_valid_character(tString[0]));
	printf("findStart:%c\n", *find_word_start(tString));
	printf("findEnd:%c\n", *find_word_end(tString));
	printf("CountWords:%d\n", count_words(tString));
    
   char ** t = tokenize(tString);
   print_tokens(t);

    //free(tString);
	return 0;
}

