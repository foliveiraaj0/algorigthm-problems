package programming_problems.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import utils.data_structures.Node;

public class DeleteWithoutHeadPointer {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String TString = "";
		try {
			TString = reader.readLine();
		} catch (IOException e) {
		}

		int T = Integer.parseInt(TString);

		for (int i = 0; i < T; i++) {
			String S = "";
			try {
				S = reader.readLine();
			} catch (IOException e) {
			}

			List<Integer> values = new ArrayList<Integer>();
			
			int nextSpace = S.indexOf(" ");
			
			while(nextSpace != -1) {
				String stringValue =S.substring(0, nextSpace);
				values.add(Integer.parseInt(stringValue));
				S = S.substring(nextSpace+1);
				nextSpace = S.indexOf(" ");
			}
			values.add(Integer.parseInt(S));
			
			Node head = null;
			Node previous = null;
			for (int j = 0; j < values.size(); j++) {
				Node node = new Node((int)values.get(j));
				if(head == null) {
					head = node;
				}
				if(previous != null) {
					previous.setNext(node);
				}
				previous = node;
			}
			
			String toDeleteString = "";
			try {
				toDeleteString = reader.readLine();
			} catch (IOException e) {
			}
		
			int toDelete = Integer.parseInt(toDeleteString);
		
			Node current = head;
			
			while (current.getData() != toDelete) {
				current = current.getNext();
			}
			
			//solution - start
			if(current.getNext() != null) {
				current.setData(current.getNext().getData());
				current.setNext(current.getNext().getNext());
			}
			//end
			
			Node.print(head);
			
		}

	}

}
