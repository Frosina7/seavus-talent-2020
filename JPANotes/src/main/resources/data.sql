insert into "user" (id,username,password) values (101,'nikola','nikola');
insert into "user" (id,username,password) values (102,'lina','lina');
insert into "user" (id,username,password) values (103,'monika','monika');

insert into "note" (id,title,content,user_id) values (101,'Coding','Java',101);
insert into "note" (id,title,content,user_id) values (102,'Shopping','Food',101);
insert into "note" (id,title,content,user_id) values (103,'Running','In nature',101);
insert into "note" (id,title,content,user_id) values (104,'Reading','Refactoring',102);
insert into "note" (id,title,content,user_id) values (105,'Shopping','Shoes,Dresses,Shirts',102);

insert into "tag" (id,name,user_id) values (101,'programming',101);
insert into "tag" (id,name,user_id) values (102,'shop',101);
insert into "tag" (id,name,user_id) values (103,'sport',101);
insert into "tag" (id,name,user_id) values (104,'studing',101);
insert into note_tags(note_id,tags_id) values (101,101);
insert into note_tags(note_id,tags_id) values (102,102);
insert into note_tags(note_id,tags_id) values (103,103);




