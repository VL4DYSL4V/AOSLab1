package measurementForLab;

public class LongMeasurer extends PrimitiveTypeOperationsMeasurer {

    private volatile long l0 = 4L;
    private volatile long l1 = 2L;
    private volatile long l2 = 2L;
    private volatile long l3 = 3L;
    private volatile long l4 = 6L;
    private volatile long l5 = 7L;
    private volatile long l6 = 9L;
    private volatile long l7 = 11L;
    private volatile long l8 = 0;
    private volatile long l9 = 0;

    @Override
    public double addingTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getPlusMinusIterAmount(); i++) {
            l0 += l4;
            l4 += l1;
            l1 += l5;
            l5 += l2;
            l2 += l6;

            l6 += l0;
            l0 += l3;
            l3 += l7;
            l5 += l6;
            l7 += l1;

        }
        long finishTime = System.nanoTime();
        resetLongs();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getPlusMinusIterAmount()),
                10*super.getPlusMinusIterAmount());

    }

    @Override
    public double differTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getPlusMinusIterAmount(); i++) {
            l0 -= l4;
            l4 -= l1;
            l1 -= l5;
            l5 -= l2;
            l2 -= l6;

            l6 -= l0;
            l0 -= l3;
            l3 -= l7;
            l5 -= l6;
            l7 -= l1;
        }
        long finishTime = System.nanoTime();
        resetLongs();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getPlusMinusIterAmount()),
                10*super.getPlusMinusIterAmount());

    }

    @Override
    public double multiplyingTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i <  super.getMultDivIterAmount(); i++) {
            l0 *= l4;
            l4 *= l1;
            l1 *= l5;
            l5 *= l2;
            l2 *= l6;

            l6 *= l0;
            l0 *= l3;
            l3 *= l7;
            l5 *= l6;
            l7 *= l1;
        }
        long finishTime = System.nanoTime();
        resetLongs();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getMultDivIterAmount()),
                10 * super.getMultDivIterAmount());
    }

    @Override
    public double divisionTime() {
        long startTime = System.nanoTime();
        for (int k = 0; k < super.getMultDivIterAmount(); k++) {
            instantiateLongsForDivision();
            for (int i = 0; i < 60; i++) {
                l0 /= l4;
                l1 /= l5;
                l2 /= l6;
                l3 /= l7;
                l9 /= l8;
            }
            reversedLongInstantiationForDivision();
            for (int i = 0; i < 60; i++) {
                l4 /= l0;
                l5 /= l1;
                l6 /= l2;
                l7 /= l3;
                l8 /= l9;
            }
        }
        long finishTime = System.nanoTime();
        resetLongs();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(2 * 60 * super.getMultDivIterAmount()),
                60 * 10 * super.getMultDivIterAmount());
    }

    private void resetLongs() {
        l0 = 4L;
        l1 = 2L;
        l2 = 2L;
        l3 = 3L;
        l4 = 6L;
        l5 = 7L;
        l6 = 9L;
        l7 = 11L;
        l8 = 0;
        l9 = 0;
    }

    private void instantiateLongsForDivision() {
        instantiateLongs(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, 2, 2, 2, 2, 2, Long.MAX_VALUE);
    }

    private void reversedLongInstantiationForDivision() {
        instantiateLongs(2, 2, 2, 2, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, 2);
    }

    private void instantiateLongs(long l0, long l1, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9) {
        this.l0 = l0;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;
        this.l5 = l5;
        this.l6 = l6;
        this.l7 = l7;
        this.l8 = l8;
        this.l9 = l9;
    }
}
