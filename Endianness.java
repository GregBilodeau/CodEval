import java.nio.ByteOrder;

/*
 * CHALLENGE DESCRIPTION:

Write a program which prints the endianness of the system.

INPUT SAMPLE:

There is no input for this program.

OUTPUT SAMPLE:

Print to stdout the endianness, wheather it is LittleEndian or BigEndian.*/

public class Endianness {

	public static void main(String[] args) {
		
		if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
			System.out.println("BigEndian");
		} else {
			System.out.println("LittleEndian");
		}
	}

}
