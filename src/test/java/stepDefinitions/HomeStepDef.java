package stepDefinitions;

import browserManager.BrowersManager;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomeStepDef {
    WebDriver driver = BrowersManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 60);
    @Then("^En la pagina home debo ver el usuario \"([^\"]*)\"$")
    public void en_la_pagina_home_debo_ver_el_usuario(String user) {
        String actualUser = userLabel().getAttribute("innerText");
        Assert.assertTrue(actualUser.contains(user),"El usuario no esta logueado");
    }

    @Then("^Cierro session$")
    public void cerrar_session() {
        seleccionarOpcionEnUserDropdown("Sign Out");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Sign In')]")));
    }


    @When("^Lleno el campo search con \"([^\"]*)\"$")
    public void llenarSearchTextBox(String curso){
        searchTextBox().sendKeys(curso);
        searchTextBox().sendKeys(Keys.ENTER);
        /*Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();*/
    }

    @Then("^El curso \"([^\"]*)\" debe ser mostrado en home page$")
    public void verificarCursoEnHome(String curso){
        try{
            driver.findElement(By.xpath("//h4[contains(text(),'"+curso+"')]"));
        } catch(Exception e){
            Assert.fail("El curso: "+curso+" no fue mostrado");
        }
    }
    @Then("^Cierro sesion$")
    public void cierro_sesion() {
        seleccionarOpcionEnUserDropdown("Sign Out");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sign In')]")));
    }

    @Then("^hacer click \"([^\"]*)\"$")
    public void hacerClick(String ingresar )  {
        WebElement clik= driver.findElement(By.xpath("//a[contains(text(),'"+ingresar+"')]"));
        clik.click();
    }

    @Then("^hacer click en \"([^\"]*)\" para ingresar curso$")
    public void hacerClickEnParaIngresarCurso(String infoCurso){
        WebElement ingresoCurso= driver.findElement(By.xpath("//h4[contains(text(),'"+infoCurso+"')]"));
        ingresoCurso.click();
    }

    @Then("^verificar que el precio \"([^\"]*)\" sea correcto$")
    public void verificarQueElPrecioSeaCorrecto(String infPrecio){
        WebElement verficarprecio= driver.findElement(By.xpath("//a[contains(text(),'"+infPrecio+"')]"));
        String actualMensaje = verficarprecio.getAttribute("innerText");
        Assert.assertTrue(actualMensaje.contains(infPrecio),"el mensaje es correcto");
    }

    private WebElement userLabel(){
        return driver.findElement(By.xpath("//*[@id='my_account']/span"));
    }

    private  WebElement searchTextBox(){
        return driver.findElement(By.cssSelector("#search-form > div.col-sm-4.col-sm-offset-2.products__search-box > input"));
    }

    private void seleccionarOpcionEnUserDropdown(String option){
        userLabel().click();
        //ul[@class='dropdown-menu']/li/a[contains(text(),'My Account')]
      //  WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@class='dropdown-menu']/li/a[contains(text(),'"+option+"')]")));
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[contains(text(),'"+option+"')]")).click();
        //jsExecutor
    }


}
