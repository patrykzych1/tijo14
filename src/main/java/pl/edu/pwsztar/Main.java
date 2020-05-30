package pl.edu.pwsztar;

class Main {
    public static void main(String[] args) {
        System.out.println("--- PESEL ---");
        UserId userId = new UserId("94012731083");
        System.out.println(userId.isCorrect());
    }
}
