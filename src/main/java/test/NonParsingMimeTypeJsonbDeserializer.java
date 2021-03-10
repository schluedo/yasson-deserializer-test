package test;

import java.lang.reflect.Type;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.json.bind.JsonbException;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;

/**
 * this Deserializer does in fact nothing (but returns a special MimeType to see when it was applied)
 *
 */
public class NonParsingMimeTypeJsonbDeserializer implements JsonbDeserializer<MimeType> {

	public MimeType deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
		try {
			return new MimeType("not", "parsed");
		} catch (MimeTypeParseException e) {
			throw new JsonbException("fail", e);
		}
	}

}
