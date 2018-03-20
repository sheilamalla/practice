package com.learning.project;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class FileManipulationSample<T> {
	
	public void writeToFile(List<T> list, String file)
	{
		ObjectOutputStream outStream = null;
		try {
			outStream = new ObjectOutputStream(new FileOutputStream(file));
			for(T p: list)// for list of objects type T
			{
				outStream.writeObject(p);
			}
		}
		catch(IOException ioException) {
			System.out.println("Error opening file");
		}
		catch(NoSuchElementException noSuchElementException){
			System.out.println("Invalid input");
		}
		
		finally {
			try {
				if(outStream !=null)
				{
					outStream.close();
				}
			}
				catch(IOException ioException){
					System.err.println("Error closing file");
				}
			}
		
	}

	
	public List<T> readFromFile(String file){
		List<T> list = new ArrayList<T>();
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(file));
			while(true)
			{
				@SuppressWarnings("unchecked")
				T p = (T) inputStream.readObject();
				list.add(p);
			}
		}
		catch(EOFException eofException) {
			return list;
		}catch(ClassNotFoundException classNotFoundException)
		{
			System.err.println("object creation failed.");
		}
		catch(IOException ioException) {
			System.err.println("Error closing file.");
		}
		finally {
			try {
				if(inputStream!=null)
					inputStream.close();
					
			}
			catch(IOException ioException) {
				System.err.println("Error closing file.");
			}
		}
		return list;	
	}
		
	
	
}

