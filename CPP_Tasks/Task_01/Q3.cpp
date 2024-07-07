#include<iostream>
#include<string>
#include<math.h>
std :: string decimalToBinary(int decimal) ; 
int binaryToDecimal(std:: string binary) ;

int main() {
    int choice;
    while (true) {
        std::cout << "Select conversion type:\n";
        std::cout << "1. Binary to Decimal\n";
        std::cout << "2. Decimal to Binary\n";
        std::cout << "3. Exit\n";
        std::cout << "Enter your choice: ";
        std::cin >> choice;

        if (choice == 1) {
            std:: string binary;
            std::cout << "Enter binary number: ";
            std::cin >> binary;
            int decimal = binaryToDecimal(binary);
            std::cout << binary << " in binary is " << decimal << " in decimal.\n";
        } else if (choice == 2) {
            int decimal;
            std::cout << "Enter decimal number: ";
            std::cin >> decimal;
            std:: string binary = decimalToBinary(decimal);
            std::cout << decimal << " in decimal is " << binary << " in binary.\n";
        } else if (choice == 3) {
            break;
        } else {
           std:: cout << "Invalid choice. Please try again.\n";
        }
    }
    return 0;
}
// Function to convert decimal to binary
std :: string decimalToBinary(int decimal) {
    std:: string binary = "";
    while (decimal > 0) {
        binary = (decimal % 2 == 0 ? "0" : "1") + binary;
        decimal /= 2;
    }
    return binary.empty() ? "0" : binary;
}
// Function to convert binary to decimal
int binaryToDecimal(std:: string binary) {
    int decimal = 0;
    int length = binary.length();
    for (int i = 0; i < length; ++i) {
        if (binary[length - i - 1] == '1') {
            decimal += pow(2, i);
        }
    }
    return decimal;
}