package com.andrewsavich.exposit.deliveryservice.dataload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class DataLoaderFromJson<T> implements DataLoader<T> {
	private String fileName;
	private List<T> objects;
	private ClassLoader classLoader;
	private Class<? extends T> clazz;

	public DataLoaderFromJson(String fileName, Class<? extends T> clazz) {
		this.fileName = fileName;
		this.objects = new ArrayList<>();
		this.clazz = clazz;
		classLoader = getClass().getClassLoader();
	}

	public List<T> load() {
		if (classLoader.getResource(fileName) == null) {
			throw new IllegalArgumentException("Wrong file name, or file no exist");
		}

		File jsonFile = new File(classLoader.getResource(fileName).getFile());

		try {

			ObjectMapper mapper = new ObjectMapper();
			TypeFactory type = TypeFactory.defaultInstance();

			objects = mapper.readValue(jsonFile, type.constructCollectionType(ArrayList.class, clazz));

		} catch (JsonParseException e) {
			System.err.println("JSON file: " + fileName + "  with invalid syntax. Details: " + e);
		} catch (JsonMappingException e) {
			System.err.println("Problems in " + fileName + "  with convert JSON data. Details: " + e);
		} catch (IOException e) {
			System.err.println("Problems with opening a JSON file:  " + fileName + "  ! Details: " + e);
		}
		
		System.out.println("We got " + objects.size() + " objects from json: " + fileName);
		
		return objects;
	}

}
