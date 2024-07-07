#include<iostream>

int main() {

    int result = 0 ; 
    int input = 0 ;
    std :: cout<< "enter input number "<<std::endl;  
    std:: cin>> input ; 
    while(input){
        result+=input ; 
        std:: cin>> input ; 
    }
    std:: cout<< "the result was  "<< result <<std:: endl ; 
}