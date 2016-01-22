package com.jsoup;

import com.jsoup.dao.VacancyDao;
import com.jsoup.model.*;
import com.jsoup.tools.Provider;

/**
 * Created by vladimir on 21.01.16.
 */
public class Aggregator {
    public static void main(String[] args) {

        VacancyDao.getInstance().createTable();
        Provider providerAstound = new Provider(new AstoundStrategy());
        Provider providerCiklum = new Provider(new CiklumStrategy());
        Provider providerWorkUA = new Provider(new WorkUAStrategy());
        Provider providerLuxoft = new Provider(new LuxoftStrategy());

        Controller controller = new Controller(providerLuxoft, providerAstound, providerCiklum, providerWorkUA);
        controller.scan();
        controller.addVacanciesToDb();
    }
}
