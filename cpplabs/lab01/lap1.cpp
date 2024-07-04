#include<stdio.h>
#include<stdlib.h>

char ** AllocateStringArray(int StringCount); 
void StoringString(char ** , int ); 
char* GetStrings(void); 
void PrintArrayOfString(char ** , int ) ; 
void DestroyStringArray(char ** , int ) ;
int main(){
     int StringCount  ; 
     printf("enter the number of string you need to ennter \n"); 
     scanf("%d", &StringCount); 
     char ** MyString= AllocateStringArray( StringCount);
     StoringString(MyString ,  StringCount );
     PrintArrayOfString(MyString,  StringCount ); 
     DestroyStringArray(MyString , StringCount ); 
}
/* allocate memory for string array dynamically */
char ** AllocateStringArray(int StringCount){
     char ** StringArray = NULL ; 
     StringArray =(char**)malloc(sizeof(char**) * StringCount); 
     return StringArray ; 
}
/* get every srting from user */
char* GetStrings(void){
     int length ; 
     printf("enter the length of string"); 
     scanf("%d",&length) ; 
     char * string = (char*)malloc(sizeof(char)*length) ;
     /* getteing string from user */
     for(int i =0 ; i < length ; i++){
          scanf(" %c",&string[i]); 
     } 
     /* retun string after get it */
     return string ; 
}
/* storing all string from user into string array */
void StoringString(char ** StringArray , int StringCount ){
     for(int i =0 ; i < StringCount ; i++){
          *(StringArray+i)=GetStrings();
     }
}

/* print array after store it user */
void PrintArrayOfString(char ** StringArray, int StringCount ) {
     for(int i = 0 ; i < StringCount ;i++){
          printf("%s\n",*(StringArray+i)); 
     }
}
void DestroyStringArray(char ** StringArray ,int StringCount){
     for(int i =0 ; i<StringCount ; i++){
          /* free every array element */
          free(*(StringArray+i)); 
     }
          /* free whole large array  */
     free(StringArray) ; 
} 
