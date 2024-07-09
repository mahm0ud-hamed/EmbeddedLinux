    #include"calc.hpp"

    int Calc:: add(){
        return operand1 + operand2 ; 
    }
    int Calc:: sub(){
        
        return operand1 - operand2 ; 
    }
    int Calc:: mul(){
        return operand1 * operand2 ; 
    }
    float Calc:: div(){
        if(0 == operand2 )
            return operand1 / operand2 ; 
        else 
            std::cout<<" operation cant done"<<std::endl ;
    }
 