/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraper;

/**
 *
 * @author katrina
 */
public  class Article implements Item{

    private String title;
    private  int orderNumber;
    private int points;
    private int commentsNumber;

//    public static class Builder {
//
//        private int orderNumber;
//        private String title;
//        private int points;
//        private int commentsNumber;
//
//        //builder methods for setting property
//        public Builder orderNumber(int orderNumber) {
//            this.orderNumber = orderNumber;
//            return this;
//        }
//
//        public Builder title(String title) {
//            this.title = title;
//            return this;
//        }
//
//        public Builder points(int points) {
//            this.points = points;
//            return this;
//        }
//
//        public Builder commentsNumber(int commentsNumber) {
//            this.commentsNumber = commentsNumber;
//            return this;
//        }
//
//        //return fully build object
//        public Article build() {
//            return new Article(this);
//        }
//    }
////private constructor to enforce object creation through builder
//
//    private Article(Builder builder) {
//        this.orderNumber = builder.orderNumber;
//        this.title = builder.title;
//        this.points = builder.points;
//        this.commentsNumber = builder.commentsNumber;
//
//    }

    public String getTitle() {
        return title;
    }

    public int getPoints() {
        return points;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setCommentsNumber(int commentsNumber) {
        this.commentsNumber = commentsNumber;
    }

    

}
