package Builder;

public class BreadBuilderExample {


    static class Bread {
        private String doughType;
        private int crustLayers;
        private boolean hasNuts;
        private boolean hasRaisins;

        public String getDoughType() {
            return doughType;
        }

        public int getCrustLayers() {
            return crustLayers;
        }

        public boolean hasNuts() {
            return hasNuts;
        }

        public boolean hasRaisins() {
            return hasRaisins;
        }

        @Override
        public String toString() {
            return "Bread{" +
                    "doughType='" + doughType + '\'' +
                    ", crustLayers=" + crustLayers +
                    ", hasNuts=" + hasNuts +
                    ", hasRaisins=" + hasRaisins +
                    '}';
        }
    }


    static class BreadBuilder {
        private String doughType;
        private int crustLayers;
        private boolean hasNuts;
        private boolean hasRaisins;

        public BreadBuilder setDoughType(String doughType) {
            this.doughType = doughType;
            return this;
        }

        public BreadBuilder setCrustLayers(int crustLayers) {
            this.crustLayers = crustLayers;
            return this;
        }

        public BreadBuilder setHasNuts(boolean hasNuts) {
            this.hasNuts = hasNuts;
            return this;
        }

        public BreadBuilder setHasRaisins(boolean hasRaisins) {
            this.hasRaisins = hasRaisins;
            return this;
        }

        public Bread build() {
            Bread bread = new Bread();
            bread.doughType = this.doughType;
            bread.crustLayers = this.crustLayers;
            bread.hasNuts = this.hasNuts;
            bread.hasRaisins = this.hasRaisins;
            return bread;
        }
    }


    public static void main(String[] args) {
        Bread wholeWheatBread = new BreadBuilder()
                .setDoughType("Whole Wheat")
                .setCrustLayers(2)
                .setHasNuts(true)
                .setHasRaisins(false)
                .build();

        Bread ryeBread = new BreadBuilder()
                .setDoughType("Rye")
                .setCrustLayers(1)
                .setHasNuts(false)
                .setHasRaisins(true)
                .build();


        System.out.println("Whole Wheat Bread: " + wholeWheatBread);
        System.out.println("Rye Bread: " + ryeBread);
    }
}