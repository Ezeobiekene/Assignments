public class CharacterOne extends Character{

    public CharacterOne() {
        super("I work in the behavioral unit of the FBI, I speak multiple languages and my IQ is 187.", "Spencer Reid");
    }

    @Override
    public String greeting() {
        return "Hello, I'm late for work.";
    }

    @Override
    public String getInformation() {
        return "My mother struggles with Schizophrenia and I might face the same fate.";
    }

    @Override
    public String sayGoodbye() {
        return "Bye, that was a lovely conversation.";
    }
}
