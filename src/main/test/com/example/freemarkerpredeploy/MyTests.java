package com.example.freemarkerpredeploy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@WebAppConfiguration
public class MyTests {

	@Autowired
	WebApplicationContext context;

	WebClient webClient;

	@Before
	public void setup() {
		webClient = MockMvcWebClientBuilder.webAppContextSetup(context).build();
		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
	}

	@Test
	public void superTest() throws Exception {

		HtmlPage page = webClient.getPage("http://localhost:8080");
		HtmlTextInput messageText = page.getHtmlElementById("msg");
		messageText.setValueAttribute("blymie");

		HtmlForm form = page.getForms().get(0);
		HtmlSubmitInput submit = form.getOneHtmlElementByAttribute("input", "type", "submit");
		HtmlPage newPage = submit.click();

		String receivedText = newPage.getHtmlElementById("received").getTextContent();
		System.out.println(receivedText);
	}

}
