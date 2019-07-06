import appleterminal.AtomicPane;
import appleterminal.CompositePane;
import appleterminal.ScriptBuilder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ScriptException {
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

        CompositePane p2_3 = new CompositePane();
        p2_3.addChild(new AtomicPane("a6"));
        p2_3.addChild(new AtomicPane("a7"));
        p2_3.addChild(new AtomicPane("a8"));
        p2_3.addChild(new AtomicPane("a9"));
        p2_3.addChild(new AtomicPane("a10"));
        p2_3.setVertically(false);
        p3.addChild(p2_3);

        ScriptBuilder scriptBuilder = new ScriptBuilder();

        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = engineManager.getEngineByName("AppleScript");
//        scriptEngine.eval(new BufferedReader(new FileReader(ClassLoader.getSystemResource("applescript").getFile())));
        scriptEngine.eval(new BufferedReader(new StringReader(scriptBuilder.build(p3))));

    }
}
