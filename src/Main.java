import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

		int suspects,preceding,concurrent;

		char[] line = buffer.readLine().toCharArray();
		
		String[] auxStr = (new String(line, 0 , line.length)).split(" ");
		suspects = Integer.parseInt(auxStr[0]);
		preceding = Integer.parseInt(auxStr[1]); // number of distinct direct precedences among tasks
		concurrent = Integer.parseInt(auxStr[2]); // limit used in the definition of hard week

		int[] pred = new int[suspects]; // precedencias
		List<Integer>[] succ = new ArrayList[suspects]; // precedencias

		for(int i = 0; i < suspects; i++) {
			succ[i] = new ArrayList<Integer>();
		}
		
		//para cada arco guardar quais estao a apontar para eles, os antecessores + sucessores
		//ir guardando as taks da semana -> 
		
		int x, y;

		//System.out.println(a);

		for (int i = 0; i < preceding; i++) {
			line = buffer.readLine().toCharArray();
			String[] aux = (new String(line, 0 , line.length)).split(" ");
			x = Integer.parseInt(aux[0]);
			y = Integer.parseInt(aux[1]);

			pred[y]++;
			succ[x].add(y);
		}

		HardWeeks hardWeeks = new HardWeeks(limit, pred,succ);
		
		System.out.println(hardWeeks.getMaxTasks()+" "+hardWeeks.getWeeksAboveLimit());
	}
}
