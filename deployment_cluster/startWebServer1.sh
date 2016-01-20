#!/bin/sh
docker rm -f books_web1
docker run -d --name books_web1 -p 9000:9000 -v /tmp/rootlogs:/tmp --link books_app1:localhost  funthomas424242/books.web

