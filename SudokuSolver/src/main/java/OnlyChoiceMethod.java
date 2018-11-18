public class OnlyChoiceMethod extends SolvingMethod {
    public OnlyChoiceMethod(){
        this.guess = false;
        this.onlyChoice = true;
        this.twins = false;
    }
    @Override
    public String toString() {
        return "OnlyChoice";
    }
}
