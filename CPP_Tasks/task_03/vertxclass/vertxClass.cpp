#include<iostream>
#include"vertxClass.hpp"
 
void vertxCalss:: setXrandom() {
// Seed the random number generator with the current time
    srand(static_cast<unsigned int>(time(0))); 
     x =(rand() % (high - low + 1)) + low; 
     

}
 void vertxCalss::setYrandom() {
    // Seed the random number generator with the current time
    srand(static_cast<unsigned int>(time(0))); 
    y =(rand() % (high - low + 1)) + low; 
 }
int  vertxCalss:: getXrandom(){
    return x ; 
}
int  vertxCalss:: getYrandom(){
    return y ; 
}

std::string vertxCalss:: stringFormat(){
    std::string f1 ; 
    f1="random poinst[ +" + std::to_string(x) + ", "+std::to_string(y) +"]" ; 
    return  f1 ; 
}