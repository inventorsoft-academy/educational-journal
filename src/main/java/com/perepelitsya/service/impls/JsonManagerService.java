package com.perepelitsya.service.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.perepelitsya.model.Student;
import com.perepelitsya.model.Subject;
import com.perepelitsya.service.interfaces.FileManager;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andriu on 8/20/2017.
 */
public class JsonManagerService implements FileManager {

    private final static Logger log = Logger.getLogger(FileManagerService.class);
    private final static String studentFile = "src\\main\\resources\\student.json";
    private final static String subjectFile = "src\\main\\resources\\subject.json";


    //
//    @Override
//    public void writeToFileStudent(List<Student> studentList) throws IOException {
////
////        for (Student student : studentList) {
////            JSONObject jsonObject = new JSONObject();
////            jsonObject.put("id", student.getId());
////            jsonObject.put("firstName", student.getFirstName());
////            jsonObject.put("lastName", student.getLastName());
////            jsonObject.put("birthDay", student.getBirthDay().format(formatterDateForBirthday));
////            jsonObject.put("group", student.getGroup());
////            jsonObject.put("mark", student.getMark().format(formatterDateForMark));
////            for (Subject subject : student.getSubjects()) {
////                JSONArray jsonArray = new JSONArray();
////                jsonArray.add(subject.getIdOfSubject());
////                jsonArray.add(subject.getName());
////                jsonObject.put("subjects", jsonArray);
////            }
////            try (FileWriter file = new FileWriter(studentFile)) {
////                file.write(jsonObject.toJSONString());
////                file.flush();
////                log.info("Json subject created");
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
//
//        final CollectionLikeType listType = objectMapper.getTypeFactory().constructCollectionLikeType(List.class, Student.class);
//        for (Student student : studentList) {
//            objectMapper.writeValue(studentFile, student);
//        }
//
//    }
    @Override
    public void writeToFileStudent(List<Student> studentList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(studentFile), studentList);
        log.info("Students wrote to file");
    }

    @Override
    public void writeToFileSubject(List<Subject> subjectList) throws IOException {
//        for (Subject subject : subjectList) {
//            JSONObject obj = new JSONObject();
//            obj.put("name", subject.getName());
//            obj.put("idOfSubject", subject.getIdOfSubject());
//            try (FileWriter file = new FileWriter(subjectFile)) {
//                file.write(obj.toJSONString());
//                file.flush();
//                log.info("Json subject created");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(subjectFile), subjectList);
        log.info("Subjects wrote to file");

    }

    @Override
    public List<Student> readFromFileStudent() throws IOException, ParseException {
//
//                List<Student> studentList = new ArrayList<>();
//        try {
//            FileReader reader = new FileReader(studentFile);
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
//            long id = (long) jsonObject.get("id");
//            String firstName = (String) jsonObject.get("firstName");
//            String lastName = (String) jsonObject.get("lastName");
//            long group = (long) jsonObject.get("group");
//
//
//
//            JSONArray subjectList = (JSONArray) jsonObject.get("subjects");
//            List<Subject> subjects = new ArrayList<>();
//            for (Object o : subjectList)
//            {
//                JSONObject sub = (JSONObject) o;
//                long idOfSub = (long) sub.get("id");
//                String name = (String) sub.get("nameOfSubject");
//                Subject subject = new Subject(idOfSub, name);
//                subjects.add(subject);
//            }
//            LocalDateTime mark = (LocalDateTime) jsonObject.get("mark");
//            LocalDateTime birthDay = LocalDateTime.parse((CharSequence) jsonObject.get("birthDay"));
//            studentList.add(new Student(id, firstName, lastName, birthDay, group, mark, subjects));
//        } catch (IOException | ParseException | NullPointerException| ClassCastException ex) {
//            ex.printStackTrace();
//        }
        ObjectMapper objectMapper = new ObjectMapper();
        final CollectionLikeType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class);
        List<Student> students = objectMapper.readValue(new File(studentFile), listType);
        return students;
    }

    @Override
    public List<Subject> readFromFileSubject() throws IOException, ParseException {
//        List<Subject> subjectList = new ArrayList<>();
//        try {
//            FileReader fileReader = new FileReader(subjectFile);
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
//            long id = (long) jsonObject.get("idOfSubject");
//            String name = (String) jsonObject.get("name");
//            subjectList.add(new Subject(id, name));
//        } catch (FileNotFoundException | ClassCastException e) {
//            e.printStackTrace();
//        }
//        return subjectList;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Subject> subjectList = new ArrayList<>();
        final CollectionLikeType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Subject.class);
        subjectList.add(objectMapper.readValue(new File(subjectFile), listType));
        return subjectList;
    }

}