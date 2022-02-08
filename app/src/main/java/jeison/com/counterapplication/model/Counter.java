package jeison.com.counterapplication.model;

public class Counter {
    private String definition;
    private int counterTime;

    public Counter(String definition, int counterTime) {
        this.definition = definition;
        this.counterTime = counterTime;
    }
    
    public String getDefinition() {
        return definition;
    }

    public int getCounterTime() {
        return counterTime;
    }
}
