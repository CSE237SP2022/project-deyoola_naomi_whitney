#!/bin/bash
#Run Program
javac -d bin src/catalog/*.java
java -cp bin catalog.Cart
