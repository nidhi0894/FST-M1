# Create a Python dictionary that contains a bunch of fruits and their prices.
# Write a program that checks if a certain fruit is available or not.

fruitsDict = {"Apple":"350","Banana":"30","Strawberry":"500","Guvava":"200","Papaya":"100","Mango":"660"}

check = input("Fruit you want???      ")
if check in fruitsDict:
    print(check, ", fruit is available")
else:
    print(check, ", fruit is not availanle")    
