package test;

import java.lang.reflect.Type;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import jakarta.json.bind.JsonbException;
import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;

public class NonParsingMimeTypeJsonbDeserializer implements JsonbDeserializer<MimeType> {

	public MimeType deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
		try {
			return new MimeType("not", "parsed");
		} catch (MimeTypeParseException e) {
			throw new JsonbException("fail", e);
		}
	}

}
