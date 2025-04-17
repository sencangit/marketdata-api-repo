SELECT name FROM sys.schemas;

--1. Create schema
CREATE SCHEMA market_data;

--2. Create tables
-- Entity table
CREATE TABLE market_data.entity_details (
    entity_id INT IDENTITY(1,1) PRIMARY KEY,
    entity_name NVARCHAR(255) NOT NULL,
    country NVARCHAR(100),
	create_dt DATETIME DEFAULT GETDATE()
);

-- Market Products table
CREATE TABLE market_data.market_products (
    product_id INT IDENTITY(1,1) PRIMARY KEY,
    entity_id INT NOT NULL,
    ticker_name NVARCHAR(10) UNIQUE NOT NULL,
    price_date DATETIME NOT NULL,
    price DECIMAL(18,4),
	create_dt DATETIME DEFAULT GETDATE()    
);


-- Market Rating Agencies table
CREATE TABLE market_data.rating_agencies (
    agency_id INT IDENTITY(1,1) PRIMARY KEY,
    agency_name NVARCHAR(100) NOT NULL UNIQUE,
	create_dt DATETIME DEFAULT GETDATE()
);

-- Market Credit Ratings table
CREATE TABLE market_data.credit_ratings (
    rating_id INT IDENTITY(1,1) PRIMARY KEY,
    product_id INT,
    agency_id INT NOT NULL,
    rating NVARCHAR(10) NOT NULL, -- e.g., 'A', 'B', etc.
    review NVARCHAR(50),         -- e.g., 'Stable', 'Negative'
	create_dt DATETIME DEFAULT GETDATE()
);


--3. Create indexes
-- Fast lookup by ticker
CREATE NONCLUSTERED INDEX IX1_market_products_ticker ON market_data.market_products(ticker_name);

--4. Adding constraints to this

-- Adding foreign key constraints to market_products table
ALTER TABLE market_data.market_products
ADD CONSTRAINT FK1_market_products_entity_details
FOREIGN KEY (entity_id)
REFERENCES market_data.entity_details(entity_id);

-- Adding foreign key constraints to credit_ratings table
ALTER TABLE market_data.credit_ratings
ADD CONSTRAINT FK1_credit_ratings_market_products
FOREIGN KEY (product_id)
REFERENCES market_data.market_products(product_id);

ALTER TABLE market_data.credit_ratings
ADD CONSTRAINT FK3_credit_ratings_rating_agencies
FOREIGN KEY (agency_id)
REFERENCES market_data.rating_agencies(agency_id);

---- Creation ends here-----

select * from market_data.entity_details;

select * from market_data.market_products;

select * from market_data.rating_agencies;

select * from market_data.credit_ratings;



drop table market_data.market_products;

drop table market_data.entity_details;

drop table market_data.credit_ratings;

drop table [market_data].[rating_agencies];

SELECT 
    f.name AS ForeignKey,
    OBJECT_NAME(f.parent_object_id) AS TableName
FROM sys.foreign_keys AS f
WHERE f.referenced_object_id = OBJECT_ID('market_data.entity_details');

-- Step 2: Drop the foreign key
ALTER TABLE market_data.market_products
DROP CONSTRAINT FKn4b8hmiot5jp4x7q1a32vs6xc;


SELECT TOP (1000) * FROM [market_data].[market_products]

SELECT TOP (1000) * FROM [market_data].[entity_details]

SELECT TOP (1000) * FROM [market_data].[rating_agencies]

SELECT TOP (1000) * FROM [market_data].[credit_ratings]

-- Inserts
--entity_details
INSERT INTO [market_data].[entity_details] (entity_name, country)
VALUES ('IBM', 'USA');

INSERT INTO [market_data].[entity_details] (entity_name, country)
VALUES ('Manulife', 'Canada');

--rating_agencies
INSERT INTO [market_data].[rating_agencies] (agency_name)
VALUES ('S&P Global');

INSERT INTO [market_data].[rating_agencies] (agency_name)
VALUES ('Fitch');

--market_products
INSERT INTO [market_data].[market_products] (entity_id, ticker_name, price_date, price)
VALUES (1, 'IBM.N', '04/04/2025', '100.12');