#!/bin/bash
#Run Program
javac -d bin src/catalog/*.java
java -cp bin catalog.Cart
java -cp project-deyoola_naomi_whitney.jar chatbot.Main