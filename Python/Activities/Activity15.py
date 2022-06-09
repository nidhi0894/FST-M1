# Write a Python program that throws a NameError. Handle the error so it doesn't halt execution
try:
    add=a+b
    print(add)
except NameError:
    print("value of a and b is not assigned")