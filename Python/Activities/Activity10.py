# Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5

mumbers_tuple = (12,9,25,17,40,5,8)
print("Numbers divisible by 5:")
print("\n")
for number in mumbers_tuple:
   
    if(number % 5 == 0):
        print(number)
    else:
        continue    