# Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.
# Hint : like this: 1, 1, 2, 3, 5, 8, 13, …

def fibonacci(n):
    first=0
    second=1
    if n < 0:
        print("Invalid input")
    elif n == 0:
        return 0
    elif n == 1:
        return 1    
    else: 
        for i in range(1,n):
            temp = first + second
            first = second
            second = temp
        return temp    


number = int(input("Enter a number to print Fabonacci series: "))
print("Fibonacci Sequence: ")
for i in range(number):
    print(fibonacci(i))

