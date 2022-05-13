# Print out a message addressed to them that tells them the year that they will turn 100 years old.

name = input("Enter Name:")
age = int(input("Enter age:"))
currentYear = int(input("Enter current year:") 	)
remainingYears = 100-age
year=(currentYear+remainingYears)
# year = ((currentYear +( 100 - age )))
print("will be 100 years old in the year ",year)