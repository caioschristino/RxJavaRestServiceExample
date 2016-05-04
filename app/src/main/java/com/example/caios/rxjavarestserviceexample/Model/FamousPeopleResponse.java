package com.example.caios.rxjavarestserviceexample.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by caios on 5/4/16.
 */
public class FamousPeopleResponse  implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<FamousPeople> famousPeople;

    public List<FamousPeople> getFamousPeople() {
        return famousPeople;
    }
}
