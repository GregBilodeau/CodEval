import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * CHALLENGE DESCRIPTION:

In this challenge you're presented with a situation in which you need to output big symbols on devices which only support ASCII characters and single, fixed-width fonts. To do this you're going to use pseudo-graphics to ‘draw’ these big symbols.

Here is an example of the font with digits from 0 to 9:

1
2
3
4
5
6
-**----*--***--***---*---****--**--****--**---**--
*--*--**-----*----*-*--*-*----*-------*-*--*-*--*-
*--*---*---**---**--****-***--***----*---**---***-
*--*---*--*-------*----*----*-*--*--*---*--*----*-
-**---***-****-***-----*-***---**---*----**---**--
--------------------------------------------------
Each pixel is marked either with asterisk ‘*’ or with minus ‘-’. Size of a digit is 5×6 pixels.

Your task is to write a program, which outputs the numbers given to you with the font as in the example.

INPUT SAMPLE:

The first argument is a file that contains the lines with digits sequences you need to magnify. E.g.:

1
2
3
4
5
3.1415926
1.41421356
01-01-1970
2.7182818284
4 8 15 16 23 42
OUTPUT SAMPLE:

Print to stdout the magnified digits:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
***----*---*-----*--****--**--***---**--
---*--**--*--*--**--*----*--*----*-*----
-**----*--****---*--***---***--**--***--
---*---*-----*---*-----*----*-*----*--*-
***---***----*--***-***---**--****--**--
----------------------------------------
--*---*-----*---*---***----*--***--****--**--
-**--*--*--**--*--*----*--**-----*-*----*----
--*--****---*--****--**----*---**--***--***--
--*-----*---*-----*-*------*-----*----*-*--*-
-***----*--***----*-****--***-***--***---**--
---------------------------------------------
-**----*---**----*----*---**--****--**--
*--*--**--*--*--**---**--*--*----*-*--*-
*--*---*--*--*---*----*---***---*--*--*-
*--*---*--*--*---*----*-----*--*---*--*-
-**---***--**---***--***--**---*----**--
----------------------------------------
***--****---*---**--***---**----*---**--***---**---*---
---*----*--**--*--*----*-*--*--**--*--*----*-*--*-*--*-
-**----*----*---**---**---**----*---**---**---**--****-
*-----*-----*--*--*-*----*--*---*--*--*-*----*--*----*-
****--*----***--**--****--**---***--**--****--**-----*-
-------------------------------------------------------
-*----**----*--****---*---**--***--***---*---***--
*--*-*--*--**--*-----**--*-------*----*-*--*----*-
****--**----*--***----*--***---**---**--****--**--
---*-*--*---*-----*---*--*--*-*-------*----*-*----
---*--**---***-***---***--**--****-***-----*-****-
--------------------------------------------------
CONSTRAINTS:

Input lines are up to 16 symbols long.
Input can contain some other symbols, which should be ignored (i.e. points, hyphens, spaces); only numbers must be printed out.*/

public class BigDigits {
    
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		
		String str0[] = 	{"-**--",
							"*--*-",
							"*--*-",
							"*--*-",
							"-**--",
							"-----"};
		String str1[] = 	{"--*--",
							"-**--",
							"--*--",
							"--*--",
							"-***-",
							"-----"};
		String str2[] = 	{"***--",
							"---*-",
							"-**--",
							"*----",
							"****-",
							"-----"};
		String str3[] = 	{"***--",
							"---*-",
							"-**--",
							"---*-",
							"***--",
							"-----"};
		String str4[] = 	{"-*---",
							"*--*-",
							"****-",
							"---*-",
							"---*-",
							"-----"};
		String str5[] = 	{"****-",
							"*----",
							"***--",
							"---*-",
							"***--",
							"-----"};
		String str6[] = 	{"-**--",
							"*----",
							"***--",
							"*--*-",
							"-**--",
							"-----"};
		String str7[] = 	{"****-",
							"---*-",
							"--*--",
							"-*---",
							"-*---",
							"-----"};
		String str8[]= 		{"-**--",
							"*--*-",
							"-**--",
							"*--*-",
							"-**--",
							"-----"};
		String str9[] = 	{"-**--",
							"*--*-",
							"-***-",
							"---*-",
							"-**--",
							"-----"};
		
		String[][] numericals = {str0,str1,str2,str3,str4,str5,str6,str7,str8,str9};
		
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				ArrayList<Character> numbers = new ArrayList<Character>();
				for(char c : line.toCharArray()){
					int charVal = (int) c;
					if(charVal >= 48 && charVal <= 57){
						numbers.add(c);
					}
				}
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i <= 5; i++){
					for(char c : numbers){
						int num = Character.getNumericValue(c);
						String[] numberArray = numericals[num];
						sb.append(numberArray[i]);
					}
					sb.append("\n");
				}
				System.out.print(sb.toString());
			}
		}
		scanner.close();
	}

}
