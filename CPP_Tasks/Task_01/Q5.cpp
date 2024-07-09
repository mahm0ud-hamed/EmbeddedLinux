#include<iostream>


struct Employee{
    struct Name{
        char * firstname= nullptr ; 
        char * middlename= nullptr ; 
        char * lasttname= nullptr ; 
    } ; 
    struct  DOP{
        int day ; 
        int month ; 
        int year ;  
    };
    struct address {
        char * street = nullptr ; 
        char * country = nullptr ; 
        char * city = nullptr ; 

    };
    struct contacts{
        char * phoneNumber= nullptr ; 
        char * mobileNumber= nullptr ;
        char * email = nullptr ; 
    }; 
    struct Salary{
        int basic ; 
        int additional ; 
        float  reduction ; 
        float taxes ; 
    };
    
}; 
void SetName(Employee* emp , char * name){
    (emp->Name).firstname = *name ;
}
int main (){
    Employee mahmoud; 

}