
#include"carClass.hpp" 

void Car:: SetCarCompany(std::string company){
    this->company = company ; 
}

std::string Car:: GetCarCompany(){
    return company ; 
}

void Car::SetCarModel(std::string Model ) {
    model = Model ; 
}
std::string Car:: GetCarModel(){
    return model ; 
} 
std::string Car:: SetCarYear(int year ){
    this->year = year ; 
}
int Car:: GetCarYear(){
    return year ; 
}
