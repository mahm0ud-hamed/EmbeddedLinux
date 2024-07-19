#include<iostream>
#include"accImpelem.hpp"

int main(){

    account mahmoud(1000); 
    std::cout<<"total ammount = "<<mahmoud.getTotalAmount()<<std::endl; ;
    std::cout<<"checking amount "<< mahmoud.checkAmount()<<std::endl;
    mahmoud.makeDeposite(2000);
    std::cout<<"checking amount after deposite = "<< mahmoud.checkAmount()<<std::endl;
    std::cout<<"total ammount after deposite  = "<<mahmoud.getTotalAmount()<<std::endl; 
    mahmoud.makeWithdrwal(3000);
    std::cout<<"checking amount after deposite = "<< mahmoud.checkAmount()<<std::endl;
    std::cout<<"total ammount after deposite  = "<<mahmoud.getTotalAmount()<<std::endl; 
    std::cout<<"acocunt nuber of deposite "<<mahmoud.getNbOfDeposites()<<std::endl;
    std::cout<<"number of account "<<account::getnoOfAccounts()<<std::endl;
    account::displayAccountInfo();
    return 0 ;
}