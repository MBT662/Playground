CC = gcc
LIBS = /usr/lib/x86_64-linux-gnu/libcunit.so.1.0.1 `pkg-config --libs openssl` 
CFLAGS = -I. -g -w -I./.. `pkg-config --cflags openssl`
CDIR = ./src/crypto
BINDIR = ./bin
TESTDIR = ./src/tests

all: 
	$(CC) $(CFLAGS) $(TESTDIR)/hashcash_test.c \
	$(CDIR)/hashcash.c $(LIBS) -o $(BINDIR)/hashcash_test

clean:
	rm -f $(BINDIR)/hashcash_test $(TDIR)/*.orig 

test: 
	./bin/hashcash_test
	 
	