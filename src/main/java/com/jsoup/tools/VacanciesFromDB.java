package com.jsoup.tools;


import com.jsoup.bean.Vacancy;
import com.jsoup.dao.VacancyDao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vladimir on 16.01.16.
 */

public class VacanciesFromDB {

    private List<Vacancy> vacancies = null;

    public VacanciesFromDB() {
        setVacancyList();
    }

    public List<Vacancy> getVacancyList() {
        return VacancyDao.getInstance().getVacancyFromDB();
    }

    private void setVacancyList() {
        vacancies = getVacancyList();
    }

    public void sortByData(String type) {

        if (type.equals("title")) {
            Collections.sort(vacancies, new Comparator<Vacancy>() {
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            });
        }
        if (type.equals("data")) {
            Collections.sort(vacancies, new Comparator<Vacancy>() {
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getDateOfPublication().compareTo(o2.getDateOfPublication());
                }
            });
        }
        if (type.equals("company"))
            Collections.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getCompanyName().compareTo(o2.getCompanyName());
                }
            });
        if (type.equals("city"))
            Collections.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getCity().compareTo(o2.getCity());
                }
            });
    }
}
