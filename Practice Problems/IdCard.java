class IdCard {
    String name;
    int booksIssued;

    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        IdCard rohan = new IdCard("Rohan", 0);

        IdCard duplicate = ravi;

        duplicate.booksIssued = 3;

        IdCard separate = new IdCard("Rohan", 3);

        System.out.println("Rohan's booksIssued (via first variable): "
                + rohan.booksIssued);

        System.out.println("duplicate == rohan: " + (duplicate == rohan));
        System.out.println("separate == rohan: " + (separate == rohan));
    }
}
