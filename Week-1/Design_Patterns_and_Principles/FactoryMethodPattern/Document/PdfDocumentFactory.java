// package Week-1.Design_Patterns_and_Principles.FactoryMethodPattern.Document;

public class PdfDocumentFactory extends DocumentFactory {

    public Document createDocument() {
        return new PdfDocument();
    }

}
