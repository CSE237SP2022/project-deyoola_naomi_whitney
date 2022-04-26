package chatbot;

public class Keyword {

    public String keyword = "";
    public String target = "";
    public String className = "";
    public String arg = "";
    public String variable = "";
    public String variableValue = "";
    public String learnWord = "";
    public int score = 0;

   
    public Keyword(String keyword, String target, String className, String arg, String variable, int score, String learnWord) {
        this.keyword = keyword;
        this.target = target;
        this.className = className;
        this.arg = arg;
        this.variable = variable;
        this.score = score;
        this.learnWord = learnWord;
    }
}