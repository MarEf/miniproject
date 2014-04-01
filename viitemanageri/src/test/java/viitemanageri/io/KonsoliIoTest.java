/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viitemanageri.io;

import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabriel
 */
public class KonsoliIoTest {
    Io io;
    Scanner scanner;
    
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
}
