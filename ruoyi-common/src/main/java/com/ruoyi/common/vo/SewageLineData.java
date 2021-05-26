package com.ruoyi.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @description: ss
 * @author: sun
 * @create: 2021-05-20 22:25
 */
@Data
public class SewageLineData {

    private List<String> xData;

    private YData yData;

    @Data
    public static class YData {

        private List<Double> ydata1;
        private List<Double> ydata2;

    }

    private List<String> lines;

}
