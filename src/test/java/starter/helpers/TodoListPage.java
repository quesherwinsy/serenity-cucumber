package starter.helpers;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://todomvc.com/examples/angularjs/#/")
public class TodoListPage extends PageObject {
    // @DefaultUrl annotation specifies the URL that needs to be typed in the browser's address bar
    // PageObject. This contains all the information we will need to use a particular web page.
    // ITEM_NAME_FIELD and ITEMS_LIST that help identify specific HTML elements on the pag
    public static Target ITEM_NAME_FIELD = Target.the("item name field").locatedBy(".new-todo");

    public static Target ITEMS_LIST = Target.the(" item list").locatedBy(".todo-list li");
}
