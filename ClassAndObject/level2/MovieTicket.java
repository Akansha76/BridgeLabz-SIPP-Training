
    class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    // Book a ticket
    void bookTicket(String movie, int seat, double price) {
        this.movieName = movie;
        this.seatNumber = seat;
        this.price = price;
        System.out.println("Ticket Booked Successfully!");
    }

    // Display ticket details
    void displayTicket() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.bookTicket("Inception", 12, 250);
        ticket.displayTicket();
    }
}


