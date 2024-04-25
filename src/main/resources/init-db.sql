-- Table Definition ----------------------------------------------

 CREATE TABLE IF NOT EXISTS books (
     id INTEGER PRIMARY KEY,
     name character varying(255) NOT NULL,
     language character varying(255),
     category character varying(255)
 );

 -- Indices -------------------------------------------------------

 CREATE UNIQUE INDEX IF NOT EXISTS books_pkey ON books(id);