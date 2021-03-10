package test;

import java.lang.reflect.Type;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.bind.JsonbException;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;

/**
 * this Deserializer sall be able to read plain mimeType-string AND/OR mimeType-object-structure
 * 
 *
 */
public class FlexibleMimeTypeJsonbDeserializer implements JsonbDeserializer<MimeType> {

	public MimeType deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
		JsonValue jsonValue = parser.getValue();
		try {
			
			switch (jsonValue.getValueType()) {
			case STRING:
				String str = ((JsonString)jsonValue).getString();
				return new MimeType(str);
			case OBJECT:
				JsonObject jsonObject = jsonValue.asJsonObject();
				String primary = jsonObject.getString("primary");
				String sub = jsonObject.getString("sub");
				return new MimeType(primary, sub);
			default:
				throw new JsonbException("not supported!");
			}
		} catch (MimeTypeParseException e) {
			throw new JsonbException("fail", e);
		}
	}

}
