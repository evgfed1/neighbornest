INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'user');

INSERT INTO public."user" (id, role_id, username, password) VALUES (DEFAULT, 1, 'Evgeny', '123');
INSERT INTO public."user" (id, role_id, username, password) VALUES (DEFAULT, 1, 'Anton', '123');

INSERT INTO public.resident (id, user_id, first_name, last_name, email, phone, birthdate, status) VALUES (DEFAULT, 1, 'Evgeny', 'Fedotov', 'evgy@gmail.com', '+37255678902', '1993-02-09', 'A');
INSERT INTO public.resident (id, user_id, first_name, last_name, email, phone, birthdate, status) VALUES (DEFAULT, 2, 'Anton', 'Kovaltsuk', 'kovaljski@gmail.com', '+37255618162', '1985-11-06', 'A');

INSERT INTO public.association (id, building_id, name, phone, email, reg_number) VALUES (DEFAULT, 1, 'Jupako KU', '+372 555555555', 'neighbornest@jupako.ee', 'REG12345');

UPDATE building
SET address = 'Õismäe tee 109'
WHERE id = 1;

UPDATE building
SET post_index = '13519'
WHERE id = 1;

INSERT INTO public.consumption (id, created_by_resident_id, apartment_id, hot_water, cold_water, electricity, gas, created_at) VALUES (DEFAULT, 1, 1, (23.155), (97.341), (51.537), Null, '2023-05-30');
INSERT INTO public.consumption (id, created_by_resident_id, apartment_id, hot_water, cold_water, electricity, gas, created_at) VALUES (DEFAULT, 2, 2, (34.429), (101.548), (42.473), Null, '2023-05-28');

INSERT INTO public.apartment (id, building_id, number, floor, number_of_rooms, area, balcony) VALUES (DEFAULT, 1, 25, 5, 4, 92, true);
INSERT INTO public.apartment (id, building_id, number, floor, number_of_rooms, area, balcony) VALUES (DEFAULT, 1, 23, 4, 3, 78, true);

INSERT INTO public.resident_apartment (id, apartment_id, resident_id) VALUES (DEFAULT, 1, 2);
INSERT INTO public.resident_apartment (id, apartment_id, resident_id) VALUES (DEFAULT, 2, 1);