
public class TestObjectContainer {

	private TestObject testObject1;
	private TestObject testObject2;
	private String containerAttribute1;
	private String containerAttribute2;
	public TestObject getTestObject1() {
		return testObject1;
	}
	public void setTestObject1(TestObject testObject1) {
		this.testObject1 = testObject1;
	}
	public TestObject getTestObject2() {
		return testObject2;
	}
	public void setTestObject2(TestObject testObject2) {
		this.testObject2 = testObject2;
	}
	public String getContainerAttribute1() {
		return containerAttribute1;
	}
	public void setContainerAttribute1(String containerAttribute1) {
		this.containerAttribute1 = containerAttribute1;
	}
	public String getContainerAttribute2() {
		return containerAttribute2;
	}
	public void setContainerAttribute2(String containerAttribute2) {
		this.containerAttribute2 = containerAttribute2;
	}
	@Override
	public String toString() {
		return "TestObjectContainer [testObject1=" + testObject1 + ", testObject2=" + testObject2
				+ ", containerAttribute1=" + containerAttribute1 + ", containerAttribute2=" + containerAttribute2 + "]";
	}
	
	
}
