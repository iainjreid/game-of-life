COMPILER = ghc -Wall
MAIN = main

all: target clean start

target:
	$(COMPILER) -o $(MAIN) $(MAIN).hs

clean:
	rm $(MAIN).hi $(MAIN).o

start:
	./$(MAIN)
