package com.java.music.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.java.music.model.Artist;
import com.java.music.model.Artist_;



public class ArtistSpecification {

    public static Specification<Artist> nameIsLike(final String searchTerm) {
        
        return new Specification<Artist>() {
            @Override
            public Predicate toPredicate(Root<Artist> personRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                String likePattern = getLikePattern(searchTerm);
                return cb.like(cb.lower(personRoot.<String>get(Artist_.name)), likePattern);
            }
            
            private String getLikePattern(final String searchTerm) {
                StringBuilder pattern = new StringBuilder();
                pattern.append("%");
                pattern.append(searchTerm.toLowerCase());
                pattern.append("%");
                return pattern.toString();
            }
        };
    }
}
