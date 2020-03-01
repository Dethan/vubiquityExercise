package test;

import org.testng.annotations.Test;

import java.io.IOException;
import org.testng.Assert;
import utils.BaseRequest;

public class RequestTest extends BaseRequest{
	
	//Planee usar org.JSON para leer y convertir el archivo ubicado en Test Data en un JSONOBject, pero tuve problemas 
	String userInfo =  "{\n\"name\":\"Juan Camaney\",\n\"salary\":\"666\",\n\"age\":\"234\"\n}";
	
	@Test
	public void validateNewUSerCreated() throws IOException {
			String postResponse = usersRequests().sendNewUserPost(userInfo);
			Assert.assertTrue(postResponse.contains("httpCode:200"));
			System.out.println(postResponse);
			//Hardcoded test ID, el metodo GET no envia nada, replique la request con los mismo valores en Postam ysi funciona, la respuesta del endpoint no me da pistas  de que esta fallando
			String getResponse = usersRequests().getNewUserById("72");
			System.out.println(getResponse);

	}

}
