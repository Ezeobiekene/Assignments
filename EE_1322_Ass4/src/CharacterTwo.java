public class CharacterTwo extends Character {
    public CharacterTwo() {
        super("I bear the title \"The Concierge of Crime.\"", "Reymond Reddington");
    }

    @Override
    public String greeting() {
        return "Well hello there";
    }

    @Override
    public String getInformation() {
        return "My only gaol is to protect Elizabeth Keen and I will do anything to achieve that.";
    }

    @Override
    public String sayGoodbye() {
        return "Goodbye! It was nice talking to you";
    }
}
