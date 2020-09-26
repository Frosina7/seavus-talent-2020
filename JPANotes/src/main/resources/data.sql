insert into "user" (id,username,password) values (101,'nikola','nikola');
insert into "user" (id,username,password) values (102,'stefi','stefi');
insert into "user" (id,username,password) values (103,'maja','maja');

insert into "note" (id,title,content,user_id) values (101,'Coding','Java',101);
insert into "note" (id,title,content,user_id) values (102,'Shopping','Food',102);
insert into "note" (id,title,content,user_id) values (103,'Running','Late',103);

insert into "tag" (id,name,user_id) values (101,'Programming',101);
insert into "tag" (id,name,user_id) values (102,'Shop',102);
insert into "tag" (id,name,user_id) values (103,'Sport',103);
insert into note_tags(note_id,tags_id) values (101,102);





