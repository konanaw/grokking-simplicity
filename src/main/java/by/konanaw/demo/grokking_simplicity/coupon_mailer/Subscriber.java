package by.konanaw.demo.grokking_simplicity.coupon_mailer;

public class Subscriber {
    private final String email;
    private final int recommendationsCount;

    public Subscriber(String email, int recommendationsCount) {
        this.email = email;
        this.recommendationsCount = recommendationsCount;
    }

    public String getEmail() {
        return email;
    }

    public int getRecommendationsCount() {
        return recommendationsCount;
    }
}
