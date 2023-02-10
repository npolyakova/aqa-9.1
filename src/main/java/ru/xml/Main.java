package ru.xml;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        try (StaxStreamProcessor processor = new StaxStreamProcessor(Files.newInputStream(Paths.get("src/main/resources/example.xml")))) {
            XMLStreamReader reader = processor.getReader();
            while (reader.hasNext()) {       // while not end of XML
                int event = reader.next();   // read next event
//                if (event == XMLEvent.START_ELEMENT &&
//                        "BREED".equals(reader.getLocalName())) {
//                    System.out.println(reader.getElementText());
//                }
                if (event == XMLEvent.START_ELEMENT &&
                        ("NAME".equals(reader.getLocalName()) || "BREED".equals(reader.getLocalName()))) {
                    System.out.println(reader.getElementText());
                }

            }
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println("Something get wrong");
        }
    }
}
