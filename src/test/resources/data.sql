TRUNCATE TABLE Adres RESTART IDENTITY;
TRUNCATE TABLE Bestelling RESTART IDENTITY;
TRUNCATE TABLE BestellingVerzameling RESTART IDENTITY;
TRUNCATE TABLE Dag RESTART IDENTITY;
TRUNCATE TABLE Klant RESTART IDENTITY;
TRUNCATE TABLE MenuItem RESTART IDENTITY;
TRUNCATE TABLE Menu RESTART IDENTITY;
TRUNCATE TABLE Openingsuren RESTART IDENTITY;
TRUNCATE TABLE Tafel RESTART IDENTITY;
TRUNCATE TABLE Uitbater RESTART IDENTITY;
TRUNCATE TABLE Zaak RESTART IDENTITY;

INSERT INTO Adres(Id, Straat, HuisNr, Postcode, Gemeente)
VALUES (1, 'JavaStraat', 18, 3000, 'Leuven'),
       (2, 'SpringStraat', 255, 2000, 'Antwerpen'),
       (3, 'JPAWeg', 64, 1020, 'Ergens');

INSERT INTO Bestelling(Id) VALUES (1), (2), (3);

INSERT INTO MenuItem(Id, Naam, Prijs)
VALUES (1, 'Pizza', 15.5),
       (2, 'Spaghetti', 20.25),
       (3, 'Macaroni', 12.0);

INSERT INTO Bestelling_menuItems(Bestelling_Id, menuItems_Id)
VALUES (1, 2), (2, 3), (2, 2), (3, 1);

INSERT INTO BestellingVerzameling(Id) VALUES (1), (2), (3);

INSERT INTO BestellingVerzameling_bestellingen(BestellingVerzameling_Id, bestellingen_Id)
VALUES (2, 1), (3, 1), (2, 3);

INSERT INTO Dag(Naam, OpeningsUur, SluitingsUur)
VALUES ('Ma', '12:30 P.M.', '19:00 P.M.'),
       ('Wo', '08:15 A.M.', '21:30 P.M.'),
       ('Zo', '12:00 P.M.', '20:45 P.M.');