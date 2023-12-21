-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
-- DROP SCHEMA public_test CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA public3
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA public3 TO neighbor;
GRANT ALL ON SCHEMA public3 TO PUBLIC;

