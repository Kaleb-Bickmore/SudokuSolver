public class GuessMethod extends SolvingMethod {
    public GuessMethod(){
        this.guess = true;
        this.onlyChoice = true;
        this.twins = false;
    }
    @Override
    public String toString() {
        return "BackTrack";
    }
}
