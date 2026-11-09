package com.todos.pages;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.todos.utils.BasePage;

public class TodosPage extends BasePage {
    public TodosPage() throws IOException {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//input[@placeholder='What needs to be done?']")
    public WebElement inputText;

    @FindBy(how = How.XPATH, using = "//label[@data-testid='todo-item-label']")
    public WebElement todoText;

    @FindBy(how = How.XPATH, using = "//input[@class='toggle']")
    public WebElement checkBox;

    public void submitTodos(String todos) {
        inputText.clear();
        inputText.sendKeys(todos);
        inputText.sendKeys(Keys.ENTER);
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public String checkElementContain(WebElement element) {
        return element.getText();
    }

    public boolean isCheckBoxSelected(WebElement element) {
        return element.isSelected();
    }
}
