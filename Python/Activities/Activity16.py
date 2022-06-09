class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        # The self parameter is a reference to the current instance of the class, and is used to access variables that belongs to the class.
        # The other two parameters are just data that you want to initialize your object with.
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color
 
    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")
 
    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")
 
car1 = Car("Toyota", "Corolla", "2015", "Manual", "White")
car2 = Car("Maruti", "800", "2013", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")
 
car1.accelerate()
car1.stop()