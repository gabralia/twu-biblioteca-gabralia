(1)
select member.name from book,checkout_item,member where book.title = "The Hobbit" and book.id = checkout_item.book_id and checkout_item.member_id = member.id;

(2)
select count(1) from member where id not in(select member_id from checkout_item);

(3)
select title from book where id not in (select book_id from checkout_item where book_id is not null)
union
select title from movie where id not in (select movie_id from checkout_item where movie_id is not null);

(4)
insert into book(id,title) values(11,"The Pragmatic Programmer");
insert into member(id,name) values(43,"Little Voice");
insert into checkout_item(member_id,book_id) values(43,11);
select member.name from book,checkout_item,member where book.title = "The Pragmatic Programmer" and book.id = checkout_item.book_id and checkout_item.member_id = member.id;

(5)
select name from member WHERE id in (select member_id from checkout_item group by member_id HAVING count(1)>1);