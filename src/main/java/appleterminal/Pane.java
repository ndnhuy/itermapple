package appleterminal;

import java.util.Iterator;

public interface Pane {
    String generateScript();
    String getName();
    String setName(String name);
    Iterator<Pane> childrenIterator();
    void addChild(Pane pane);
    void setVertically(boolean isVertically);
    boolean isVertically();
}
