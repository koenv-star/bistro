CREATE TABLE Adres (
    Id                          INT IDENTITY PRIMARY KEY ,
    Gemeente                    VARCHAR(255) NULL,
    HuisNr                      VARCHAR(255) NULL,
    Postcode                    INT          NULL,
    Straat                      VARCHAR(255) NULL
);

CREATE TABLE Bestelling (
    Id                          INT IDENTITY PRIMARY KEY
);

create table BestellingVerzameling (
    Id                          INT IDENTITY PRIMARY KEY
);

CREATE TABLE BestellingVerzameling_bestellingen (
    BestellingVerzameling_Id    INT NOT NULL,
    bestellingen_Id             INT NOT NULL,
    CONSTRAINT FK_BestellingVerzameling_Bestelling  FOREIGN KEY (bestellingen_Id) REFERENCES Bestelling (Id),
    CONSTRAINT FK_BestellingVerzameling_Bestellingen_BestellingVerzameling  FOREIGN KEY (BestellingVerzameling_Id) REFERENCES BestellingVerzameling (Id)
);

CREATE TABLE Dag (
    Naam                        VARCHAR(255) NOT NULL PRIMARY KEY ,
    OpeningsUur                 TIME NULL,
    SluitingsUur                TIME NULL
);

CREATE TABLE Klant (
    email                       VARCHAR(255) NOT NULL PRIMARY KEY ,
    Krediet                     INT NULL,
    Naam                        VARCHAR(255) NULL,
    Voornaam                    VARCHAR(255) NULL,
    Wachtwoord                  VARCHAR(255) NULL
);

CREATE TABLE Klant_bestellingVerzamelingen (
    Klant_email                 VARCHAR(255) NOT NULL,
    bestellingVerzamelingen_Id  INT NOT NULL,
    CONSTRAINT FK_Klant_BestellingVerzamelingen_BestellingVerzameling  FOREIGN KEY (bestellingVerzamelingen_Id) REFERENCES BestellingVerzameling (Id),
    CONSTRAINT FK_Klant_BestellingVerzamelingen_Klant  FOREIGN KEY (Klant_email) REFERENCES Klant (email)
);

CREATE TABLE Menu (
    Id INT IDENTITY PRIMARY KEY
);

CREATE TABLE MenuItem (
    Id    INT IDENTITY PRIMARY KEY ,
    Naam  VARCHAR(255) NULL,
    Prijs FLOAT NULL
);

CREATE TABLE Bestelling_menuItems (
    Bestelling_Id INT NOT NULL,
    menuItems_Id  INT NOT NULL,
    CONSTRAINT FK_Bestelling_MenuItems_MenuItems FOREIGN KEY (menuItems_Id) REFERENCES MenuItem (Id),
    CONSTRAINT FK_Bestelling_MenuItems_Bestelling FOREIGN KEY (Bestelling_Id) REFERENCES Bestelling (Id)
);

CREATE TABLE Menu_menuItems (
    Menu_Id         INT NOT NULL,
    menuItems_Id    INT NOT NULL,
    CONSTRAINT FK_Menu_MenuItems_Menu  FOREIGN KEY (Menu_Id) REFERENCES Menu (Id),
    CONSTRAINT FK_Menu_MenuItems_MenuItem  FOREIGN KEY (menuItems_Id) REFERENCES MenuItem (Id)
);

CREATE TABLE Openingsuren (
    Id              INT IDENTITY PRIMARY KEY
);

CREATE TABLE Tafel (
    Id              INT IDENTITY PRIMARY KEY,
    Stoelen         INT NULL
);

CREATE TABLE Uitbater (
    email           VARCHAR(255) NOT NULL PRIMARY KEY,
    Krediet         INT NULL,
    Naam            VARCHAR(255) NULL,
    Voornaam        VARCHAR(255) NULL,
    Wachtwoord      VARCHAR(255) NULL
);

CREATE TABLE Zaak (
    Id              INT IDENTITY PRIMARY KEY,
    Naam            VARCHAR(255) NULL,
    Parking         BIT          NULL,
    Rating          FLOAT        NULL,
    adres_Id        INT          NULL,
    menu_Id         INT          NULL,
    openingsUren_Id INT          NULL,
    uitbater_email  VARCHAR(255) NULL,
    CONSTRAINT FK_Zaak_Uitbater FOREIGN KEY (uitbater_email) REFERENCES Uitbater (email),
    CONSTRAINT FK_Zaak_Menu FOREIGN KEY (menu_Id) REFERENCES Menu (Id),
    CONSTRAINT FK_Zaak_Adres FOREIGN KEY (adres_Id) REFERENCES Adres (Id),
    CONSTRAINT FK_Zaak_Openingsuren FOREIGN KEY (openingsUren_Id) REFERENCES Openingsuren (Id)
);

CREATE TABLE Uitbater_zaken (
    Uitbater_email VARCHAR(255) NOT NULL,
    zaken_Id       INT NOT NULL,
    CONSTRAINT FK_Uitbater_Zaken_Zaak FOREIGN KEY (zaken_Id) REFERENCES Zaak (Id),
    CONSTRAINT FK_Uitbater_Zaken_Uitbater FOREIGN KEY (Uitbater_email) REFERENCES Uitbater (email)
);

CREATE TABLE Zaak_tafels (
    Zaak_Id         INT NOT NULL,
    tafels_Id       INT NOT NULL,
    CONSTRAINT FK_Zaak_Tafels_Tafel FOREIGN KEY (tafels_Id) REFERENCES Tafel (Id),
    CONSTRAINT FK_Zaak_Tafels_Zaak FOREIGN KEY (Zaak_Id) REFERENCES Zaak (Id)
);

CREATE TABLE Reservatie (
    Id              INT IDENTITY PRIMARY KEY,
    Tijdstip        DATETIME(6)  NULL,
    Totaal          DOUBLE       NULL,
    UurMarge        TIME         NULL,
    klant_email     VARCHAR(255) NULL,
    tafel_Id        INT          NULL,
    zaak_Id         INT          NULL,
    CONSTRAINT FK_Reservatie_Tafel FOREIGN KEY (tafel_Id) REFERENCES Tafel (Id),
    CONSTRAINT FK_Reservatie_Klant FOREIGN KEY (klant_email) REFERENCES Klant (email),
    CONSTRAINT FK_Reservatie_Zaak FOREIGN KEY (zaak_Id) REFERENCES Zaak (Id)
);

CREATE TABLE Klant_reservaties (
    Klant_email     VARCHAR(255) NOT NULL,
    reservaties_Id  INT NOT NULL,
    CONSTRAINT FK_Klant_Reservaties_Reservatie FOREIGN KEY (reservaties_Id) REFERENCES Reservatie (Id),
    CONSTRAINT FK_Klant_Reservaties_Klant FOREIGN KEY (Klant_email) REFERENCES Klant (email)
);

CREATE TABLE Zaak_reservaties (
    Zaak_Id        INT NOT NULL,
    reservaties_Id INT NOT NULL,
    CONSTRAINT FK_Zaak_Reservaties_Zaak FOREIGN KEY (Zaak_Id) REFERENCES Zaak (Id),
    CONSTRAINT FK_Zaak_Reservaties_Reservatie FOREIGN KEY (reservaties_Id) REFERENCES Reservatie (Id)
);