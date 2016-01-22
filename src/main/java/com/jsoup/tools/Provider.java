package com.jsoup.tools;

import com.jsoup.bean.Vacancy;
import com.jsoup.model.Strategy;

import java.util.List;

/**
 * Created by vladimir on 21.01.16.
 */
public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchCity, String searchLanguage) {
        return strategy.getVacancies(searchCity, searchLanguage);
    }
}
