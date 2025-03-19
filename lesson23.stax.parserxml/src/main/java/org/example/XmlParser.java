package org.example;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class XmlParser {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/sonnet.xml";
        Book book = new Book();

        try (FileInputStream fileInputStream = new FileInputStream(xmlFile)) {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(fileInputStream);

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        if ("firstName".equals(elementName)) {
                            book.setFirstName(reader.getElementText());
                        } else if ("lastName".equals(elementName)) {
                            book.setLastName(reader.getElementText());
                        } else if ("title".equals(elementName)) {
                            book.setTitle(reader.getElementText());
                        } else if ("line".equals(elementName)) {
                            book.addLine(reader.getElementText());
                        }
                        break;
                }
            }

            try (FileWriter writer = new FileWriter(book.getFileName())) {
                writer.write(book.getLines());
            }

            System.out.println("Файл успешно создан: " + book.getFileName());

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}