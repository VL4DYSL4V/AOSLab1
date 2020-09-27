package statistics;

import measurement.PrimitiveTypeOperationsMeasurer;
import util.StatisticsUtils;

public class LabOperationStatistics implements OperationStatistics {

    @Override
    public double addingStatistics(PrimitiveTypeOperationsMeasurer measurer, int iterAmount) {
        double addingTime = 0.0;
        for (int i = 0; i < iterAmount; i++) {
            addingTime += measurer.addingTime();
        }
        addingTime /= iterAmount;
        return StatisticsUtils.roundToThousandth(addingTime);
    }

    @Override
    public double differStatistics(PrimitiveTypeOperationsMeasurer measurer, int iterAmount) {
        double differTime = 0.0;
        for (int i = 0; i < iterAmount; i++) {
            differTime += measurer.differTime();
        }
        differTime /= iterAmount;
        return StatisticsUtils.roundToThousandth(differTime);
    }

    @Override
    public double multiplyStatistics(PrimitiveTypeOperationsMeasurer measurer, int iterAmount) {
        double multiplyingTime = 0.0;
        for (int i = 0; i < iterAmount; i++) {
            multiplyingTime += measurer.multiplyingTime();
        }
        multiplyingTime /= iterAmount;
        return StatisticsUtils.roundToThousandth(multiplyingTime);
    }

    @Override
    public double divideStatistics(PrimitiveTypeOperationsMeasurer measurer, int iterAmount) {
        double divisionTime = 0.0;
        for (int i = 0; i < iterAmount; i++) {
            divisionTime += measurer.divisionTime();
        }
        divisionTime /= iterAmount;
        return StatisticsUtils.roundToThousandth(divisionTime);
    }
}
