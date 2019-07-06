package appleterminal;

import org.junit.Test;
import org.mockito.Matchers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScriptBuilderTest {

    @Test
    public void testBuildScript() {
        ScriptBuilder scriptBuilder = new ScriptBuilder();
        Pane rooPane = mock(CompositePane.class);
        when(rooPane.generateScript()).thenReturn("##TEST##");
        when(rooPane.getName()).thenReturn("rootPane");

        String rs = scriptBuilder.build(rooPane);
        assertThat(rs, equalTo("tell application \"iTerm\"\n" +
                "tell current window\n" +
                "create tab with default profile\n" +
                "end tell\n" +
                "set rootPane to (current session of current window)\n" +
                "##TEST##\n" +
                "end tell"));
    }
}
