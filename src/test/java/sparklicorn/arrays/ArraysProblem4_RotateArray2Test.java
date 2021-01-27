package sparklicorn.arrays;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

import org.junit.Test;

public class ArraysProblem4_RotateArray2Test {

	@Test(expected = NullPointerException.class)
	public void rotate_whenInputIsNull_throwsNullPointerException() {
		ArraysProblem4_RotateArray2.rotate(null);
	}

	@Test
	public void rotate() throws IOException, ClassNotFoundException, ClassCastException {

		int[][] input = new int[][] { new int[] { 1, 2, 3, 4 }, new int[] { 5, 6, 7, 8 }, new int[] { 9, 0, 1, 2 },
				new int[] { 3, 4, 5, 6 } };

		int[][] expected = new int[][] { new int[] { 2, 3, 4, 8 }, new int[] { 1, 7, 1, 2 }, new int[] { 5, 6, 0, 6 },
				new int[] { 9, 3, 4, 5 } };

		serializeAndWriteToFile(new File("input"), input);
		serializeAndWriteToFile(new File("expected"), expected);

		input = deserializeFromFile(new File("input"), int[][].class);
		expected = deserializeFromFile(new File("expected"), int[][].class);

		System.out.println("INPUT:");
		System.out.println(Arrays.deepToString(input));
		System.out.println("EXPECTED:");
		System.out.println(Arrays.deepToString(expected));

		ArraysProblem4_RotateArray2.rotate(input);
		assertArrayEquals(expected, input);
	}

	public static void serializeAndWriteToFile(File outFile, Serializable data) throws IOException {
		ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(outFile));
		objOutStream.writeObject(data);
		objOutStream.close();
	}

	public static <T extends Serializable> T deserializeFromFile(File inFile, Class<T> clazzOfT) throws IOException, ClassNotFoundException, ClassCastException {
		ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(inFile));
		Object deserializedObj = objInStream.readObject();
		objInStream.close();
		return clazzOfT.cast(deserializedObj);
	}
}
