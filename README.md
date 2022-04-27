# project-deyoola_naomi_whitney
project-deyoola_naomi_whitney created by GitHub Classroom

# What user stories were completed this iteration?
We completed the necessary information for our application to properly function. A user can select items from a list of three products to add to their cart. Each item includes a listed names, prices, category, and descriptions of each item as well as giving the user the ability to see the total price of all items, the total number of items available with tax, add items, remove items, and get the total size of the cart. We also completed the chatbot, called BearBot, to chat with a customer and provide them with a promocode via an API link that generates random password combos (these password combos act as "promo codes"). We also created login form to login in a customer with an account to Bear Necessities with a username of "bearcustomer@wustl.edu" and password of "test".


# Is there anything that you implemented but doesn't currently work?
Right now, BearBot chatbot and Login page work perfectly as Java applications but we are figuring out the correct translations of commands to run via our shell script. Ideally, the command to run the Bearbot chatbot would be: java -cp bin BearBot.jar chatbot.Main. The command to run the login page: javac BearNecessitiesLoginPage.java or  javac -d  bin src/login/*.java [Pictured Below Are Pictures of both BearBot and Near Necessities Login Form]
![IMG_1771](https://user-images.githubusercontent.com/54600423/165544988-8b5c8940-6b41-4bbe-8add-9ece21b86cf2.jpg)
![IMG_1772](https://user-images.githubusercontent.com/54600423/165545002-61970fa4-f375-45cf-9f23-645ac1775b04.jpg)
![IMG_1773 2](https://user-images.githubusercontent.com/54600423/165545011-4d3aef47-fa48-4543-9d6a-83730dae2668.jpg)
![IMG_1779](https://user-images.githubusercontent.com/54600423/165545015-7960e4f1-5f51-4b36-be96-f87340af49bb.jpg)

# What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
The command needed to compile and run our code from the command (in order to select items for your cart): ./run_program.sh 
