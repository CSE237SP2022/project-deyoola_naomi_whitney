#!/bin/bash
#Run Program
if [ ! -d "bin" ]; then
	mkdir bin
	chmod 777 bin
fi
javac -d bin src/catalog/*.java
java -cp bin catalog.CatalogItem
