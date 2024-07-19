#ifndef _ACCIMPELEM_H_
#define _ACCIMPELEM_H_

class account { 
    public : 
    using acc = account ; 
    static int getnoOfAccounts () ; 
    static int getTotalAmount(); 
    static int getNbOfDeposites(); 
    static int getNoOfWithdrwals(); 
    static void displayAccountInfo(); 

    account(int Initial_deposite ) ; 
    ~account() ; 
    void makeDeposite(int deposite ) ; 
    bool makeWithdrwal(int withdrwal);
    int checkAmount()const; 
    void displayStatus()const; 

private : 
    static int m_noOfaccounts ; 
    static int m_totalAmount ; 
    static int m_totalNbdeposits ; 
    static int m_totalnbwithdrwals ; 
    static void m_displayTimeStamp () ; 

    int m_aacountIndex ; 
    int m_amount ; 
    int m_noOfDeposits ; 
    int m_noOfWithdrwals ; 
    account() ;

};

#endif 