package com.hexagonal.template.application.paging;

public class Page {

    private final int pageNum;
    private final int listSize;
    private final int totalListCount;
    private final boolean asc;
    private int listStartIdx;
    private int listEndIdx;

    public Page(int pageNum, int listSize, int totalListCount, boolean asc) {
        this.pageNum = pageNum;
        this.listSize = listSize;
        this.totalListCount = totalListCount;
        this.asc = asc;
        calculatePage();
    }

    private void calculatePage() {
        listStartIdx = (pageNum - 1) * listSize;
        if((listStartIdx+1) > totalListCount){
            listStartIdx = 0;
            listEndIdx = 0;
        }else{
            listEndIdx = (pageNum * listSize);
            if((listEndIdx+1) > totalListCount){
                listEndIdx = totalListCount;
            }
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getListSize() {
        return listSize;
    }

    public int getListStartIdx() {
        return listStartIdx;
    }

    public int getListEndIdx() {
        return listEndIdx;
    }

    public boolean isAsc() {
        return asc;
    }
}
