FROM ubuntu:latest
LABEL authors="guillaume"

ENTRYPOINT ["top", "-b"]