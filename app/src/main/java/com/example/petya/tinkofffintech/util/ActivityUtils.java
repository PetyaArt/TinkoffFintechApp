package com.example.petya.tinkofffintech.util;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.google.common.base.Preconditions.checkNotNull;

public class ActivityUtils {

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    public static String getParseTime(String dateStart, String dateEnd) {
        if (dateStart == null && dateEnd == null)
            return "";

        String date = null;
        String date2 = null;
        Locale russian = new Locale("ru");
        String[] newMonths = {
                "ЯНВ", "ФЕВ", "МАРТ", "АПР", "МАЯ", "ИЮНЬ",
                "ИЮЛЬ", "АВГ", "СЕНТ", "ОКТ", "НОЯБ", "ДЕКА"};
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(russian);
        dfs.setMonths(newMonths);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", russian);
        sdf.setDateFormatSymbols(dfs);
        try {
            if (dateStart == null) {
                Date dateE = sdf.parse(dateEnd);
                date = new SimpleDateFormat("MMM yyyy Г.", russian).format(dateE);
                date = date.toUpperCase();

                return date;
            } else if (dateEnd == null) {
                Date dateS = sdf.parse(dateStart);
                date = new SimpleDateFormat("MMM yyyy Г.", russian).format(dateS);
                date = date.toUpperCase();
                return date;
            } else {
                Date dateS = sdf.parse(dateStart);
                Date dateE = sdf.parse(dateEnd);
                if (new SimpleDateFormat("MMM", russian).format(dateS)
                        .equals(new SimpleDateFormat("MMM", russian).format(dateE))) {
                    date = "";
                    date2 = new SimpleDateFormat("MMM yyyy Г.", russian).format(dateE);
                    date2 = date2.toUpperCase();
                } else {
                    date = new SimpleDateFormat("MMM - ", russian).format(dateS);
                    date = date.toUpperCase();
                    date2 = new SimpleDateFormat("MMM yyyy Г.", russian).format(dateE);
                    date2 = date2.toUpperCase();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date + date2;
    }
}
