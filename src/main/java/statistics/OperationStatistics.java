package statistics;

import measurementForLab.PrimitiveTypeOperationsMeasurer;

public interface OperationStatistics {
    double addingStatistics(PrimitiveTypeOperationsMeasurer measurer, int iterAmount);

    double differStatistics(PrimitiveTypeOperationsMeasurer measurer, int iterAmount);

    double multiplyStatistics(PrimitiveTypeOperationsMeasurer measurer, int iterAmount);

    double divideStatistics(PrimitiveTypeOperationsMeasurer measurer, int iterAmount);
}
