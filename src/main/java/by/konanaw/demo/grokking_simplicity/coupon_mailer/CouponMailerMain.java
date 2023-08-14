package by.konanaw.demo.grokking_simplicity.coupon_mailer;

import java.util.List;
import java.util.stream.Collectors;

public class CouponMailerMain {
    private static CouponRepository couponRepository = new CouponRepository();
    private static SubscriberRepository subscriberRepository = new SubscriberRepository();
    private static EmailSystem emailSystem = new EmailSystem();

    public static void main(String[] args) {
        var coupons = fetchCouponsFromDB();
        var goodCoupons = selectCouponsByRank(coupons, CouponRank.GOOD);
        var bestCoupons = selectCouponsByRank(coupons, CouponRank.BEST);
        var subscribers = fetchSubscribersFromDB();
        var emails = emailsForSubscribers(subscribers, goodCoupons, bestCoupons);
//        for (Email email : emails) {
//            emailSystem.send(email);
//        }
        emails.forEach(email -> emailSystem.send(email));
    }

    private static List<Email> emailsForSubscribers(List<Subscriber> subscribers, List<Coupon> goodCoupons, List<Coupon> bestCoupons) {
        String goodCouponsCodes = goodCoupons.stream().map(coupon -> coupon.getCode()).collect(Collectors.joining(", "));
        String bestCouponsCodes = bestCoupons.stream().map(coupon -> coupon.getCode()).collect(Collectors.joining(", "));
        List<Email> emails = subscribers.stream()
                .map(subscriber -> emailForSubscriber(subscriber, goodCouponsCodes, bestCouponsCodes))
                .collect(Collectors.toList());
//        List<Email> emails = new ArrayList<>();
//        for (Subscriber subscriber : subscribers) {
//            var email = emailForSubscriber(subscriber, goodCouponsCodes, bestCouponsCodes);
//            emails.add(email);
//        }
        return emails;
    }

    private static Email emailForSubscriber(Subscriber subscriber, String goodCoupons, String bestCoupons) {
        var rank = subCouponRank(subscriber);
        if (rank == CouponRank.BEST) {
            return new Email("newsletter@coupondog.co", subscriber.getEmail(),
                    "Your best weekly coupons inside", "Here are the best coupons: " + bestCoupons);
        } else /*if (rank == CouponRank.GOOD) */ {
            return new Email("newsletter@coupondog.co", subscriber.getEmail(),
                    "Your good weekly coupons inside", "Here are the good coupons: " + goodCoupons);
        }
    }

    private static CouponRank subCouponRank(Subscriber subscriber) {
        return subscriber.getRecommendationsCount() >= 10 ? CouponRank.BEST : CouponRank.GOOD;
    }

    private static List<Coupon> selectCouponsByRank(List<Coupon> coupons, CouponRank couponRank) {
        return coupons.stream().filter(coupon -> coupon.getRank() == couponRank).collect(Collectors.toList());
    }

    private static List<Subscriber> fetchSubscribersFromDB() {
        return subscriberRepository.fetchWithRecommendationsGreaterThanZero();
    }

    private static List<Coupon> fetchCouponsFromDB() {
        return couponRepository.fetchAll();
    }

}
