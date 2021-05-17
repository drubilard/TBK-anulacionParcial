package Pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import commons.Browser;
import commons.Configuration;
import commons.WebAutomator;

public class LoginTBKPage extends LoadableComponent<LoginTBKPage> {
	private WebAutomator automator;
	@FindBy(id = "UsuarioRut")
	private WebElement usuarioLocator;
	@FindBy(id = "PasswordClient")
	private WebElement passLocator;
	@FindBy(xpath = "//*[@id=\"loginIn\"]/div[3]/button")
	private WebElement submitLocator;
	@FindBy(id = "list-companies")
	private WebElement listCompaniasLocator;
	@FindBy(id = "btn-companies")
	private WebElement submitOrganizacionLocator;
	@FindBy(xpath = "/html/body/table[2]/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr[1]/td/div/table/tbody/tr/td")
	private WebElement transaccionesLocator;
	@FindBy(xpath = "/html/body/table[2]/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr[15]/td/table/tbody/tr/td[1]")
	private WebElement anulacionesLocator;
	@FindBy (xpath="/html/body/table[2]/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td/div/iframe")
	private WebElement iframeAnulacionesLocator;
	@FindBy(css = "a[href=\"anulaciones.html\"]")
	private WebElement solicitaranuLocator;
	@FindBy (id="ticket")
	private WebElement inputTicketLocator;
	@FindBy (css="button[id=btn-codigo-comercio]")
	private WebElement botonLocalLocator;
	@FindBy (css="input[id='cod-auto']")
	private WebElement buscadorLocalLocator;
	@FindBy (linkText="29724172 - LAN CARGA ATO BALMACEDA (CLP)")
	private WebElement localAnulacionLocator;
	@FindBy (id="fecha")
	private WebElement fechaAnulacionLocator;
	@FindBy (id="buscar")
	private WebElement botonBuscarAnulacionLocator;
	@FindBy (css="#anulaciones > tbody > tr:nth-child(1) > td:nth-child(1) > div > input")
	private WebElement registroAnularLocator;
	@FindBy (linkText = "Solicitar (1) anulación")
	private WebElement botonSolicitarAnulacionLocator;
	@FindBy (name = "monto")
	private WebElement inputMontoAnulacionLocator;
	@FindBy (id ="anular-ventas-btn")
	private WebElement botonAnularLocator;	
	@FindBy (id ="confirmarSolicitud")
	private WebElement botonConfirmarAnularLocator;
	
	public LoginTBKPage(Browser browser) throws Exception {
		automator = new WebAutomator(browser);
		PageFactory.initElements(automator.getDriver(), this);

	}

	public WebAutomator getAutomator() {
		return this.automator;
	}

	public void login() {
		automator.type(usuarioLocator, Configuration.USER);
		automator.type(passLocator, Configuration.PASSWORD);
		automator.click(submitLocator);

	}

	public void selectOrganizacion() {
		automator.waitUntilPresent(listCompaniasLocator, 10);
		Select select = new Select(listCompaniasLocator);
		select.selectByValue(Configuration.ORGANIZACION);
		automator.click(submitOrganizacionLocator);

	}

	public void selectMenuAnulaciones() {
		automator.waitUntilClickable(transaccionesLocator, 15);
		automator.click(transaccionesLocator);
		automator.waitUntilClickable(anulacionesLocator, 5);
		automator.click(anulacionesLocator);
	}

	public void solicitarAnulacion() {
		automator.waitUntilClickable(iframeAnulacionesLocator, 15);
		automator.switchToIframe(iframeAnulacionesLocator);
		automator.waitUntilClickable(solicitaranuLocator, 20);
		automator.clickJs(solicitaranuLocator);
		
	}
	public void generarAnulacion() {
		automator.waitUntilClickable(fechaAnulacionLocator,15);
		automator.type(fechaAnulacionLocator,Configuration.FECHAANULACION);
		automator.waitUntilClickable(botonLocalLocator, 20);
		automator.clickJs(botonLocalLocator);
		automator.waitUntilPresent(buscadorLocalLocator,15);
		automator.type(buscadorLocalLocator,Configuration.LOCALANULACION);
		automator.click(localAnulacionLocator,15);
		automator.click(botonBuscarAnulacionLocator,15);
		automator.click(registroAnularLocator,15);
		automator.click(botonSolicitarAnulacionLocator,15);
		automator.waitUntilPresent(inputMontoAnulacionLocator, 15);
		automator.type(inputMontoAnulacionLocator, "12");
		automator.click(botonAnularLocator,15);
		automator.click(botonConfirmarAnularLocator,15);

		
	}
	
	@Override
	protected void load() {
		automator.visit(Configuration.APP_URL);
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(automator.getTitle().equals("Acceso Clientes - Transbank S.A."), "Page not loaded");
	}

}
