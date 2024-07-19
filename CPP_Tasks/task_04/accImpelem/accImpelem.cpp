#include<iostream> 
#include"accImpelem.hpp"
#include <iomanip>


 int account:: m_noOfaccounts  =0 ;       // static members  
 int account:: m_totalAmount =0 ;    // static members 
 int account:: m_totalNbdeposits=0 ;    // static members 
 int account:: m_totalnbwithdrwals=0 ;    // static members 
void account::displayAccountInfo(){
    std::cout<<std::setw(72)<<std::setfill('-')<<""<<""<<std::endl;
    std::cout<<"|"<<std::setw(10)<<std::setfill(' ')<< "account#" <<std::setw(4)<<"|"<<std::setw(15)<< "#_deposites" <<std::setw(4)<<"|"<<std::setw(15)<< "#_withdrwals" <<std::setw(4)<<"|"<<std::setw(15)<< "tot_amount" <<std::setw(4)<<"|"<<std::endl;
    std::cout<<"|"<<std::setw(70)<<std::setfill('-')<<""<<"|"<<std::endl;
    std::cout<<"|"<<std::setw(10)<<std::setfill(' ')<< getnoOfAccounts() <<std::setw(6)<<"|"<<std::setw(10)<< getNbOfDeposites() <<std::setw(6)<<"|"<<std::setw(10)<< getNoOfWithdrwals() <<std::setw(6)<<"|"<<std::setw(10)<< getTotalAmount() <<std::setw(6)<<"|"<<std::endl;
    // std::cout<<std::setw(41)<<std::setfill('-')<<""<<std::endl;

 }
 int account:: getnoOfAccounts () {
    return m_noOfaccounts ; 
 }
 int account:: getTotalAmount(){
    return m_totalAmount ; 
 }
 int account:: getNbOfDeposites(){
    return m_totalNbdeposits; 
 } 
 int account:: getNoOfWithdrwals(){
    return m_totalnbwithdrwals ; 
 } 
account:: account(int Initial_deposite ):account() {
    m_noOfaccounts ++ ; 
    m_noOfDeposits ++ ; 
    m_totalAmount+=Initial_deposite ; 
    m_amount = Initial_deposite ; 
}
void account:: makeDeposite(int deposite ) {
    m_noOfDeposits ++ ; 
    m_totalNbdeposits ++ ; 
    m_totalAmount+=deposite; 
    m_amount+=deposite ; 
}
bool account:: makeWithdrwal(int withdrwal){
    bool operation = true  ;
    if(m_amount > 0 && withdrwal <= m_amount ){
        m_noOfWithdrwals ++ ; 
        m_totalnbwithdrwals ++ ; 
        m_amount-=withdrwal ; 
        m_totalAmount-=withdrwal ;
    }
    else {
        std::cout<< "you acocunt can't cover withdrwal ammount "<<std::endl;
        std::cout<<"your balance was "<<m_amount<<std::endl;
        operation = false ; 
    }
    return operation ; 
}
int  account:: checkAmount()const{
    return m_amount ;
}
void account:: displayStatus()const{
    std::cout<<"your account is active " ;
} 
account::account():m_amount(0),m_noOfDeposits(0),m_noOfWithdrwals(0){}
account:: ~account() {

} 