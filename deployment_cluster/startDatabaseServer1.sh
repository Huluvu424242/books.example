#!/bin/sh
docker rm -f books_db1
docker run -d -p 1521:1521 -p 80:80 --name books_db1 funthomas424242/books.db
