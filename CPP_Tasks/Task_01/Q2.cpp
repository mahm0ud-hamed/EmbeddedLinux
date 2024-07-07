#include<iostream>

int main(){
    int input = 25300 ; 
    int minutes = static_cast<int>(input%60/3600) ; 
    int hours = static_cast<int>(input/3600) ;
    int seconds = (input%3600)/60 ; 
    std:: cout<< "H : S : M  " << hours << ":" << minutes << ":" << seconds << std::endl; 

}