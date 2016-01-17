#!/bin/sh
#docker rm -f books_db
#docker run -d -p 1521:1521 -p 80:80 --name books_db funthomas424242/books.db

docker rm -f books_app
docker run -d --name books_app -p 8080:8080 -v /tmp/rootlogs:/tmp --link books_db:books_db  funthomas424242/books.app

docker rm -f books_web
docker run -d --name books_web -p 9000:9000 -v /tmp/rootlogs:/tmp --link books_app:localhost  funthomas424242/books.web

