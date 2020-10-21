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
    CONSTRAINT UK_q4l243ugd4p4f1oxy4k1fx1gr UNIQUE (bestellingen_Id),
    CONSTRAINT FK8if308uvgid8p41wuiqb1swb8  FOREIGN KEY (bestellingen_Id) REFERENCES Bestelling (Id),
    CONSTRAINT FKs0jvr4outinnep57jqd2xsj0s  FOREIGN KEY (BestellingVerzameling_Id) REFERENCES BestellingVerzameling (Id)
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
    CONSTRAINT UK_ao81e7bh7s9u22spsavy1xkfw UNIQUE (bestellingVerzamelingen_Id),
    CONSTRAINT FK3gohtqgxomd8si92div98r5i3  FOREIGN KEY (bestellingVerzamelingen_Id) REFERENCES BestellingVerzameling (Id),
    CONSTRAINT FKpq1ujlda2kshtf1f7nylff028  FOREIGN KEY (Klant_email) REFERENCES Klant (email)
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
    CONSTRAINT UK_st8kn918j508qjoqnmmd9h8ya UNIQUE (menuItems_Id),
    CONSTRAINT FKbwjorqphhen03tc3eei6qk3ca FOREIGN KEY (menuItems_Id) REFERENCES MenuItem (Id),
    CONSTRAINT FKcscvws1m0lhncjo8lju7flx9 FOREIGN KEY (Bestelling_Id) REFERENCES Bestelling (Id)
);

CREATE TABLE Menu_menuItems (
    Menu_Id         INT NOT NULL,
    menuItems_Id    INT NOT NULL,
    CONSTRAINT UK_n4v8vvescrx25ew96cafp198l UNIQUE (menuItems_Id),
    CONSTRAINT FKb01mbv7o0onjaojuw0ib3aq42  FOREIGN KEY (Menu_Id) REFERENCES Menu (Id),
    CONSTRAINT FKit4h0hdu0q91k6rlnv2bboae9  FOREIGN KEY (menuItems_Id) REFERENCES MenuItem (Id)
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
    CONSTRAINT FK2cg3nhcurkh86l8k1lijqdnof FOREIGN KEY (uitbater_email) REFERENCES Uitbater (email),
    CONSTRAINT FK478ee282dan182jujo7nkjl1q FOREIGN KEY (menu_Id) REFERENCES Menu (Id),
    CONSTRAINT FKhby3g422lw78dvu2q2mftwww9 FOREIGN KEY (adres_Id) REFERENCES Adres (Id),
    CONSTRAINT FKq353wayq69mq28t0w6h7n3sxc FOREIGN KEY (openingsUren_Id) REFERENCES Openingsuren (Id)
);

CREATE TABLE Uitbater_zaken (
    Uitbater_email VARCHAR(255) NOT NULL,
    zaken_Id       INT NOT NULL,
    CONSTRAINT UK_k1k01cinsjs4ecj0f3fs6dkdt UNIQUE (zaken_Id),
    CONSTRAINT FKaiktbkq1ulwu3pgi67nd0o34a FOREIGN KEY (zaken_Id) REFERENCES Zaak (Id),
    CONSTRAINT FKowj16l3imc9ekb292enhrqvu0 FOREIGN KEY (Uitbater_email) REFERENCES Uitbater (email)
);

CREATE TABLE Zaak_tafels (
    Zaak_Id         INT NOT NULL,
    tafels_Id       INT NOT NULL,
    CONSTRAINT UK_8sfwe4s91wh92rbi070xd3dcn UNIQUE (tafels_Id),
    CONSTRAINT FK1is9tri7hby1uchrmyyi9c2r FOREIGN KEY (tafels_Id) REFERENCES Tafel (Id),
    CONSTRAINT FKdi9ewiwt58kp5qkxetac6khw7 FOREIGN KEY (Zaak_Id) REFERENCES Zaak (Id)
);

CREATE TABLE reservatie (
    Id              INT IDENTITY PRIMARY KEY,
    Tijdstip        DATETIME(6)  NULL,
    Totaal          DOUBLE       NULL,
    UurMarge        TIME         NULL,
    klant_email     VARCHAR(255) NULL,
    tafel_Id        INT          NULL,
    zaak_Id         INT          NULL,
    CONSTRAINT FK7yp46ad1g1rxnnjc9ifg84jfq FOREIGN KEY (tafel_Id) REFERENCES Tafel (Id),
    CONSTRAINT FKa5hw854arbhwlcuyptq83ip4y FOREIGN KEY (klant_email) REFERENCES Klant (email),
    CONSTRAINT FKatjf1trfkdhhsk3jhoby99gqq FOREIGN KEY (zaak_Id) REFERENCES Zaak (Id)
);

CREATE TABLE Klant_reservaties (
    Klant_email     VARCHAR(255) NOT NULL,
    reservaties_Id  INT NOT NULL,
    CONSTRAINT UK_j0ulrvrb81bjvny7kj38gqnjl UNIQUE (reservaties_Id),
    CONSTRAINT FKnwwgit0nvmke7pr6pk7yukgf3 FOREIGN KEY (reservaties_Id) REFERENCES reservatie (Id),
    CONSTRAINT FKoq3c2wa1f4vlru9yreumldkiv FOREIGN KEY (Klant_email) REFERENCES Klant (email)
);

CREATE TABLE Zaak_reservaties (
    Zaak_Id        INT NOT NULL,
    reservaties_Id INT NOT NULL,
    CONSTRAINT UK_trbo9wx5yxlgx4ca9ov0r4ti9 UNIQUE (reservaties_Id),
    CONSTRAINT FK296gu1tmurrqel0aaosffujmw FOREIGN KEY (Zaak_Id) REFERENCES Zaak (Id),
    CONSTRAINT FK3jkpopfy8skn2wq014ul38qu0 FOREIGN KEY (reservaties_Id) REFERENCES reservatie (Id)
);