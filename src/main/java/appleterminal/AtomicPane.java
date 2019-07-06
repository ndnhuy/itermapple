package appleterminal;

import java.util.ArrayList;
import java.util.Iterator;

public class AtomicPane extends AbstractPane {

    public AtomicPane() {}

    public AtomicPane(String name) {
        this.name = name;
    }

    @Override
    public String generateScript() {
        StringBuilder sb = new StringBuilder();
        sb.append("tell ").append(this.name).append("\n");
        sb.append("set name to \"").append(this.name).append("\"").append("\n");
        sb.append("end tell").append("\n");
        return sb.toString();
    }

    @Override
    public Iterator<Pane> childrenIterator() {
        return new ArrayList<Pane>().iterator();
    }

    @Override
    public void addChild(Pane pane) {
        // do nothing
    }
}
