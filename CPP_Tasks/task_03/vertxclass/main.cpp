#include<iostream>
#include"vertxClass.hpp"

int main(){
    vertxCalss v1 ; 
    v1.setXrandom(); 
    v1.setYrandom(); 
    std::cout<<"xrandom "<<v1.getXrandom()<<std::endl; 
    std::cout<<"yrandom"<<v1.getYrandom() <<std::endl; 
    std::cout<<v1.stringFormat()<<std::endl; 
    return 0 ;
}