package com.example.blink;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.xmlpull.v1.XmlSerializer;

import android.util.Xml;

public class Programm_Handler {
	
	public static String create_Programm (Programm programm) throws Exception {
		XmlSerializer xmlSerializer = Xml.newSerializer();
		StringWriter writer = new StringWriter();
		xmlSerializer.setOutput(writer);
		xmlSerializer.startDocument("UTF-8", true);
		
		xmlSerializer.startTag("", "1");
		xmlSerializer.attribute("", "1", String.valueOf(programm.geta()));
		xmlSerializer.endTag("", "1");
		
		xmlSerializer.startTag("", "2");
		xmlSerializer.attribute("", "2", String.valueOf(programm.getb()));
		xmlSerializer.endTag("", "2");
		
		xmlSerializer.startTag("", "3");
		xmlSerializer.attribute("", "3", String.valueOf(programm.getc()));
		xmlSerializer.endTag("", "3");
		
		xmlSerializer.startTag("", "4");
		xmlSerializer.attribute("", "4", String.valueOf(programm.getd()));
		xmlSerializer.endTag("", "4");
		
		xmlSerializer.endDocument();
		return writer.toString();
	}
	
	public void WriteProgramm (String programm, String ProgrammName){
		File file = new File(ProgrammName);
		BufferedWriter writer = null;
		try {
		writer = new BufferedWriter(new FileWriter(file, true));
		writer.write(programm);
		writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
