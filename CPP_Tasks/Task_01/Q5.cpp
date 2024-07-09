#include<iostream>


struct Employee{

    struct Name{
        char * firstname= nullptr ; 
        char * middlename= nullptr ; 
        char * lasttname= nullptr ; 
    } Name; 
    struct  DOP{
        int day ; 
        int month ; 
        int year ;  
    }DOP;
    struct address {
        char * street = nullptr ; 
        char * country = nullptr ; 
        char * city = nullptr ; 

    }address;
    struct contacts{
        char * phoneNumber= nullptr ; 
        char * mobileNumber= nullptr ;
        char * email = nullptr ; 
    }contacts; 
    struct Salary{
        int basic ; 
        int additional ; 
        float  reduction ; 
        float taxes ; 
    }Salary;
    
}; 
void SetName(Employee* emp , char * name){
    emp->Name.firstname = name ;
}
int main (){
    Employee mahmoud;
    SetName(&mahmoud , "mahmoud hamed") ;
    std::cout<< "first name is "<<mahmoud.Name.firstname<<std::endl;

}