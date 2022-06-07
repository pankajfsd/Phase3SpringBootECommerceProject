package com.pankaj.phase3project.global;

import java.util.ArrayList;
import java.util.List;

import com.pankaj.phase3project.model.Product;

public class GlobalData {
	public static List<Product> cart;
	
	static {
		cart = new ArrayList<Product>();
	}

}
