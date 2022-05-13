# To create the multiplication table (from 1 to 10) of a number.

number = int(input("Enter number to print table for:  "))

for i in range(1,11):
    print(number, " * ", i , " = ", (number*i))