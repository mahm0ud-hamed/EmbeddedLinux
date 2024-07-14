#include"calc.hpp"

int main(){



    auto var = 0 ; 
    auto var2 = 0; 
    std::cin>> var;
    std::cin>> var2;
    Calc operation1 ('/' , var , var2 ) ; 
    double result= operation1.Result() ; 

}