create table if not exists Adres
(
    Id       int IDENTITY
        primary key,
    Gemeente varchar(255) null,
    HuisNr   varchar(255) null,
    Postcode int          null,
    Straat   varchar(255) null
);

create table if not exists BestellingVerzameling
(
    Id          int IDENTITY
        primary key,
    Klant_Email varchar(255) null
);

create table if not exists Bestelling
(
    Id            int IDENTITY
        primary key,
    bestelling_verzameling_id int null,
    constraint FK99vm7bo5i08jyn8q4oje4rqqq
        foreign key (bestelling_verzameling_id) references BestellingVerzameling (Id) on delete CASCADE
);

create table if not exists Klant
(
    Email      varchar(255) not null
        primary key,
    Krediet    double       null,
    Naam       varchar(255) null,
    Voornaam   varchar(255) null,
    Wachtwoord varchar(255) null
);

create table if not exists Menu
(
    Id int IDENTITY
        primary key
);

create table if not exists MenuItem
(
    Id           int IDENTITY
        primary key,
    Naam         varchar(255) null,
    Prijs        float        null,
    menu_item_id int          null,
    constraint FK7qobp7074f0kbaxo6pwkj22fs
        foreign key (menu_item_id) references Menu (Id) on delete cascade
);

create table if not exists Openingsuren
(
    Id int IDENTITY
        primary key
);

create table if not exists Dag
(
    Naam             varchar(255) not null
        primary key,
    OpeningsUur      time         null,
    SluitingsUur     time         null,
    openings_uren_id int          null,
    constraint FKg25w7pdeyrnhonpku522die1v
        foreign key (openings_uren_id) references Openingsuren (Id) on delete cascade
);

create table if not exists Uitbater
(
    Email      varchar(255) not null
        primary key,
    Krediet    double       null,
    Naam       varchar(255) null,
    Voornaam   varchar(255) null,
    Wachtwoord varchar(255) null
);

create table if not exists Zaak
(
    Id              int IDENTITY
        primary key,
    Naam            varchar(255) null,
    Parking         bit          null,
    Rating          float        null,
    Adres_Id        int          null,
    Menu_Id         int          null,
    Openingsuren_Id int          null,
    Uitbater_Email  varchar(255) null,
    constraint FK6olxl6sn5b85w6ykn90exg55u
        foreign key (Menu_Id) references Menu (Id) on delete CASCADE,
    constraint FK9yy7qly1y9uvgm5l1fs8ynatt
        foreign key (Adres_Id) references Adres (Id) on delete CASCADE,
    constraint FKjkdv2a7douv2bfs4uiy0rpp4p
        foreign key (Openingsuren_Id) references Openingsuren (Id) on delete CASCADE,
    constraint FKor2ftcutapr3ehfipjtbfldsw
        foreign key (Uitbater_Email) references Uitbater (Email) on delete CASCADE
);

create table if not exists Tafel
(
    Id      int IDENTITY
        primary key,
    Stoelen int null,
    zaak_id int null,
    constraint FK5hnlkh5cb97ymj8x910fqldn4
        foreign key (zaak_id) references Zaak (Id) on delete CASCADE
);

create table if not exists Reservatie
(
    Id          int IDENTITY
        primary key,
    Tijdstip    datetime(6)  null,
    Totaal      double       null,
    UurMarge    time         null,
    Klant_Email varchar(255) null,
    Tafel_Id    int          null,
    Zaak_Id     int          null,
    constraint FKk58raqe3godi237rdkvxd62e9
        foreign key (Zaak_Id) references Zaak (Id) on delete CASCADE,
    constraint FKn86jbj6wnofa80g7l0jw8ikfw
        foreign key (Tafel_Id) references Tafel (Id) on delete CASCADE
);