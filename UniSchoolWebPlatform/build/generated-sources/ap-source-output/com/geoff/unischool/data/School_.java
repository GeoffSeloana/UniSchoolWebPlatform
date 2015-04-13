package com.geoff.unischool.data;

import com.geoff.unischool.data.Grade;
import com.geoff.unischool.data.News;
import com.geoff.unischool.data.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T14:37:24")
@StaticMetamodel(School.class)
public class School_ { 

    public static volatile ListAttribute<School, News> newsList;
    public static volatile ListAttribute<School, Grade> gradeList;
    public static volatile SingularAttribute<School, Integer> schoolID;
    public static volatile SingularAttribute<School, Double> latitude;
    public static volatile SingularAttribute<School, String> name;
    public static volatile ListAttribute<School, Student> studentList;
    public static volatile SingularAttribute<School, String> slogan;
    public static volatile SingularAttribute<School, Double> longitude;

}