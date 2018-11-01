package com.learn.volleytest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HeroModel {

    @SerializedName("heroes")
    @Expose
    private List<Hero> heroes = null;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    class Hero implements Serializable
    {
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("imageurl")
        @Expose
        private String imageurl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }

}
