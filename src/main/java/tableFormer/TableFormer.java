package tableFormer;


import data.Pair;

import java.util.List;
import java.util.Map;

public class TableFormer {
    /**The structure of 'data': key - standard java's primitive type's name,
     * value - a List of data.Pair objects, where first element is amount of operations per second
     * and second element - percentage of the maximum number of operations per second
     * */
    public String getStatistics(Map<String, List<Pair<Double>>> data) {
        StringBuilder sb = new StringBuilder(600);
        data.forEach((key, list) ->{
            sb.append(formRow("+", key, String.valueOf(list.get(0).getFirst()), list.get(0).getSecond().intValue()));
            sb.append(formRow("-", key, String.valueOf(list.get(1).getFirst()), list.get(1).getSecond().intValue()));
            sb.append(formRow("*", key, String.valueOf(list.get(2).getFirst()), list.get(2).getSecond().intValue()));
            sb.append(formRow("/", key, String.valueOf(list.get(3).getFirst()), list.get(3).getSecond().intValue()));
            sb.append("***********************************************************\n");
        });
        return sb.toString();
    }

    public String formRow(String operation, String type, String operPerSec, int percentage) {
        StringBuilder sb = new StringBuilder(100);
        String afterTypeWhitespace = correctWhitespace(8, type.length());
        String afterAmountWhitespace = correctWhitespace(18, operPerSec.length());
        String scale = scale(percentage);
        String afterScaleWhitespace = correctWhitespace(22,(int) (percentage * 0.2) - 1);
        sb.append(operation).append("  ").append(type).append(afterTypeWhitespace)
                .append(operPerSec).append(afterAmountWhitespace)
                .append(scale).append(afterScaleWhitespace).append(percentage).append(" %\n");
        return sb.toString();
    }

    private String correctWhitespace(int maxAmount, int notWhiteCharsAmount){
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < maxAmount - notWhiteCharsAmount; i++){
            out.append(" ");
        }
        return out.toString();
    }

    private String scale(int percentage){
        StringBuilder sb = new StringBuilder(20);
        for (int i = 0; i < percentage; i += 5){
            sb.append("X");
        }
        return sb.toString();
    }
}
