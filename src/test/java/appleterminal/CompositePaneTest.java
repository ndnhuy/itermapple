package appleterminal;

import org.junit.Test;

public class CompositePaneTest {

    @Test
    public void shouldGenerateScriptCorrectly() {
        CompositePane p1 = new CompositePane();
        p1.addChild(new AtomicPane("a1"));
        p1.addChild(new AtomicPane("a2"));
        p1.setVertically(true);

        CompositePane p2_1 = new CompositePane();
        p2_1.addChild(p1);
        p2_1.addChild(new AtomicPane("a3"));
        p2_1.setVertically(false);

        CompositePane p2_2 = new CompositePane();
        p2_2.addChild(new AtomicPane("a4"));
        p2_2.addChild(new AtomicPane("a5"));
        p2_2.setVertically(false);

        CompositePane p3 = new CompositePane();
        p3.addChild(p2_1);
        p3.addChild(p2_2);
        p3.setVertically(true);
        p3.addChild(new AtomicPane("a6"));

        System.out.println(p3.generateScript());
    }
}
