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

		List<Integer>[] precedingConjectures = new ArrayList[suspects]; // precedencias
		List<Integer>[] concurrentConjectures = new ArrayList[suspects]; // precedencias

		for(int i = 0; i < suspects; i++) {
			precedingConjectures[i] = new ArrayList<Integer>();
			concurrentConjectures[i] = new ArrayList<Integer>();
		}
		
		//para cada arco guardar quais estao a apontar para eles, os antecessores + sucessores
		//ir guardando as taks da semana -> 
		
		int x, y;

		//System.out.println(a);

		for (int i = 0; i < suspects; i++) {
			line = buffer.readLine().toCharArray();
			String[] aux = (new String(line, 0 , line.length)).split(" ");
			x = Integer.parseInt(aux[0]);
			y = Integer.parseInt(aux[1]);

			if (i < preceding) { // preceding conjectures
				precedingConjectures[y].add(x); // o x esteve a galeria antes do y
			} else {				// concurrent conjectures
				concurrentConjectures[x].add(y); // o x e o y estiveram na galeria ao mesmo tempo
				concurrentConjectures[y].add(x);
			}
		}

		SuspiciousBackpack suspiciousBackpack = new SuspiciousBackpack(precedingConjectures, concurrentConjectures);
		
		System.out.println(suspiciousBackpack.solve());
	}
}
