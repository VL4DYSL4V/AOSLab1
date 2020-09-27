package app;

import data.Pair;
import measurementForLab.*;
import statistics.LabOperationStatistics;
import statistics.OperationStatistics;
import tableFormer.TableFormer;
import util.StatisticsUtils;

import java.util.*;

public class Application {

    private final OperationStatistics operationStatistics = new LabOperationStatistics();
    private final TableFormer tableFormer = new TableFormer();

    private Map<String, List<Pair<Double>>> data = new LinkedHashMap<>();

    public void run() {
        calculateStatistics("int", new IntMeasurer(), 40);
        calculateStatistics("long", new LongMeasurer(), 20);
        calculateStatistics("double", new DoubleMeasurer(), 20);
        calculateStatistics("float", new FloatMeasurer(), 20);
        calculatePercentage();
        System.out.println(tableFormer.getStatistics(Collections.unmodifiableMap(data)));
    }

    private void calculateStatistics(String key, PrimitiveTypeOperationsMeasurer measurer, int iterAmount){
        List<Pair<Double>> values = new ArrayList<>();
        values.add(new Pair<>(
                StatisticsUtils.nsForOpToOpPerSecConverter( operationStatistics.addingStatistics(measurer, iterAmount))
                , 0.0));
        values.add(new Pair<>(
                StatisticsUtils.nsForOpToOpPerSecConverter(operationStatistics.differStatistics(measurer, iterAmount))
                , 0.0));
        values.add(new Pair<>(
                StatisticsUtils.nsForOpToOpPerSecConverter(operationStatistics.multiplyStatistics(measurer, iterAmount))
                , 0.0));
        values.add(new Pair<>(
                StatisticsUtils.nsForOpToOpPerSecConverter(operationStatistics.divideStatistics(measurer, iterAmount))
                , 0.0));
        this.data.put(key, values);
    }

    private void calculatePercentage(){
        double maximum = 0.0;
        for(String key: data.keySet()){
            for(Pair<Double> pair: data.get(key)){
                maximum = Math.max(maximum, pair.getFirst());
            }
        }
        for(String key: data.keySet()){
            for(Pair<Double> pair: data.get(key)){
                pair.setSecond((pair.getFirst() * 100)/ maximum);
            }
        }
    }
}
