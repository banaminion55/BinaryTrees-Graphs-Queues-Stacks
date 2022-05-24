package IterationStation;

public class Ramen {

    private String broth, meat;
    private int volume;

    private static String[] brothNames = {"tonkotsu", "kimchi", "spicy mayo", "miso", "shoyu"};
    private static String[] meatNames = {"beef", "pork chashu", "chicken", "seafood"};

    public Ramen() {
        int randomBroth = (int)(Math.random()*brothNames.length);
        broth = brothNames[randomBroth];
        int randomMeat = (int)(Math.random()*meatNames.length);
        meat = meatNames[randomMeat];
        volume = (int)(1+Math.random()*5);
    }

    public Ramen(String broth, String meat, int volume) {
        this.broth = broth;
        this.meat = meat;
        this.volume = volume;
    }

    public String getBroth() {
        return broth;
    }

    public void setBroth(String broth) {
        this.broth = broth;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Ramen{" +
                "broth='" + broth + '\'' +
                ", meat='" + meat + '\'' +
                ", volume=" + volume +
                '}';
    }
}
