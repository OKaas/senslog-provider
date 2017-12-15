
-- INPUT DUMMY DATA FOR DEVELOPMENT

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 1, 'testing_group', NULL);

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 2, 'testing_group_child', 1);

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 3, 'testing_group_child_second', 1);

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 4, 'testing_group_child_third',  2);

INSERT INTO "user"(
            id, audio, lang, module_administrator, module_log_book, name,
            password, real_name, group_id)
    VALUES ( 1, false, 'CZ', true, true, 'test', 'test', 'test real', 1);

INSERT INTO "user"(
            id, audio, lang, module_administrator, module_log_book, name,
            password, real_name, group_id)
    VALUES ( 2, false, 'CZ', true, true, 'test2', 'test', 'test real', 3);

INSERT INTO unit(
            id, description, is_mobile)
    VALUES ( 1, 'unit test', false);

INSERT INTO unit(
            id, description, is_mobile)
    VALUES ( 2, 'big unit', false);

INSERT INTO unit(
        id, description, is_mobile)
    VALUES ( 3, 'third big unit', true);

INSERT INTO unit_to_group(
            id, unit_id, user_group_id)
    VALUES (1, 1, 1);

INSERT INTO unit_to_group(
            id, unit_id, user_group_id)
    VALUES (2, 2, 1);

INSERT INTO unit_to_group(
            id, unit_id, user_group_id)
    VALUES (3, 3, 1);

INSERT INTO "position"(
            id, altitude, dop, speed, time_received, time_stamp, unit_id)
    VALUES (1, 1.1, 1.2, 1.3, '2017-09-14T03:34:13', '2017-09-14T03:34:13', 1);

INSERT INTO "position"(
            id, altitude, dop, speed, time_received, time_stamp, unit_id)
    VALUES (2, 1.6, 1.7, 1.8, '2017-09-14T03:34:13', '2017-09-14T03:34:13', 1);


--INSERT INTO phenomenonReceive(id, username, unit_desc)
--    VALUES ( 1, 'speed', 'm/s');
--
--INSERT INTO sensorReceive (id, username, type, phenomenon_id)
--    VALUES ( nextval('seq_sensor'), 'sensor1', 'test_sensor', 1);

--INSERT INTO unit_holder(id, address, email, icon_id, username, phone, www)
--    VALUES ( 1, 'test', 'test', 0, 'test', 'test', 'test');

--INSERT INTO unit (id, description, holder_id, is_mobile) values
--( 1, 'testing unit', 1, FALSE );

--INSERT INTO unit_position(id, altitude, dop, first_time_stamp, speed, time_received, time_stamp, unit_id)
--    VALUES (1, '1', '1', '2017-06-08 11:00:00', '1', '2017-06-08 11:00:00', '2017-06-08 11:00:00', 1);
--
--INSERT INTO unit_to_group(id, unit_id, group_id)
--    VALUES ( nextval('seq_unit_to_group'), 1, 1);

