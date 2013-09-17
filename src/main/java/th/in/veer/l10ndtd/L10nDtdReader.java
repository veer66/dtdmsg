package th.in.veer.l10ndtd;

import com.sun.xml.dtdparser.DTDEventListener;
import com.sun.xml.dtdparser.DTDParser;
import com.sun.xml.dtdparser.InputEntity;
import org.xml.sax.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vee
 * Date: 9/17/13 AD
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class L10nDtdReader {
    public Translation[] read(InputSource inputSource) throws IOException, SAXException {
        final ArrayList<Translation> translations = new ArrayList<Translation>();
        DTDParser parser = new DTDParser();

        // http://stackoverflow.com/a/155353
        parser.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId)
                    throws SAXException, IOException {
                if (systemId.contains("chrome://branding/locale/brand.dtd")) {
                    return new InputSource(new StringReader(""));
                } else {
                    return null;
                }
            }
        });

        parser.setDtdHandler(new DTDEventListener() {
            @Override
            public void setDocumentLocator(Locator locator) {
            }

            @Override
            public void processingInstruction(String s, String s2) throws SAXException {
            }

            @Override
            public void notationDecl(String s, String s2, String s3) throws SAXException {
            }

            @Override
            public void unparsedEntityDecl(String s, String s2, String s3, String s4) throws SAXException {
            }

            @Override
            public void internalGeneralEntityDecl(String key, String value) throws SAXException {
                translations.add(new Translation(key, value));
            }

            @Override
            public void externalGeneralEntityDecl(String s, String s2, String s3) throws SAXException {
            }

            @Override
            public void internalParameterEntityDecl(String s, String s2) throws SAXException {
            }

            @Override
            public void externalParameterEntityDecl(String s, String s2, String s3) throws SAXException {
            }

            @Override
            public void startDTD(InputEntity inputEntity) throws SAXException {
            }

            @Override
            public void endDTD() throws SAXException {
            }

            @Override
            public void comment(String s) throws SAXException {
            }

            @Override
            public void characters(char[] chars, int i, int i2) throws SAXException {
            }

            @Override
            public void ignorableWhitespace(char[] chars, int i, int i2) throws SAXException {
            }

            @Override
            public void startCDATA() throws SAXException {
            }

            @Override
            public void endCDATA() throws SAXException {
            }

            @Override
            public void fatalError(SAXParseException e) throws SAXException {
            }

            @Override
            public void error(SAXParseException e) throws SAXException {
            }

            @Override
            public void warning(SAXParseException e) throws SAXException {
            }

            @Override
            public void startContentModel(String s, short i) throws SAXException {
            }

            @Override
            public void endContentModel(String s, short i) throws SAXException {
            }

            @Override
            public void attributeDecl(String s, String s2, String s3, String[] strings, short i, String s4) throws SAXException {
            }

            @Override
            public void childElement(String s, short i) throws SAXException {
            }

            @Override
            public void mixedElement(String s) throws SAXException {
            }

            @Override
            public void startModelGroup() throws SAXException {
            }

            @Override
            public void endModelGroup(short i) throws SAXException {
            }

            @Override
            public void connector(short i) throws SAXException {
            }
        });
        parser.parse(inputSource);
        return translations.toArray(new Translation[translations.size()]);
    }
}
