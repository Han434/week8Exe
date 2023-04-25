import com.fasterxml.jackson.databind.ObjectMapper;
import com.petstore.Category;
import com.petstore.Pet;
import com.petstore.TagsItem;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testPetStore() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://petstore.swagger.io/v2/pet/4");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        Pet pet = objectMapper.readValue(response, Pet.class);
        assertEquals("laxfile", pet.getName());
    }
}