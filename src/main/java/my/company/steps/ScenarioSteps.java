package my.company.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.company.pages.BasePageObject;
import java.util.LinkedHashMap;

public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    InsurancePageSteps insurancePageSteps = new InsurancePageSteps();
    InsuranceOfTravelersPageSteps insuranceOfTravelersPageSteps = new InsuranceOfTravelersPageSteps();
    SendDataPageSteps sendDataPageSteps = new SendDataPageSteps();
    LinkedHashMap<String, String> testData = new LinkedHashMap<>();

    @Given("Страница загружена")
    public void Test() {
        BaseSteps baseSteps = new BaseSteps();
        baseSteps.getDriver().get(baseSteps.baseUrl + "/");
    }

    @And("Закрыто сообщение с предупреждением Cookies")
    public void closeCookies() throws Throwable{
        mainPageSteps.closeCookies();
    }

    @And("Выбран элемент меню Страхование")
    public void selectMenuInsurance() throws Throwable{
        mainPageSteps.selectMenuInsurance();
    }

    @When("Нажатие на кнопку Онлайн")
            public  void getOnline(){
        insurancePageSteps.getOnline();
    }

    @Then("Заголовок страницы равен: Страхование путешественников")
            public void checkTitle(){
        insurancePageSteps.checkTitle();
    }

    @When("Нажать на ссылку Страхование путешественников")
            public void goToData(){
        insuranceOfTravelersPageSteps.goToData();
    }

    @Then("Открыть новое окно")
            public void openNewWindow(){
        BasePageObject.openNewWindow(BaseSteps.getDriver());
    }

    @And("Выбрать минимальную сумму страхования")
            public void getSumm(){
        sendDataPageSteps.getSumm();
    }

    @And("Нажать на кнопку")
            public void issue(){
        sendDataPageSteps.Issue();
    }

    @When("Заполнить поля данными")
    public void putTestData(){
        testData.put("Фамилия","Ivanov");
        testData.put( "Имя","Ivan");
        testData.put("Дата рождения", "01.01.1990");
        testData.put("Фамилия страхователя", "Петрова");
        testData.put("Имя страхователя", "Наталья");
        testData.put("Отчество страхователя", "Петровна");
        testData.put("Дата рождения страхователя", "01.01.2001");
        testData.put("Пол", "female");
        testData.put("Серия паспорта", "1234");
        testData.put("Номер паспорта", "123456");
        testData.put("Дата выдачи", "01.01.2000");
        testData.put("Место выдачи", "ОВД Красногорского района");

        sendDataPageSteps.fillFields(testData);
    }

    @Then("Поля заполнены корректно")
    public void checkFillFields(){
        testData = BasePageObject.clearElement("Пол", testData);
        sendDataPageSteps.checkFillFields(testData);
    }

    @When("Нажать на Продолжить")
        public void Continue() {
        sendDataPageSteps.Continue();
    }

     @Then("Отображается сообщение об ошибке: Заполнены не все обязательные поля")
     public void errorMessage(){
         sendDataPageSteps.errorMessage("Заполнены не все обязательные поля");
     }
}

