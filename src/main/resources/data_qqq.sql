-- INPUT DUMMY DATA FOR DEVELOPMENT

INSERT INTO "groups" (id, group_name, has_children, parent_group_id ) VALUES
( 1, 'testing_group', FALSE, NULL);

INSERT INTO system_users (user_id, user_password, user_name, user_real_name, groups_id ) VALUES
( nextval('seq_system_user'), 'ADD_AES_SHA256_OR_SOMETHING!!!!', 'userQQ', 'userQQ', 1);