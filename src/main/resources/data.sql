
-- INPUT DUMMY DATA FOR DEVELOPMENT

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 1, 'testing_group', NULL);

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 2, 'testing_group_child', 1);

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 3, 'testing_group_child_second', 1);

INSERT INTO user_group (id, name, parent_group_id ) VALUES
( 4, 'testing_group_child_third',  2);

--INSERT INTO "user" (id, password, name, real_name, group_id ) VALUES
--( nextval('seq_user'), 'ADD_AES_SHA256_OR_SOMETHING!!!!', 'userQQ', 'userQQ', 2);
--
--INSERT INTO phenomenon(id, name, unit_desc)
--    VALUES ( 1, 'speed', 'm/s');
--
--INSERT INTO sensor (id, name, type, phenomenon_id)
--    VALUES ( nextval('seq_sensor'), 'sensor1', 'test_sensor', 1);

--INSERT INTO unit_holder(id, address, email, icon_id, name, phone, www)
--    VALUES ( 1, 'test', 'test', 0, 'test', 'test', 'test');

--INSERT INTO unit (id, description, holder_id, is_mobile) values
--( 1, 'testing unit', 1, FALSE );

--INSERT INTO unit_position(id, altitude, dop, first_time_stamp, speed, time_received, time_stamp, unit_id)
--    VALUES (1, '1', '1', '2017-06-08 11:00:00', '1', '2017-06-08 11:00:00', '2017-06-08 11:00:00', 1);
--
--INSERT INTO unit_to_group(id, unit_id, group_id)
--    VALUES ( nextval('seq_unit_to_group'), 1, 1);

