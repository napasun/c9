import pymysql

conn = pymysql.connect(
    user='root',
    passwd='test',
    host='localhost',
    db='test'
)

cur = conn.cursor()

cur.execute('DROP TABLE items')

cur.execute('''
    create table items (
        item_id INTEGER PRIMARY KEY auto_increment,
        name TEXT,
        price INTEGER
    )
''')

data = [('banana', 300),('mango', 640),('kiwi', 280)]

for i in data:
    cur.execute("insert into items(name, price) values(%s,%s)", i)

cur.execute("select * from items")

for row in cur.fetchall():
    print(row)