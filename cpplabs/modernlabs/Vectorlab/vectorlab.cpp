#include<iostream>
#include <vector>

std::vector<std::vector<int>> SwapRowColoumn(std::vector<std::vector<int>> &myVec) ;

int main(){
std::vector<std::vector<int>> myvec= {
    {1,2},
    {4,5},
    {7,8}
};
/*for(const auto  &out : myvec){
    for(auto in : out){
        std::cout<< in <<" "; 
    }
    std::cout<< std::endl ; 
}*/
std::vector<std::vector<int>> newvec = SwapRowColoumn(myvec) ;
for(const auto  &out : newvec){
    for(auto in : out){
        std::cout<< in <<" "; 
    }
    std::cout<< std::endl ; 
}
}


std::vector<std::vector<int>> SwapRowColoumn(std::vector<std::vector<int>> &myVec){
 
    int colm= myVec[0].size();
    int rows = myVec.size() ; 
    // allocte new vector with 
    std::vector<std::vector<int>> tempVec(colm , std::vector<int>(rows));
    std::cout<<"cols " << colm << " rwos "<<rows<<std::endl; 
    for(int i=0 ; i<rows ; i++){
        for(int j = 0 ; j < colm ; j++){
            tempVec[j][i] = myVec[i][j] ; 
        }
    }
    return tempVec ; 

}
