// package Week-1.Design_Patterns_and_Principles.FactoryMethodPattern.Document;

// package Design_Patterns_and_Principles.FactoryMethodPattern.Document;
public class Client {
    public static void main(String args[]) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }

}
