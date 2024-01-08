-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-12-20 16:58:25.275

-- tables
-- Table: apartment
CREATE TABLE apartment (
                           id serial  NOT NULL,
                           building_id int  NOT NULL,
                           number int  NOT NULL,
                           floor int  NOT NULL,
                           number_of_rooms int  NOT NULL,
                           area int  NOT NULL,
                           balcony boolean  NOT NULL,
                           CONSTRAINT apartment_pk PRIMARY KEY (id)
);

-- Table: association
CREATE TABLE association (
                             id serial  NOT NULL,
                             building_id int  NOT NULL,
                             name varchar(255)  NOT NULL,
                             address varchar(255)  NOT NULL,
                             post_index varchar(255)  NOT NULL,
                             phone varchar(255)  NOT NULL,
                             email varchar(255)  NOT NULL,
                             reg_number varchar(255)  NOT NULL,
                             CONSTRAINT id PRIMARY KEY (id)
);

-- Table: building
CREATE TABLE building (
                          id serial  NOT NULL,
                          date_of_build date  NOT NULL,
                          cadastral varchar(255)  NOT NULL,
                          floors int  NOT NULL,
                          lift boolean  NOT NULL,
                          CONSTRAINT building_pk PRIMARY KEY (id)
);

-- Table: consumption
CREATE TABLE consumption (
                             id serial  NOT NULL,
                             created_by_resident_id int  NOT NULL,
                             apartment_id int  NOT NULL,
                             hot_water decimal(8,3)  NULL,
                             cold_water decimal(8,3)  NULL,
                             electricity decimal(8,3)  NULL,
                             gas decimal(8,3)  NULL,
                             created_at date  NOT NULL,
                             CONSTRAINT consumption_pk PRIMARY KEY (id)
);

-- Table: lift
CREATE TABLE lift (
                      id serial  NOT NULL,
                      building_id int  NOT NULL,
                      current_inspection date  NOT NULL,
                      next_inspection date  NOT NULL,
                      service_company varchar(255)  NOT NULL,
                      CONSTRAINT lift_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                         id serial  NOT NULL,
                         role_id int  NOT NULL,
                         username varchar(255)  NOT NULL,
                         password varchar(255)  NOT NULL,
                         CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: resident
CREATE TABLE resident (
                          id serial  NOT NULL,
                          user_id int  NOT NULL,
                          first_name varchar(255)  NOT NULL,
                          last_name varchar(255)  NOT NULL,
                          email varchar(255)  NOT NULL,
                          phone varchar(255)  NOT NULL,
                          birthdate date  NOT NULL,
                          status char(1)  NOT NULL,
                          CONSTRAINT resident_pk PRIMARY KEY (id)
);

-- Table: resident_apartment
CREATE TABLE resident_apartment (
                                    id serial  NOT NULL,
                                    apartment_id int  NOT NULL,
                                    resident_id int  NOT NULL,
                                    CONSTRAINT resident_apartment_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: apartment_building (table: apartment)
ALTER TABLE apartment ADD CONSTRAINT apartment_building
    FOREIGN KEY (building_id)
        REFERENCES building (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;


-- Reference: association_building (table: association)
ALTER TABLE association ADD CONSTRAINT association_building
    FOREIGN KEY (building_id)
        REFERENCES building (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: consumption_apartment (table: consumption)
ALTER TABLE consumption ADD CONSTRAINT consumption_apartment
    FOREIGN KEY (apartment_id)
        REFERENCES apartment (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: consumption_resident (table: consumption)
ALTER TABLE consumption ADD CONSTRAINT consumption_resident
    FOREIGN KEY (created_by_resident_id)
        REFERENCES resident (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: lift_building (table: lift)
ALTER TABLE lift ADD CONSTRAINT lift_building
    FOREIGN KEY (building_id)
        REFERENCES building (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: resident_apartment_apartment (table: resident_apartment)
ALTER TABLE resident_apartment ADD CONSTRAINT resident_apartment_apartment
    FOREIGN KEY (apartment_id)
        REFERENCES apartment (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: resident_apartment_resident (table: resident_apartment)
ALTER TABLE resident_apartment ADD CONSTRAINT resident_apartment_resident
    FOREIGN KEY (resident_id)
        REFERENCES resident (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: resident_user (table: resident)
ALTER TABLE resident ADD CONSTRAINT resident_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

-- changed 20231228-9:52

-- Добавление нового столбца "address" и "post_index" с типом данных VARCHAR(255) в таблицу "building"
ALTER TABLE building
    ADD COLUMN address VARCHAR(255);

ALTER TABLE building
    ADD COLUMN post_index VARCHAR(255);

-- Удаление столбца "address" и "post_index" из таблицы "association"
ALTER TABLE association
    DROP COLUMN address;

ALTER TABLE association
    DROP COLUMN post_index;

-- changed 20240108-19:05
--added new relation table resident_association

CREATE TABLE resident_association (
                                      id serial  NOT NULL,
                                      association_id int  NOT NULL,
                                      resident_id int  NOT NULL,
                                      CONSTRAINT resident_association_pk PRIMARY KEY (id)
);

-- Reference: resident_association_association (table: resident_association):)
ALTER TABLE resident_association ADD CONSTRAINT resident_association_association
    FOREIGN KEY (association_id)
        REFERENCES association (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: resident_association_resident (table: resident_association)
ALTER TABLE resident_association ADD CONSTRAINT resident_association_resident
    FOREIGN KEY (resident_id)
        REFERENCES resident (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
