
-- INPUT DUMMY DATA FOR DEVELOPMENT

-- TESTING GET UNIT
INSERT INTO "user" (id, email, name, password) VALUES (1, 'user.unit.test', 'user.unit.test', 'user.unit.test');
INSERT INTO unit_group(id, description) VALUES (1, 'unit_group.unit.test');

INSERT INTO unit(id, description, id_unit_group) VALUES (1, 'unit.unit.test', 1);
INSERT INTO unit(id, description, id_unit_group) VALUES (2, 'unit.unit.test2', 1);

INSERT INTO privilege_group(id, description) VALUES (1, 'privilege_group');
INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (1, 1, 1);

--INSERT INTO enum_item(id, code, description) VALUES (1, 'enum_item.unit.test', 'enum_item.unit.test');
--INSERT INTO enum_item(id, code, description) VALUES (2, 'enum_item.unit.test2', 'enum_item.unit.test2');
--INSERT INTO privilege(id, id_enum_item) VALUES (1, 1);
--INSERT INTO privilege(id, id_enum_item) VALUES (2, 2);
--
--
---- connect privilege group to user2unit_group
--INSERT INTO privilege_group2user2unit_group(id_user2unit_group, id_privilege_group) VALUES (1, 1);
--
---- connect privilege to privilege group
--INSERT INTO privilege2privilege_group(id_privilege_group, id_privilege) VALUES (1, 1);
--INSERT INTO privilege2privilege_group(id_privilege_group, id_privilege) VALUES (1, 2);

-- create some "fake" units
INSERT INTO unit_group(id, description) VALUES (2, 'unit_group.unit.test.FAIL');
INSERT INTO unit(id, description, id_unit_group) VALUES (3, 'unit.unit.test.FAIL', 2);

-- create another user
INSERT INTO "user" (id, email, name, password) VALUES (2, 'user.unit.test2', 'user.unit.test2', 'user.unit.test2');
INSERT INTO unit_group(id, description) VALUES (3, 'unit_group.unit.test2');
INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (2, 3, 2);

-----------------------------------------------------------------------

-- TESTING POSITION
INSERT INTO "user" (id, email, name, password) VALUES (10, 'user.position.test10', 'user.position.test10', 'user.position.test10');
INSERT INTO unit_group(id, description) VALUES (10, 'unit_group.position.test10');

INSERT INTO unit(id, description, id_unit_group) VALUES (10, 'unit.position.test', 10);
INSERT INTO unit(id, description, id_unit_group) VALUES (11, 'unit.position.test2', 10);

INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (10, 10, 10);
INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (11, 10, 10);

INSERT INTO "position" (id, altitude, dop, speed, "timestamp", id_unit) VALUES (10, 10, 10.10, 10.10, current_timestamp, 10);
INSERT INTO "position" (id, altitude, dop, speed, "timestamp", id_unit) VALUES (11, 11, 11.11, 11.11, current_timestamp, 10);
INSERT INTO "position" (id, altitude, dop, speed, "timestamp", id_unit) VALUES (12, 12, 12.12, 12.12, current_timestamp, 10);
INSERT INTO "position" (id, altitude, dop, speed, "timestamp", id_unit) VALUES (13, 13, 13.13, 13.13, current_timestamp, 10);
INSERT INTO "position" (id, altitude, dop, speed, "timestamp", id_unit) VALUES (14, 14, 14.14, 14.14, current_timestamp, 10);

INSERT INTO "position" (id, altitude, dop, speed, "timestamp", id_unit) VALUES (15, 15, 15.15, 15.15, current_timestamp, 11);
INSERT INTO "position" (id, altitude, dop, speed, "timestamp", id_unit) VALUES (16, 16, 16.16, 16.16, current_timestamp, 11);
INSERT INTO "position" (id, altitude, dop, speed, "timestamp", id_unit) VALUES (17, 17, 17.17, 17.17, current_timestamp, 11);
INSERT INTO "position" (id, altitude, dop, speed, "timestamp", id_unit) VALUES (18, 18, 18.18, 18.18, current_timestamp, 11);
INSERT INTO "position" (id, altitude, dop, speed, "timestamp", id_unit) VALUES (19, 19, 19.19, 19.19, current_timestamp, 11);

-----------------------------------------------------------------------

-- TESTING PHENOMENON
INSERT INTO "user" (id, email, name, password) VALUES (20, 'user.phenomenon.test20', 'user.phenomenon.test20', 'user.phenomenon.test20');
INSERT INTO unit_group(id, description) VALUES (20, 'unit_group.phenomenon.test20');

INSERT INTO unit(id, description, id_unit_group) VALUES (20, 'unit.phenomenon.test', 20);
INSERT INTO unit(id, description, id_unit_group) VALUES (21, 'unit.phenomenon.test2', 20);

INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (20, 20, 20);

INSERT INTO phenomenon(id, description, physical_unit) VALUES (20, 'phenomenon.test20', 'phenomenon.test20');
INSERT INTO phenomenon(id, description, physical_unit) VALUES (21, 'phenomenon.test21', 'phenomenon.test21');
INSERT INTO phenomenon(id, description, physical_unit) VALUES (22, 'phenomenon.test22', 'phenomenon.test22');
INSERT INTO phenomenon(id, description, physical_unit) VALUES (23, 'phenomenon.test23', 'phenomenon.test23');

INSERT INTO metadata(id, code, description, value) VALUES (20, 'metadata.test20', 'metadata.test20', 20);

INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (20, 'sensor.phenomenon.test20', 20, 20, 20);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (21, 'sensor.phenomenon.test21', 20, 21, 20);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (22, 'sensor.phenomenon.test22', 20, 22, 21);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (23, 'sensor.phenomenon.test23', 20, 23, 21);

INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (24, 'sensor.phenomenon.test24', 20, 20, 21);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (26, 'sensor.phenomenon.test25', 20, 20, 20);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (27, 'sensor.phenomenon.test25', 20, 21, 20);

-- ADD FAKE UNIT with fake phenomenon
INSERT INTO unit_group(id, description) VALUES (21, 'unit_group.phenomenon.test21');
INSERT INTO unit(id, description, id_unit_group) VALUES (22, 'unit.phenomenon.test22', 21);

INSERT INTO phenomenon(id, description, physical_unit) VALUES (24, 'phenomenon.test24', 'phenomenon.test24');
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (28, 'sensor.phenomenon.test28', 20, 24, 22);

-----------------------------------------------------------------------

-- TESTING SENSORS
INSERT INTO "user" (id, email, name, password) VALUES (30, 'user.sensor.test30', 'user.sensor.test30', 'user.sensor.test30');
INSERT INTO unit_group(id, description) VALUES (30, 'unit_group.sensor.test30');

INSERT INTO unit(id, description, id_unit_group) VALUES (30, 'unit.sensor.test', 30);
INSERT INTO unit(id, description, id_unit_group) VALUES (31, 'unit.sensor.test2', 30);

INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (30, 30, 30);

INSERT INTO phenomenon(id, description, physical_unit) VALUES (30, 'sensor.test30', 'sensor.test30');
INSERT INTO phenomenon(id, description, physical_unit) VALUES (31, 'sensor.test31', 'sensor.test31');
INSERT INTO phenomenon(id, description, physical_unit) VALUES (32, 'sensor.test32', 'sensor.test32');
INSERT INTO phenomenon(id, description, physical_unit) VALUES (33, 'sensor.test33', 'sensor.test33');

INSERT INTO metadata(id, code, description, value) VALUES (30, 'sensor.metadata.test30', 'sensor.metadata.test30', 30);

INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (30, 'sensor.test30', 30, 30, 30);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (31, 'sensor.test31', 30, 31, 30);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (32, 'sensor.test32', 30, 32, 30);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (33, 'sensor.test33', 30, 33, 31);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (34, 'sensor.test34', 30, 33, 31);

-- ADD OBSERVATION
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (30, '2017-07-07T00:00:00', 30, 30);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (31, '2017-07-07T00:00:00', 30, 30);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (32, '2017-07-07T00:00:00', 30, 30);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (33, '2017-07-07T00:00:00', 30, 30);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (34, '2017-07-07T00:00:00', 30, 30);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (35, '2017-07-07T00:00:00', 30, 30);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (36, '2017-07-07T00:00:00', 30, 30);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (37, '2017-07-07T00:00:00', 30, 30);

-- ADD FAKE UNIT with fake sensor
INSERT INTO unit_group(id, description) VALUES (31, 'unit_group.sensor.test31');
INSERT INTO unit(id, description, id_unit_group) VALUES (32, 'unit.sensor.test32', 31);

INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (35, 'sensor.test35', 30, 30, 32);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (36, 'sensor.test36', 30, 30, 32);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (37, 'sensor.test37', 30, 31, 32);
-----------------------------------------------------------------------

-- TESTING OBSERVATION
INSERT INTO "user" (id, email, name, password) VALUES (40, 'user.observation.test40', 'user.observation.test40', 'user.observation.test40');
INSERT INTO unit_group(id, description) VALUES (40, 'unit_group.observation.test30');

INSERT INTO unit(id, description, id_unit_group) VALUES (40, 'unit.observation.test', 40);
INSERT INTO unit(id, description, id_unit_group) VALUES (41, 'unit.observation.test2', 40);

INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (40, 40, 40);

INSERT INTO phenomenon(id, description, physical_unit) VALUES (40, 'phenomenon.observation.test40', 'phenomenon.observation.test40');
INSERT INTO metadata(id, code, description, value) VALUES (40, 'metadata.observation.test40', 'metadata.observation.test40', 40);

INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (40, 'sensor.observation.test40', 40, 40, 40);
INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (41, 'sensor.observation.test41', 40, 40, 40);

-- ADD OBSERVATION
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (40, '2017-07-07T00:00:00', 40, 40);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (41, '2017-07-07T01:01:01', 40, 40);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (42, '2017-07-07T02:02:02', 40, 40);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (43, '2017-07-07T03:03:03', 40, 40);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (44, '2018-08-08T04:04:04', 40, 41);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (45, '2018-08-08T05:05:05', 40, 41);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (46, '2018-08-08T06:06:06', 40, 41);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (47, '2018-08-08T07:07:07', 40, 41);
INSERT INTO observation(id, "timestamp", value, id_sensor) VALUES (48, '2018-08-08T08:08:08+2', 40, 41);

-----------------------------------------------------------------------

-- TESTING EVENT
INSERT INTO "user" (id, email, name, password) VALUES (50, 'user.event.test50', 'user.event.test50', 'user.event.test50');
INSERT INTO "user" (id, email, name, password) VALUES (51, 'user.event.test51', 'user.event.test51', 'user.event.test51');

INSERT INTO unit_group(id, description) VALUES (50, 'unit_group.event.test50');
INSERT INTO unit_group(id, description) VALUES (51, 'unit_group.event.test51');

INSERT INTO unit(id, description, id_unit_group) VALUES (50, 'unit.event.test', 50);
INSERT INTO unit(id, description, id_unit_group) VALUES (51, 'unit.event.test2', 50);

INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (50, 50, 50);
INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (51, 51, 51);

INSERT INTO enum_item(id, code, description) VALUES (50, 'event.status.unprocessed', 'event.status.unprocessed');

INSERT INTO event_code(id, code, description) VALUES (50, 'event.running', 'event of heartbeat');

INSERT INTO event(id, "timestamp", id_enum_item, id_event_code, id_unit) VALUES (50, '2010-01-01T00:00:00', 50, 50, 50);
INSERT INTO event(id, "timestamp", id_enum_item, id_event_code, id_unit) VALUES (51, '2011-01-01T01:01:01', 50, 50, 50);
INSERT INTO event(id, "timestamp", id_enum_item, id_event_code, id_unit) VALUES (52, '2012-02-02T00:00:00', 50, 50, 50);
INSERT INTO event(id, "timestamp", id_enum_item, id_event_code, id_unit) VALUES (53, '2013-03-03T00:00:00', 50, 50, 50);

INSERT INTO event(id, "timestamp", id_enum_item, id_event_code, id_unit) VALUES (54, '2014-04-04T00:00:00', 50, 50, 51);
INSERT INTO event(id, "timestamp", id_enum_item, id_event_code, id_unit) VALUES (55, '2015-05-05T00:00:00', 50, 50, 51);
INSERT INTO event(id, "timestamp", id_enum_item, id_event_code, id_unit) VALUES (56, '2016-06-06T00:00:00', 50, 50, 51);
INSERT INTO event(id, "timestamp", id_enum_item, id_event_code, id_unit) VALUES (57, '2017-07-07T00:00:00', 50, 50, 51);

-----------------------------------------------------------------------

-- TESTING ENUM ITEM
INSERT INTO "user" (id, email, name, password) VALUES (60, 'user.event.test60', 'user.event.test60', 'user.event.test60');

INSERT INTO enum_item(id, code, description)VALUES (60, 'enum.test60', 'enum.test60');
INSERT INTO enum_item(id, code, description)VALUES (61, 'enum.test61', 'enum.test61');
INSERT INTO enum_item(id, code, description)VALUES (62, 'enum.test62', 'enum.test62');
INSERT INTO enum_item(id, code, description)VALUES (63, 'enum.test63', 'enum.test63');


-----------------------------------------------------------------------

-- TESTING EVENT CODE
INSERT INTO "user" (id, email, name, password) VALUES (70, 'user.event.test70', 'user.event.test70', 'user.event.test70');

INSERT INTO enum_item(id, code, description)VALUES (70, 'enum.test70', 'enum.test70');
INSERT INTO enum_item(id, code, description)VALUES (71, 'enum.test71', 'enum.test71');
INSERT INTO enum_item(id, code, description)VALUES (72, 'enum.test72', 'enum.test72');
INSERT INTO enum_item(id, code, description)VALUES (73, 'enum.test73', 'enum.test73');
-----------------------------------------------------------------------

-- TESTING UNIT GROUP
INSERT INTO "user" (id, email, name, password) VALUES (80, 'user.unit_group.test80', 'user.unit_group.test80', 'user.unit_group.test80');
INSERT INTO "user" (id, email, name, password) VALUES (81, 'user.unit_group.test81', 'user.unit_group.test81', 'user.unit_group.test81');

INSERT INTO unit_group(id, description) VALUES (80, 'user.unit_group.test80');
INSERT INTO unit_group(id, description) VALUES (81, 'user.unit_group.test81');
INSERT INTO unit_group(id, description) VALUES (82, 'user.unit_group.test82');
INSERT INTO unit_group(id, description) VALUES (83, 'user.unit_group.test83');

INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (80, 80, 80);
INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (81, 81, 81);
INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (82, 82, 80);
INSERT INTO user2unit_group(id, id_unit_group, id_user) VALUES (83, 83, 80);

INSERT INTO unit(id, description, id_unit_group) VALUES (80, 'user.event.test80', 80);
INSERT INTO unit(id, description, id_unit_group) VALUES (81, 'user.event.test81', 80);
INSERT INTO unit(id, description, id_unit_group) VALUES (82, 'user.event.test82', 80);
INSERT INTO unit(id, description, id_unit_group) VALUES (83, 'user.event.test83', 80);

INSERT INTO unit(id, description, id_unit_group) VALUES (84, 'user.event.test84', 81);
INSERT INTO unit(id, description, id_unit_group) VALUES (85, 'user.event.test85', 81);

INSERT INTO unit(id, description, id_unit_group) VALUES (86, 'user.event.test86', 82);

INSERT INTO unit(id, description, id_unit_group) VALUES (87, 'user.event.test87', 83);

-----------------------------------------------------------------------

-- TESTING METADATA
INSERT INTO "user" (id, email, name, password) VALUES (90, 'user.metadata.test90', 'user.metadata.test90', 'user.metadata.test90');

INSERT INTO metadata(id, code, description, value) VALUES (90, 'metadata.test90', 'metadata.test90', 90);
INSERT INTO metadata(id, code, description, value) VALUES (91, 'metadata.test91', 'metadata.test91', 91);
INSERT INTO metadata(id, code, description, value) VALUES (92, 'metadata.test92', 'metadata.test92', 92);
INSERT INTO metadata(id, code, description, value) VALUES (93, 'metadata.test93', 'metadata.test93', 93);


-----------------------------------------------------------------------