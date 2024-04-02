public class CharacterThree extends Character {

    public CharacterThree() {
        super("I am known for my intuition and being a man of few words.", "Leroy Jethro Gibbs");
    }

    @Override
    public String greeting() {
        return "Hello";
    }

    @Override
    public String getInformation() {
        return "I killed the man responsible for the death of my wife and daughter.";
    }

    @Override
    public String sayGoodbye() {
        return "bye";
    }
}
