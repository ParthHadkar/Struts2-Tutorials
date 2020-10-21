package com.P23StrutsControlTags.model.iterator;

import java.util.Comparator;

public class DepartmentComparator implements Comparator<Employee>{

	public int compare(Employee o1, Employee o2) {
		return o1.getDept().compareTo(o2.getDept());
	}

}
