package Factory;

public class DocumentFactoryExample {

    interface Document {
        void open();
    }


    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening a Word document.");
        }
    }

    static class PDFDocument implements Document {
        public void open() {
            System.out.println("Opening a PDF document.");
        }
    }


    abstract static class DocumentCreator {
        public void openDocument() {
            Document doc = createDocument();
            doc.open();
        }
        abstract Document createDocument();
    }


    static class WordDocumentCreator extends DocumentCreator {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PDFDocumentCreator extends DocumentCreator {
        public Document createDocument() {
            return new PDFDocument();
        }
    }

    // Клиент
    public static void main(String[] args) {
        DocumentCreator creator;

        System.out.println("Using WordDocumentCreator:");
        creator = new WordDocumentCreator();
        creator.openDocument();

        System.out.println("\nUsing PDFDocumentCreator:");
        creator = new PDFDocumentCreator();
        creator.openDocument();
    }
}