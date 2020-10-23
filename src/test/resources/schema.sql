CREATE TABLE IF NOT EXISTS Adres (
    Id                          INT IDENTITY PRIMARY KEY,
    Gemeente                    VARCHAR(255) NOT NULL,
    HuisNr                      VARCHAR(255) NOT NULL,
    Postcode                    INT          NOT NULL,
    Straat                      VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Bestelling (
    Id                          INT IDENTITY PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS BestellingVerzameling (
    Id                          INT IDENTITY PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Dag (
    Naam                        VARCHAR(255) NOT NULL PRIMARY KEY ,
    OpeningsUur                 TIME NOT NULL,
    SluitingsUur                TIME NOT NULL
);

CREATE TABLE IF NOT EXISTS Klant (
    Email                       VARCHAR(255) NOT NULL PRIMARY KEY ,
    Krediet                     DOUBLE NOT NULL,
    Naam                        VARCHAR(255) NOT NULL,
    Voornaam                    VARCHAR(255) NOT NULL,
    Wachtwoord                  VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Menu (
    Id INT IDENTITY PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS MenuItem (
    Id                          INT IDENTITY PRIMARY KEY ,
    Naam                        VARCHAR(255) NOT NULL,
    Prijs                       FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS Openingsuren (
    Id                          INT IDENTITY PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Tafel (
    Id              INT IDENTITY PRIMARY KEY,
    Stoelen         INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Uitbater (
    Email           VARCHAR(255) NOT NULL PRIMARY KEY,
    Krediet         DOUBLE NOT NULL,
    Naam            VARCHAR(255) NOT NULL,
    Voornaam        VARCHAR(255) NOT NULL,
    Wachtwoord      VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS BestellingVerzameling_bestellingen (
    BestellingVerzameling_Id    INT NOT NULL,
    bestellingen_Id             INT NOT NULL,
    CONSTRAINT FK_BestellingVerzameling_Bestelling FOREIGN KEY (bestellingen_Id) REFERENCES Bestelling (Id) ON DELETE CASCADE,
    CONSTRAINT FK_BestellingVerzameling_Bestellingen_BestellingVerzameling  FOREIGN KEY (BestellingVerzameling_Id) REFERENCES
        BestellingVerzameling (Id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Klant_bestellingVerzamelingen (
    Klant_Email                 VARCHAR(255) NOT NULL,
    bestellingVerzamelingen_Id  INT NOT NULL,
    CONSTRAINT FK_Klant_BestellingVerzamelingen_BestellingVerzameling  FOREIGN KEY (bestellingVerzamelingen_Id)
        REFERENCES BestellingVerzameling (Id) ON DELETE CASCADE,
    CONSTRAINT FK_Klant_BestellingVerzamelingen_Klant  FOREIGN KEY (Klant_Email) REFERENCES Klant (Email) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Menu_menuItems (
    Menu_Id                     INT NOT NULL,
    menuItems_Id                INT NOT NULL,
    CONSTRAINT FK_Menu_MenuItems_Menu  FOREIGN KEY (Menu_Id) REFERENCES Menu (Id) ON DELETE CASCADE,
    CONSTRAINT FK_Menu_MenuItems_MenuItem  FOREIGN KEY (menuItems_Id) REFERENCES MenuItem (Id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Bestelling_menuItems (
    Bestelling_Id               INT NOT NULL,
    menuItems_Id                INT NOT NULL,
    CONSTRAINT FK_Bestelling_MenuItems_MenuItems FOREIGN KEY (menuItems_Id) REFERENCES MenuItem (Id) ON DELETE CASCADE,
    CONSTRAINT FK_Bestelling_MenuItems_Bestelling FOREIGN KEY (Bestelling_Id) REFERENCES Bestelling (Id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Openingsuren_dagen (
    OpeningsUren_Id             INT NOT NULL,
    dagen_Naam                  VARCHAR(255) NOT NULL,
    CONSTRAINT FK_Openingsuren_dagen_Openingsuren FOREIGN KEY (OpeningsUren_Id) REFERENCES Openingsuren (Id) ON DELETE CASCADE,
    CONSTRAINT FK_Openingsuren_dagen_Dag FOREIGN KEY (dagen_Naam) REFERENCES Dag (Naam) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Zaak (
    Id              INT IDENTITY PRIMARY KEY,
    Naam            VARCHAR(255) NOT NULL,
    Parking         BIT          NOT NULL,
    Rating          FLOAT        NOT NULL,
    Adres_Id        INT          NOT NULL,
    Menu_Id         INT          NOT NULL,
    Openingsuren_Id INT          NOT NULL,
    Uitbater_Email  VARCHAR(255) NOT NULL,
    CONSTRAINT FK_Zaak_Uitbater FOREIGN KEY (Uitbater_Email) REFERENCES Uitbater (Email) ON DELETE CASCADE,
    CONSTRAINT FK_Zaak_Menu FOREIGN KEY (Menu_Id) REFERENCES Menu (Id) ON DELETE CASCADE,
    CONSTRAINT FK_Zaak_Adres FOREIGN KEY (Adres_Id) REFERENCES Adres (Id) ON DELETE CASCADE,
    CONSTRAINT FK_Zaak_Openingsuren FOREIGN KEY (Openingsuren_Id) REFERENCES Openingsuren (Id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Zaak_tafels (
     Zaak_Id         INT NOT NULL,
     tafels_Id       INT NOT NULL,
     CONSTRAINT FK_Zaak_Tafels_Tafel FOREIGN KEY (tafels_Id) REFERENCES Tafel (Id) ON DELETE CASCADE,
     CONSTRAINT FK_Zaak_Tafels_Zaak FOREIGN KEY (Zaak_Id) REFERENCES Zaak (Id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Reservatie (
    Id              INT IDENTITY PRIMARY KEY,
    Tijdstip        DATETIME(6)  NOT NULL,
    Totaal          DOUBLE       NOT NULL,
    UurMarge        TIME         NOT NULL,
    Klant_Email     VARCHAR(255) NOT NULL,
    Tafel_Id        INT          NOT NULL,
    Zaak_Id         INT          NOT NULL,
    CONSTRAINT FK_Reservatie_Tafel FOREIGN KEY (Tafel_Id) REFERENCES Tafel (Id) ON DELETE CASCADE,
    CONSTRAINT FK_Reservatie_Klant FOREIGN KEY (Klant_Email) REFERENCES Klant (Email) ON DELETE CASCADE,
    CONSTRAINT FK_Reservatie_Zaak FOREIGN KEY (Zaak_Id) REFERENCES Zaak (Id) ON DELETE CASCADE
);