abstract class Item {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Item(){
        title = " ";
    }

    public Item(String title){
        this.title = title;
    }

    public abstract String getListing();

    @Override
    public String toString(){
        return title;
    }
}