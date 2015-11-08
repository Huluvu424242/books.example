#!/bin/sh
docker rm -f books_db
docker run -d -p 1521:1521 -p 80:80 --name books_db funthomas424242/books.db
