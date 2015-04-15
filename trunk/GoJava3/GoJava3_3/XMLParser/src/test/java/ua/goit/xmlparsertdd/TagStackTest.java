package ua.goit.xmlparsertdd;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;


public class TagStackTest {
  
  void runMachine(String testString) throws XMLNestingException{
    XMLParser.Builder builder = XMLParser.Builder.newParserBuilder();
    XMLParser parser = builder.build();
    TagStateMachine machine = new TagStateMachine();
    char c;
    TagState currentState = TagState.INIT;
    try (InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(testString.getBytes()))) {
        while (inputStreamReader.ready()) {
        c = (char) inputStreamReader.read();
        currentState = machine.next(c, parser);
  
        }
      } catch (IOException e) {
        
        e.printStackTrace();
      }
  }
  
  @Test (expected = XMLNestingException.class)
  public void Error_on_DoubleHeader() throws XMLNestingException, IOException {
    String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'> < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?><bbbb par3='val3'/>bla1<!-- comment -->bla2</aaa>";
    runMachine(testString);
  }
  
 @Test (expected = XMLNestingException.class)
  public void Error_on_WrongCloseTag() throws  XMLNestingException {
   String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'> <aaa><bb></aaa></bb>";
   runMachine(testString);
  }
  
@Test (expected = XMLNestingException.class)
  public void Error_on_HeaderTagAfterRoot() throws XMLNestingException, IOException {

    String  testString = "<bb>< ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'> <bb></aaa></bb>";
    runMachine(testString);
}
  
@Test (expected = XMLNestingException.class)

  public void Error_on_HeaderTagAftgerSingleRoot() throws XMLNestingException {
    XMLParser.Builder builder = builder = XMLParser.Builder.newParserBuilder();
    Parser parser;
    String  testString = "<bb/> < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> ";
    runMachine(testString);
  }

}