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
    Id          int Identity primary key,
    Klant_Email varchar(255) null
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
    Id    int IDENTITY
        primary key,
    Naam  varchar(255) null,
    Prijs float        null,
    Beschrijving varchar(255) not null,
    Categorie int not null
);
create table if not exists Menu_MenuItems
(
    menu_id      int not null,
    menu_item_id int not null,
    constraint FKcc68jx1q1g14tne50g12jipcm
        foreign key (menu_id) references Menu (Id) ON DELETE CASCADE ,
    constraint FKcguavnqxv4uriuxr916qju5sa
        foreign key (menu_item_id) references MenuItem (Id) ON DELETE CASCADE
);
create table if not exists Openingsuren
(
    Id int IDENTITY
        primary key
);
create table if not exists Dag
(
    id               int IDENTITY
        primary key,
    Naam             varchar(255) null,
    OpeningsUur      time         null,
    SluitingsUur     time         null,
    openings_uren_id int          null,
    constraint FKg25w7pdeyrnhonpku522die1v
        foreign key (openings_uren_id) references Openingsuren (Id) ON DELETE CASCADE
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
        foreign key (Menu_Id) references Menu (Id) ON DELETE CASCADE ,
    constraint FK9yy7qly1y9uvgm5l1fs8ynatt
        foreign key (Adres_Id) references Adres (Id) ON DELETE CASCADE ,
    constraint FKjkdv2a7douv2bfs4uiy0rpp4p
        foreign key (Openingsuren_Id) references Openingsuren (Id) ON DELETE CASCADE ,
    constraint FKor2ftcutapr3ehfipjtbfldsw
        foreign key (Uitbater_Email) references Uitbater (Email) ON DELETE CASCADE
);

create table if not exists Bestelling
(
    Id                        int IDENTITY primary key,
    Aantal                    int null,
    zaak_Id                   int null,
    bestelling_verzameling_id int null,
    Menu_Item_Id              int null,
    constraint FK6pgylk2t442urcq35hdgp1dae
        foreign key (bestelling_verzameling_id) references BestellingVerzameling (Id),
    constraint FKqd3hhj7o4aewxl4rcmcdkltuq
        foreign key (zaak_Id) references Zaak (Id),
    constraint FKwjo64foccqq3exv2ybf94g6g
        foreign key (Menu_Item_Id) references MenuItem (Id)
);
create table if not exists Bestelling_MenuItems
(
    bestelling_id int not null,
    menu_item_id  int not null,
    constraint FK3d8r0a1hj2gyddve7ucx4391r
        foreign key (menu_item_id) references MenuItem (Id) ON DELETE CASCADE ,
    constraint FKbps9k79up3ic9opqhs2of6i88
        foreign key (bestelling_id) references Bestelling (Id) ON DELETE CASCADE
);
create table if not exists Tafel
(
    Id      int IDENTITY
        primary key,
    Stoelen int null,
    zaak_id int null,
    constraint FK5hnlkh5cb97ymj8x910fqldn4
        foreign key (zaak_id) references Zaak (Id) ON DELETE CASCADE
);
create table if not exists Reservatie
(
    Id          int IDENTITY
        primary key,
    Tijdstip    datetime(6)  null,
    UurMarge    time         null,
    Klant_Email varchar(255) null,
    Tafel_Id    int          null,
    Zaak_Id     int          null,
    constraint FKk58raqe3godi237rdkvxd62e9
        foreign key (Zaak_Id) references Zaak (Id) ON DELETE CASCADE ,
    constraint FKn86jbj6wnofa80g7l0jw8ikfw
        foreign key (Tafel_Id) references Tafel (Id) ON DELETE CASCADE
);