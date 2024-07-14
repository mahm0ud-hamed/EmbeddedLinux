#include<iostream>
#include <variant>

class Calc{
    private : 
  
 int add(int var1 , int var2);
    int sub(int var1 , int var2);
    int mul(int var1 , int var2);
    float div(int var1 , int var2);
    public : 
    Calc(){
    } 

    double USER_CALC(int var1 , int var2,char op){
        
         double result;
        switch (op)
        {
            case '+': result = add(var1,var2) ;  break;
            case '-': result = sub(var1,var2);   break;
            case '*': result = mul(var1,var2) ;   break;
            case '/': result = div(var1,var2);  break;
 
            default:
                // do nothing 
            break;
        }
        return result;
        
    }

};