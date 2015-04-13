/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geoff.unischool.util;

import com.geoff.unischool.data.Grade;
import com.geoff.unischool.data.Gradenews;
import com.geoff.unischool.data.News;
import com.geoff.unischool.data.School;
import com.geoff.unischool.data.Student;
import com.geoff.unischool.dto.GradeDTO;
import com.geoff.unischool.dto.SchoolDTO;
import com.geoff.unischool.dto.StudentDTO;
import com.geoff.unischool.dto.transfer.ResponseDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Generate {

    @PersistenceContext
    EntityManager em;

    Random random = new Random();
    ResponseDTO resp = new ResponseDTO();
    private Object dataUtil;

    //----------------------------------------------------------------------------------------------Register School----------
    public ResponseDTO generateAll(DataUtil dataUtil) {

        log.log(Level.INFO, "Attempt to register school ");
        School s = new School();
        try {
            Double Lat = 20.2265;
            Double Lon = 26.5555;

            s.setName("Diamond Ranch High School");
            s.setSlogan("Education is power");
            s.setLatitude(Lat);
            s.setLongitude(Lon);
            em.persist(s);
            em.flush();
            log.log(Level.INFO, "School registered with ID: " + s.getSchoolID() + "| Name : " + s.getName());
            resp.setSchool(new SchoolDTO(s));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to register school", dataUtil.getErrorString(e));
        }

        resp = registerGrades(s, dataUtil, resp);
        return resp;
    }

    //-----------------------------------------------------------------------------------------------Register Grade--------------------
    public ResponseDTO registerGrades(School school, DataUtil dataUtil, ResponseDTO resp) {

        log.log(Level.INFO, "Attempt to register grades ");
        try {
            List<GradeDTO> grades = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                int grade = i + 1;
                Grade g = new Grade();
                g.setGradeNumber(grade);
                g.setSchool(school);
                em.persist(g);
                em.flush();
                log.log(Level.INFO, "Grade: " + g.getGradeNumber() + ", registered with ID: " + g.getGradeID());
                grades.add(new GradeDTO(g));
                resp = registerStudents(school, g, dataUtil, resp);
                registerGradeNews(school, g, dataUtil);

            }
            resp.setGradeList(grades);
        } catch (Exception e) {
            log.log(Level.OFF, "failed to register grades " + dataUtil.getErrorString(e));
        }

        return resp;
    }

    //-------------------------------------------------------------------------------------------------------Register Students---------------------
    public ResponseDTO registerStudents(School school, Grade g, DataUtil dataUtil, ResponseDTO resp) {

        log.log(Level.INFO, "Attempt to register students ");
        try {
            List<StudentDTO> students = new ArrayList<>();
            for (int k = 0; k < 15; k++) {
                Student s = new Student();
                s.setFirstName(firstNames[random.nextInt(firstNames.length - 1)]);
                s.setMiddleName(girls[random.nextInt(girls.length - 1)]);
                s.setLastName(lastNames[random.nextInt(lastNames.length - 1)]);
                s.setGrade(g);
                s.setSchool(school);
                s.setEmail(k+"bluh@gmail.com");
                em.persist(s);
                em.flush();
                log.log(Level.INFO, "Student: " + s.getFirstName() + " " + s.getLastName() + ", registered with ID: " + s.getStudentID());
                students.add(new StudentDTO(s));
            }
            resp.setStudentList(students);
        } catch (Exception e) {
            log.log(Level.OFF, "failed to register students " + dataUtil.getErrorString(e));
        }
        return resp;
    }

    //--------------------------------------------------------------------------------------register gradenews-------------
    public void registerGradeNews(School school, Grade g, DataUtil dataUtil ) {
        for (int o = 0; o < 5; o++) {
            Gradenews gn = new Gradenews();
            gn.setDatePublished(new Date());
            gn.setGrade(g);
            gn.setNews(getNews(school, dataUtil, resp, o));
            em.persist(gn);
            em.flush();
        }

        
    }

    //---------------------------------------------------------------------------------get news--------------------------

    public News getNews(School school, DataUtil dataUtil, ResponseDTO resp,int count) {
        
        News n = new News();
        n.setTitle(titles[count]);
        n.setSubTitle(subTitles[count]);
        n.setDetails(Details[count]);
        n.setLongitude(lon[count]);
        n.setLatitude(lat[count]);
        n.setSchool(school);
        n.setDatePubliched(new Date());
        em.persist(n);
        em.flush();
        return n;

    }
    
    public String[] titles = {"School caretaker jailed for 51 rapes",
        "Day 3: Bizsport Rugby Fest",
        "Chalk Talk",
        "Results",
        "Catholic teaching on Facebook"};
    public String[] subTitles = {"A man was sentenced to 51 life terms by the Mtubatuba High Court on Thursday, after being found guilty of 51 counts of raping schoolboys",
        "Day 3 of the Bizsport Glenwood Rugby Festival saw the Under-14, Under-15 and 2nd XVs back in action.",
        "Be careful what you say at teacher union conferences",
        "KES Hockey Fest",
        "Catholic school reinstates teacher suspended for defending Catholic teaching on Facebook"};
    public String[] Details = {"Jabulani Bennedict Sibiya, 29, was facing charges of rape of minors between the ages of nine and 13, which he committed between ",
        "2nd XV Lichtenburg 16 – 10 Rustenburg Glenwood 48 – 0 Montana Under-15 Montana 24 – 14 Lichtenburg Rustenburg 45 – 5 Wonderboom Michaelhouse 24 – 22",
        "You have to be so careful what you say at teacher union conferences these days. Mark Baker, the president of the Association of Teachers and Lecturers, ex",
        "Day 1, Thursday 02 April: Affies 2 – 1 DHS St David’s 2 – 1 Queen’s College Eldoraigne 1 – 3 Grey College KES 0 – 1 Hilton St John’s 4 – 0 DHS Parktown Boys 0 – 2",
        "SOMERVILLE, NJ, April 10, 2015 (LifeSiteNews.com) -- A teacher suspended from a Catholic school for using Facebook to defend traditional marriage has been reinstated.Almost one month ago"};
    public Double[] lat = {56.15,26.63,0.0,0.0,23.11};
    public Double[] lon = {25.15,94.63,0.0,0.0,16.11};
    

    public String[] firstNames = {
        "Benjamin", "Johnny", "Tom", "Sam", "Thomas", "Zeke", "John",
        "Tommy", "Peter", "Paul", "Forrest", "Bennie", "Mark", "MacDonald",
        "McLean", "Chris", "Frank", "Mark", "Ronald", "Ronnie", "Blake",
        "John", "Vincent", "Jack", "Bobby", "Malenga", "Sean", "Shane",
        "Mack", "Jonty", "Lance", "David", "Adam", "Luke",
        "Jean", "Peter", "Francois", "Stephen", "Geoffrey", "Omar", "Andre", "Robert", "Hunter",
        "William", "Harry", "Boyce", "Lee", "Lawrence", "Michael", "Noonan", "Caleb", "Jacob",
        "Samuel", "Andrew", "Bernard", "Jack", "Tommy", "Johannes", "Lance", "Jeremiah", "Jerry",
        "Trayvon", "Newton", "Sam", "Fred", "TJ", "Raymond", "Godfrey", "Charlie", "Mingus",
        "Ryan", "Steve", "Stephen", "Hunter", "Henry", "Jordan", "Andrew",
        "Brandon", "Louis", "Christopher", "Daniel", "Eli", "Liam", "Carter", "Dominic",
        "Parker", "Anthony", "Benjamin", "Lucas", "Connor", "Zachary",
        "Cameron", "Matthew", "Justin", "Nathan", "Sebastian", "Brody",
        "Alexander", "Alex", "Levi", "James", "Aiden", "Cooper", "Xavier", "Ryder",
        "Michael", "Tyler", "Ethan", "Jonathan", "Robert", "Roberto", "Gabriel",
        "Chase", "Logan", "Hudson", "Julian", "Aaron", "Severiano", "Owen"
    };
    public String[] lastNames = {
        "Molefe", "Maringa", "Sikhakhane", "Hanayani", "Moerane", "Sithole",
        "Botha", "Khuzwayo", "Ntini", "Mayeza", "Nkosi", "Chauke", "Baloyi",
        "Black", "Qubeka", "Maisela", "Kgongoane", "Machaka", "Shikwambane", "Mosheou",
        "Maseko", "Montwedi", "Sibiya", "Sono", "Samuels", "Gondwe", "Maluleke", "Mathebula",
        "Hlungwane", "Tsotetsi", "Marule", "Moreledi", "Ngwenya", "Chukudu", "Mbhazima", "Shilowa",
        "Mathe", "Mofua", "Mosiane", "Lwembula", "Kuse", "Dube", "Bala", "Ramakatsa", "Mantsoe",
        "Molantoa", "Gonyogo", "Nete", "Kalane", "Makitane", "Khampepe", "Mbele", "Nthako",
        "Nyapoza", "Mlambo", "Ranchebe", "Maketekete", "Phahlane", "Mothekhe", "Tolo", "Moholoholo",
        "Fuzile"

    };

    public String[] girls = {
        "Mary", "Louise", "Brenda", "Samantha", "Ivanka", "Petra", "Maria",
        "Sue", "Thabitah", "Henrietta", "Fannie", "Bernande", "Linda", "Catherine",
        "Lee", "Christina", "Denise", "Yvonne", "Isabella", "Mia", "Blake",
        "Alexis", "Sofia", "Claire", "Melanie", "Sarah", "Brianna", "Jasmine",
        "Grace", "Hannah", "Elizabeth", "Natalie", "Allison", "Zoe",
        "Jean", "Julia", "Lucy", "Hailey", "Leah", "Andrea", "Kaylee", "Victoria", "Jocelyn",
        "Brooklyn", "Sophie", "Madison", "Taylor", "Alexandra", "Alexa", "Riley",
        "Aubree", "Naomi", "Kayla", "Michelle", "Bernande", "Arianne",
        "Anna", "Gabriella", "Madeline", "Maggie", "Evelyn", "Lily", "Bella", "Savannah",
        "Kimberley", "Charlotte",
        "Stella", "Leah", "Ella", "Serenity", "Katherine", "Reagan",
        "Godiva", "Caroline", "Alyssa", "Sarah", "Molly", "Morgan",
        "Chloe"
    };

    private static final Logger log = Logger.getLogger(Generate.class.getName());

}
