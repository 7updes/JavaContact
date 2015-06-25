insert into contact (id, first_name, last_name, birth_date) values (1, 'Misha', 'Krug', '1952-02-03');
insert into contact (id, first_name, last_name, birth_date) values (2, 'Boris', 'Burda', '1957-01-11');
insert into contact (id, first_name, last_name, birth_date) values (3, 'Merlyn', 'Manson', '1969-12-09');
insert into contact (id, first_name, last_name, birth_date) values (4, 'Edgar', 'Zapashniy', '1952-02-03');

insert into hobby (id, title, description) values (1,'Circus', 'Actor of circus');
insert into hobby (id, title, description) values (2,'Music', 'Singing');
insert into hobby (id, title, description) values (3,'Science', 'smart people');
insert into hobby (id, title, description) values (4,'Cinema', 'TVs actor');

insert into place (id, title, description) values (1,'MOST-CITY', 'shopping');
insert into place (id, title, description) values (2,'Dafi', 'relax');
insert into place (id, title, description) values (3,'karavan', 'relax');

insert into contact_hobby (contact_id, hobby_id) values (1, 2);
insert into contact_hobby (contact_id, hobby_id) values (2, 3);
insert into contact_hobby (contact_id, hobby_id) values (2, 4);
insert into contact_hobby (contact_id, hobby_id) values (3, 2);
insert into contact_hobby (contact_id, hobby_id) values (4, 1);
insert into contact_hobby (contact_id, hobby_id) values (4, 4);

insert into contact_place (contact_id, place_id) values (1, 2);
insert into contact_place (contact_id, place_id) values (1, 1);
insert into contact_place (contact_id, place_id) values (2, 3);
insert into contact_place (contact_id, place_id) values (3, 3);
insert into contact_place (contact_id, place_id) values (2, 1);

insert into contact_friendship (contact_id, friend_id) values (1, 2);
insert into contact_friendship (contact_id, friend_id) values (1, 4);
insert into contact_friendship (contact_id, friend_id) values (2, 4);
insert into contact_friendship (contact_id, friend_id) values (3, 4);

insert into message (message_time, content, contact_from_id, contact_to_id) values (CURRENT_TIMESTAMP , 'wazzup niga', 1, 2);
insert into message (message_time, content, contact_from_id, contact_to_id) values (CURRENT_TIMESTAMP, 'yoyo', 2, 1);
insert into message (message_time, content, contact_from_id, contact_to_id) values (CURRENT_TIMESTAMP, 'what time ? ', 1, 4);
insert into message (message_time, content, contact_from_id, contact_to_id) values (CURRENT_TIMESTAMP, '5 oclock', 4, 1);