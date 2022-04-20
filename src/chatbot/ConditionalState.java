package chatbot;


// fetch random conditional state messages
public String fetchMessage() {
    Random generator = new Random();
    return messages.get(generator.nextInt(messages.size()));
}