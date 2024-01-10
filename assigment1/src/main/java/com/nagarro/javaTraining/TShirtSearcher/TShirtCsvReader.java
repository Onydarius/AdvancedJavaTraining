package com.nagarro.javaTraining.TShirtSearcher;


import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class TShirtCsvReader {

    public static List<TShirt> readTShirts(Reader reader) {
    	
        List<TShirt> csvToBean = new CsvToBeanBuilder<TShirt>(reader)
                .withSeparator('\u007C')
                .withType(TShirt.class)
                .build().parse();
                return csvToBean;
    }
}