# hello: 
# 	echo "hello world"
# 	echo "this will print if file hello is not exist " 
# blah.o:blah.c
# 	gcc blah.c -o blah  


# some_file: other_file
# 	echo "This will always run, and runs second"
# 	touch some_file

# other_file:
# 	echo "This will always run, and runs first"
# clean:
# 	rm some_file 

# files= file1 file2 

# some_file:${files}
# 	echo 'look at this variable'$(files)
# 	touch some_files 
# file1: 
# 	touch file1 
# file2: 
# 	touch file2 

# clean : 
# 	rm file1 file2 some_file

# all: one two three 

# one:
# 	touch one 
# two:
# 	touch two 
# three:
# 	touch three 
# clean:
# 	rm one two three 

# all:file1.o file2.o 

# file1.o file2.o : 
# 	echo $@
# clean:
# 	rm file1.o file2.o 

# ThingRight=$(wildcard *.o)
# WrongThing= *.o 
# files= one two three 
#  all:$(files)

#  one:$(WrongThing)

#  two:*.o

#  three:$(ThingRight)

#  four: $(wildcard *.o)

# clean: 
# 	# rm some_file file1 file2 echo '*.o'

objects= foo.o bar.o all.o 
CC= gcc 
all:$(objects)
	$(CC)  $^ -o all 

%.o:%.c 
	$(CC) -c $^ -o $@  
# bar.o:bar.c 
# 	$(CC) -c $^ -o bar.o 
# all.o:all.c 
# 	$(CC) -c $^ -o all.o 
all.c: 
	@echo "int main() { return 0; }" > all.c
%.c: 
	touch $@ 
clean: 
	@ rm *.c *.o  all 

