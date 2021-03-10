package test;

import java.lang.reflect.Type;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.json.bind.JsonbException;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;

/**
 * this Deserializer just calls {@link JsonParser#getValue()} (and returns a special MimeType to see when it was applied)
 *
 */
public class StaticMimeTypeJsonbDeserializer implements JsonbDeserializer<MimeType> {

	public MimeType deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
		//could be object or string:
		parser.getValue();
		try {
			return new MimeType("static", "static");
		} catch (MimeTypeParseException e) {
			throw new JsonbException("fail", e);
		}
	}

}
