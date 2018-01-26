package com.monsanto.mbt;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shipment {

    public enum WidgetSortOption {
        PROD_DATE, COLOR;
    }

    private static final int MAX_WIDGET = 10;

    public  List<Widget> createShipments(List<Widget> widgets, WidgetSortOption widgetSortOption) {
        Comparator<Widget> comparator = null;
        if (widgetSortOption == WidgetSortOption.PROD_DATE) {
            comparator = (Widget w1, Widget w2)-> w1.getProductionDate().compareTo(w2.getProductionDate());
        } else {
            comparator = (Widget w1, Widget w2)-> w1.getColor().compareTo(w2.getColor());
        }
        widgets.sort(comparator);

        return  widgets.stream().limit(MAX_WIDGET).collect(Collectors.toList());
    }


}
