import javax.activation.MimeType;

public class TestObject {

	private MimeType mimeTypeString;
	private MimeType mimeTypeObject;
	private String string1;
	private String string2;
	
	public MimeType getMimeTypeString() {
		return mimeTypeString;
	}
	public void setMimeTypeString(MimeType mimeTypeString) {
		this.mimeTypeString = mimeTypeString;
	}
	public MimeType getMimeTypeObject() {
		return mimeTypeObject;
	}
	public void setMimeTypeObject(MimeType mimeTypeObject) {
		this.mimeTypeObject = mimeTypeObject;
	}
	public String getString1() {
		return string1;
	}
	public void setString1(String string1) {
		this.string1 = string1;
	}
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	@Override
	public String toString() {
		return "TestObject [mimeTypeObject=" + mimeTypeObject + ", mimeTypeString=" + mimeTypeString + ", string1="
				+ string1 + ", string2=" + string2 + "]";
	}
	
	
}
