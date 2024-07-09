#include<iostream>

class Calc{
    private : 
    int op ;
    int operand1 =0 ; 
    int operand2 =0  ;
    int add();
    int sub();
    int mul();
    float div() ;
    public : 
    Calc(char  op , int operand1 , int operand2 ):op(op),operand1(operand1),operand2(operand2){

    } 

    auto Result(){
        auto result = 0 ;  // auto variable must be initialized 
        switch (op)
        {
            case '+': result = add() ;  break;
            case '-': result = sub() ;  break;
            case '*': result = mul() ;  break;
            case '/': result = div() ;  break;
 
            default:
                // do nothing 
            break;
        }
        return result ; 
    }
};