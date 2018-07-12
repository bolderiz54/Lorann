package view;

import controller.IController;
import model.IModel;
import controller.Order;

public abstract class ControllerMock implements IController {

    Order last;
    int i;

    public Order getLastOrder(){
        return last;
    }
    public int geti() {
    	return i;
    }

    public void setModel(IModel model) {
        // UNUSED METHOD
    }

    public void start() {
        // UNUSED METHOD
    }


}
