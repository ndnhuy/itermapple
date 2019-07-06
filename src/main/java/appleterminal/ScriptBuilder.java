package appleterminal;

public class ScriptBuilder {
    public String build(Pane rootPane) {
        StringBuilder sb = new StringBuilder();
        sb.append("tell application \"iTerm\"\n" +
                "tell current window\n" +
                "create tab with default profile\n" +
                "end tell\n");

        sb.append(String.format("set %s to (current session of current window)\n", rootPane.getName()));
        sb.append(rootPane.generateScript());
        sb.append("\nend tell");
        return sb.toString();
    }
}
