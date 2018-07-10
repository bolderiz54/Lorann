package view;

import static org.junit.Assert.*;

import java.awt.*;

import org.junit.Test;

import model.ModelFacade;




public class ViewFacadeTest {
	
	
	
	Rectangle view;
	
	@Test
	public void testViewFacade() {
		
		final int tailleX = 480;
		final int tailleY = 360;
		this.view = new Rectangle(0, 0, tailleX, tailleY);
		assertTrue(tailleX > 0);
		assertTrue(tailleY > 0);
	}

	@Test
	public void testGetInteract() {
		ModelFacade model = new ModelFacade(10, 0);
		final ViewFacade view = new ViewFacade(model);
		assertTrue(view.getInteract() instanceof Interact);
		
	}
	


	

}
