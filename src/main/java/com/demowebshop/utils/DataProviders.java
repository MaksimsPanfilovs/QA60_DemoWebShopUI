package com.demowebshop.utils;

import com.demowebshop.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"male", "Alex", "Johnson", "palex23@gmail.com", "qwertY1!"});
        list.add(new Object[]{"female", "Alexa", "Johnsony", "palexa3@gmail.com", "qwertY3!"});
        list.add(new Object[]{"male", "Lexus", "Park", "apark23@gmail.com", "qWertY1!"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new User().setGender(split[0])
                    .setFirstname(split[1])
                    .setLastname(split[2])
                    .setEmail(split[3])
                    .setPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }


}
