public class Question {
    private String text;
    private String answer;
    private int levelOfDifficulty;

    public Question(String newText, String newAnswer, int newLevelOfDifficult){
        text=newText;
        answer=newAnswer;
        levelOfDifficulty=newLevelOfDifficult;
    }

    public String getText(){
       return text;
    }

    public void setText(String newText){
        text=newText;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String newAnswer){
        answer=newAnswer;
    }

    public int getLevelOfDifficulty(){
        return levelOfDifficulty;
    }

    public void setLevelOfDifficulty(int newLevelOfDifficulty){
        levelOfDifficulty=newLevelOfDifficulty;
    }

    @Override
    public String toString(){
        return "Question:"+ text+"\nAnswer: " +answer+ "\nLevel of difficulty: "+levelOfDifficulty;
    }
}
