package appleterminal;

public abstract class AbstractPane implements Pane {
    protected String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String setName(String name) {
        return this.name = name;
    }

    @Override
    public boolean isVertically() {
        return false;
    }

    @Override
    public void setVertically(boolean isVertically) {
        // do nothing
    }
}
