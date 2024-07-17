#include<iostream>
#include<random>
#include<array>

class game{
    private : 
    std::array<std::array<bool,5>,5> board; 
        int pgusses ; 
        int maxgusses ; 
        int locationx ; 
        int locationy ;
        bool win = false ;  
    public : 
        game(int maxgusses):maxgusses(maxgusses){
            pgusses = 0 ; 
            locationx = rand() %6 ; 
            locationy = rand() %6 ; 
            board[locationx][locationy]= true ; 
        }
        /*check if the gusseing in correct or not */ 
        bool guess(int x , int y ){
            /* check if two postions are in range of array */
           if((x <= 4 && x >0 )&&  (y <=4 && y >0 )){
                pgusses ++ ; 
           } 
           else {
                std::cout<<" you are out of boundries "<<std::endl; 
                return false  ; 
           }
           /* check if two postions in nearest to needed postion */
           if( x <(locationx-1)){
                std::cout<<" you are near in x cordinate "<<std::endl; 
           }
           if(y < (locationy-1)){
                std::cout<<"you are near in y cordinate "<<std::endl; 
           }
           if((x == locationx) && (y==locationy) ){
                win = true ; 
           }
            return win ; 
        }
         
        bool gameOver()const{
            if (pgusses == maxgusses ){
                return true ; 
            }
            else {
                return false ; 
            }
        }
        bool Win(){
            return win ;  
        }
        int getGuess(){
            return pgusses ; 
        }


} ;

int main(){
    int x , y ; 

    game mygame(5) ; 
    while(!mygame.Win() && !mygame.gameOver()){

        std::cout<<"enter your gussing cordinates "<<std::endl ; 
        std::cout<<"x= ";
        std::cin>>x ;
        std::cout<<"y= ";
        std::cin>>y ; 

        mygame.guess(x , y ) ;
    }
    /* if program end with wininng the game */
    if(mygame.Win()){
        std::cout<<"you are winning the game"<<std::endl ; 
    }
    else{
        std::cout<<"GAME OVER"<<std::endl ; 

    }
 
}