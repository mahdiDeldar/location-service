create table location_service.locations
(
    id                bigint primary key,
    name              varchar(255),
    ascii_name        varchar(255),
    alternate_names   text,
    latitude          float8,
    longitude         float8,
    feature_class     varchar(5),
    feature_code      varchar(5),
    country_code      varchar(5),
    cc2               varchar(255),
    admin1_code       varchar(255),
    admin2_code       varchar(255),
    admin3_code       varchar(255),
    admin4_code       varchar(255),
    population        bigint,
    elevation         varchar(255),
    dem               varchar(255),
    timezone          varchar(30),
    modification_date varchar(30)
);

create table location_service.countries
(
    id                   bigint primary key references location_service.locations (id),
    iso                  varchar(2),
    iso3                 varchar(3),
    iso_numeric          varchar(3),
    fips                 varchar(2),
    capital              varchar(255),
    continent            varchar(30),
    tld                  varchar(30),
    currency_code        varchar(30),
    currency_name        varchar(30),
    phone                varchar(30),
    postal_code_format   varchar(255),
    postal_code_regex    varchar(255),
    languages            varchar(255),
    neighbours           varchar(255),
    equivalent_fips_code varchar(255)

);

create index locations_country_code_feature_code on location_service.locations (country_code, feature_code);
create index locations_country_code_feature_code_adm1 on location_service.locations (country_code, feature_code, admin1_code);
