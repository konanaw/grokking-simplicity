package by.konanaw.demo.grokking_simplicity.coupon_mailer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubscriberRepository {
    private static List<Subscriber> subscribers = Arrays.asList(
            new Subscriber("john@coldmail.com", 2),
            new Subscriber("sam@pmail.co", 16),
            new Subscriber("linda1989@oal.com", 1),
            new Subscriber("jan1940@ahoy.com", 0),
            new Subscriber("mrbig@pmail.co", 25),
            new Subscriber("lol@lol.lol", 0)
    );

    public List<Subscriber> fetchAll() {
        return subscribers;
    }

    public List<Subscriber> fetchWithRecommendationsGreaterThanZero() {
        return subscribers.stream().filter(s -> s.getRecommendationsCount() > 0).collect(Collectors.toList());
    }
}
