public class Horse {
    int number;
    String name;
    String jockey;
    String odds;

    public Horse() {
    }

    public Horse(int number, String name, String jockey, String odds) {
        this.number = number;
        this.name = name;
        this.jockey = jockey;
        this.odds = odds;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }
}
