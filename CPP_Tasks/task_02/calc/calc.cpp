    #include"calc.hpp"

    int Calc:: add(int var1 , int var2){
        return operand1 + operand2 ; 
    }
    int Calc:: sub(int var1 , int var2){
        
        return operand1 - operand2 ; 
    }
    int Calc:: mul(int var1 , int var2){
        return operand1 * operand2 ; 
    }
    float Calc:: div(int var1 , int var2){
        if(0 == operand2 )
            return operand1 / operand2 ; 
        else 
            std::cout<<" operation cant done"<<std::endl ;
    }
 