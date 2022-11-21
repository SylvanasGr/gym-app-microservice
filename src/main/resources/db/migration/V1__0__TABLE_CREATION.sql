CREATE TABLE Users
(
    UserId SERIAL,
    Name VARCHAR(45) NOT NULL,
    Surname VARCHAR(45) NOT NULL,
    Sex CHARACTER(1) NOT NULL,
    Age INTEGER NOT NULL,
    Email VARCHAR(60) UNIQUE NOT NULL,
    Username VARCHAR(30) NOT NULL,
    Password VARCHAR(45) NOT NULL,
    Country VARCHAR(30) NOT NULL,
    Area VARCHAR(30) NOT NULL,
    PhoneNumber VARCHAR(30) NOT NULL,
    CONSTRAINT Users_PK PRIMARY KEY (UserId)
);

CREATE TABLE TrainerTypes 
(
    TypeId INTEGER,
    Name VARCHAR(60),
    CONSTRAINT TrainerTypes_PK PRIMARY KEY (TypeId)
);
INSERT INTO TrainerTypes(TypeId, Name) VALUES(1, 'Gym');
INSERT INTO TrainerTypes(TypeId, Name) VALUES(2, 'Freelancer');

CREATE TABLE Trainers 
(
    UserId INTEGER,
    TrainerTypeId INTEGER,
    BankAccount VARCHAR(60),
    ProfileDescription VARCHAR(250),
    CONSTRAINT Trainers_PK PRIMARY KEY (UserId),
    CONSTRAINT Trainers_FK1 FOREIGN KEY (UserId) REFERENCES Users,
    CONSTRAINT Trainers_FK2 FOREIGN KEY (TrainerTypeId) REFERENCES TrainerTypes
);

CREATE TABLE Trainees 
(
    UserId INTEGER,
    Weight REAL,
    Height REAL,
    Injuries VARCHAR(250),
    CONSTRAINT Trainees_PK PRIMARY KEY (UserId),
    CONSTRAINT Trainees_FK FOREIGN KEY (UserId) REFERENCES Users
);

CREATE TABLE ExerciseCategories
(
    Id SERIAL,
    Name VARCHAR(45),
    CONSTRAINT ExerciseCategories_PK PRIMARY KEY (Id)
);

CREATE TABLE Exercises
(
    Name VARCHAR(45),
    CategoryId INTEGER,
    CONSTRAINT Exercises_PK PRIMARY KEY (Name),
    CONSTRAINT Exercises_FK FOREIGN KEY (CategoryId) REFERENCES ExerciseCategories
);

CREATE TABLE CustomTrainerExercises
(
    TrainerId INTEGER,
    Name VARCHAR(45),
    CategoryId INTEGER,
    EquipmentDescription VARCHAR(150),
    CONSTRAINT CustomTrainerExercises_PK PRIMARY KEY (TrainerId),
    CONSTRAINT CustomTrainerExercises_FK1 FOREIGN KEY (TrainerId) REFERENCES Trainers,
    CONSTRAINT CustomTrainerExercises_FK2 FOREIGN KEY (CategoryId) REFERENCES ExerciseCategories
);

CREATE TABLE Courses
(
    Id SERIAL,
    TrainerId INTEGER,
    Name VARCHAR(45),
    Description VARCHAR(350),
    Duration INTEGER,
    Price REAL,
    IsPersonal BOOLEAN,
    CONSTRAINT Courses_PK PRIMARY KEY (Id),
    CONSTRAINT Courses_FK FOREIGN KEY (TrainerId) REFERENCES Trainers
);