package by.konanaw.demo.grokking_simplicity.coupon_mailer;

public class Coupon {
    private String code;
    private CouponRank rank;

    public Coupon(String code, CouponRank rank) {
        this.code = code;
        this.rank = rank;
    }

    public String getCode() {
        return code;
    }

    public CouponRank getRank() {
        return rank;
    }
}
