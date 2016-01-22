package com.jsoup.model;

import com.jsoup.bean.Vacancy;

import java.util.List;

/**
 * Created by vladimir on 21.01.16.
 */
public interface Strategy {
    List<Vacancy> getVacancies(String searchCity, String searchPrLanguage);
}
