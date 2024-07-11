# # read form user 
# read -sp"enter your password" password

# # condition  on files  
# echo ${password}   
# if [ -file ./mahmoud ];then
#     echo "not exist"
#     touch "mahmoud"
# else 
#     echo "file was exisit"
# fi 
# # condition in stings = , != , -z , -n 
# if [ "mahmoud" != "mahmoud" ];then 
#     echo "two strings are equall " 
# elif [ "mahmoud" != "ahmed" ];then 
#     echo "two string are not equal "
# fi 
 
# if [ -n "mahmoud" ];then 
#     echo "mahmoud is not zero character string  "
# fi 

# # logical operators ------------------------------- 

# # [[]] with && and ||  [] with -a and -o 
# if [[ "mahmoud" = "mahmoud"  &&  "mahmoud" != "ahmed" ]];then 
#     echo " and logical operatr "
# fi 

# loops -------------------------------------------------------

# for var in 1 2 3 4 5 
# do echo $var
# done 

# for var in {1..5}
# do echo $var 
# done 

# # will print every string seperated with white space 
# name="mahmoud mohamed hamed"
# for str in $name
# do echo $str 
# done

# # will print whole string in one line  
# name="mahmoud mohamed hamed"
# for str in "$name"
# do echo $str 
# done  

x=0
while [ $x -lt 10 ];do 
    echo $x 
    ((x ++ )) # to wite c-style expression 
done 

#Check the condition.
#If the condition is false, then execute the statements and go back to step 1.
#If the condition is true, then the program control moves to the next command in the script.
echo " unilt loop "
 y=0 
until [ $y -gt 10 ]; do 
    echo $y 
    ((y++))
done 

colors=("red" "green" "blue")
# Check if the first element is "red" and the second is "yellow"
if [ "${colors[0]}" = "red" ] && [ "${colors[1]}" = "yellow" ]; then
    echo "The first two colors are red and yellow."
else
    echo "The colors are different."
fi
# array -----------------------------------
array=( "trials.sh" "hamed" "gad " )
array[3]="ali" # append element on array 
array+=("syaed") # append on the last of array 

for var in "${array[*]}"
do echo $var
done 
if [ "${array[0]}" = "mahmoud" ];then 
    echo "ana mawgorf"
fi 
if [ "${array[0]}" = "mahmoud" ] && [ "${array[1]}" = "hamed" ];then 
echo "array is valid "
fi 
# checking if array contain an element 
if [[ ${array[@]} =~ "mahmoud" ]];then 
    echo "user is exist " 
fi 

if [[ ${array[@]} =~ "mahmoud" ]] && [[ ${array[@]} =~ "hamed" ]];then 
    echo "users is exist " 
fi 


# print all element with indcies get array index  ${!arr[@]}
array[10]="sameh"
for i in {1..10}; do  # ${!array[@]} return index of filled indexis 
    # if empty element if zero element string  
    if [[ -z "${array[$i]}" ]];then
        echo " array[$i]  empty "
    else 
        echo "mahmoud"
        echo "array[$i]" ":" ${array[$i]}
    fi
done 

# if you want to initialize empty indcies 

# for i in {1..10};do 
#     if [ -z "${array[i]}" ]; then 
#         array[i]="empty"
#     fi    
# done 

#  echo ${array[@]}

# print slicing array that conatain an empty index will ignore empty 
# array slicing form index to index 
# slice=${array[@]:1:9}; 
# echo "sliced array "${slice[@]}
# array slicing from index to end 
# you can use it to process some file 
    # sliced=${array[@]:1}
    # echo "from 1 to end   "${sliced[@]}
    # cat ${array[0]}


# associative array its ann array can be accessd through key and values 
# declare -A arrayname 
# initialization arrayname[key]=value  

#example 
declare -A fruits 
fruits[yellow]="banana" 
fruits[red]="tomato"
fruits[green]="apple"
# # accessing element using its key 
# echo ${fruits[red]} ;
declare -A colorFruits=([banana]="yello" [apple]="red" [mango]=green)

echo "the color of bannana "${colorFruits[banana]}
# append on array using new key 
colorFruits[orange]="orange"

# printing whole array will not printed in assending or desending order 
# echo "all array" ${colorFruits[@]} 

# iterating onn key 
for key in ${!colorFruits[@]};do
echo "color of  $key = "${colorFruits[$key]}
done


echo "after deleting an element "
#deleteing an element with its key 
unset ${colorFruits[apple]}
#printing after deleting an element  
for key in ${!colorFruits[@]};do
echo "color of  $key = "${colorFruits[$key]}
done