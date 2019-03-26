package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Map<String , Integer> map = new TreeMap<>();
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while(line != null) {
				
				String[] fields = line.split(",");
				String candidateName = fields[0];
				int candidateNumberOfVotes = Integer.parseInt(fields[1]);
				
				if(map.containsKey(candidateName) == true) {
					int lastTotalVotes = map.get(candidateName);
					candidateNumberOfVotes += lastTotalVotes;
				}
				map.put(candidateName, candidateNumberOfVotes);
				
				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		for (String c : map.keySet()) {
			System.out.println(c + ": " + map.get(c));
		}
		
		sc.close();
	}

}
