--Create Keyspace for the app
--CREATE KEYSPACE coin_mx WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

--Create Keyspace table for books
CREATE TABLE coin_mx.books_available (
  id UUID PRIMARY KEY,
  book_code text,
  book_description text,
  book_currency text
);

--Insert available books
INSERT INTO coin_mx.books_available(id, book_code, book_description, book_currency) VALUES (uuid(), 'btc_mxn', 'Bitcoin', 'mx');
INSERT INTO coin_mx.books_available(id, book_code, book_description, book_currency) VALUES (uuid(), 'eth_mxn', 'Ethereum', 'mx');
INSERT INTO coin_mx.books_available(id, book_code, book_description, book_currency) VALUES (uuid(), 'xrp_mxn', 'Ripple', 'mx');
INSERT INTO coin_mx.books_available(id, book_code, book_description, book_currency) VALUES (uuid(), 'ltc_mxn', 'Litecoin', 'mx');
INSERT INTO coin_mx.books_available(id, book_code, book_description, book_currency) VALUES (uuid(), 'tusd_mxn', 'True USD', 'mx');
INSERT INTO coin_mx.books_available(id, book_code, book_description, book_currency) VALUES (uuid(), 'mana_mxn', 'Decentraland', 'mx');
INSERT INTO coin_mx.books_available(id, book_code, book_description, book_currency) VALUES (uuid(), 'gnt_mxn', 'Golem', 'mx');
INSERT INTO coin_mx.books_available(id, book_code, book_description, book_currency) VALUES (uuid(), 'bat_mxn', 'Basic Attention Token', 'mx');

--Validate inserted rows
--SELECT * FROM coin_mx.books_available;