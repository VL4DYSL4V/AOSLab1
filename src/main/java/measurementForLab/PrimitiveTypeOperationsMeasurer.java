package measurementForLab;

public abstract class PrimitiveTypeOperationsMeasurer {

    private static final long timeOfMillionIterations = initializeIterTime();

    private final int plusMinusIterAmount = 1_000_000;

    private final int multDivIterAmount = 1_000;

    private static long initializeIterTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
        }
        long finishTime = System.nanoTime();
        return finishTime - startTime;
    }

    public static long calculateIterationsTime(int iterationAmount) {
        return timeOfMillionIterations / 1_000_000 * iterationAmount;
    }

    public static long getTimeOfMillionIterations() {
        return timeOfMillionIterations;
    }

    public final double standartTimeCalculator(long nanoStart, long nanoFinish, long nanoTimeOfEmptyIters, int operationAmount){
        return ((double) (nanoFinish - nanoStart
                - nanoTimeOfEmptyIters)) / operationAmount;
    }

    public int getPlusMinusIterAmount() {
        return plusMinusIterAmount;
    }

    public int getMultDivIterAmount() {
        return multDivIterAmount;
    }

    public abstract double addingTime();

    public abstract double differTime();

    public abstract double multiplyingTime();

    public abstract double divisionTime();

}
