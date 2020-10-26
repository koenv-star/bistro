create table if not exists Adres
(
    Id       int IDENTITY
        primary key,
    Gemeente varchar(255) null,
    HuisNr   varchar(255) null,
    Postcode int          null,
    Straat   varchar(255) null
);

create table if not exists Bestelling
(
    Id int IDENTITY
        primary key
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
    Prijs float        null
);

create table if not exists Bestelling_menuItems
(
    Bestelling_Id int not null,
    menuItems_Id  int not null,
    constraint UK_st8kn918j508qjoqnmmd9h8ya
        unique (menuItems_Id),
    constraint FKbwjorqphhen03tc3eei6qk3ca
        foreign key (menuItems_Id) references MenuItem (Id) ON DELETE CASCADE ,
    constraint FKcscvws1m0lhncjo8lju7flx9
        foreign key (Bestelling_Id) references Bestelling (Id) ON DELETE CASCADE
);

create table if not exists Menu_menuItems
(
    Menu_Id      int not null,
    menuItems_Id int not null,
    constraint UK_n4v8vvescrx25ew96cafp198l
        unique (menuItems_Id),
    constraint FKb01mbv7o0onjaojuw0ib3aq42
        foreign key (Menu_Id) references Menu (Id) ON DELETE CASCADE ,
    constraint FKit4h0hdu0q91k6rlnv2bboae9
        foreign key (menuItems_Id) references MenuItem (Id) ON DELETE CASCADE
);

create table if not exists Openingsuren
(
    Id int IDENTITY
        primary key
);

create table if not exists Dag
(
    Naam           varchar(255) not null
        primary key,
    OpeningsUur    time         null,
    SluitingsUur   time         null,
    OpeningsUrenId int          null,
    constraint FK24raso40ksg9grnmmmrp3xr2q
        foreign key (OpeningsUrenId) references Openingsuren (Id) ON DELETE CASCADE
);

create table if not exists Tafel
(
    Id      int IDENTITY
        primary key,
    Stoelen int null
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

create table if not exists BestellingVerzameling
(
    Id                   int IDENTITY
        primary key,
    Klant_Uitbater_Email varchar(255) null,
    constraint FK831w3um8wtf6319w551kfst2y
        foreign key (Klant_Uitbater_Email) references Uitbater (Email) ON DELETE CASCADE
);

create table if not exists BestellingVerzameling_bestellingen
(
    BestellingVerzameling_Id int not null,
    bestellingen_Id          int not null,
    constraint UK_q4l243ugd4p4f1oxy4k1fx1gr
        unique (bestellingen_Id),
    constraint FK8if308uvgid8p41wuiqb1swb8
        foreign key (bestellingen_Id) references Bestelling (Id) ON DELETE CASCADE ,
    constraint FKs0jvr4outinnep57jqd2xsj0s
        foreign key (BestellingVerzameling_Id) references BestellingVerzameling (Id) ON DELETE CASCADE
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

create table if not exists Reservatie
(
    Id                   int IDENTITY
        primary key,
    Tijdstip             datetime(6)  null,
    Totaal               double       null,
    UurMarge             time         null,
    Klant_Email          varchar(255) null,
    Tafel_Id             int          null,
    Zaak_Id              int          null,
    Klant_Uitbater_Email varchar(255) null,
    constraint FKcy9hwn045xdgswxxg15xrbjt3
        foreign key (Klant_Uitbater_Email) references Uitbater (Email) ON DELETE CASCADE ,
    constraint FKgtyf722nqvxygjc4l921rb1wu
        foreign key (Klant_Email) references Klant (Email) ON DELETE CASCADE ,
    constraint FKk58raqe3godi237rdkvxd62e9
        foreign key (Zaak_Id) references Zaak (Id) ON DELETE CASCADE ,
    constraint FKn86jbj6wnofa80g7l0jw8ikfw
        foreign key (Tafel_Id) references Tafel (Id) ON DELETE CASCADE
);

create table if not exists Zaak_tafels
(
    Zaak_Id   int not null,
    tafels_Id int not null,
    constraint UK_8sfwe4s91wh92rbi070xd3dcn
        unique (tafels_Id),
    constraint FK1is9tri7hby1uchrmyyi9c2r
        foreign key (tafels_Id) references Tafel (Id) ON DELETE CASCADE ,
    constraint FKdi9ewiwt58kp5qkxetac6khw7
        foreign key (Zaak_Id) references Zaak (Id) ON DELETE CASCADE
);

