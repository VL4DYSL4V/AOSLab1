package util;

import java.math.BigDecimal;

public class StatisticsUtils {

    public static double roundToThousandth(double d) {
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(3, BigDecimal.ROUND_DOWN);
        return bigDecimal.doubleValue();
    }

    public static double nsForOpToOpPerSecConverter(double nsForOP){
        return roundToThousandth(1 / nsForOP * Math.pow(10, 9));
    }
}
