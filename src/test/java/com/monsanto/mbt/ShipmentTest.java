package com.monsanto.mbt;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ShipmentTest {

    private Shipment shipment;

    @Before
    public void init() {
        shipment = new Shipment();
    }

    @Test
    public void testShipment_Sorted_By_Color(){
        List<Widget> widgets = WidgetUtils.getSampleWidgets();
        List<Widget> widgetList = shipment.createShipments(widgets, Shipment.WidgetSortOption.COLOR);

        assertTrue(widgetList.get(0).getColor().equals("Blue"));
        assertTrue(widgetList.get(0).getSerialNumber() == 2);
        assertTrue(widgetList.size() == 10);
        assertTrue(widgetList.get(9).getColor().equals("Green"));
        assertTrue(widgetList.get(9).getSerialNumber() == 11);
    }

    @Test
    public void testShipment_Sorted_By_Date(){
        List<Widget> widgets = WidgetUtils.getSampleWidgets();
        List<Widget> widgetList = shipment.createShipments(widgets, Shipment.WidgetSortOption.PROD_DATE);

        assertTrue(widgetList.get(0).getColor().equals("Red"));
        assertTrue(widgetList.get(0).getSerialNumber() == 9);
        assertTrue(WidgetUtils.dateToStringConverter(widgetList.get(0).getProductionDate()).equals("09-01-2005"));
        assertTrue(widgetList.size() == 10);
        assertTrue(widgetList.get(9).getColor().equals("Red"));
        assertTrue(widgetList.get(9).getSerialNumber() == 17);
        assertTrue(WidgetUtils.dateToStringConverter(widgetList.get(9).getProductionDate()).equals("07-01-2008"));

    }


}
