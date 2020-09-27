package measurement;

public class IntMeasurer extends PrimitiveTypeOperationsMeasurer {

    private volatile int i0 = 3;
    private volatile int i1 = 8;
    private volatile int i2 = 3;
    private volatile int i3 = 8;
    private volatile int i4 = 4;
    private volatile int i5 = 2;
    private volatile int i6 = 4;
    private volatile int i7 = 5;
    private volatile int i8 = 4;
    private volatile int i9 = 2;

    @Override
    public double addingTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getPlusMinusIterAmount(); i++) {
            i0 += i4;
            i4 += i1;
            i1 += i7;
            i5 += i2;
            i2 += i6;

            i6 += i0;
            i0 += i1;
            i3 += i2;
            i6 += i5;
            i7 += i3;
        }
        long finishTime = System.nanoTime();
        resetInts();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getPlusMinusIterAmount()),
                10*super.getPlusMinusIterAmount());
    }

    @Override
    public double differTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getPlusMinusIterAmount(); i++) {
            i0 -= i4;
            i4 -= i1;
            i1 -= i7;
            i5 -= i2;
            i2 -= i6;

            i6 -= i0;
            i0 -= i1;
            i3 -= i2;
            i6 -= i5;
            i7 -= i3;
        }
        long finishTime = System.nanoTime();
        resetInts();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getPlusMinusIterAmount()),
                10*super.getPlusMinusIterAmount());

    }

    @Override
    public double multiplyingTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getMultDivIterAmount(); i++) {
            i0 *= i4;
            i4 *= i1;
            i1 *= i7;
            i5 *= i2;
            i2 *= i6;

            i6 *= i0;
            i0 *= i1;
            i3 *= i2;
            i6 *= i5;
            i7 *= i3;
        }
        long finishTime = System.nanoTime();
        resetInts();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime( super.getMultDivIterAmount()),  10*super.getMultDivIterAmount());
    }

    @Override
    public double divisionTime() {
        long startTime = System.nanoTime();
        for (int k = 0; k <  super.getMultDivIterAmount(); k++) {
            instantiateIntsForDivision();
            for (int i = 0; i < 30; i++) {
                i0 /= i4;
                i1 /= i5;
                i2 /= i6;
                i3 /= i7;
                i9 /= i8;
            }
            reversedIntInstantiationForDivision();
            for (int i = 0; i < 30; i++) {
                i4 /= i0;
                i5 /= i1;
                i6 /= i2;
                i7 /= i3;
                i8 /= i9;
            }
        }
        long finishTime = System.nanoTime();
        resetInts();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(2 * 30 *  super.getMultDivIterAmount()),
                30 * 10 * super.getMultDivIterAmount());
    }

    private void resetInts() {
        i0 = 3;
        i1 = 8;
        i2 = 3;
        i3 = 8;
        i4 = 4;
        i5 = 2;
        i6 = 4;
        i7 = 5;
        i8 = 4;
        i9 = 2;
    }

    private void instantiateIntsForDivision() {
        instantiateInts(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 2, 2, 2, 2, Integer.MAX_VALUE);
    }

    private void reversedIntInstantiationForDivision() {
        instantiateInts(2, 2, 2, 2, Integer.MAX_VALUE,
                Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2);
    }

    private void instantiateInts(int i0, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.i0 = i0;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.i5 = i5;
        this.i6 = i6;
        this.i7 = i7;
        this.i8 = i8;
        this.i9 = i9;
    }
}
