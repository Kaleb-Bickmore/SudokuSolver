public class GuessMethod extends SolvingMethod {
    public GuessMethod(){
        this.guess = true;
        this.onlyChoice = false;
        this.triplets = false;
        this.twins = false;
    }
    @Override
    public String toString() {
        return "GuessMethod";
    }
}
