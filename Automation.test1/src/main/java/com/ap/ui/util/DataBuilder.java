package com.ap.ui.util;

import java.util.ArrayList;
import java.util.List;

import com.ap.datamodel.ProductData;

public class DataBuilder 
{
	public List<ProductData> prepareProductData()
	{
		List<ProductData> prodData = new ArrayList<ProductData>();
		Read_XLSX read = new Read_XLSX("TestData.xlsx", "src/main/com/ap/ui/testdata/");
		Object[][]objs = new Object[read.retrieveNoOfRows("Sheet1")-1][read.retrieveNoOfCols("Sheet1")];
		objs = read.retrieveTestData1("Sheet1");
		for(Object[]obj:objs)
		{
			ProductData productData = new ProductData();
			productData.setProductName(obj[0].toString());
			productData.setQuantity(obj[1].toString());
			productData.setSize(obj[3].toString());
			productData.setColor(obj[2].toString());
		}
		return prodData;
	}
}
