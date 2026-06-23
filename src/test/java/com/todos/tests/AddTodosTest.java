package com.todos.tests;

import java.io.IOException;
import static org.testng.Assert.assertTrue; 
import static org.testng.Assert.assertFalse; 
import org.testng.annotations.Test;

import com.todos.pages.TodosPage;
import com.todos.utils.Setup;

public class AddTodosTest extends Setup {

	public AddTodosTest() throws IOException {
		super();
		
	}
	TodosPage todosPage;
	@Test(priority = 1)
	public void iCanAddTodos () throws IOException {
		todosPage = new TodosPage();
		Boolean TodoField = todosPage.isElementDisplayed(TodosPage.inputText);
		assertTrue(TodoField);
		todosPage.submitTodos(prop.getProperty("todos1"));
		
	String elementTodo =todosPage.checkElementContain(TodosPage.todoText);
	assertTrue(elementTodo.contains(prop.getProperty("todos1")));
		
	Boolean checkBox =todosPage.isCheckBoxSelected(TodosPage.checkBox);
	assertFalse(checkBox);
	}

}
