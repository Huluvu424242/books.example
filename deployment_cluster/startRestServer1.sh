#!/bin/sh
docker rm -f books_app1
docker run -d --name books_app1 -p 8081:8080 -v /tmp/rootlogs:/tmp --link books_db1:books_db  funthomas424242/books.app
