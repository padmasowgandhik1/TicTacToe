public class Player {
    private final int id;
    private final String name;
    private final char symbol;

    public Player(final int id, final String name, final char symbol){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public String getDetails(){
        return this.id + "." + this.name + "(" + this.symbol + ") ";
    }

    public char getSymbol(){
        return this.symbol;
    }

    public String getName(){
        return this.name;
    }
}
