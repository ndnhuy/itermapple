package appleterminal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositePane extends AbstractPane {

    public CompositePane() {}

    public CompositePane(String name) {
        this.name = name;
    }

    private List<Pane> panes = new ArrayList<>();
    private boolean isVertically;

    @Override
    public String generateScript() {
        StringBuilder sb = new StringBuilder();
        Iterator<Pane> iterator = panes.iterator();
        if (!iterator.hasNext()) {
            throw new RuntimeException("must have children");
        }
        genSplitScript(iterator, sb, iterator.next());
        panes.forEach(p -> sb.append(p.generateScript()).append("\n"));
        return sb.toString();
    }

    private void genSplitScript(Iterator<Pane> iter, StringBuilder sb, Pane currentPane) {
        if (!iter.hasNext()) {
            return;
        }
        Pane nextPane = iter.next();
        sb.append(String.format("tell %s \n", currentPane.getName()));
        sb.append(String.format("set %s to (", nextPane.getName()));
        if (this.isVertically) {
            sb.append("split vertically with default profile");
        } else {
            sb.append("split horizontally with default profile");
        }
        sb.append(")\n");
        genSplitScript(iter, sb, nextPane);
        sb.append("end tell\n");
    }

    @Override
    public Iterator<Pane> childrenIterator() {
        return panes.iterator();
    }

    public void setPanes(List<Pane> panes) {
        this.panes = panes;
    }

    @Override
    public void addChild(Pane pane) {
        if (panes.isEmpty()) {
            this.name = pane.getName();
        }
        panes.add(pane);
    }

    @Override
    public void setVertically(boolean isVertically) {
        this.isVertically = isVertically;
    }

    @Override
    public boolean isVertically() {
        return this.isVertically;
    }
}
