package com.java.music.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;



@StaticMetamodel(Artist.class)
public class Artist_ {
	public static volatile SingularAttribute<Artist, String> name;
}
           