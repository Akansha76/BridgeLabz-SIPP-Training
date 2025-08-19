Q1.

CLASS Pet

&nbsp;   ATTRIBUTES:

&nbsp;       name

&nbsp;       age

&nbsp;       breed

&nbsp;       color

&nbsp;   

&nbsp;   CONSTRUCTOR(name, age, breed, color):

&nbsp;       this.name = name

&nbsp;       this.age = age

&nbsp;       this.breed = breed

&nbsp;       this.color = color

&nbsp;   

&nbsp;   METHOD displayInfo():

&nbsp;       PRINT "Name: " + name

&nbsp;       PRINT "Age: " + age

&nbsp;       PRINT "Breed: " + breed

&nbsp;       PRINT "Color: " + color





CLASS Dog EXTENDS Pet

&nbsp;   ATTRIBUTES:

&nbsp;       isTrained

&nbsp;   

&nbsp;   CONSTRUCTOR(name, age, breed, color, isTrained):

&nbsp;       CALL super(name, age, breed, color)

&nbsp;       this.isTrained = isTrained

&nbsp;   

&nbsp;   METHOD displayInfo():

&nbsp;       CALL super.displayInfo()

&nbsp;       PRINT "Trained: " + isTrained





CLASS Cat EXTENDS Pet

&nbsp;   ATTRIBUTES:

&nbsp;       isIndoor

&nbsp;   

&nbsp;   CONSTRUCTOR(name, age, breed, color, isIndoor):

&nbsp;       CALL super(name, age, breed, color)

&nbsp;       this.isIndoor = isIndoor

&nbsp;   

&nbsp;   METHOD displayInfo():

&nbsp;       CALL super.displayInfo()

&nbsp;       PRINT "Indoor Cat: " + isIndoor





CLASS Bird EXTENDS Pet

&nbsp;   ATTRIBUTES:

&nbsp;       canTalk

&nbsp;   

&nbsp;   CONSTRUCTOR(name, age, breed, color, canTalk):

&nbsp;       CALL super(name, age, breed, color)

&nbsp;       this.canTalk = canTalk

&nbsp;   

&nbsp;   METHOD displayInfo():

&nbsp;       CALL super.displayInfo()

&nbsp;       PRINT "Can Talk: " + canTalk



METHOD main():

  dog1 = NEW Dog("Bruno", 3, "Labrador", "Brown", true)

  cat1 = NEW Cat("Kitty", 2, "Persian", "White", false)

  bird1 = NEW Bird("Mithu", 1, "Parrot", "Green", true)



  dog1.displayInfo()

  cat1.displayInfo()

  bird1.displayInfo()









Q2.



METHOD main():

    # Suppose membership started on 01-01-2024

    member1 = NEW Member("Akanksha", "M101", "01-01-2024", 12)



    member1.displayInfo()



    PRINT member1.checkValidity("15-08-2025")



CLASS Member

&nbsp;   ATTRIBUTES:

&nbsp;       name

&nbsp;       memberID

&nbsp;       membershipDate   

&nbsp;       validityPeriod   # in months (example: 12 months = 1 year)

&nbsp;   

&nbsp;   CONSTRUCTOR(name, memberID, membershipDate, validityPeriod):

&nbsp;       this.name = name

&nbsp;       this.memberID = memberID

&nbsp;       this.membershipDate = membershipDate

&nbsp;       this.validityPeriod = validityPeriod

&nbsp;   

&nbsp;   METHOD checkValidity(currentDate):

&nbsp;       expiryDate = membershipDate + validityPeriod (in months)

&nbsp;       IF currentDate <= expiryDate:

&nbsp;           RETURN "Membership is Valid"

&nbsp;       ELSE:

&nbsp;           RETURN "Membership has Expired"

&nbsp;   

&nbsp;   METHOD displayInfo():

&nbsp;       PRINT "Member Name: " + name

&nbsp;       PRINT "Member ID: " + memberID

&nbsp;       PRINT "Membership Date: " + membershipDate

&nbsp;       PRINT "Validity (months): " + validityPeriod









