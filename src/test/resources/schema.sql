CREATE TABLE IF NOT EXISTS Adres (
    Id          INTEGER IDENTITY NOT NULL,
    Straat      VARCHAR(64),
    HuisNr      VARCHAR(12),
    Postcode    INTEGER,
    Gemeente    VARCHAR(64)
);

-- CREATE TABLE IF NOT EXISTS Bestelling (
--     Id          INTEGER IDENTITY NOT NULL,
--     CONSTRAINT FK_Bestelling_MenuItem FOREIGN KEY(Id) REFERENCES MenuItem(Id);
-- );

