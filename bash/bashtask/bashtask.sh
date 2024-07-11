# taking path of directory 
#if directory is exisit or not if [[ -d {{path/to/directory}} ]];
# list all files find {{root_path}} -maxdepth 0 -type f 
# checking on name of files using if 
# mv ro specific directory 

echo $1 
#chek on directoru 
if [[ ! -d $1/images ]];then 
mkdir $1/image 
fi 
if [[ ! -d $1/document ]];then 
mkdir $1/document 
fi 
if [[ ! -d $1/others ]];then 
mkdir $1/others 
fi 

 
for exte in "*.txt" "*.doc" "*.pdf"; do 
    if [ $(find $1/$exte) ]; then 
        mv $1/$exte $1/document
    fi 
done 

for exte in "*.jpg" "*.png" "*.gif" ; do 
    if [ $(find $1/$exte) ]; then 
        mv $1/$exte $1/image
    fi 
done 

#find {{root_path}} -name '{{*.ext}}' -exec {{wc -l}} {} \;
find $1 -maxdepth 1 -type f -exec mv {} $1/others/ \;

#echo "your path is "$dirctory