package com.geoff.unischool.data;

import com.geoff.unischool.data.Gradenews;
import com.geoff.unischool.data.School;
import com.geoff.unischool.data.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T14:37:24")
@StaticMetamodel(Grade.class)
public class Grade_ { 

    public static volatile SingularAttribute<Grade, Integer> gradeID;
    public static volatile ListAttribute<Grade, Gradenews> gradenewsList;
    public static volatile SingularAttribute<Grade, School> school;
    public static volatile ListAttribute<Grade, Student> studentList;
    public static volatile SingularAttribute<Grade, Integer> gradeNumber;

}