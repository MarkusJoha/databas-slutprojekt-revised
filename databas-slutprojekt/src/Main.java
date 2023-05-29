import models.TableCreator;
import views.Menu;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        TableCreator.createTables();
        Menu.performAction();
    }
}
