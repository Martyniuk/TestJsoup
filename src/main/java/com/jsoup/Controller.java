package com.jsoup;

import com.jsoup.bean.Vacancy;
import com.jsoup.dao.VacancyDao;
import com.jsoup.tools.Provider;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vladimir on 21.01.16.
 */
public class Controller {
    private Provider[] providers;
    private ArrayList<Vacancy> vacs = new ArrayList<>();

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        try {
            for (Provider provider : providers) {
                for (Vacancy vacancy : provider.getJavaVacancies("kiev", "java")) {
                    vacs.add(vacancy);
                }
            }
        } catch (NullPointerException e) {

        }
        System.out.println(vacs.size());
    }

    public void addVacanciesToDb() {
        for (Vacancy vacancy : vacs) {
            VacancyDao.getInstance().addVacancy(vacancy.getLink(),
                    vacancy.getTitle(),
                    vacancy.getCity(),
                    vacancy.getDescription(),
                    vacancy.getDateOfPublication(),
                    vacancy.getTypeOfEmployment(),
                    vacancy.getCompanyName(),
                    vacancy.getExperienceOfWork(),
                    vacancy.isShow(),
                    vacancy.getKeyWord());
            System.out.printf("%s, added to DB\n", vacancy.getTitle());
        }
    }
}
