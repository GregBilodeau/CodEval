import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

You are given the pairs of time values. The values are in the HH:MM:SS format with leading zeros. Your task is to find out the time difference between the pairs.

INPUT SAMPLE:

The first argument is a file that contains lines with the time pairs.

For example:

1
2
3
4
5
14:01:57 12:47:11
13:09:42 22:16:15
08:08:06 08:38:28
23:35:07 02:49:59
14:31:45 14:46:56
OUTPUT SAMPLE:

Print to stdout the time difference for each pair, one per line. You must format the time values in HH:MM:SS with leading zeros.

For example:

1
2
3
4
5
01:14:46
09:06:33
00:30:22
20:45:08
00:15:11
*/

public class DeltaTime {
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split("\\s");
				String time1 = elements[0];
				String time2 = elements[1];
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				Date first = null;
				Date second = null;
				try {
					first = format.parse(time1);
					second = format.parse(time2);
					long diff = 0;
					diff = Math.abs(first.getTime() - second.getTime());
					int days, hours, mins, secs;
					days = (int) (diff / (1000*60*60*24));  
					hours = (int) ((diff - (1000*60*60*24*days)) / (1000*60*60)); 
					mins = (int) (diff - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);
					secs = (int) (diff - (1000*60*60*24*days) - (1000*60*60*hours) - (1000*60*mins)) / (1000);
					System.out.println(String.format("%02d", hours) +":" + String.format("%02d", mins) + ":" + String.format("%02d", secs));
				} catch (ParseException e) {
					// 
				}
				
			}
		}
		
		fileScanner.close();

	}

}
