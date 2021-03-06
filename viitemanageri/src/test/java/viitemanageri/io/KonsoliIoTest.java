
package viitemanageri.io;


import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author gabriel
 */
public class KonsoliIoTest {
    private Io io;
    private Scanner scanner;
    
    @Test
    public void lukuLuetaanOikein()
    {
        scanner = new Scanner("4");
        io = new KonsoliIo(scanner);
        assertEquals(4, io.lueInt(""));
    }
    
    @Test
    public void merkkijonoLuetaanOikein()
    {
        scanner = new Scanner("testi");
        io = new KonsoliIo(scanner);
        assertEquals("testi", io.lueString(""));
    }
    
    @Test
    public void printlnKutsutaanOikeallaArgumentilla(){
        PrintStream ps = mock(PrintStream.class);
        System.setOut(ps);
        scanner = new Scanner("testi");
        io = new KonsoliIo(scanner);
        io.tulosta("testString");
        verify(ps).println(eq("testString"));        
    }
}
