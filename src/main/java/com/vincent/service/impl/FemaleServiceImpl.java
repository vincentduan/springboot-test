package com.vincent.service.impl;

import com.vincent.service.UserService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("female")
public class FemaleServiceImpl implements UserService {

    @Autowired
    private Client client;

    @Override
    public String getGender(String name) {
        SearchResponse test = client.prepareSearch("test").setQuery(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", name))).setSize(0).get();
        System.out.println("female" + test.getHits().totalHits);
        return null;
    }
}
