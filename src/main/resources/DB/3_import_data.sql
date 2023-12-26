INSERT INTO role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO role (id, name) VALUES (DEFAULT, 'user');
INSERT INTO building (id, date_of_build, cadastral, floors, lift) VALUES (DEFAULT, '2023-01-01', 12345, 5, true);
INSERT INTO apartment (id, building_id, number, floor, number_of_rooms, area, balcony) VALUES (DEFAULT, 1, 23, 4, 3, 78, true);
INSERT INTO apartment (id, building_id, number, floor, number_of_rooms, area, balcony) VALUES (DEFAULT, 1, 25, 5, 4, 92, true);
INSERT INTO "user" (id, role_id, username, password) VALUES (DEFAULT, 1, 'Evgeny', '123');
INSERT INTO "user" (id, role_id, username, password) VALUES (DEFAULT, 1, 'Anton', '123');
INSERT INTO association (id, building_id, name, address, post_index, phone, email, reg_number) VALUES (DEFAULT, 1, 'Jupako KU', 'Õismäe tee 109 - 46', '13519', '+372 555555555', 'neighbornest@jupako.ee', 'REG12345');
INSERT INTO resident (id, user_id, first_name, last_name, email, phone, birthdate, status) VALUES (DEFAULT, 1, 'Evgeny', 'Fedotov', 'evgy@gmail.com', '+37255678902', '1993-02-09', 'A');
INSERT INTO resident (id, user_id, first_name, last_name, email, phone, birthdate, status) VALUES (DEFAULT, 2, 'Anton', 'Kovaltsuk', 'kovaljski@gmail.com', '+37255618162', '1985-11-06', 'A');
INSERT INTO consumption (id, created_by_resident_id, apartment_id, hot_water, cold_water, electricity, gas, created_at) VALUES (DEFAULT, 1, 1, (23.155), (97.341), (51.537), Null, '2023-05-30');
INSERT INTO consumption (id, created_by_resident_id, apartment_id, hot_water, cold_water, electricity, gas, created_at) VALUES (DEFAULT, 2, 2, (34.429), (101.548), (42.473), Null, '2023-05-28');
INSERT INTO resident_apartment (id, apartment_id, resident_id) VALUES (DEFAULT, 1, 2);
INSERT INTO resident_apartment (id, apartment_id, resident_id) VALUES (DEFAULT, 2, 1);
INSERT INTO lift (id, building_id, current_inspection, next_inspection, service_company) VALUES (DEFAULT, 1, '2023-12-21', '2024-12-21', 'KONE')
