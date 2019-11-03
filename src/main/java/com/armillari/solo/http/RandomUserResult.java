package com.armillari.solo.http;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class RandomUserResult {
    public static class ResultJackson {
        public String gender;
        public NameJackson name;
        public ResultJackson() {}
        public String getFirstName() {
            return this.name.first;
        }
    }

    public static class NameJackson {
        public String title;
        public String first;
        public String last;
        public NameJackson() {}
    }

    public static class InfoJackson {
        public InfoJackson() {}
    }

    public List<ResultJackson> results;
    @JsonIgnore
    public InfoJackson info;
    public RandomUserResult() {}

    public List<ResultJackson> getResults() {
        return this.results;
    }
}
