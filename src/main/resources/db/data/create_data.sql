INSERT INTO Users(Name, Surname, Sex, Age, Email, Username, Password, Country, Area, PhoneNumber)
VALUES('George', 'Papas', 'M', 34, 'g.papas@mymail.com', 'gpap', 'gpap', 'Greece', 'Attiki', '00306973880123');
INSERT INTO Users(Name, Surname, Sex, Age, Email, Username, Password, Country, Area, PhoneNumber)
VALUES('Nikos', 'Ioannou', 'M', 23, 'n.ioannou@mymail.com', 'nioan', 'nioan', 'Greece', 'Macedonia', '00306978780126');
INSERT INTO Users(Name, Surname, Sex, Age, Email, Username, Password, Country, Area, PhoneNumber)
VALUES('Maria', 'Papadopoulou', 'F', 28, 'm.papadopoulou@mymail.com', 'mpapa', 'mpapa', 'Greece', 'Arta', '00306930019823');
INSERT INTO Users(Name, Surname, Sex, Age, Email, Username, Password, Country, Area, PhoneNumber)
VALUES('Jesus', 'Christ', 'M', 33, 'jc@mymail.com', 'jc', 'jc', 'Israel' , 'Palestine', '008091029328');

INSERT INTO Trainers(UserId, TrainerTypeId, BankAccount, ProfileDescription)
VALUES(1, 2, 'GR123213912093', 'My name is George Papas.');
INSERT INTO Trainers(UserId, TrainerTypeId, BankAccount, ProfileDescription)
VALUES(2, 1, 'GR021371231235', 'My name is Nikos Ioannou.');
INSERT INTO Trainees(UserId, Weight, Height, Injuries)
VALUES(3, 56, 1.67, 'Broken leg 4 yrs ago.');
INSERT INTO Trainees(UserId, Weight, Height, Injuries)
VALUES(4, 81, 1.78, 'Nailed hands.');