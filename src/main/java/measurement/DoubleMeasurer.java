package measurement;

public class DoubleMeasurer extends PrimitiveTypeOperationsMeasurer {

    private volatile double d0 = 273193.0;
    private volatile double d1 = 3728193.0;
    private volatile double d2 = 183.2;
    private volatile double d3 = 0.7;
    private volatile double d4 = 0.9;
    private volatile double d5 = 83619;
    private volatile double d6 = 827.01;
    private volatile double d7 = 2;

    @Override
    public double addingTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getPlusMinusIterAmount(); i++) {
            d0 += d4;
            d4 += d1;
            d1 += d5;
            d5 += d2;
            d2 += d6;

            d6 += d0;
            d0 += d7;
            d3 += d2;
            d5 += d6;
            d7 += d3;
        }
        long finishTime = System.nanoTime();
        resetDoubles();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getPlusMinusIterAmount()),10* super.getPlusMinusIterAmount());
    }

    @Override
    public double differTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getPlusMinusIterAmount(); i++) {
            d0 -= d4;
            d4 -= d1;
            d1 -= d5;
            d5 -= d2;
            d2 -= d6;

            d6 -= d0;
            d0 -= d7;
            d3 -= d2;
            d5 -= d6;
            d7 -= d3;
        }
        long finishTime = System.nanoTime();
        resetDoubles();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getPlusMinusIterAmount()),10* super.getPlusMinusIterAmount());
    }

    @Override
    public double multiplyingTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getMultDivIterAmount(); i++) {
            d0 *= d4;
            d4 *= d1;
            d1 *= d5;
            d5 *= d2;
            d2 *= d6;

            d6 *= d0;
            d0 *= d7;
            d3 *= d2;
            d5 *= d6;
            d7 *= d3;
        }
        long finishTime = System.nanoTime();
        resetDoubles();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getMultDivIterAmount()),10* super.getMultDivIterAmount());
    }

    @Override
    public double divisionTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getMultDivIterAmount(); i++) {
            d0 /= d4;
            d4 /= d1;
            d1 /= d5;
            d5 /= d2;
            d2 /= d6;

            d6 /= d0;
            d0 /= d7;
            d3 /= d2;
            d5 /= d6;
            d7 /= d3;
        }
        long finishTime = System.nanoTime();
        resetDoubles();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getMultDivIterAmount()),10* super.getMultDivIterAmount());
    }

    private void resetDoubles(){
        d0 = 273193.0;
        d1 = 3728193.0;
        d2 = 183.2;
        d3 = 0.7;
        d4 = 0.9;
        d5 = 83619;
        d6 = 827.01;
        d7 = 2;
    }
}
