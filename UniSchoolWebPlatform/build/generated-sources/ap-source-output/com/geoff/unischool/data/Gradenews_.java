package com.geoff.unischool.data;

import com.geoff.unischool.data.Grade;
import com.geoff.unischool.data.News;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T14:37:24")
@StaticMetamodel(Gradenews.class)
public class Gradenews_ { 

    public static volatile SingularAttribute<Gradenews, Date> datePublished;
    public static volatile SingularAttribute<Gradenews, News> news;
    public static volatile SingularAttribute<Gradenews, Integer> gradeNewsID;
    public static volatile SingularAttribute<Gradenews, Grade> grade;

}