from datetime import datetime
 
x = datetime.now()
print("Current date and time:  "+str(x))
print("Year:   "+str(x.year)) # Output: 2020

print("Which day:  "+str(x.strftime("%a"))) # Weekday, half version-----Output: Fri
print("Which day:  "+str(x.strftime("%A"))) # Weekday, full version-----Output: Friday

print("No of day in the week:  "+str(x.strftime("%w")))  # Weekday as a number 0-6, 0 is Sunday

print("Day of month 01-31:  "+str(x.strftime("%D")))  # Day of month 01-31

print("Month name, short version:  "+str(x.strftime("%b")))  # Dec

print("Month name, full version:  "+str(x.strftime("%B")))  # December

print("Month as a number 01-12:  "+str(x.strftime("%m"))) 

# %y	Year, short version, without century	20
# %Y	Year, full version	2020
# %H	Hour 00-23	17
# %I	Hour 00-12	05
# %p	AM/PM	PM
# %M	Minute 00-59	41
# %S	Second 00-59	08
# %j	Day number of year 001-366	365
# %U	Week number of year, Sunday as the first day of week, 00-53	52
# %W	Week number of year, Monday as the first day of week, 00-53	07
# %c	Local version of date and time	Mon Dec 31 17:41:00 2018
# %x	Local version of date	12/31/18
# %X	Local version of time	17:41:00