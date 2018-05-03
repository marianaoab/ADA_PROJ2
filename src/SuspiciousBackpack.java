import java.util.ArrayList;
import java.util.List;

public class SuspiciousBackpack {
	
	List<Integer>[] precedingConjectures; // precedencias
	List<Integer>[] concurrentConjectures; // precedencias

	public SuspiciousBackpack(List<Integer>[] precedingConjectures, List<Integer>[] concurrentConjectures) {
		this.precedingConjectures = precedingConjectures;
		this.concurrentConjectures = concurrentConjectures;
	}
	
	public boolean solve() {
		return true;
	}

}
