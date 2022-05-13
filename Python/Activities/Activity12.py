# Write a recursive function to calculate the sum of numbers from 0 to 10

def calculateSum(number):
    sum =0
    for i in range(number+1):
        sum += i
    return sum    

num = int(input("Enter number:   "))
print("Calculated sum is::  ",calculateSum(num))