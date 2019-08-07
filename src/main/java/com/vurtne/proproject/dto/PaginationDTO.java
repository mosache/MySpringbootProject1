package com.vurtne.proproject.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PaginationDTO<T> {

    //数据
    private ArrayList<T> data;

    //总项数
    private int totalCount;

    //总页数
    private int totalPage;

    //当前页
    private int currentPage;

    //每页显示数量
    private int size;

    //offSet
    private int offSet;

    //要显示的页
    private ArrayList<Integer> pages = new ArrayList<>();

    //是否显示上一页
    private boolean showPrevious;

    //是否显示下一页
    private boolean showNext;

    //是否显示第一页按钮
    private boolean showFirst;

    //是否显示最后一页按钮
    private boolean showLast;

    public void setPagination(int totalCount,int page,int size){
        this.totalCount = totalCount;
        this.size = size;

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        }else  {
            totalPage = (totalCount / size) + 1;
        }

        this.currentPage = page;

        this.offSet = (page - 1) * size;
//        if ((offSet + 1) % size == 0) {
//            this.currentPage = (offSet + 1) / size;
//        }else {
//            this.currentPage = ((offSet + 1) / size) + 1;
//        }

        this.pages.clear();
        this.pages.add(currentPage);
        int previousFlag = currentPage - 1;
        while (previousFlag > 0 && previousFlag >= currentPage - 3) {
            if (previousFlag > 0){
                this.pages.add(0,previousFlag);
            }
            previousFlag -= 1;
        }

        int nextFlag = currentPage + 1;
        while (nextFlag < currentPage + 3 && nextFlag <= totalPage) {
            this.pages.add(nextFlag);
            nextFlag++;
        }

        if (this.currentPage != 1){
            this.showPrevious = true;
        }else {
            this.showPrevious = false;
        }

        if (this.currentPage != totalPage) {
            this.showNext = true;
        }else {
            this.showNext = false;
        }

        if (pages.contains(1)) {
            this.showFirst = false;
        }else {
            this.showFirst = true;
        }

        if (pages.contains(totalPage)) {
            this.showLast = false;
        }else {
            this.showLast = true;
        }
    }
}
