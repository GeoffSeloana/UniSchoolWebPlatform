package com.geoff.unischool.data;

import com.geoff.unischool.data.Grade;
import com.geoff.unischool.data.School;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T14:37:24")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Integer> studentID;
    public static volatile SingularAttribute<Student, String> firstName;
    public static volatile SingularAttribute<Student, String> lastName;
    public static volatile SingularAttribute<Student, School> school;
    public static volatile SingularAttribute<Student, Grade> grade;
    public static volatile SingularAttribute<Student, String> middleName;
    public static volatile SingularAttribute<Student, String> email;

}