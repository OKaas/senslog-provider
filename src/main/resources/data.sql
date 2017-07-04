-- INPUT DUMMY DATA FOR DEVELOPMENT

INSERT INTO user_group (id, name, has_children, parent_group_id ) VALUES
( 1, 'testing_group', TRUE, NULL);

INSERT INTO user_group (id, name, has_children, parent_group_id ) VALUES
( 2, 'testing_group_child', FALSE, 1);

INSERT INTO "user" (id, password, name, real_name, group_id ) VALUES
( nextval('seq_user'), 'ADD_AES_SHA256_OR_SOMETHING!!!!', 'userQQ', 'userQQ', 2);