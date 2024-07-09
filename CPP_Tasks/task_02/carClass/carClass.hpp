#include<iostream>

class Car{
    private : 
    std:: string company ; 
    std:: string model ; 
    int  year ; 
    public: 
    void SetCarCompany(std:: string company); 
    std::string GetCarCompany(); 
    void SetCarModel(std::string Model ) ; 
    std::string GetCarModel(); 
    std::string SetCarYear(int year ) ; 
    int GetCarYear(); 

}; 