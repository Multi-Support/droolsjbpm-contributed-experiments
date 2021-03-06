package dt.memory;

import java.io.Serializable;
import java.util.Comparator;

public class NumberComparator implements Comparator<Number>, Serializable {
	public NumberComparator() {
	}

	public int compare(Number n0, Number n1) {
		if (n0.doubleValue() < n1.doubleValue())
			return -1;
		else if (n0.doubleValue() > n1.doubleValue())
			return 1;
		else
			return 0;
	}
}
