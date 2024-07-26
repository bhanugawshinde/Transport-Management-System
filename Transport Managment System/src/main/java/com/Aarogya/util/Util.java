package com.Aarogya.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.ServletInputStream;

public class Util {
	public static Map<String, Object> jsonToMap(ServletInputStream inputStream){
		Map<String, Object> map = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			String jsonPayload = reader.readLine();
			JsonObject j = new Gson().fromJson(jsonPayload, JsonObject.class);
			Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
			map = new Gson().fromJson(j, mapType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		return map;
	}
	
	public static  Map<String, Object> jsonToMap(String profile) {
		Map<String, Object> map = null;
		String jsonPayload = profile;
		try {
			JsonObject j = new Gson().fromJson(jsonPayload, JsonObject.class);
			Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
			map = new Gson().fromJson(jsonPayload, mapType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return map;
		
	}
	
	public static Map<String,String> stringToMap(String str){
		Map<String,String> map = new HashMap<>();
		str = str.substring(1,str.length()-1);
		String[] keyValuePairs = str.split(", ");
		for(String keyValuePair : keyValuePairs) {
			String[] keyValue = keyValuePair.split("="); 
			if(keyValue.length==2) map.put(keyValue[0], keyValue[1]);
			else map.put(keyValue[0], "");
		}
		return map;
	}
	
	public static String[] jsonToArray(ServletInputStream inputStream) {
		String idsArray[]=null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line = reader.readLine();
			Gson gson = new Gson();
			JsonObject jsonObject = JsonParser.parseString(line).getAsJsonObject();
			idsArray = gson.fromJson(jsonObject.getAsJsonArray("ids"), String[].class);		
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return idsArray;
	}
	public static Date getSqlDate(String dateString) {
		if(dateString.equals("") || dateString==null)return null;
		LocalDate ld = LocalDate.parse(dateString);
		Date date = Date.valueOf(ld);
		return date;
	}
	public static String ObjectToString(Object obj) {
		Gson gson = new Gson();
		String str = gson.toJson(obj);
		return str;
	}
	public static Object StringToObject(String string, Class<Object> cls) {
		Gson gson = new Gson();
		Object obj = gson.fromJson(string, cls);
		return obj;
	}
	
	public static String formatDate(String date) {
		 if (date == null || date.equals("")) return null;

		    // Define regular expressions for the date formats
		    String pattern1 = "^[A-Za-z]{3} \\d{1}, \\d{4}$";  // MMM d, yyyy
		    String pattern2 = "^[A-Za-z]{3} \\d{2}, \\d{4}$";  // MMM dd, yyyy

		    DateTimeFormatter formatter;
		    if (Pattern.matches(pattern1, date)) {
		        formatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
		    } else if (Pattern.matches(pattern2, date)) {
		        formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);
		    } else {
		       return null;
		    }

		    LocalDate localDate = LocalDate.parse(date, formatter);
		    DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    return localDate.format(newFormatter);
	}
	public static boolean saveBase64File(String folderName,String fileName,String base64Data) {
			
			//Decode Base64 string to bytes
			String[] parts = base64Data.split(",");
			base64Data = parts.length>1?parts[1]:parts[0];
			
			//Define file path and create necessary directories
			String filePath =folderName +File.separator + fileName;
			File storeFile = new File(filePath);
			// folders not exist then create
			if(!storeFile.exists()) storeFile.getParentFile().mkdirs();
			
			//write bytes to File
		try (FileOutputStream fos = new FileOutputStream(storeFile)){
			byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
			fos.write(decodedBytes);
		}catch(IOException i){
			i.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		System.out.println("File uploaded to: " + storeFile.getAbsolutePath());
		return true;
	}

	
}
