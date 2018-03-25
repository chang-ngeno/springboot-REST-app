package tk.macoz.demo.service;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;
import tk.macoz.demo.bean.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CountryService implements ICountryService {
    private final ArrayList<Country> countries;

    public CountryService() {

        countries = new ArrayList();
    }

    @Override
    public ArrayList<Country> findAll() {

        FileInputStream fis = null;

        try {

            String fileName = "src/main/resources/countries.csv";

            fis = new FileInputStream(new File(fileName));
            CSVReader reader = new CSVReader(new InputStreamReader(fis));
            String[] nextLine;
            reader.readNext();
            //s
            while ((nextLine = reader.readNext()) != null) {

                Country newCountry = new Country(nextLine[0],
                        Integer.valueOf(nextLine[1]));
                countries.add(newCountry);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(CountryService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return countries;
    }
}
