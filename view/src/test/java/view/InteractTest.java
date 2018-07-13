package view;

import view.Order;
import org.junit.Before;
import org.junit.Test;
import view.mock.ComponentMock;
import view.mock.ControllerMock;

import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

/**
 * Tests GameFrame class
 */
public class InteractTest {
	
	

    Interact t;
    ControllerMock c;

   /* @Before
    public void setUp() throws Exception {
        c = new ControllerMock();
        t = new Interact();
        t.setController(c);
    } */
    @Test 
    public void testIsKeyPressedChar() {
		Interact interact = new Interact();
		assertFalse(interact.isKeyPressed('a'));
	}
    
    @Test 
    public void testIsKeyPressedCode() {
		Interact interact = new Interact();
		assertFalse(interact.isKeyPressed(1));
	}

 /*   @Test
    public void testKeyPressedShouldUpCharacterUp() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_UP);
        this.t.keyPressed(e);
        assertEquals(Order.UP, c.getLastOrder());
        assertEquals(2, c.geti());
    }


    @Test
    public void testKeyPressedShouldLeftCharacterLeft() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_LEFT);
        this.t.keyPressed(e);
        assertEquals(Order.LEFT, c.getLastOrder());
        assertEquals(2, c.geti());
    }


    @Test
    public void testKeyPressedShouldLeftCharacterRight() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_RIGHT);
        this.t.keyPressed(e);
        assertEquals(Order.RIGHT, c.getLastOrder());
        assertEquals(2, c.geti());
    }

    @Test
    public void testKeyPressedShouldLeftCharacterDown() throws Exception {
        KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
        e.setKeyCode(KeyEvent.VK_DOWN);
        this.t.keyPressed(e);
        assertEquals(Order.DOWN, c.getLastOrder());
        assertEquals(2, c.geti());
    }

*/
}
