#include<iostream>
#include<cstdlib>

typedef struct {
    int x  ; 
    int y ; 
}vertix;

int main(){
    vertix myvrtx[5];
    int high = 100 ; 
    int low = -100 ; 
     // Seed the random number generator with the current time
    srand(static_cast<unsigned int>(time(0))); 
    for(int i =0 ; i <5 ; i++){
        myvrtx[i].x =(rand() % (high - low + 1)) + low; 
        myvrtx[i].y =(rand() % (high - low + 1)) + low; 
       // std :: cout<<rand()<<std::endl; 
    }
    for(int i =0 ; i<5 ; i++){
        std::cout<<"the random value if x of "<<i<<" "<<myvrtx[i].x<<std::endl; 
        std::cout<<"the random value if y of "<<i<<" "<<myvrtx[i].y<<std::endl; 

    }
}