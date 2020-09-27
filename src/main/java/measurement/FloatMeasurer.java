package measurement;

public class FloatMeasurer extends PrimitiveTypeOperationsMeasurer {

    private volatile float f0 = 63.0f;
    private volatile float f1 = 3.0f;
    private volatile float f2 = 12;
    private volatile float f3 = 514363.f;
    private volatile float f4 = 366.73f;
    private volatile float f5 = 2636.2862f;
    private volatile float f6 = 3517.02f;
    private volatile float f7 = 11.0f;

    @Override
    public double addingTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getPlusMinusIterAmount(); i++) {
            f0 += f4;
            f4 += f1;
            f1 += f5;
            f5 += f2;
            f2 += f3;

            f6 += f0;
            f0 += f7;
            f3 += f2;
            f5 += f6;
            f7 += f1;

        }
        long finishTime = System.nanoTime();
        resetFloats();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getPlusMinusIterAmount()),
                10*super.getPlusMinusIterAmount());
    }

    @Override
    public double differTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getPlusMinusIterAmount(); i++) {
            f0 -= f4;
            f4 -= f1;
            f1 -= f5;
            f5 -= f2;
            f2 -= f3;

            f6 -= f0;
            f0 -= f7;
            f3 -= f2;
            f5 -= f6;
            f7 -= f1;
        }
        long finishTime = System.nanoTime();
        resetFloats();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getPlusMinusIterAmount()),
                10*super.getPlusMinusIterAmount());
    }

    @Override
    public double multiplyingTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getMultDivIterAmount(); i++) {
            f0 *= f4;
            f4 *= f1;
            f1 *= f5;
            f5 *= f2;
            f2 *= f6;

            f6 *= f0;
            f0 *= f7;
            f3 *= f2;
            f5 *= f6;
            f7 *= f3;
        }
        long finishTime = System.nanoTime();
        resetFloats();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getMultDivIterAmount()),10* super.getMultDivIterAmount());
    }

    @Override
    public double divisionTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < super.getMultDivIterAmount(); i++) {
            f0 /= f4;
            f4 /= f1;
            f1 /= f5;
            f5 /= f2;
            f2 /= f6;

            f6 /= f0;
            f0 /= f7;
            f3 /= f2;
            f5 /= f6;
            f7 /= f3;
        }
        long finishTime = System.nanoTime();
        resetFloats();
        return super.standartTimeCalculator(startTime, finishTime,
                PrimitiveTypeOperationsMeasurer.calculateIterationsTime(super.getMultDivIterAmount()),10* super.getMultDivIterAmount());
    }

    private void resetFloats() {
        f0 = 63.0f;
        f1 = 3.0f;
        f2 = 12;
        f3 = 514363.f;
        f4 = 366.73f;
        f5 = 2636.2862f;
        f6 = 3517.02f;
        f7 = 11.0f;
    }
}
