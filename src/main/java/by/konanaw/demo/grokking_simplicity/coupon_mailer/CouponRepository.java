package by.konanaw.demo.grokking_simplicity.coupon_mailer;

import java.util.Arrays;
import java.util.List;

public class CouponRepository {

    private static List<Coupon> coupons = Arrays.asList(
            new Coupon("MAYDISCOUNT", CouponRank.GOOD),
            new Coupon("10PERCENT", CouponRank.BAD),
            new Coupon("PROMOTION45", CouponRank.BEST),
            new Coupon("IHEARTYOU", CouponRank.BAD),
            new Coupon("GETADEAL", CouponRank.BEST),
            new Coupon("ILIKEDISCOUNTS", CouponRank.GOOD)
    );

    public List<Coupon> fetchAll() {
        return coupons;
    }
}
