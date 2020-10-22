CREATE TABLE Adres (
    Id                          INT IDENTITY PRIMARY KEY,
    Gemeente                    VARCHAR(255) NOT NULL,
    HuisNr                      VARCHAR(255) NOT NULL,
    Postcode                    INT          NOT NULL,
    Straat                      VARCHAR(255) NOT NULL
);

CREATE TABLE Bestelling (
    Id                          INT IDENTITY PRIMARY KEY
);

CREATE TABLE BestellingVerzameling (
    Id                          INT IDENTITY PRIMARY KEY
);

CREATE TABLE Dag (
    Naam                        VARCHAR(255) NOT NULL PRIMARY KEY ,
    OpeningsUur                 TIME NULL,
    SluitingsUur                TIME NULL
);

CREATE TABLE Klant (
    Email                       VARCHAR(255) NOT NULL PRIMARY KEY ,
    Krediet                     DOUBLE NULL,
    Naam                        VARCHAR(255) NULL,
    Voornaam                    VARCHAR(255) NULL,
    Wachtwoord                  VARCHAR(255) NULL
);

CREATE TABLE Menu (
    Id INT IDENTITY PRIMARY KEY
);

CREATE TABLE MenuItem (
    Id                          INT IDENTITY PRIMARY KEY ,
    Naam                        VARCHAR(255) NULL,
    Prijs                       FLOAT NULL
);

CREATE TABLE Openingsuren (
    Id                          INT IDENTITY PRIMARY KEY
);

CREATE TABLE Tafel (
    Id              INT IDENTITY PRIMARY KEY,
    Stoelen         INT NULL
);

CREATE TABLE Uitbater (
    Email           VARCHAR(255) NOT NULL PRIMARY KEY,
    Krediet         DOUBLE NULL,
    Naam            VARCHAR(255) NULL,
    Voornaam        VARCHAR(255) NULL,
    Wachtwoord      VARCHAR(255) NULL
);

CREATE TABLE BestellingVerzameling_bestellingen (
    BestellingVerzameling_Id    INT NOT NULL,
    bestellingen_Id             INT NOT NULL,
    CONSTRAINT FK_BestellingVerzameling_Bestelling  FOREIGN KEY (bestellingen_Id) REFERENCES Bestelling (Id),
    CONSTRAINT FK_BestellingVerzameling_Bestellingen_BestellingVerzameling  FOREIGN KEY (BestellingVerzameling_Id) REFERENCES BestellingVerzameling (Id)
);

CREATE TABLE Klant_bestellingVerzamelingen (
    Klant_Email                 VARCHAR(255) NOT NULL,
    bestellingVerzamelingen_Id  INT NOT NULL,
    CONSTRAINT FK_Klant_BestellingVerzamelingen_BestellingVerzameling  FOREIGN KEY (bestellingVerzamelingen_Id) REFERENCES BestellingVerzameling (Id),
    CONSTRAINT FK_Klant_BestellingVerzamelingen_Klant  FOREIGN KEY (Klant_Email) REFERENCES Klant (Email)
);

CREATE TABLE Menu_menuItems (
    Menu_Id                     INT NOT NULL,
    menuItems_Id                INT NOT NULL,
    CONSTRAINT FK_Menu_MenuItems_Menu  FOREIGN KEY (Menu_Id) REFERENCES Menu (Id),
    CONSTRAINT FK_Menu_MenuItems_MenuItem  FOREIGN KEY (menuItems_Id) REFERENCES MenuItem (Id)
);

CREATE TABLE Bestelling_menuItems (
    Bestelling_Id               INT NOT NULL,
    menuItems_Id                INT NOT NULL,
    CONSTRAINT FK_Bestelling_MenuItems_MenuItems FOREIGN KEY (menuItems_Id) REFERENCES MenuItem (Id),
    CONSTRAINT FK_Bestelling_MenuItems_Bestelling FOREIGN KEY (Bestelling_Id) REFERENCES Bestelling (Id)
);

CREATE TABLE Openingsuren_dagen (
    OpeningsUren_Id             INT NOT NULL,
    dagen_Naam                  VARCHAR(255) NOT NULL,
    CONSTRAINT FK_Openingsuren_dagen_Openingsuren FOREIGN KEY (OpeningsUren_Id) REFERENCES Openingsuren (Id),
    CONSTRAINT FK_Openingsuren_dagen_Dag FOREIGN KEY (dagen_Naam) REFERENCES Dag (Naam)
);

CREATE TABLE Zaak (
    Id              INT IDENTITY PRIMARY KEY,
    Naam            VARCHAR(255) NULL,
    Parking         BIT          NULL,
    Rating          FLOAT        NULL,
    Adres_Id        INT          NULL,
    Menu_Id         INT          NULL,
    Openingsuren_Id INT          NULL,
    Uitbater_Email  VARCHAR(255) NULL,
    CONSTRAINT FK_Zaak_Uitbater FOREIGN KEY (Uitbater_Email) REFERENCES Uitbater (Email),
    CONSTRAINT FK_Zaak_Menu FOREIGN KEY (Menu_Id) REFERENCES Menu (Id),
    CONSTRAINT FK_Zaak_Adres FOREIGN KEY (Adres_Id) REFERENCES Adres (Id) ON DELETE CASCADE,
    CONSTRAINT FK_Zaak_Openingsuren FOREIGN KEY (Openingsuren_Id) REFERENCES Openingsuren (Id)
);

CREATE TABLE Zaak_tafels (
     Zaak_Id         INT NOT NULL,
     tafels_Id       INT NOT NULL,
     CONSTRAINT FK_Zaak_Tafels_Tafel FOREIGN KEY (tafels_Id) REFERENCES Tafel (Id),
     CONSTRAINT FK_Zaak_Tafels_Zaak FOREIGN KEY (Zaak_Id) REFERENCES Zaak (Id) ON DELETE CASCADE
);

CREATE TABLE Reservatie (
    Id              INT IDENTITY PRIMARY KEY,
    Tijdstip        DATETIME(6)  NULL,
    Totaal          DOUBLE       NULL,
    UurMarge        TIME         NULL,
    Klant_Email     VARCHAR(255) NULL,
    Tafel_Id        INT          NULL,
    Zaak_Id         INT          NULL,
    CONSTRAINT FK_Reservatie_Tafel FOREIGN KEY (Tafel_Id) REFERENCES Tafel (Id),
    CONSTRAINT FK_Reservatie_Klant FOREIGN KEY (Klant_Email) REFERENCES Klant (Email),
    CONSTRAINT FK_Reservatie_Zaak FOREIGN KEY (Zaak_Id) REFERENCES Zaak (Id) ON DELETE CASCADE
);