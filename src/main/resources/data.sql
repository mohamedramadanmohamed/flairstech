ALTER TABLE IF EXISTS city
    DROP CONSTRAINT IF EXISTS city_pkey CASCADE;

ALTER TABLE IF EXISTS country
    DROP CONSTRAINT IF EXISTS country_pkey CASCADE;

ALTER TABLE IF EXISTS city
    DROP CONSTRAINT IF EXISTS country_language_pkey CASCADE;

ALTER TABLE IF EXISTS country
    DROP CONSTRAINT IF EXISTS country_capital_fkey CASCADE;

ALTER TABLE IF EXISTS country_language
    DROP CONSTRAINT IF EXISTS country_language_country_code_fkey CASCADE;

DROP TABLE IF EXISTS city CASCADE;
DROP TABLE IF EXISTS country CASCADE;
DROP TABLE IF EXISTS country_language CASCADE;

CREATE TABLE country (
    code character(3) NOT NULL,
    name text NOT NULL,
    continent text NOT NULL,
    region text NOT NULL,
    surface_area real NOT NULL,
    indep_year smallint,
    population integer NOT NULL,
    life_expectancy real,
    gnp numeric(10,2),
    gnp_old numeric(10,2),
    local_name text NOT NULL,
    government_form text NOT NULL,
    head_of_state text,
    capital integer,
    code2 character(2) NOT NULL
);

CREATE TABLE city (
    id integer NOT NULL,
    name text NOT NULL,
    country_code character(3) NOT NULL,
    district text NOT NULL,
    population integer NOT NULL
);

CREATE TABLE country_language (
    country_code character(3) NOT NULL,
    "language" text NOT NULL,
    is_official boolean NOT NULL,
    percentage real NOT NULL
);

insert into country (code, name, continent, region, surface_area, indep_year, population, life_expectancy, gnp, gnp_old, local_name, government_form, head_of_state, capital, code2) 
			  values('AFG','Afghanistan','Asia','Southern and Central Asia',652090,1919,22720000,45.900002,5976.00,5976.00,'Afganistan/Afqanestan','Islamic Emirate','Mohammad Omar',1,'AF');
insert into city (id, name, country_code, district, population) 
	Values(1,'Kabul','AFG','Kabol',1780000);	  
insert into country_language (country_code, "language", is_official, percentage) values('AFG','Pashto',true,52.400002);
