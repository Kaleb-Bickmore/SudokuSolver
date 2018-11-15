public class TwinsMethod extends SolvingMethod {
    public TwinsMethod(){
        this.guess = false;
        this.twins = true;
        this.triplets = false;
        this.onlyChoice = false;

    }
    @Override
    public String toString() {
        return "TwinsMethod";
    }
}
