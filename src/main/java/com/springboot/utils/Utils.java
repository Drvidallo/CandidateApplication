package com.springboot.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	public String getfullName(String lastName, String firstName) {
		return lastName + " ," + firstName;
	}
	
	@SafeVarargs
	public static <T> void clearArrayList(List<? extends Object> ...lists) {
		for (List<? extends Object> list : lists) {
            list.clear(); // Clear each ArrayList within the list
        }
	}

}
