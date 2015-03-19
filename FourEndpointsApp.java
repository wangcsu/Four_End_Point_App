import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class FourEndpointsApp {

	public static void main(String[] args) throws IOException, ParseException {
		int option;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		do{
			System.out.println("1. User Authentication");
			System.out.println("2. Display group of Users");
			System.out.println("3. Check Status");
			System.out.println("4. List Files in the Directory");
			System.out.println("5. Exit");
			System.out.println("Please make a selection: ");
			
			option = in.nextInt();
			
			switch (option){
			case 1:
				UserAuth.Authenticate();
				break;
			case 2:
				DisplayUsers.Display();
				break;
			case 3:
				Status.show();
				break;
			case 4:
				System.out.println("Please enter directory path:");
				in = new Scanner(System.in);
				String path = in.nextLine();
				FindAllFiles.AllFiles(path);
				break;
			default:
				System.out.println("Exit program.");
				break;
			}
		}while(option > 0 && option <= 4);
		

	}

}
