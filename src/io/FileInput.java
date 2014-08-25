package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileInput {
	/**
	 * @see http://stackoverflow.com/questions/7413830/java-read-line-from-file
	 */
	public static List<Integer> readFile(String path) {
		InputStream fis;
		BufferedReader br = null;
		String line;
		List<Integer> result = new ArrayList<Integer>();
		
		try {
			fis = new FileInputStream(path);
			br = new BufferedReader(new InputStreamReader(fis,
					Charset.forName("UTF-8")));
			while ((line = br.readLine()) != null) {
				int i = Integer.parseInt(line);
				result.add(i);
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException("could not find the file: " + path);
		} catch (IOException e) {
			throw new RuntimeException("could not read from file: " + path);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
		return result;
	}
}
