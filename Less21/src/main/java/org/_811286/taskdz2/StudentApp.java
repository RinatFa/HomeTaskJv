package org._811286.taskdz2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class StudentApp {
    public static final String FILE_JSON = "stdnt.json";
    public static final String FILE_BIN = "stdnt.bin";
    public static final String FILE_XML = "stdnt.xml";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void saveTasksToFile(String fileName, Student stdnt) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), stdnt);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(stdnt);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), stdnt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student loadTasksFromFile(String fileName) {
        Student stdnt = new Student();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    stdnt = objectMapper.readValue(file, objectMapper.getTypeFactory().constructType(Student.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        stdnt = (Student) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    stdnt = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructType(Student.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return stdnt;
    }

    public static void displayStud(Student stdnt) {
        System.out.println("Имя: " + stdnt.getName());
        System.out.println("Возраст: " + stdnt.getAge());
        System.out.println("Средний балл: " + stdnt.getGpa());
    }
}
