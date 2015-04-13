package com.geoff.unischool.data;

import com.geoff.unischool.data.Gradenews;
import com.geoff.unischool.data.School;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-13T14:37:24")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, Integer> newsID;
    public static volatile ListAttribute<News, Gradenews> gradenewsList;
    public static volatile SingularAttribute<News, String> subTitle;
    public static volatile SingularAttribute<News, School> school;
    public static volatile SingularAttribute<News, Double> latitude;
    public static volatile SingularAttribute<News, Date> datePubliched;
    public static volatile SingularAttribute<News, String> details;
    public static volatile SingularAttribute<News, String> title;
    public static volatile SingularAttribute<News, Double> longitude;

}