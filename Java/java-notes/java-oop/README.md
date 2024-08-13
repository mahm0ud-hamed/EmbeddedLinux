# JAVA OOP 
##  website for codding 
- codility 

oop is a software paradime is to mapping real life world  object in code

what is the class 
calss is the blue print of the objcet all design and feature will caried in the object 


what is the object? 
a component of a program that knows how to perform certain actions and how to interact with other elements of the program

how to define class 

<access modifier> * calss <name>{
 attribute decleatration * // * stand for zero or more 
 methode declaration *
 cinstructor declaration *

}

OOP main principles 

- encapsulation -> it is to encapsulate data and behaviour in class and its, its a language mechanism for restricting access to 
    some object component 
    
     data is private for miss use and constrain  this done is by validation in setters and getters must check on parameter 

- inheritance  -> 
- abstarction 
- polymorphism 

ptivate -> it can access inside calss only 

setter and getter format 
   <modifire> void setVariableName(){

    }

    <modifire> data_type getVariableName(){

    }

- constructor not create  object, it initialize object "instance member variables "

- default constructor appear only when no written consructor in calss , noce you crate one no default constructor appear 

- objects is java always stored in heap -> class_name obj_name = new constructor(); new alloacte in jvm heap 

- if you not use new key word this will be refrence calass_name  obj_name ;

- constructor ca be private and it will accessable in class only and it for control object initiation 

---------------------------------------------------------------------------------------------------------------
**instance member**
- it a object description for defrintiate between object and another
- it allocate in memory when objetcs created 
- it allocate in memory with number of objects if it variable , if it method it will be allocated one time only 
- it can access only throwh object 

- constructor  is a instance member because it initilaize instance attributes 
- constructor can't be static because in=t intialize instance attribures 

**this pointer is implicitly  passed for istance mebmer method  only** 

**this reference is a reference to the curret object of teh class** 

if you has a function parameter with same name of object vriable name this is called shadwoing 

**class members**
- is a class description .. it belong to class not belong to object .. shared between all object
- it enter memory when class enter emory using class loader 
- it allocate in memory one time only 
- it can be access throgh calss name 

- why not allocate static attribute explicitly ? 
    calss laoder allocate memory for this static variable  

- static method access static mebmbers only -> because the instance member allocate in memory after the instance created 
-  

## oop || Aplets 

- inheritance : it is to extened functionaliteies of an exsisting class 
- inherite **is a** relation ship relatin betwwen child and its parent 

**using of inhertance**
- reduce ammount of code nedded by developer 
- make code easy to maintain 
- Helps i building more reasonabke class hierachy and simulating to the real world 

- condition for inheritance must be sahred the most charactaristics and different in low charactaristics 

- when create an object form child , implicitly it was create an object from  parent using deafult constructor by deafault 
    you can prove this by calling of parent cinstructor whrn create child object 
    or by using methods of parent which cant be accessed until object is created 

- if the parent class has no default constructor and has a parametrized constructor when create an object from child this will      generate error  

- if no default constructor in parent , to avoid error in the first line of child constructor must use super(); and pass to it parameter which will pass to paramitrized parent constructor "constructor redirection"


obfusactor : make obfuscation operation  it seams like encryption by generated a scrumbled byte code to gaurd code from decompiler 
             it minimize code foot print in memory 

## polymorphism 

- **method over laoding** "it is the apperance multibe time of methods with same name and different in paramitize list in same class or more calss that has an inheritance between them "
- constructor can be overloaded 

parmitrized list 
- nuber of parameter 
- name 
- arranging of paramter 

- return type is not considered as function signature , because you can return and not recive return in any variable ;


- **method overriding** "is the apperance of method in multible class that has an inheritance with same signature" 
- from modifer to first btacted of body { 

- ***referenc from parent to child*** it will take parent feature only 

- no overriding for static mehods 

``` java 
parent p = new child() ; 

```
- java i working as late binding or dynamic binding all methods are virtula by default and you cant change it 

- abstrcat funtion is a function that no copleted declaration 
- once it appear in calss this calss must be abstact

``` java 
public abstract class {

    abstract int calcSum(); 
}
``` 
- abstract class: is a class may contain 0 or more anstarct methods and | 0 or more concrete methods 

```java 
class shape{
    abstract double calcArea(); 
    // error sahpe must be abstracted 
}

/* solution 

class shape{
     double calcArea(){} 
}*/

abstract class shape{
    abstract double calcArea(); 
    // error sahpe must be abstracted 
}

/*cant make an object from this class */
abstract class shape {
    int calcArea(){
        return 1 ; 
    }
}

``` 

**child refrence if point to parent object will generate a compiler error**
