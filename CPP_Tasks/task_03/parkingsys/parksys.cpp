#include <iostream>
enum carstype{
     big_t= 1 ,
    medium_t , 
   small_t
};
class ParkingSystem {
    int   big , small , medium ;   
public:
    ParkingSystem(int big, int medium, int small):big(big),medium(medium),small(small) { }
    
    bool addCar(int carType) {
        bool state =true ; 
        if(carType == big_t && big >0 ){
            -- big  ; 
        }
        else if (carType == big_t && big <= 0 ) {
            state = false ; 
        }
        if(carType == medium_t && medium > 0 ){
            -- medium ;  
        }
        else if (carType == medium_t && medium <=0 ){
            state =false ;  
        }
        if(carType == small_t  && small > 0){
            --small  ; 
        }
        else if(carType == small_t  && small <= 0){
            state =false ; 
        }
        return state ; 
    } 
};

int main(){
    ParkingSystem p(1,1,0); 
    std::cout<<"f big car "<< p.addCar(1)<<std::endl; 
    std::cout<<"f medium car "<<p.addCar(2)<<std::endl; 
    std::cout<<"f small  car "<<p.addCar(3)<<std::endl; 
    std::cout<<"again big car "<< p.addCar(1)<<std::endl; 
}