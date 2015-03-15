package gh.funthomas424242.webapp.books.web.pages;

public class RegisterPage extends StartSeite {


	@Override
	public String getPageUrl() {
		return SERVER_URL + serverPort + "/book/register";
	}

}
