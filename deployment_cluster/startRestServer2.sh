#!/bin/sh
docker rm -f books_app2
docker run -d --name books_app2 -p 8080:8080 -v /tmp/rootlogs:/tmp --link books_db1:books_db  funthomas424242/books.app

