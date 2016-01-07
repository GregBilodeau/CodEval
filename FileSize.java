import java.io.File;
import java.io.IOException;


public class FileSize {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		
		System.out.print(file.length());

	}

}
