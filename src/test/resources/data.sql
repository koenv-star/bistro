TRUNCATE TABLE Adres RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Bestelling RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Bestelling_menuItems RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE BestellingVerzameling RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE BestellingVerzameling_bestellingen RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Dag RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Klant RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Klant_bestellingVerzamelingen RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Menu RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Menu_menuItems RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE MenuItem RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Openingsuren RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Openingsuren_dagen RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Reservatie RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Tafel RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Uitbater RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Zaak RESTART IDENTITY AND COMMIT;
TRUNCATE TABLE Zaak_tafels RESTART IDENTITY AND COMMIT;

INSERT INTO Adres(Id, Straat, HuisNr, Postcode, Gemeente)
VALUES (1, 'JavaStraat', 18, 3000, 'Leuven'),
       (2, 'SpringStraat', 255, 2000, 'Antwerpen'),
       (3, 'JPAWeg', 64, 1020, 'Ergens'),
       (4, 'HibernateStraat', 50, 1000, 'Leuven');

INSERT INTO Bestelling(Id) VALUES (1), (2), (3);

INSERT INTO BestellingVerzameling(Id) VALUES (1), (2), (3);

INSERT INTO Dag(Naam, OpeningsUur, SluitingsUur)
VALUES ('Ma', '12:30:00', '19:00:00'),
       ('Wo', '08:15:00', '21:30:00'),
       ('Zo', '12:00:00', '20:45:00');

INSERT INTO Klant(email, Krediet, Naam, Voornaam, Wachtwoord)
VALUES ('jammik@bistro.be', 150.6, 'Jammik', 'Bistro', 'BiJam123'),
       ('resto@rant.be', 750.6, 'Rant', 'Resto', 'RaRo789'),
       ('test@klant.be', 300, 'mail', 'klant', 'klma852');

INSERT INTO Menu(Id)
VALUES (1), (2), (3);

INSERT INTO MenuItem(Id, Naam, Prijs)
VALUES (1, 'Pizza', 15.5),
       (2, 'Spaghetti', 20.25),
       (3, 'Macaroni', 12.0);

INSERT INTO Openingsuren(Id)
VALUES (1), (2), (3);

INSERT INTO Tafel(Id, Stoelen)
VALUES (1, 4), (2, 2), (3, 1);

INSERT INTO Uitbater(Email, Krediet, Naam, Voornaam, Wachtwoord)
VALUES ('mehmet@jammik.be', 1000, 'Durmus', 'Mehmet', 'MehmetDurmus'),
       ('michael@jammik.be', 1000, 'Creelle', 'Michael', 'MichaelCreelle'),
       ('koen@jammik.be', 1000, 'Vochten', 'Koen', 'KoenVochten'),
       ('jan@jammik.be', 1000, 'Olaerts', 'Jan', 'JanOlaerts');

INSERT INTO BestellingVerzameling_bestellingen(BestellingVerzameling_Id, bestellingen_Id)
VALUES (2, 1), (3, 1), (2, 3);

INSERT INTO Klant_bestellingVerzamelingen(Klant_Email, bestellingVerzamelingen_Id)
VALUES ('resto@rant.be', 2), ('test@klant.be', 1);

INSERT INTO Menu_menuItems(Menu_Id, menuItems_Id)
VALUES (1, 2), (1, 3), (2, 1), (2, 3);

INSERT INTO Bestelling_menuItems(Bestelling_Id, menuItems_Id)
VALUES (1, 2), (2, 3), (2, 2), (3, 1);

INSERT INTO Openingsuren_dagen(Openingsuren_Id, dagen_Naam)
VALUES (1, 'Ma'), (1, 'Zo'), (2, 'Wo'), (2, 'Zo');

INSERT INTO Zaak(Id, Naam, Parking, Rating, Adres_Id, Menu_Id, Openingsuren_Id, Uitbater_Email)
VALUES (1, 'Bistro Mehmet', 1, 5, 3, 1, 2, 'mehmet@jammik.be'),
       (2, 'Bistro Michael', 1, 5, 1, 3, 2, 'michael@jammik.be'),
       (3, 'Bistro Koen', 1, 5, 4, 2, 3, 'koen@jammik.be'),
       (4, 'Bistro Jan', 1, 5, 1, 3, 1, 'jan@jammik.be');

INSERT INTO Zaak_tafels(Zaak_Id, tafels_Id)
VALUES (1, 2), (1, 2),
       (2, 1), (2, 3),
       (3, 1), (3, 2),
       (4, 2), (4, 2);

INSERT INTO Reservatie(Id, Tijdstip, Totaal, UurMarge, Klant_Email, Tafel_Id, Zaak_Id)
VALUES (1, '2020-11-12 12:00:00', 55.5, '00:45:00', 'jammik@bistro.be', 1, 2),
       (2, '2021-02-05 17:50:00', 199.99, '02:00:00', 'test@klant.be', 2, 1),
       (3, '2021-06-12 09:30:00', 265.35, '03:15:00', 'jammik@bistro.be', 1, 1);