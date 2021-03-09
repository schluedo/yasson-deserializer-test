import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbConfig;
import javax.json.bind.spi.JsonbProvider;

import org.junit.Test;

import test.FlexibleMimeTypeJsonbDeserializer;
import test.NonParsingMimeTypeJsonbDeserializer;
import test.StaticMimeTypeJsonbDeserializer;

public class JsonbDeserializingTest {

	@Test
	public void testFlexibleMimeTypeJsonbDeserializer() throws Exception {
		System.out.println("parse with FlexibleMimeTypeJsonbDeserializer");
		JsonbConfig config = new JsonbConfig().withDeserializers(new FlexibleMimeTypeJsonbDeserializer()).withNullValues(true);
		Jsonb jsonb = JsonbProvider.provider().create().withConfig(config).build();
		parseAllFiles(jsonb);
	}

	@Test
	public void testNonParsingMimeTypeJsonbDeserializer() throws Exception {
		System.out.println("parse with NonParsingMimeTypeJsonbDeserializer");
		JsonbConfig config = new JsonbConfig().withDeserializers(new NonParsingMimeTypeJsonbDeserializer()).withNullValues(true);
		Jsonb jsonb = JsonbProvider.provider().create().withConfig(config).build();
		parseAllFiles(jsonb);
	}

	@Test
	public void testStaticMimeTypeJsonbDeserializer() throws Exception {
		System.out.println("parse with StaticMimeTypeJsonbDeserializer");
		JsonbConfig config = new JsonbConfig().withDeserializers(new StaticMimeTypeJsonbDeserializer()).withNullValues(true);
		Jsonb jsonb = JsonbProvider.provider().create().withConfig(config).build();
		parseAllFiles(jsonb);
	}
	
	public void parseAllFiles(Jsonb jsonb) throws Exception {
		parseJson(jsonb, "mimeTypesOnlyObjectFirst.json");
		parseJson(jsonb, "mimeTypesOnlyStringFirst.json");
		parseJson(jsonb, "mimeTypesFirst.json");
		parseJson(jsonb, "mimeTypesLast.json");
		
	}
	
	
	private TestObject parseJson(Jsonb jsonb, String filename) throws Exception {
		Path filePath = Paths.get("src/test/resources/").resolve(filename);
		try (InputStream is = Files.newInputStream(filePath)){
			TestObject testObject = jsonb.fromJson(is, TestObject.class);
			System.out.println("parsed from " + filename + ": " + testObject);
			return testObject;
		}
		
	}
}
