import sqlite3

dbpath = "test.sqlite"
conn = sqlite3.connect(dbpath)

cur = conn.cursor()
cur.executescript("""
drop table if exists items;

create table items(
    item_id integer primary key,
    name text unique,
    price integer
);

insert into items(name, price) values('apple', 800);
insert into items(name, price) values('orange', 700);
insert into items(name, price) values('banana', 900);
""")

conn.commit()

cur = conn.cursor()
cur.execute("select * from items")
item_list = cur.fetchall()

for it in item_list:
    print(it)