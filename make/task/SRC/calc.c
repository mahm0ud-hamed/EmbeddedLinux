#include<stdio.h>


int main(){

int op , x  , y  ; 
printf("1- for add \n 2- for sub  \n"); 
printf("Select operation \n"); 
printf("enter operands \n"); 
scanf("%d",x); 
scanf("%d",y); 
scanf("%d",op); 

switch (op){
case 1 : add() ; break ; 
case 2: sub() ; break ; 

}
}
