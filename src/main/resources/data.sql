
-- INPUT DUMMY DATA FOR DEVELOPMENT


-- USER GROUP
-----------------------------------------------------------------------
INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 1, 'testing_group', NULL);

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 2, 'testing_group_child', 1);

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 3, 'testing_group_child_second', 1);

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 4, 'testing_group_child_third',  2);

-- USER
-----------------------------------------------------------------------

INSERT INTO "user"(
            id, audio, lang, module_administrator, module_log_book, name,
            password, real_name, group_id)
    VALUES ( 1, false, 'CZ', true, true, 'test', 'test', 'test real', 1);

INSERT INTO "user"(
            id, audio, lang, module_administrator, module_log_book, name,
            password, real_name, group_id)
    VALUES ( 2, false, 'CZ', true, true, 'test2', 'test', 'test real', 3);

-- UNIT
-----------------------------------------------------------------------

INSERT INTO unit(
            id, description, is_mobile)
    VALUES ( 1, 'unit test', false);

INSERT INTO unit(
            id, description, is_mobile)
    VALUES ( 2, 'big unit', false);

INSERT INTO unit(
        id, description, is_mobile)
    VALUES ( 3, 'third big unit', true);

-- UNIT TO GROUP
-----------------------------------------------------------------------

INSERT INTO unit_to_group(
            id, unit_id, user_group_id)
    VALUES (1, 1, 1);

INSERT INTO unit_to_group(
            id, unit_id, user_group_id)
    VALUES (2, 2, 1);

INSERT INTO unit_to_group(
            id, unit_id, user_group_id)
    VALUES (3, 3, 1);

-- POSITION
-----------------------------------------------------------------------

INSERT INTO "position"(
            id, altitude, dop, speed, time_received, time_stamp, unit_id)
    VALUES (1, 1.1, 1.2, 1.3, '2017-09-14T03:34:13', '2017-09-14T03:34:13', 1);

INSERT INTO "position"(
            id, altitude, dop, speed, time_received, time_stamp, unit_id)
    VALUES (2, 1.6, 1.7, 1.8, '2017-09-14T03:34:13', '2017-09-14T03:34:13', 1);

INSERT INTO "position"(
            id, altitude, dop, speed, time_received, time_stamp, unit_id)
    VALUES (3, 999, 999, 999, '2018-03-30T03:33:33', '2018-03-30T03:33:33', 1);

INSERT INTO "position"(
            id, altitude, dop, speed, time_received, time_stamp, unit_id)
    VALUES (4, 999, 999, 999, '2018-01-11T01:11:11', '2018-01-11T01:11:11', 1);

INSERT INTO "position"(
            id, altitude, dop, speed, time_received, time_stamp, unit_id)
    VALUES (5, 999, 999, 999, '2018-02-22T02:22:22', '2018-02-22T02:22:22', 3);

-- PHENOMENON
-----------------------------------------------------------------------

INSERT INTO phenomenon(id, name, unit_desc)
    VALUES ( 1, 'first phenom', '1 m/s');

INSERT INTO phenomenon(id, name, unit_desc)
    VALUES ( 2, 'second phenom', '2 m/s');

INSERT INTO phenomenon(id, name, unit_desc)
    VALUES ( 3, 'third phenom', '3 m/s');

INSERT INTO phenomenon(id, name, unit_desc)
    VALUES ( 4, '4 phenom', '3 m/s');

-- SENSOR
-----------------------------------------------------------------------

INSERT INTO sensor(id, name, type, phenomenon_id, unit_id)
    VALUES ( 1, 'sensor1', 'test_sensor for 1 unit', 1, 1);

INSERT INTO sensor(id, name, type, phenomenon_id, unit_id)
    VALUES ( 2, 'sensor2', 'test_sensor for 2 unit', 2, 2);

INSERT INTO sensor(id, name, type, phenomenon_id, unit_id)
    VALUES ( 3, 'sensor3', 'test_sensor for 3 unit', 3, 3);

INSERT INTO sensor(id, name, type, phenomenon_id, unit_id)
    VALUES ( 4, 'sensor4', 'test_sensor for 3 unit', 4, 3);

-- OBSERVATION
-----------------------------------------------------------------------

INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
    VALUES ( nextval('seq_observation'), 123, '2018-02-22T02:22:22', '2018-02-22T02:22:22', 1);

INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
    VALUES ( nextval('seq_observation'), 145, '2018-03-03T03:33:33', '2018-03-03T03:33:33', 1);

INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
    VALUES ( nextval('seq_observation'), 167, '2018-04-04T04:44:44', '2018-04-04T04:44:44', 1);

INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
    VALUES ( nextval('seq_observation'), 189, '2018-05-05T05:55:55', '2018-05-05T05:55:55', 1);

INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
    VALUES ( nextval('seq_observation'), 212, '2018-01-01T01:01:01', '2018-01-01T01:01:01', 2);

INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
    VALUES ( nextval('seq_observation'), 213, '2018-02-02T02:02:02', '2018-02-02T02:02:02', 2);

INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
    VALUES ( nextval('seq_observation'), 214, '2018-03-03T03:03:03', '2018-02-03T03:03:03', 2);