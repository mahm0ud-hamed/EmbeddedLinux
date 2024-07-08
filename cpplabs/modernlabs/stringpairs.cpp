#include<iostream>

class pair{
    private : 
    std:: string first ; 
    std:: string second ; 
    public: 
    pair(){
        this->first =" " ; 
        this->second = " " ; 
    }
    pair(std:: string first , std:: string second):first(first),second(second){

    }
    void SetFirst(std:: string first){
        this->first = first ; 
    }
    void SetSecond(std:: string second){
        this->second = second ; 
    }
    std:: string  GetFirst(){
        return this->first ; 
    }
    std:: string  GetSecond(){
        return this->second ;
    }
    void SetPair(std:: string first , std:: string second){
        this->first = first ; 
        this -> second = second ; 
    }
    void SwapPair() {
        std:: string temp =" " ; 
        temp= first; 
        first = second ; 
        second = temp ; 
    }


}; 

int  main(){

    pair mypair , yourpair("MAHMOUD","HAMED"); 
    std::cout<<"after default constructor"<<std::endl ; 
    std::cout<< "fisrt "<< mypair.GetFirst()<<std::endl ; 
    std::cout<< "second "<< mypair.GetSecond()<<std::endl ; 

    std::cout<<"after parameter constructor"<<std::endl ;
    std::cout<< "fisrt "<< yourpair.GetFirst()<<std::endl ; 
    std::cout<< "second "<< yourpair.GetSecond()<<std::endl ; 
    std::cout<<"-------------------------"<<std::endl ; 
    yourpair.SwapPair(); 
    std::cout<<"after swap"<<std::endl ;
    std::cout<< "fisrt "<< yourpair.GetFirst()<<std::endl ; 
    std::cout<< "second "<< yourpair.GetSecond()<<std::endl ; 
}