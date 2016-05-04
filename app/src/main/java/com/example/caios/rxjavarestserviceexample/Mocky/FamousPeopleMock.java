package com.example.caios.rxjavarestserviceexample.Mocky;

import com.example.caios.rxjavarestserviceexample.GsonUtils;
import com.example.caios.rxjavarestserviceexample.Model.FamousPeople;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caios on 5/4/16.
 */
public class FamousPeopleMock implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<FamousPeople> famousPeople;

    public FamousPeopleMock(){
        this.famousPeople = new ArrayList<>();
        this.famousPeople.add(new FamousPeople("Dwayne Johnson","2 de maio de 1972","Dwayne Douglas Johnson, conhecido pelo nome artístico The Rock, é um ator, produtor e lutador américo-canadense"));
        this.famousPeople.add(new FamousPeople("Audrey Hepburn","4 de maio de 1929","Audrey Hepburn foi uma premiada atriz e humanitária britânica. É considerada um ícone de estilo e, segundo o American Film Institute, a terceira maior lenda feminina do cinema, atrás apenas de Katharine Hepburn e Bette Davis"));
        this.famousPeople.add(new FamousPeople("Beyoncé","4 de setembro de 1981","Beyoncé Giselle Knowles Carter, mais conhecida simplesmente como Beyoncé, é uma cantora, compositora, atriz, dançarina, coreógrafa, arranjadora vocal, produtora, diretora de vídeo e empresária americana nascida e criada em Houston, no Texas."));
        this.famousPeople.add(new FamousPeople("David Beckham","2 de maio de 1975","David Robert Joseph Beckham, é um ex-futebolista inglês que atuava como meia. Sua ultima equipe foi o Paris Saint-Germain, no qual anunciou sua aposentadoria no final da temporada 2012/2013, acaba no dia 26 de maio de 2013"));
        this.famousPeople.add(new FamousPeople("Abraham Lincoln","12 de fevereiro de 1809","Abraham Lincoln /ˈeɪbrəhæm ˈlIŋkən/ foi um político norte-americano. 16° presidente dos Estados Unidos, posto que ocupou de 4 de março de 1861 até seu assassinato em 15 de abril de 1865"));
        this.famousPeople.add(new FamousPeople("Katy Perry","25 de outubro de 1984","Katheryn Elizabeth Hudson, conhecida pelo nome artístico Katy Perry, é uma cantora e compositora norte-americana de música pop e dance"));
    }

    public String getJsonObject() {
        return GsonUtils.getJsonFromClass(this);
    }
}
